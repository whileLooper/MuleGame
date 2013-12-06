import java.awt.Point;


public class TileFactory {

	public TileFactory(){
		
	}
	
	public Tile createTile(String type, int i, int j) {
		switch (type) {
		case "P": {
			return new Plain(new Point(i, j));
		}
		case "R": {
			return new River(new Point(i, j));
		}
		case "M1": {
			return new M1(new Point(i, j));
		}
		case "M2": {
			return new M2(new Point(i, j));
		}
		case "M3": {
			return new M3(new Point(i, j));
		}
		case "Town": {
			return new TownT(new Point(i, j));
		}
		default: {
			return null;
		}
		}
	}
}
