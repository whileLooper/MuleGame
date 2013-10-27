import java.util.Random;
import javax.swing.ImageIcon;


public class M2 extends Tile {

	/**
	 * This is a subclass of tile, M2, represent the tile M2
	 */
	
	/**
	 * This is the constructor for M2 Class
	 */
	public M2(){
		super(new ImageIcon("src/M2.png"), 1, 1, 3, new Random().nextInt(4));
	}
}
