import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * M2.java
 * Version 254. Copyright One-E
 * @author One-E
 * This is a subclass of tile, Mountain 2, represent the tile Mountain 2
 */
@SuppressWarnings("serial")
public class M2 extends Tile {

	public boolean mine = false;
	
	/**
	 * This is the constructor for Mountain 2 Class
	 */
	public M2(Point newPoint){
		super(new ImageIcon("Image/tileImages/M2.png"), 1, 1, 3, new Random().nextInt(4), newPoint);
	}
	
	/**
	 * set this mountain has crystite mine
	 */
	public void setCrystite(boolean res){
		mine = res;
		if (mine) {
			image = new ImageIcon("Image/tileImages/M2mining.png");
		}
		else {
			image = new ImageIcon("Image/tileImages/M2.png");
		}
	}
	
	/**
	 * check is the mountains has mine
	 * @return
	 */
	public boolean hasMine(){
		return mine;
	}
	
	/**
	 * return mountain type 2
	 * @return tile type
	 */
	public String getType(){
		return "Mountains";
	}
}
