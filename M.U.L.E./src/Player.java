import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Player.java
 * Version 293. Copyright One-E.
 *
 * @author Team One-E
 * The object of player, with all players information
 * image, name, color, resource info.
 */
public class Player implements Comparable{
	
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
	
	private Point mapLocation = new Point(425, 375);
	private Point townLocation;
	
	private Mule currentMule = null;
	private ArrayList<Mule> mules = new ArrayList<Mule>();
	
	
	/**
	 * This is the Player class' constructor
	 * @param n is the player's name
	 * @param c is the player's color
	 * @param r is the player's race
	 * @param gameD is the game difficulty.
	 */
	public Player(String n, Color c, String r, String gameD){
		name = n;
		color = c;
		race = r;
		initiate(gameD);
	}
	
	/**
	 * This method gives a initial value to player's money and other resources according to player's race and game difficulty
	 * @param gameD is the game difficulty.
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
		
		choseImage();
	}
	
	/**
	 * Choose the image that is related to the race of the player.
	 */
	private void choseImage(){
		switch (race) {
		case "Human": {
			image1 = (new ImageIcon("Image/playerImages/human1.png"))
					.getImage();
			image2 = (new ImageIcon("Image/playerImages/human2.png"))
					.getImage();
			break;
		}
		case "Flapper": {
			image1 = (new ImageIcon("Image/playerImages/flapper1.png"))
					.getImage();
			image2 = (new ImageIcon("Image/playerImages/flapper2.png"))
					.getImage();
			break;
		}
		case "Pandarian": {
			image1 = (new ImageIcon("Image/playerImages/panda1.png"))
					.getImage();
			image2 = (new ImageIcon("Image/playerImages/panda2.png"))
					.getImage();
			break;
		}
		case "MonkeyKing": {
			image1 = (new ImageIcon("Image/playerImages/monkey1.png"))
					.getImage();
			image2 = (new ImageIcon("Image/playerImages/monkey2.png"))
					.getImage();
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
	 * this method returns player's race
	 * @return race of player
	 */
	public String getRace(){
		return race;
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
	
	/**
	 * This method used to get player-owned tiles 
	 * @return tiles player owns
	 */
	public ArrayList<Tile> getTiles(){
		return lands;
	}
	
	/**
	 * This method used to get mules owned by player
	 * @return the mules list
	 */
	public ArrayList<Mule> getMules(){
		return mules;
	}
	
	/**
	 * this method used to add resource
	 * @param type is the resource's type
	 * @param amount is the resource's amount 
	 */
	public void addResource(String type, int amount){
		switch(type){
		case "Food": addFood(amount); break;
		case "Energy": addEnergy(amount); break;
		case "Smithore": addOre(amount); break;
		case "Crystite": addCrystal(amount); break;
		}
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
	
	public void deductFood(int amount) {
		food = food - amount;
		if (food < 0) {
			food = 0;
		}
	}
	/**
	 * add energy to the current energy
	 * @param amount of energy need to be added
	 */
	public void addEnergy(int amount){
		energy = energy + amount;
	}
	
	public void deductEnergy(int amount) {
		energy = energy - amount;
		if (energy < 0) {
			energy = 0;
		}
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
	 * This method used to deduce the money 
	 * @param amount to deduce, remains 0 if money is below 0.
	 */
	public void deduceMoney(int amount){
		money -= amount;
		if(money < 0){
			money = 0;
		}
	}
	
	/**
	 * This method used to consume food and energy every turn
	 * @param amount of food player consume 
	 */
	public void consumeFoodNEnergy(int amount){
		food -= amount;
		if(food < 0){
			food = 0;
		}
		for(Mule mule : mules){
			String type = mule.getMuleType();
			if(!type.equals("Energy")){
				energy --;
			}
		}
		if(energy < 0){
			energy = 0;
		}
	}
	
	/**
	 * This method is for players to buy lands, first it checks whether player have enough money, and check whether the land 
	 * is purchasable, if so, then the deal is done, and at last it will return a boolean value to indicate whether the deal
	 * is successful or not
	 * @param price is the price for the tile
	 * @param land is the tile to buy
	 * @return true if success, false if unsuccessful.
	 */
	public boolean buyLand(int price, Tile land){
		if(money > price){
			if(land.beBought()){
				land.buyLand(this);
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
	
	/**
	 * Set the mule on the tile, runs away if failed.
	 * @param tile the mule is set on.
	 */
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
	/**
	 * Compare the Player o with the current player and checks who have more money.
	 */
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
			currentMule = null;
		}
	}
	
	/**
	 * Arraylist of mules that have been set down by the player.
	 * @param tiles
	 * @return the list of mules by the players.
	 */
	public ArrayList<Mule> Restore(ArrayList<Tile> tiles){
		choseImage();
		imgMove = 0;
		lands = tiles;
		if(currentMule != null){
			currentMule.Restore(this);
		}
		return mules;
	}
}
