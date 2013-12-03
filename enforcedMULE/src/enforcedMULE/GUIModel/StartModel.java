package enforcedMULE.GUIModel;

import enforcedMULE.GUIPresenter.PlayerPresenter;

public class StartModel {
	
	public static String difficulty;
	public static String maptype;
	public static int numOfPlayer;
	
	public static PlayerPresenter[] players;
	
	public static int currentN = 0;
	
	private StartModel(){
		
	}
	
	public void setupGameInfo(String[] info){
		difficulty = info[0];
		maptype = info[1];
		numOfPlayer = Integer.parseInt(info[2]);
		players = new PlayerPresenter[numOfPlayer];
	}
	
	public int addPlayer(PlayerPresenter player){
		players[currentN] = player;
		currentN ++;
		if(currentN == numOfPlayer) return -1;
		return currentN;
	}

}
