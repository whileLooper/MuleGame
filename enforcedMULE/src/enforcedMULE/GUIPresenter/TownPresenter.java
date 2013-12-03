package enforcedMULE.GUIPresenter;

import enforcedMULE.GUIModel.TownModel;
import enforcedMULE.GUIView.TownView;

public class TownPresenter {
	
	private TownView townview;
	private TownModel townmodel;
	
	public TownPresenter(TownView tv, TownModel tm) {
		townview = tv;
		townmodel = tm;
	}
	public void reset() {
		
	}
	
	public void playerEnterStore() {
		
	}
	
	public boolean isPlayerInStore() {
		return false;
	}
	
	public void setPlayerInStore(boolean pis) {

	}
	
	public Store getStore() {
		return store;
	}
}
