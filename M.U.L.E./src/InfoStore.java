import java.awt.Point;
import java.util.ArrayList;

/**
 * InfoStore.java
 * Version 253. Copyright One-E
 * @author One-E
 * 
 * The class that stores the information of the game.
 *
 */
public class InfoStore {

	private String GameDifficulty;
	//private Game.GameState GameState;
	private int CurrentPlayer;
	private int CurrentTurn;
	private int TurnTime;
	private boolean PlayerInTown;
	private Player[] Players;
	private ArrayList<ArrayList<Point>> PlayerTiles = new ArrayList<ArrayList<Point>>();
	private ArrayList<ArrayList<Mule>> PlayerMules = new ArrayList<ArrayList<Mule>>();
	private int Food, Energy, Smithore, Crystite, Mule; 
	private boolean PlayerInStore = false;
	private Game g;
	/**
	private Point CurrentPlayerMapLocation;
	private Point CurrentPlayerTownLocation = null;
	private Mule CurrentPlayerMule = null;
	*/
	
	/**
	 * Constructor for InfoStore class. Takes in the game.
	 */
	public InfoStore(Game g){
		this.g = g;
		collectGameInfo();
		collectPlayerInfo();
		collectStoreTownInfo();
	}
	
	/**
	 * Collect the game info of the game 
	 */
	private void collectGameInfo(){
		GameDifficulty = g.getDifficulty();
		//GameState = g.getGameState();
		CurrentPlayer = g.getCurrentPlayerInd();
		CurrentTurn = g.getCurrentTurn();
		TurnTime = g.getTurnTime();
		PlayerInTown = g.isPlayerInTown();
	}
	
	/**
	 * Collect the player info of the game
	 */
	private void collectPlayerInfo(){
		Players = g.getPlayers();
		for(Player player: Players){
			/**
			if(player == g.getCurrentPlayer()){
				
				CurrentPlayerMapLocation = player.getMapLocation();
				if(PlayerInTown){
					CurrentPlayerTownLocation = player.getTownLocation();
				}
				if(player.getMule() != null){
					CurrentPlayerMule = player.getMule();
				}
				
			}
			*/
			ArrayList<Tile> lands = player.getTiles();
			ArrayList<Point> tile = new ArrayList<Point>();
			ArrayList<Mule> mule = new ArrayList<Mule>();
			for(Tile land : lands){
				Point p = land.getPoint();
				Mule m = land.getMule();
				tile.add(p);
				mule.add(m);
			}
			PlayerTiles.add(tile);
			PlayerMules.add(mule);
		}
	}
	
	/**
	 * Collect the town info
	 */
	private void collectStoreTownInfo(){
		Town town = g.getTown();
		if(PlayerInTown){
			PlayerInStore = town.isPlayerInStore();
		}
		Store store = town.getStore();
		Food = store.getFood();
		Energy = store.getEnergy();
		Smithore = store.getSmithore();
		Crystite = store.getCrystite();
		Mule = store.getMule();
	}
	
	/**
	 * Getter for the difficulty
	 * 
	 * @return the difficulty of the game.
	 */
	public String getDifficulty(){
		return GameDifficulty;
	}
	
	/**
	 * Getter for the current player.
	 * 
	 * @return the current player.
	 */
	public int getCurrentPlayer(){
		return CurrentPlayer;
	}
	
	/**
	 * Getter for the current turn.
	 * 
	 * @return the current turn.
	 */
	public int getCurrentTurn(){
		return CurrentTurn;
	}
	
	/**
	 * Getter for the turn time.
	 * 
	 * @return the turn time.
	 */
	public int getTurnTime(){
		return TurnTime;
	}
	
	/**
	 * Check if player is in town.
	 * @return true if player is in town.
	 */
	public boolean isPlayerInTown(){
		return PlayerInTown;
	}
	
	/**
	 * Getter for the list of players
	 * 
	 * @return the list of players
	 */
	public Player[] getPlayers(){
		return Players;
	}
	
	/**
	 * Getter for the player tiles 
	 * 
	 * @return the list of player tiles
	 */
	public ArrayList<ArrayList<Point>> getPlayerTiles(){
		return PlayerTiles;
	}
	
	/**
	 * Getter for the player mules
	 * @return the player mules
	 */
	public ArrayList<ArrayList<Mule>> getPlayerMules(){
		return PlayerMules;
	}
	
	/**
	 * Getter for food
	 * @return the amount of food.
	 */
	public int getFood(){
		return Food;
	}
	
	/**
	 * Getter for the energy.
	 * @return the amount of energy.
	 */
	public int getEnergy(){
		return Energy;
	}
	
	/**
	 * Getter for the smithore
	 * @return the amount of smithore
	 */
	public int getSmithore(){
		return Smithore;
	}
	
	/**
	 * Getter for the crystite
	 * @return the amount of crystite.
	 */
	public int getCrystite(){
		return Crystite;
	}
	
	/**
	 * Getter for the mule
	 * @return the amount of mules.
	 */
	public int getMule(){
		return Mule;
	}
	
	/**
	 * Check if player is in store.
	 * @return true if player is in store.
	 */
	public boolean isPlayerInStore(){
		return PlayerInStore;
	}
	/**
	public Point getCurrentPlayerMapLocation(){
		return CurrentPlayerMapLocation;
	}
	public Point getCurrentPlayerTownLocation(){
		return CurrentPlayerTownLocation;
	}
	public Mule getCurrentPlayerMule(){
		return CurrentPlayerMule;
	}
	*/
}
