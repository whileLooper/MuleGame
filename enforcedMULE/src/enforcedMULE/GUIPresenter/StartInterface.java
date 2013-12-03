package enforcedMULE.GUIPresenter;

import java.awt.Graphics;
import java.awt.event.MouseListener;

import enforcedMULE.GUIModel.PlayerModel;

/**
 * The interface of startview
 * @author Team: OneE
 *
 */
public interface StartInterface {
	
	/**
	 * choose new game or load game
	 */
	public void start();
	
	/**
	 * create a new game menu
	 */
	public void newGame();
	
	/**
	 * getting the game information from start menu
	 * @return	the starting game information
	 */
	public String[] getGameInfo();
	
	/**
	 * display second player start menu
	 * @param playerNum number of players
	 */
	public void newPlayerMenu(int playerNum);
	
	/**
	 * getting the players information from view
	 * such as player name, race, color
	 * @return	player presenter information
	 */
	public PlayerPresenter getPlayerInfo();
	
	/**
	 * adding a listener to handle all the events in GUI 
	 * @param mouselistener
	 */
	public void addListener(MouseListener mouselistener);
	
	/**
	 * paint component method for painting 
	 * @param page the graphics
	 */
	public void paintComponent(Graphics page);

}