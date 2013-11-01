import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Player implements Comparable{
	
	/**
	 * This is the Player class, used to store player's information
	 */
	private String name;
	private Color color;
	private String race;
	private Image image1 = (new ImageIcon("player1.png")).getImage();
	private Image image2 = (new ImageIcon("player2.png")).getImage();
	private int imgMove = 0;
	private ArrayList<Tile> lands = new ArrayList<Tile>();
	
	private int money;
	private int food;
	private int energy;
	private int ore = 0 ;
	private int crystal = 0;
	
	private Point mapLocation = new Point(425, 375);
	private Point townLocation;
	
	
	/**
	 * This is the Player class' constructor
	 * @param n is the player's name
	 * @param c is the player's color
	 * @param r is the player's race
	 */
	public Player(String n, Color c, String r, String gameD){
		name = n;
		color = c;
		race = r;
		initiate(gameD);
	}
	
	/**
	 * This method gives a initial value to player's money and other resources according to player's race and game difficulty
	 */
	private void initiate(String gameD){
		switch(race){
		case "Human": money = 600; break;
		case "Flapper": money = 1600; break;
		case "Others": money = 1000; break;
		default:;
		}
		switch(gameD){
		case "Beginner":{
			food = 8; energy = 4; break;
		}
		case "Standard":{
			food = 4; energy = 2; break;
		}
		case "Tournament":{
			food = 4; energy = 2; break;
		}
		default:;
		}
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
	 * This method return player's money
	 * @return player's money
	 */
	public int getMoney(){
		return money;
	}
	
	/**
	 * This method returns player's food amount
	 * @return player's food amount
	 */
	public int getFood(){
		return food;
	}
	
	/**
	 * This method adds player's money
	 * @param m is the amount of money to add
	 */
	public void addMoney(int m){
		money += m;
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
	
	public boolean buyResource(String type, int price){
		
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
	 * This method resets player's location 
	 */
	public void resetMapLocation(){
		mapLocation = new Point(425, 375);
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
		if(imgMove == 0){
		g.drawImage(image1, mapLocation.x, mapLocation.y, 50, 50, null);
		imgMove = 1;
		}else{
		g.drawImage(image2, mapLocation.x, mapLocation.y, 50, 50, null);
		imgMove = 0;}
	}
	
	/**
	 * This method is used to draw player on town
	 * @param g is the graphics
	 */
	public void drawOnTown(Graphics g){
		if(imgMove == 0){
		g.drawImage(image1, townLocation.x, townLocation.y, 50, 50, null);
		imgMove = 1;
		}else{
		g.drawImage(image2, townLocation.x, townLocation.y, 50, 50, null);
		imgMove = 0;
			}
		}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return money - ((Player)o).getMoney();
	}
}
