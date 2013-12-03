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
	 * 
	 */
	public void start();
	
	public void newGame();
	
	public String[] getGameInfo();
	
	public void newPlayer(int playerNum);
	
	public PlayerModel getPlayerInfo();
	
	public void addListener(MouseListener mouselistener);
	
}
