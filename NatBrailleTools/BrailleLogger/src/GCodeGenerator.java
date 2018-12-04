import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *  
 */

/**
 * @author lenovo
 *
 */
public class GCodeGenerator { 

	
	public String Home ()
	{
		return ("G28 X\nG28 Y\n");
	}
	public String Speed()
	{
		return ("G1 F14000\n");
	}
	
	public String Position()
	{
		return ("G90\n");
	}
	
	public String Motoroff ()
	{
		return "M84\n";
	}
	
	public String Header ()
	{
		String gcode = "";
		gcode = Home ();
		gcode += Speed ();
	
		return gcode;
	}
	
	public String Footer ()
	{
		// TODO avoid magic
		String gcode = "G1 X10.00 Y600.00\n"; // eject page
		gcode += Motoroff ();
	
		return gcode;
	}

	public String moveTo(double x, double y) 
	{
		DecimalFormatSymbols sym= new DecimalFormatSymbols ();
		sym.setDecimalSeparator('.');
		DecimalFormat decimalFormat = new DecimalFormat("##0.000", sym);
		
		String gcode = "G1 X" + decimalFormat.format(x) + " Y" + decimalFormat.format(y) + "\n";
		return gcode;
	}
	
	public String printDot() {
		
		return ("M3 S1\nM3 S0\n");
		
	}
}
