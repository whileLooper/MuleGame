import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * M3.java
 * Version 254. Copyright One-E
 * @author One-E
 * This is a subclass of tile, Mountain 3, represent the tile Mountain 3
 */
@SuppressWarnings("serial")
public class M3 extends Tile {

	public boolean mine = false;
	/**
	 * This is the constructor for Mountain 3 Class
	 */
	public M3(Point newPoint){
		
		super(new ImageIcon("Image/tileImages/M3.png"), 1, 1, 4, new Random().nextInt(4), newPoint, "M3");
	}
	
	/**
	 * set this mountain has crystite mine
	 */
	public void setCrystite(boolean res){
		mine = res;
		if (mine) {
			
			image = new ImageIcon("Image/tileImages/M3mining.png");
		}
		else {
			image = new ImageIcon("Image/tileImages/M3.png");
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
	 * return mountain type 1
	 * @return tile type
	 */
	public String getType(){
		return "Mountains";
	}
}
