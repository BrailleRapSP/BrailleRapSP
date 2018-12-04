import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * Braille encoder class 
 * 
 * @author crocsg
 *
 */
public class Braille2GcodeEncoder {

	private GCodeGenerator generator = new GCodeGenerator ();
	private int page_num= 0;
	private int char_cnt_line = 0;
	
	private BrailleGcodeEncoding encoder;
	
	private float position_x;
	private float position_y;
	
	private ArrayList <Point2D.Float> pagedot;
	private ArrayList<ArrayList<Point2D.Float>> linedot;
	private String bufline = "";
	private String pagegcode = "";
	
	private final float Braille_cell_width = 2.3f;
	private final float Braille_cell_height = 2.3f;
	private final float Braille_cell_padding = 6.1f;
	private final float Braille_line_padding = 10f;
	private boolean pageAvailable = false;
	private boolean newpage=true;
	
	/**
	 * @return the pageAvailable
	 */
	public boolean isPageAvailable() {
		return pageAvailable;
	}

	

	/**
	 * @return the pagegcode
	 */
	public String getPagegcode() {
		return pagegcode;
	}



	/**
	 * Constructor
	 */
	private Braille2GcodeEncoder() {
		
	}

	/**
	 * Constructor
	 * @param encoder Braille Encoding
	 */
	public Braille2GcodeEncoder(BrailleGcodeEncoding encoder) {
		this.encoder = encoder;
	}
	
	
	public void startPage ()
	{
		pagedot = new ArrayList <Point2D.Float> ();
		position_y = 2;//TODO avoid magic
		pageAvailable = false;
		newpage = false;
		pagegcode = "";
		startLine ();
		
		 
	}
	
	/**
	 * Complete GCode encoding for the current page
	 */
	public void endPage ()
	{
		if ( ! pagedot.isEmpty())
		{
			pagegcode = generator.Header();
			
			for (Point2D.Float p: pagedot) 
			{
				pagegcode += generator.moveTo(p.getX(),p.getY());
				pagegcode += generator.printDot();
			}
			pagegcode += generator.Footer();
			
			
			pageAvailable  = true;
			
			int n = JOptionPane.showConfirmDialog(
		            null,
		            "Page " + (page_num+1) + " chargez le papier quand l'embosseuse est disponible",
		            "BrailleRapSP Embosseuse Braille",
		            JOptionPane.OK_CANCEL_OPTION);
			if (n == JOptionPane.CANCEL_OPTION)
			{
				// cancel print
				System.exit(0);
			
			}
			
			page_num++;
		}
	}
	
	
	/**
	 * Start a new line
	 */
	public void startLine ()
	{
		linedot = new ArrayList <ArrayList <Point2D.Float>> ();
		for (int i =0; i < encoder.getNline(); i++ )
		{
			linedot.add(new ArrayList<Point2D.Float>());
		}
		
		position_x = 0; //TODO avoid magic
		bufline = "";
	}
	
	
	/**
	 * @param p Dot position in Braille character
	 * @return Absolute position on page
	 */
	private Point2D.Float getDotAbsolutePosition(Point p)
	{
		Point2D.Float absolute = new Point2D.Float();
		absolute.x = position_x + (float) p.x * Braille_cell_width;
		absolute.y = position_y + (float) p.y * Braille_cell_height;
		
		return absolute;
	}
	
	/**
	 * Update fields for next Braille character
	 */
	private void nextCellPosition ()
	{
		this.position_x += Braille_cell_padding; 
	}
	
	
	/**
	 * Update fields for next line of Braille characters
	 */
	private void nextLinePosition ()
	{
		this.position_y += Braille_line_padding;
	}
	 
	
	/**
	 * End Braille characters line
	 */
	private void endLine ()
	{
		ArrayList<Point> dots;
		
		// compute braille dots on line
		for (int i =0; i < bufline.length(); i++)
		{
			dots = encoder.GetCharacterDots(bufline.charAt(i));
			if (dots != null)
			{
				for (int d= 0; d < dots.size (); d++)
				{
					int x = dots.get(d).x;
					int y = dots.get(d).y;
					
					linedot.get(y).add(getDotAbsolutePosition(dots.get(d)));
				}
				
				nextCellPosition ();
			}
			
		}
		
		// store braille absolute dot on page
		for (int l = 0; l < linedot.size(); l++)
		{
			pagedot.addAll(linedot.get(l));
		}
		
		nextLinePosition();
	}
	
	/**
	 * Add a character in page buffer to encode in Braille 
	 * @param a character to add
	 */
	private void addCharToBuffer (char a) 
	{
		bufline += a;
	}
	
	/**
	 * Initialize Braille encoder
	 */
	public void Open ()
	{
		startPage ();
	}
	
	/*
	 * Process a character
	 * @param a character to process
	 */
	public void processChar (char a)
	{
		if (a == '\n')
		{
			endLine ();
			startLine ();
		}
		else if (a == 0x0c)
			endPage ();
		
		else
		{
			if (newpage)
				startPage();
			addCharToBuffer (a);
		}
		
	}
	
	/**
	 * CloseBraille encoder
	 */
	public void Close ()
	{
		endLine ();
		endPage ();
	}


	/*
	 * Request a new page 
	 */
	public void requestNewPage() {
		newpage = true;
		pageAvailable = false;
		startPage ();
	}

}
