package com.willwinder.sjgs.simplejavagrblstreamer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author wwinder
 */
public class SimpleJavaGrblStreamer {
    static int GRBL_BUFFER_SIZE = 125;
    
    public static void main(String argv[]) throws SerialPortException, IOException, InterruptedException {
        if (argv.length == 0)
        {
        	System.out.println("Arguments: <comm port> <baud> <file>");
            return;
        }
    	if (argv.length != 3 && argv.length != 2) {
            System.out.println("Arguments: <comm port> <baud> <file>");
            return;
        }
        
        String commPort = argv[0];
        Integer baud = Integer.parseInt(argv[1]);
        InputStream file = null;
        if (argv.length == 2)
        	file = System.in;
        else {
        		file = new FileInputStream(argv[2]);
        		System.out.println("Streaming file " + argv[2]);
        }
        
        System.out.println("Streaming to port <" + commPort + " : " + baud + ">");
        SimpleJavaGrblStreamer s = new SimpleJavaGrblStreamer(commPort, baud);
        s.send(file);
        
        System.out.println("Done senting file.");
    }
    
    String commPort = null;
    Integer baud = null;
    
    private SimpleJavaGrblStreamer(String commPort, Integer baud) {
        this.commPort = commPort;
        this.baud = baud;
    }
    
    private void send(InputStream f) throws SerialPortException, IOException, InterruptedException {
        BlockingQueue<Integer> commandComplete = new LinkedBlockingQueue();

        SerialPort serialPort = new SerialPort(commPort);
        serialPort.openPort();
        serialPort.setParams(baud, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE, true, true);

        Thread.sleep(5000);
        
        serialPort.addEventListener(new GrblSerialListener(serialPort, commandComplete));
        GrblSerialSender sender = new GrblSerialSender(f, serialPort, commandComplete, GRBL_BUFFER_SIZE);
        sender.send();
        serialPort.closePort();
    }

    private static class GrblSerialListener implements SerialPortEventListener {
        SerialPort serialPort = null;
        BlockingQueue<Integer> completedCommands;
        StringBuilder inputBuffer;
        private GrblSerialListener(SerialPort port, BlockingQueue<Integer> completedCommands) {
            this.serialPort = port;
            this.completedCommands = completedCommands;
            inputBuffer = new StringBuilder();
        }
        
        @Override
        public void serialEvent(SerialPortEvent event) {
            if(event.isRXCHAR() && event.getEventValue() > 0){
                try {
                    byte buffer[] = serialPort.readBytes();
                    for (byte b: buffer) {
                        if (b == '\n') {
                            //System.out.println("Received command: " + inputBuffer.toString());
                            if (inputBuffer.toString().startsWith("ok") || inputBuffer.toString().startsWith("error")) 
                                completedCommands.add(1);
                            inputBuffer.setLength(0);
                        } else {
                            inputBuffer.append((char)b);
                        }
                    }                
                }
                catch (SerialPortException ex) {
                    System.out.println(ex);
                    System.out.println("serialEvent");
                }
            }
        }
    }
    
    private static class GrblSerialSender {
        InputStream file = null;
        SerialPort port = null;
        Integer currentBufferSize = null;
        Integer maxBufferSize = null;
        
        BlockingQueue<Integer> completedCommands = null;
        LinkedList<Integer> activeCommandSizes;
        
        private GrblSerialSender(InputStream f, SerialPort sp, BlockingQueue<Integer> completedCommands, Integer activeBufferSize) {
            file = f;
            port = sp;
            maxBufferSize = activeBufferSize;
            currentBufferSize = 0;
            this.completedCommands = completedCommands;
            activeCommandSizes = new LinkedList<Integer>();
        }
        
        private void send() throws IOException {
            // Java 8
            //try(Stream<String> lines = Files.lines(Paths.get(file.getAbsolutePath()))){
            //    lines.forEach(s -> sendLine(s));
            //}
            
            BufferedReader br = null;
            try {
                String sCurrentLine;
                br = new BufferedReader(new InputStreamReader(file));
                while ((sCurrentLine = br.readLine()) != null) {
                    sendLine(sCurrentLine);
                }
            } finally {
                if (br != null)br.close();
            }
        }
        
        private void sendLine(String s) {
            // Wait until there is room, if necessary.
            while (maxBufferSize < (currentBufferSize + s.length() + 1)) {
                try {
                    //System.out.println("waiting for room.... active command count: " + this.activeCommandSizes.size());

                    // Wait for a command to complete
                    completedCommands.take();
                    currentBufferSize -= this.activeCommandSizes.removeFirst();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimpleJavaGrblStreamer.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
            }
            
            try {
                System.out.println("Sending command: " + s.trim());
                //System.out.printf(".");
                this.port.writeString(s.trim() + "\n");
                int commandSize = s.length() + 1;
                activeCommandSizes.add(commandSize);
                currentBufferSize  += commandSize;
            } catch (SerialPortException ex) {
                Logger.getLogger(SimpleJavaGrblStreamer.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
    }
}
