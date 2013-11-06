import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * The mule class to handle the mule unit in the game.
 * 
 * @author Bo
 * 
 */
public class Mule {

	private String muleType;
	private Point mapLocation = new Point(425, 375);
	private Point townLocation = new Point(445, 140);
	private String owner;
	private Player player;
	private Image image1 = (new ImageIcon("mule1.png")).getImage();
	private Image image2 = (new ImageIcon("mule2.png")).getImage();
	private Image setDownImg = (new ImageIcon("muleSetDown.png")).getImage();
	private int imgMove = 0;
	private boolean isSet = false;

	/*
	 * 
	 */
	public Mule(String type, Player player) {
		muleType = type;
		owner = player.getName();
		this.player = player;
	}

	/**
	 * This method returns player's location on the map
	 * 
	 * @return player's location on map
	 */
	public Point getMapLocation() {
		return mapLocation;
	}

	/**
	 * This method sets mule's location on the map
	 * 
	 * @param p
	 *            is player's new location on map
	 */
	public void setMapLocation(Point p) {
		mapLocation = p;
	}

	/**
	 * This method resets player's location
	 */
	public void resetMapLocation() {
		mapLocation = new Point(425, 370);
	}

	/**
	 * This method returns player's location on the down
	 * 
	 * @return player's location on the map
	 */
	public Point getTownLocation() {
		return townLocation;
	}

	/**
	 * This method sets player's location on the town
	 * 
	 * @param p
	 *            is player's new location on the town
	 */
	public void setTownLocation(Point p) {
		townLocation = p;
	}

	/**
	 * This method is used to draw player on town
	 * 
	 * @param g
	 *            is the graphics
	 */
	public void drawOnMap(Graphics g) {
		if(isSet){
			g.drawImage(setDownImg, mapLocation.x, mapLocation.y, 50, 50, null);
		}else{
			followPlayer(player.getMapLocation(), g);
		}
		
	}

	/**
	 * This method is used to draw player on town
	 * 
	 * @param g
	 *            is the graphics
	 */
	public void drawOnTown(Graphics g) {
		followPlayer(player.getTownLocation(), g);
	}

	/**
	 * 
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
	 */
	public boolean setDownMule(Tile tile) {
		if(tile.isEmpty()){
			tile.setMule(this);
			isSet = true;
			setMapLocation(player.getMapLocation());
			return true;
		}
		runAway();
		return false;

	}

	/**
	 * get the owner name of mule
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

}
