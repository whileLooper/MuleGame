import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tile extends JLabel{
	
	
	protected ImageIcon image;
	protected Point p;
	protected final int food;
	protected final int energy;
	protected final int ore;
	protected final int crystite;
	protected Player owner;
	protected Boolean bought = false;
	protected int price;
	
    /**
     * This is the constructor the tile class
     * @param f is the amount of food the tile products
     * @param e is the amount of energy the tile products
     * @param o is the amount of ore the tile products
     * @param c is the amount of crystal the tile products 
     */
	public Tile(ImageIcon i, int f, int e, int o, int c){
		image = i;
		food = f;
		energy = e;
		ore = o;
		crystite = c;
		setIcon(i);
	}
	
	
}
