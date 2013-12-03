package enforcedMULE.GUIModel;

public class TileModel {

	private String type;
	private String owner;
	private boolean owned = false;
	private boolean occupied = false;
	
	private int food;
	private int energy;
	private int ore;
	private int crysital;
	
	public TileModel(String t){
		type = t;
	}
	
	public boolean isOwned(){
		return owned;
	}
	
	public void bought(String player){
		owner = player;
	}
	
	public void sold(){
		owned = false;
	}
}
