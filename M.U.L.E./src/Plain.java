import java.util.Random;
import javax.swing.ImageIcon;


public class Plain extends Tile {

	/**
	 * This is a subclass of Tile, Plain, which represents plain on the map
	 */
	
	/**
	 * This is the constructor of the Plain Class
	 */
	public Plain(){
		super(new ImageIcon("Plain.png"), 2, 3, 1, new Random().nextInt(4));
	}
}
