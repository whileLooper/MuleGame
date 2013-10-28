import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;


public class Player {
	
	/**
	 * This is the Player class, used to store player's information
	 */
	private String name;
	private Color color;
	private String race;
	private Image image;
	private ArrayList<Tile> lands;
	
	private int money;
	private int energy;
	private int ore;
	private int crystal;
	
	private Point mapLocation;
	private Point townLocation;
	
	
	/**
	 * This is the Player class' constructor
	 * @param n is the player's name
	 * @param c is the player's color
	 * @param r is the player's race
	 */
	public Player(String n, Color c, String r){
		name = n;
		color = c;
		race = r;
	}
	
	/**
	 * This method returns player's color 
	 * @return player's color
	 */
	public Color getColor(){
		return color;
	}
	
	/**
	 * This method returns player's name
	 * @return player's name
	 */
	public String getName(){
		return name;
	}

	/**
	 * This method is for players to buy lands, first it checks whether player have enough money, and check whether the land 
	 * is purchasable, if so, then the deal is done, and at last it will return a boolean value to indicate whether the deal
	 * is successful or not
	 * @param price is the price for the tile
	 * @param land is the tile to buy
	 */
	public boolean buyLand(int price, Tile land){
		if(money > price){
			if(land.beBought(this)){
				money -= price;
				lands.add(land);
				System.out.println(name + " has just buy a land costing $" + price);
				return true;
			}
			return false;
		}else{
			System.out.println("Oops, you don't have enought money...");
			return false;
		}
	}
	
	/**
	 * This method returns player's location on the map
	 * @return player's location on map
	 */
	public Point getMapLocation(){
		return mapLocation;
	}
	
	/**
	 * This method sets player's location on the map
	 * @param p is player's new location on map
	 */
	public void setMapLocation(Point p){
		mapLocation = p;
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
	 * This method is used to draw the player on map
	 * @param g is the graphics 
	 */
	public void drawOnMap(Graphics g){
		g.drawImage(image, mapLocation.x, mapLocation.y, 50, 50, null);
	}
	
	/**
	 * This method is used to draw player on town
	 * @param g is the graphics
	 */
	public void drawOnTown(Graphics g){
		g.drawImage(image, townLocation.x, townLocation.y, 50, 50, null);
	}
}
