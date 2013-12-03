package enforcedMULE.GUIPresenter;

import java.awt.Color;
import java.awt.event.MouseListener;

public interface TileInterface {

	public void bought(Color color);
	
	public void sold();

	public void addListener(MouseListener mouselistener);
}
