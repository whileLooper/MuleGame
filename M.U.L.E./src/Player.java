import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * The object of player, with all players information
 * image, name, color, resource info.
 * @author Team OneE
 *
 */
public class Player implements Comparable{
	
	/**
	 * This is the Player class, used to store player's information
	 */
	private String name;
	private Color color;
	private String race;
	private transient Image image1;
	private transient Image image2;
	private transient int imgMove = 0;
	private transient ArrayList<Tile> lands = new ArrayList<Tile>();
	
	private int money;
	private int food;
	private int energy;
	private int ore = 0 ;
	private int crystal = 0;
	
	private transient Point mapLocation = new Point(425, 375);
	private transient Point townLocation;
	
	private transient Mule currentMule = null;
	private transient ArrayList<Mule> mules = new ArrayList<Mule>();
	
	
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
	
	public Player(){
		
	}
	
	/**
	 * This method gives a initial value to player's money and other resources according to player's race and game difficulty
	 */
	private void initiate(String gameD){
		switch(race){
		case "Human": money = 600; break;
		case "Flapper": money = 1600; break;
		case "Others": money = 1000; break;
		case "Pandarian": money = 800; break;
		case "MonkeyKing": money = 800; break;
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
		
		//setting the images of each players.
		switch(race){
			case "Human": {
				System.out.println("here");
				image1 = (new ImageIcon("Image/playerImages/player1.png")).getImage();
				image2 = (new ImageIcon("Image/playerImages/player2.png")).getImage();
				break;
			}
			case "Flapper": {
				image1 = (new ImageIcon("Image/playerImages/flapper1.png")).getImage();
				image2 = (new ImageIcon("Image/playerImages/flapper2.png")).getImage();
				break;
			}
			case "Pandarian": {
				image1 = (new ImageIcon("Image/playerImages/panda1.png")).getImage();
				image2 = (new ImageIcon("Image/playerImages/panda2.png")).getImage();
				break;
			}
			case "MonkeyKing": {
				image1 = (new ImageIcon("Image/playerImages/monkey1.png")).getImage();
				image2 = (new ImageIcon("Image/playerImages/monkey2.png")).getImage();
				break;
			}
			
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
	 * This method used to get player's energy amount
	 * @return player's energy amount
	 */
	public int getEnergy(){
		return energy;
	}
	
	/**
	 * This method used to get player's ore amount
	 * @return player's ore amount
	 */
	public int getOre(){
		return ore;
	}
	
	/**
	 * This method used to get player's crystal amount
	 * @return player's crystal amount
	 */
	public int getCrystal(){
		return crystal;
	}
	
	public ArrayList<Tile> getTiles(){
		return lands;
	}
	
	/**
	 * This method adds player's money
	 * @param m is the amount of money to add
	 */
	public void addMoney(int m){
		money += m;
	}

	/**
	 * add food to the current food
	 * @param amount of food need to be added
	 */
	public void addFood(int amount){
		food = food + amount;
	}
	
	/**
	 * add energy to the current energy
	 * @param amount of energy need to be added
	 */
	public void addEnergy(int amount){
		energy = energy + amount;
	}
	
	/**
	 * add ore to the current ore
	 * @param amount of ore need to be added
	 */
	public void addOre(int amount){
		ore = ore + amount;
	}
	
	
	/**
	 * add crystal to the current crystal
	 * @param amount
	 */
	public void addCrystal(int amount){
		crystal = crystal + amount;
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
	 * This method used for player to buy mule
	 * @param m is the mule people are trying to buy
	 * @param price is the mule's price
	 * @return whether the transition is successful
	 */
	public boolean buyMule(String m, int price){
		if(money >= price){
			if(currentMule == null){
				money -= price;
				currentMule = new Mule(m, this);
				System.out.println(name + " buys a " + m + " costing " + price
						+ " with left " + money);
				return true;
			}else{
				System.out.println("Transition failed, since you have one mule with you");
				return false;
			}
			
		}else{
			System.out.println("Transition failed, since you don't have enought money");
			return false;
		}
	}
	
	public void setMule(Tile tile){
		if(lands.contains(tile)){
			if(currentMule.setDownMule(tile)){
				mules.add(currentMule);
				currentMule = null;
			}else{
				currentMule = null;
				System.out.println("Mule set failed, so your mule run away!");
			}
		}else{
			currentMule= null;
			System.out.println("This land is not owned by you, so your mule run away!");
		}
	}
	
	/**
	 * This method used for player to buy recourse
	 * @param type is the kind of recourse to buy
	 * @param price is the price per recourse unit
	 * @return whether the transition is successful
	 */
	public boolean buyResource(String type, int price){
		if( money >= price){
			money -= price;
			switch(type){
			case "Food":{
				food += 1;
				break;
			}
			case "Energy":{
				energy += 1;
				break;
			}
			case "Smithore":{
				ore += 1;
				break;
			}
			case "Crystite":{
				crystal += 1;
				break;
			}
			default:;
			}
			System.out.println(name + " buys 1 " + type + " costing " + price + " left " + money);
			return true;
		}else{
			System.out.println("Transition failed, since you don't have enought money");
			return false;
		}
	}
	
	/**
	 * This method used for player to sell recourse
	 * @param type is the type player wants sell
	 * @param price is the price player can get to sell the product
	 * @return whether this transition is successful
	 */
	public boolean sellResource(String type, int price){
		switch(type){
		case "Food":{
			if(food > 0){
				food --;
				money += price;
				System.out.println(name + " sells 1 " + type + " and get " + price + " with " + money + " totally");
				return true;
			}
			System.out.println("Transition failed, since you don't have enought resource");
			return false;
		}
		case "Energy":{
			if(energy > 0){
				energy --;
				money += price;
				System.out.println(name + " sells 1 " + type + " and get " + price + " with " + money + " totally");
				return true;
			}
			System.out.println("Transition failed, since you don't have enought resource");
			return false;
		}
		case "Smithore":{
			if(ore > 0){
				ore --;
				money += price;
				System.out.println(name + " sells 1 " + type + " and get " + price + " with " + money + " totally");
				return true;
			}
			System.out.println("Transition failed, since you don't have enought resource");
			return false;
		}
		case "Crystite":{
			if(crystal > 0){
				crystal --;
				money += price;
				System.out.println(name + " sells 1 " + type + " and get " + price + " with " + money + " totally");
				return true;
			}
			System.out.println("Transition failed, since you don't have enought resource");
			return false;
		}
		default:;
		}
		return false;
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
	 * This method used to get current mule on player
	 * @return player's mule
	 */
	public Mule getMule(){
		return currentMule;
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
	public void drawOnMap(Graphics g) {
		if (imgMove == 0) {
			g.drawImage(image1, mapLocation.x, mapLocation.y, 50, 50, null);
			imgMove = 1;
		} else {
			g.drawImage(image2, mapLocation.x, mapLocation.y, 50, 50, null);
			imgMove = 0;
		}
		if(currentMule != null){
			currentMule.drawOnMap(g);
		}
	}
	
	/**
	 * This method is used to draw player on town
	 * @param g is the graphics
	 */
	public void drawOnTown(Graphics g) {
		if (imgMove == 0) {
			g.drawImage(image1, townLocation.x, townLocation.y, 50, 50, null);
			imgMove = 1;
		} else {
			g.drawImage(image2, townLocation.x, townLocation.y, 50, 50, null);
			imgMove = 0;
		}
		if(currentMule != null){
			currentMule.drawOnTown(g);
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return money - ((Player)o).getMoney();
	}
	
	/**
	 * This method will be called every time the player's turn ends
	 */
	public void turnEnd(){
		if(currentMule != null){
			currentMule.runAway();
		}
	}
}
