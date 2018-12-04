import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main program
 */

/**
 * @author lenovo
 *
 */
public class BrailleLogger {

	 
	ArrayList <Point2D.Float> braillepoints = new ArrayList <Point2D.Float>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println ("; BrailleRapSP GCODE generator");
		int arg = 0;
		for (String s: args)
		{
			System.out.println(";" + arg);
			System.out.println(";" + s);
		}
		
		if (args.length > 0)
		{
			FileReader fr;
			Braille2GcodeEncoder encoder = new Braille2GcodeEncoder(new Braille6GcodeEncoding());
			try {
				fr = new FileReader(args[0]);
				
				int i;
				while ((i=fr.read()) != -1)
				{
				      encoder.processChar((char) i); 
				      if (encoder.isPageAvailable())
				      {
				    	  System.out.println(encoder.getPagegcode());
				    	  encoder.requestNewPage ();
				      }
				}
				
				encoder.Close ();
				if (encoder.isPageAvailable())
			    {
			    	  System.out.println(encoder.getPagegcode());
			    	  
			    }
				fr.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				 
				   
		}
	}

}
