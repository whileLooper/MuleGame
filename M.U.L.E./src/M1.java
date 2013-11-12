import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;


public class M1 extends Tile{

	/**
	 * This is a subclass of tile, M1, represent the tile M1
	 */
	
	/**
	 * This is the constructor for M1 Class
	 */
	public M1(Point newPoint){
		super(new ImageIcon("Image/tileImages/M1.png"), 1, 1, 2, new Random().nextInt(4), newPoint);
	}
}
