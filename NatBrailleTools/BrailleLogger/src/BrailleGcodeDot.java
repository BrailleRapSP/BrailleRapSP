 

/**
 * 
 */

/**
 * @author lenovo
 *
 */
public class BrailleGcodeDot {
	
	
	private char car;
	
	public char getCar() {
		return car;
	}
	public void setCar(char car) {
		this.car = car;
	}
	
	private int[] pos;
	
	public int[] getPos() {
		return pos;
	}
	public void setPos(int[] pos) {
		this.pos = pos;
	}

	
	/**
	 * 
	 */
	public BrailleGcodeDot() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param car
	 * @param position
	 */
	public BrailleGcodeDot(char car, int[] position) {
		this.car = car;
		this.pos = position;
	}
	
	public BrailleGcodeDot(char car) {
		this.car = car;
		
	}
}
