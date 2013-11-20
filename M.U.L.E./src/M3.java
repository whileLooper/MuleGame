import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * M3.java
 * Version 254. Copyright One-E
 * @author One-E
 *
 */
public class M3 extends Tile {

	/**
	 * This is a subclass of tile, Mountain 3, represent the tile Mountain 3
	 */
	
	/**
	 * This is the constructor for Mountain 3 Class
	 */
	public M3(Point newPoint){
		super(new ImageIcon("Image/tileImages/M3.png"), 1, 1, 4, new Random().nextInt(4), newPoint);
	}
}
