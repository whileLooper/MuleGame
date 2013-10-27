import java.awt.Dimension;
import javax.swing.JPanel;


public class Start extends JPanel{

	/**
	 * This is the Start class, which is used to collect user input about game information and player information
	 */
	private Game game;
	
	private int numPlayer;
	private String difficulty;
	private String mapType;
	private Player[] playerList;
	
	/**
	 * This is the constructor of the Start class
	 * @param g
	 */
	public Start(Game g){
		game = g;
		setPreferredSize(new Dimension(900, 500));
		setFocusable(true);
		setVisible(true);
		validate();
	}
	
	/**
	 * This method return the map difficulty chosen by player
	 * @return the map difficulty
	 */
	public String getDifficulty(){
		return difficulty;
	}
	
	/**
	 * This method return the map type chosen by player
	 * @return the map type
	 */
	public String getMapType(){
		return mapType;
	}
	
	/**
	 * This method return the player list that contains player information chosen by players
	 * @return the list of players
	 */
	public Player[] getPlayers(){
		return playerList;
	}
}
