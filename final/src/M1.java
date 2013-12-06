import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * M1.java
 * Version 254. Copyright One-E
 * @author One-E
 * This is a subclass of tile, Mountain 1, represent the tile Mountain 1
 */
@SuppressWarnings("serial")
public class M1 extends Tile{

	private boolean mine = false;
	
	/**
	 * This is the constructor for Mountain 1 Class
	 */
	public M1(Point newPoint){
		super(new ImageIcon("Image/tileImages/M1.png"), 1, 1, 2, new Random().nextInt(4), newPoint);
	}
	
	/**
	 * set this mountain has crystite mine
	 */
	public void setCrystite(boolean res){
		mine = res;
		if (mine) {
			image = new ImageIcon("Image/tileImages/M1mining.png");
			System.out.println("Image changed.");
		}
		else {
			image = new ImageIcon("Image/tileImages/M1.png");
		}
	}
	
	/**
	 * check is the mountains has mine
	 * @return
	 */
	public boolean hasMine(){
		return mine;
	}
	
	/**
	 * return mountain type2
	 * @return tile type
	 */
	public String getType(){
		return "Mountains";
	}
}
