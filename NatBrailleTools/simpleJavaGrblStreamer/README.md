# simpleJavaGrblStreamer

A minimal Java application to stream a file to GRBL as quickly as possible.

Uses a blocking queue to send events from the serial event thread to the main thread which is sending the file.

Build with "mvn compile assembly:single"

Run with "java -jar <commPort> <baud> <file>" 
