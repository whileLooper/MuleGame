package enforcedMULE.GUIPresenter;

import java.awt.event.MouseListener;
import enforcedMULE.GUIModel.PlayerModel;

public interface StartInterface {
	
	public void start();
	
	public void newGame();
	
	public String[] getGameInfo();
	
	public void newPlayer();
	
	public PlayerModel getPlayerInfo();
	
	public void addListener(MouseListener mouselistener);
	
}
