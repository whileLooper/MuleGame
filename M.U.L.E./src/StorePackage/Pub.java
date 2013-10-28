package StorePackage;
import java.awt.*;

public class Pub extends Store {
	
	public Pub() {
		setDimension();
		setBorder();
	}
	
	/**
	 * Set the points of the store.
	 */
	public void setDimension() {
		LEFT_LEFT = new Point(300,200);
		LEFT_MID = new Point(320, 200);
		LEFT_RIGHT = new Point(320, 230);
		RIGHT_LEFT = new Point(380,230);
		RIGHT_MID = new Point(380,200);
		RIGHT_RIGHT = new Point(400,200);
	}
}
