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
	 * @return
	 */
	public String[] getGameInfo();
	
	public void newPlayer(int playerNum);
	
	public PlayerModel getPlayerInfo();
	
	public void addListener(MouseListener mouselistener);
	
}
