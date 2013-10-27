import javax.swing.BorderFactory;
import javax.swing.ImageIcon;


public class TownT extends Tile{

	/**
	 * This is a subclass of Tile, TownT, which represents Town on the map
	 */
	
	/**
	 * This is the constructor of the TownT Class
	 */
	public TownT(){
		super(new ImageIcon("Town.png"), 0, 0, 0, 0);
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
