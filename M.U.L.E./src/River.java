import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * River.java
 * Version 183. Copyright One-E
 * @author One-E
 *
 */
public class River extends Tile {

	/**
	 * This is the constructor of the River Class
	 */
	public River(Point newPoint){
		super(new ImageIcon("Image/tileImages/River.png"), 4, 2, 0, new Random().nextInt(4), newPoint);
	}
}
