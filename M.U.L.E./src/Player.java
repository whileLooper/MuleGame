import java.awt.Color;
import java.awt.Image;
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
}
