package StorePackage;
import java.awt.*;

public class Pub {
	private Point[] dimension;
	
	public Pub() {
		setDimension();
	}
	
	public void setDimension() {
		dimension = new Point[Store.SIZE];
		for (int i = 0; i < Store.WALL_SIZE_X; i++) {
			dimension[i] = new Point(Store.PUB_START_X+i,Store.PUB_START_Y);
		}
		for (int j = Store.WALL_SIZE_X; j < Store.WALL_SIZE_X + Store.WALL_SIZE_Y; j++) {
			dimension[j] = new Point(Store.PUB_START_X+Store.WALL_SIZE_X, Store.PUB_START_Y+j-Store.WALL_SIZE_X);
		}
	}
	
}
