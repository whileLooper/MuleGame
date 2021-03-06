import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Mule.java
 * Version 254. Copyright One-E
 * @author One-E
 * 
 * The mule class for the game. Contains information for the mule.
 */
public class Mule {

	private String muleType;
	private Point setLocation;
	private Point mapLocation = new Point(425, 375);
	private Point townLocation = new Point(445, 140);
	private transient String owner;
	private transient Player player;
	private transient Image image1 = (new ImageIcon("Image/muleImages/mule1.png")).getImage();
	private transient Image image2 = (new ImageIcon("Image/muleImages/mule2.png")).getImage();
	private transient Image setDownImg = (new ImageIcon("Image/muleImages/muleSetDown.png")).getImage();
	private int imgMove = 0;
	private boolean isSet = false;

	/**
	 * Constructor for the Mule object. Takes in the type of mule and the player that is buying it.
	 * @param type the type of mule
	 * @param player the player that is buying it.
	 */
	public Mule(String type, Player player) {
		muleType = type;
		owner = player.getName();
		this.player = player;
	}

	/**
	 * Getter for the player's location
	 * 
	 * @return player's location on map
	 */
	public Point getMapLocation() {
		return mapLocation;
	}

	/**
	 * Setter for the map location to point p
	 * 
	 * @param p is player's new location on map
	 */
	public void setMapLocation(Point p) {
		mapLocation = p;
	}
	
	/**
	 * Getter for the final location of the mule
	 * @return mule's final location
	 */
	public Point getSetLocation(){
		return setLocation;
	}

	/**
	 * Getter for the player's location on the town
	 * 
	 * @return player's location on the town
	 */
	public Point getTownLocation() {
		return townLocation;
	}
	
	/**
	 * This method used to get the mule's type
	 * @return the mule's type
	 */
	public String getMuleType(){
		switch(muleType){
		case "Food Mule": return "Food";
		case "Energy Mule": return "Energy";
		case "Smithore Mule": return "Smithore";
		case "Crystite Mule": return "Crystite";
		default: return null;
		}
	}

	/**
	 * This method sets player's location on the town
	 * 
	 * @param p is player's new location on the town
	 */
	public void setTownLocation(Point p) {
		townLocation = p;
	}

	/**
	 * This method is used to draw player on town
	 * 
	 * @param g is the graphics
	 */
	public void drawOnMap(Graphics g) {
		if(isSet){
			g.drawImage(setDownImg, setLocation.y * 100, setLocation.x * 100, 50, 50, null);
		}else{
			followPlayer(player.getMapLocation(), g);
		}
		
	}

	/**
	 * This method is used to draw player on town
	 * 
	 * @param g is the graphics
	 */
	public void drawOnTown(Graphics g) {
		followPlayer(player.getTownLocation(), g);
	}

	/**
	 * Allows the mule to follow the player.
	 * @param Location the location
	 * @param g the graphics
	 */
	private void followPlayer(Point Location, Graphics g) {
		// TODO Auto-generated method stub
		if (imgMove == 0) {
			g.drawImage(image1, Location.x + 45, Location.y, 50, 50, null);
			imgMove = 1;
		} else {
			g.drawImage(image2, Location.x + 45, Location.y, 50, 50, null);
			imgMove = 0;
		}
	}

	/**
	 * setting the mule on the land
	 * @param tile is the tile the mule land on
	 */
	public boolean setDownMule(Tile tile) {
		if(tile.isEmpty()){
			tile.setMule(this);
			isSet = true;
			Point locat = player.getMapLocation();
			setLocation = new Point(locat.y / 100, locat.x / 100);
			return true;
		}
		runAway();
		return false;

	}

	/**
	 * Getter for the owner of mule
	 * 
	 * @return owner of mule
	 */
	public String muleOwner() {
		return owner;
	}

	/**
	 * doing the run away action for mule
	 */
	public void runAway() {

		

	}
	
	/**
	 * Puts the mule onto the point where the player brings it.
	 * @param p the player the mule belongs to
	 * @return the location of the location
	 */
	public Point Restore(Player p){
		if(isSet){
			setDownImg = (new ImageIcon("Image/muleImages/muleSetDown.png"))
					.getImage();
			return setLocation;
		}
		else{
			player = p;
			image1 = (new ImageIcon("Image/muleImages/mule1.png")).getImage();
			image2 = (new ImageIcon("Image/muleImages/mule2.png")).getImage();
			return null;
		}
		
	}

}
