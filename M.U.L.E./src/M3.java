import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;


public class M3 extends Tile {

	/**
	 * This is a subclass of tile, M3, represent the tile M3
	 */
	
	/**
	 * This is the constructor for M3 Class
	 */
	public M3(Point newPoint){
		super(new ImageIcon("Image/tileImages/M3.png"), 1, 1, 4, new Random().nextInt(4), newPoint);
	}
}
