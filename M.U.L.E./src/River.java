import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;


public class River extends Tile {

	/**
	 * This is a subclass of Tile, River, which represents River on the map
	 */
	
	/**
	 * This is the constructor of the River Class
	 */
	public River(Point newPoint){
		super(new ImageIcon("Image/tileImages/River.png"), 4, 2, 0, new Random().nextInt(4), newPoint);
	}
}
