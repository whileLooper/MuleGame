import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * The mule class to handle the mule unit 
 * in the game.
 * @author Bo
 *
 */
public class Mule {
	
	
	private String muleType;
	private Point mapLocation = new Point(425, 375);
	private Point townLocation;
	private String owner;
	private Image image1 = (new ImageIcon("mule.png")).getImage();
	private Image image2 = (new ImageIcon("mule.png")).getImage();
	private Image setDownImg = (new ImageIcon("muleSetDown.png")).getImage();
	private int imgMove = 0;
	
	/*
	 * 
	 */
	public Mule(String type, Player player){
		muleType = type;
	}
	
	/**
	 * This method returns player's location on the map
	 * @return player's location on map
	 */
	public Point getMapLocation(){
		return mapLocation;
	}
	
	/**
	 * This method sets mule's location on the map
	 * @param p is player's new location on map
	 */
	public void setMapLocation(Point p){
		mapLocation = p;
	}
	
	/**
	 * This method resets player's location 
	 */
	public void resetMapLocation(){
		mapLocation = new Point(425, 370);
	}
	
	/**
	 * This method returns player's location on the down
	 * @return player's location on the map
	 */
	public Point getTownLocation(){
		return townLocation;
	}
	
	/**
	 * This method sets player's location on the town
	 * @param p is player's new location on the town
	 */
	public void setTownLocation(Point p){
		townLocation = p;
	}
	
	/**
	 * This method is used to draw player on town
	 * @param g is the graphics
	 */
	public void drawOnMap(Graphics g){
		if(imgMove == 0){
		g.drawImage(image1, townLocation.x, townLocation.y, 50, 34, null);
		imgMove = 1;
		}else{
		g.drawImage(image2, townLocation.x, townLocation.y, 50, 34, null);
		imgMove = 0;
			}
		}
	/**
	 * This method is used to draw player on town
	 * @param g is the graphics
	 */
	public void drawOnTown(Graphics g){
		if(imgMove == 0){
		g.drawImage(image1, townLocation.x, townLocation.y, 50, 34, null);
		imgMove = 1;
		}else{
		g.drawImage(image2, townLocation.x, townLocation.y, 50, 34, null);
		imgMove = 0;
			}
		}
	
	/*
	 * setting the mule on the land
	 */
	public void setDownMule(Graphics g){
		
		g.drawImage(setDownImg, townLocation.x, townLocation.y, 50, 34, null);

	}
	
	
	/**
	 * this method return the owner of mule
	 * @param player
	 * @return player name
	 */
	public void setMuleOwner(Player player){
		owner = player.getName();
	}
	
	/**
	 * get the owner name of mule
	 * @return owner of mule
	 */
	public String muleOwner(){
		return owner;
	}
	
	/*
	 * doing the run away action for mule 
	 */
	public void runAway(Tile tile, Graphics g){
		if(tile.isOwned()){
			System.out.println("no owner land.");
		}
		else if(!tile.isEmpty()){
			System.out.println("this is not a empty land, the mule ran away...");
			while(mapLocation.x <= 900){
				g.drawImage(image2, townLocation.x + 5, townLocation.y, 50, 34, null);
			}
		}
	}	
	
}
