import java.awt.Point;
import java.util.ArrayList;

/**
 * 
 */
 
/**
 * @author lenovo
 *
 */
public interface BrailleGcodeEncoding {

	public ArrayList<Point> GetCharacterDots (char a);
	public int getNRow ();
	public int getNline ();
	
}
