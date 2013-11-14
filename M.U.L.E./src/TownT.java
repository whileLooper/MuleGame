import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;


/**
 * the town tile class, sub class of tile, handling creat town tile method
 * and town image.
 * @author Team:oneE
 *
 */
public class TownT extends Tile{

	/**
	 * This is a subclass of Tile, TownT, which represents Town on the map
	 */
	
	/**
	 * This is the constructor of the TownT Class
	 */
	public TownT(Point newPoint){
		super(new ImageIcon("Image/tileImages/Town.png"), 0, 0, 0, 0, newPoint);
	}
	
	@Override
	/**
	 * This method overrides Tile's, because town can not been bought, just return false
	 */
	public boolean beBought(Player player){
		System.out.println("This is town, and you can not buy it");
		return false;
	}
	
}
