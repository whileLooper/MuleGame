package enforcedMULE.GUIView;

import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

import enforcedMULE.GUIPresenter.TileInterface;

public class TileView extends JComponent implements TileInterface{

	private String type;
	private Color color;
	
	public TileView(String t){
		type = t;
	}
	
	@Override
	public void bought(Color color) {
		// TODO Auto-generated method stub
		this.color = color;
	}

	@Override
	public void sold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener(MouseListener mouselistener) {
		// TODO Auto-generated method stub
		
	}

}
