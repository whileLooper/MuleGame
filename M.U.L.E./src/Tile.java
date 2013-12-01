import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Tile.java
 * Version 296. Copyright One-E
 * Tile class, the super class of all tiles on the map
 * and all events happen on the tile.
 * @author Team: oneE 
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
	protected boolean mine = false;
	protected boolean fish = false;
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
	 * @return true if bought successfully.
	 */
	public boolean beBought(){
		if(bought){
			System.out.println("Oops! Sorry, this land has been owned by someone else.");
			return false;
		}else{
			System.out.println("Land is not bought. You can buy it.");
			return true;
		}
	}
	
	/**
	 * Allows the player to buy the land
	 * @param player that is buying the land.
	 */
	public void buyLand(Player player) {
		bought = true;
		owner = player;
		setBorder(BorderFactory.createLineBorder(owner.getColor(), 5));
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
	 * This method used to get the resource the mule can product on the tile
	 * @param resource is the kind of resource to product
	 * @return the number of units of the resource can be produced
	 */
	public int products(String resource){
		switch(resource){
		case "Food": return food;
		case "Energy": return energy;
		case "Ore": return ore;
		case "Crystite": return crystite;
		default: return 0;
		}
	}
	
	/**
	 * This method used to get the mule on the tile
	 * @return the mule on the tile
	 */
	public Mule getMule(){
		return mule;
	}
	
	/**
	 * This method returns the point of the tile.
	 * @return p the point of the tile.
	 */
	public Point getPoint(){
		return p;
	}
	
	/**
	 * Loads from saved file that this player owns this tile.
	 * @param player the player that owns this tile.
	 */
	public void Restore(Player player){
		bought = true;
		owner = player;
		setBorder(BorderFactory.createLineBorder(owner.getColor(), 5));
	}

	/**
	 * checking tile contains mine or not
	 * 
	 * @return false
	 */
	public boolean hasMine() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * set this mountain has crystite mine
	 */
	public void setCrystite(boolean res) {
		mine = res;
	}

	/**
	 * checking river has fish or not
	 * 
	 * @return true if river has fish
	 */
	public boolean hasFish() {
		return false;
	}

	/**
	 * set rive has fish
	 * 
	 * @param res
	 *            true of flase
	 */
	public void setFish(boolean res) {
		fish = res;
	}
}
