import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author Qian, Bo, 
 *
 */
@SuppressWarnings("serial")
public class Tile extends JLabel{
	
	
	protected ImageIcon image;
	protected Point p;
	protected final int food;
	protected final int energy;
	protected final int ore;
	protected final int crystite;
	protected Player owner;
	protected boolean bought = false;
	protected boolean isOcuppied = false;
	protected Mule mule = null;
	
    /**
     * This is the constructor the tile class
     * @param f is the amount of food the tile products
     * @param e is the amount of energy the tile products
     * @param o is the amount of ore the tile products
     * @param c is the amount of crystal the tile products 
     */
	public Tile(ImageIcon i, int f, int e, int o, int c,Point newPoint){
		image = i;
		food = f;
		energy = e;
		ore = o;
		crystite = c;
		p = newPoint;
		setIcon(i);
	}
	
	/**
	 * This method is used for land purchase, it will return a boolean value to tell player whether this land is purchasable
	 * or not, and if it can be bought, then the land will be marked player's color.
	 * @param player
	 * @return
	 */
	public boolean beBought(Player player){
		if(bought){
			System.out.println("Oops! Sorry, this land has been owned by someone else.");
			return false;
		}else{
			bought = true;
			owner = player;
			setBorder(BorderFactory.createLineBorder(owner.getColor(), 5));
			return true;
		}
	}
	
	/**
	 * is own by player
	 * @return true if own by player, return false no one own this tile
	 */
	public boolean isOwned(){
		if(bought) return true;
		else return false;
	}
	
	/**
	 * check the land is empty land with owner or not
	 * @return	empty resource if true,
	 */
	public boolean isEmpty(){
		if(isOcuppied) return false;
		else return true;
	}
	/**
	 * this method is getting the owner of tile
	 * @return owner of tile
	 */
	public String getOwner(){
		if(owner == null){
			System.out.println("This land is not own by anyone");
			return null;
		}
		else
			return owner.getName();
	}
	
	/**
	 * This method used to set mule on the tile
	 * @param m is the mule to put on the tile
	 */
	public void setMule(Mule m){
		isOcuppied = true;
		mule = m;
	}
	
	/**
	 * This method used to get the mule on the tile
	 * @return the mule on the tile
	 */
	public Mule getMule(){
		return mule;
	}
	
	public Point getPoint(){
		return p;
	}
	
	public void Restore(Player player){
		bought = true;
		owner = player;
		setBorder(BorderFactory.createLineBorder(owner.getColor(), 5));
	}
}
