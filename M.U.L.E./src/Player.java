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

}
