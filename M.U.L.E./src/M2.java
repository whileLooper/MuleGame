import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;


public class M2 extends Tile {

	/**
	 * This is a subclass of tile, Mountain 2, represent the tile Mountain 2
	 */
	
	/**
	 * This is the constructor for Mountain 2 Class
	 */
	public M2(Point newPoint){
		super(new ImageIcon("Image/tileImages/M2.png"), 1, 1, 3, new Random().nextInt(4), newPoint);
	}
}
