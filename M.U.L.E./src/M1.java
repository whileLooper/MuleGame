import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * M1.java
 * Version 254. Copyright One-E
 * @author One-E
 *
 */
public class M1 extends Tile{

	/**
	 * This is a subclass of tile, Mountain 1, represent the tile Mountain 1
	 */
	
	/**
	 * This is the constructor for Mountain 1 Class
	 */
	public M1(Point newPoint){
		super(new ImageIcon("Image/tileImages/M1.png"), 1, 1, 2, new Random().nextInt(4), newPoint);
	}
}
