import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;


public class Plain extends Tile {

	/**
	 * This is a subclass of Tile, Plain, which represents plain on the map
	 */
	
	/**
	 * This is the constructor of the Plain Class
	 */
	public Plain(Point newPoint){
		super(new ImageIcon("Image/tileImages/Plain.png"), 2, 3, 1, new Random().nextInt(4), newPoint);
	}
}
