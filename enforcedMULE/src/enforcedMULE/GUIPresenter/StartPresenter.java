package enforcedMULE.GUIPresenter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import enforcedMULE.GUIModel.StartModel;

public class StartPresenter {
	
	private StartModel model;
	private StartInterface view;
	
	public StartPresenter(StartModel sM, StartInterface sI){
		model = sM;
		view = sI;
		view.start();
		addStartListener();
	}

	private void addStartListener() {
		// TODO Auto-generated method stub
		view.addListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton clicked = (JButton) e.getSource();
				String text = clicked.getText();
				if(text.equals("New Game")){
					view.newGame();
					addGameListener();
				}else{
					//load last game
				}
			}
		});
	}

	protected void addGameListener() {
		// TODO Auto-generated method stub
		view.addListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton clicked = (JButton) e.getSource();
				String text = clicked.getText();
				if(text.equals("Next")){
					model.setupGameInfo(view.getGameInfo());
					view.newPlayerMenu(0);
					addPlayerListener();
				}
			}
		});
	}

	protected void addPlayerListener() {
		// TODO Auto-generated method stub
		view.addListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton clicked = (JButton) e.getSource();
				String text = clicked.getText();
				if(text.equals("Next")){
					int n = model.addPlayer(view.getPlayerInfo());
					if(n > -1){
						view.newPlayerMenu(n);
					}else{
						//enter game
					}
				}
			}
		});
	}

}
