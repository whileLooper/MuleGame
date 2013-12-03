package enforcedMULE.GUIModel;

import enforcedMULE.GUIPresenter.PlayerPresenter;

/**
 * The start model class, contains all the 
 * start memu information, the basic dota.
 * @author Team: OneE
 *
 */
public class StartModel {
	
	public static String difficulty;
	public static String maptype;
	public static int numOfPlayer;
	
	public static PlayerPresenter[] players;
	
	public static int currentN = 0;
	
	/**
	 * The constructure of startModel class
	 */
	private StartModel(){
		
	}
	
	/**
	 * changing the dota from view
	 * @param info	the starting game information, such as 
	 * player number, difficulty, map type
	 */
	public void setupGameInfo(String[] info){
		difficulty = info[0];
		maptype = info[1];
		numOfPlayer = Integer.parseInt(info[2]);
		players = new PlayerPresenter[numOfPlayer];
	}
	
	/**
	 * add muti players into game 
	 * @param player  a array of players
	 * @return	current number of players
	 */
	public int addPlayer(PlayerPresenter player){
		players[currentN] = player;
		currentN ++;
		if(currentN == numOfPlayer) return -1;
		return currentN;
	}
	
	
}
