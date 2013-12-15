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

	private boolean fish = false;
	/**
	 * This is the constructor of the River Class
	 */
	public River(Point newPoint){
		super(new ImageIcon("Image/tileImages/River.png"), 4, 2, 0, new Random().nextInt(4), newPoint, "river");
	}
	
	/**
	 * set rive has fish 
	 * @param res true of flase 
	 */
	public void setFish(boolean res){
		fish = res;
	}
	
	/**
	 * checking river has fish or not
	 * @return true if river has fish
	 */
	public boolean hasFish(){
		return fish;
	}
	
	/**
	 * return river type
	 * @return tile type
	 */
	public String getType(){
		return "River";
	}
}
