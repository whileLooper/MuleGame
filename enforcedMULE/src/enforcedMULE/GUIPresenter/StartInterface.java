package enforcedMULE.GUIPresenter;

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
	 * create a new game memu
	 */
	public void newGame();
	
	/**
	 * getting the game information from start memu
	 * @return	the starting game information
	 */
	public String[] getGameInfo();
	
	/**
	 * display second player start memu
	 * @param playerNum number of players
	 */
	public void newPlayerMemu(int playerNum);
	
	/**
	 * getting the players information from view
	 * such as player name, race, color
	 * @return	player presenter information
	 */
	public PlayerPresenter getPlayerInfo();
	
	/**
	 * adding a listner to handle all the events in GUI 
	 * @param mouselistener
	 */
	public void addListener(MouseListener mouselistener);
	
}
