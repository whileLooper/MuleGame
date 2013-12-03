package enforcedMULE.GUIPresenter;

import enforcedMULE.GUIModel.TileModel;

public class TilePresenter {

	private TileModel model;
	private TileInterface view;

	public TilePresenter(TileModel tM, TileInterface tI){
		model = tM;
		view = tI;
	}
	
	
}
