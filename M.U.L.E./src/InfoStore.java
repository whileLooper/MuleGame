import java.awt.Point;
import java.util.ArrayList;




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
	/**
	private Point CurrentPlayerMapLocation;
	private Point CurrentPlayerTownLocation = null;
	private Mule CurrentPlayerMule = null;
	*/
	
	public InfoStore(Game g){
		collectGameInfo(g);
		collectPlayerInfo(g);
		collectStoreTownInfo(g);
	}
	
	private void collectGameInfo(Game g){
		GameDifficulty = g.getDifficulty();
		//GameState = g.getGameState();
		CurrentPlayer = g.getCurrentPlayerInd();
		CurrentTurn = g.getCurrentTurn();
		TurnTime = g.getTurnTime();
		PlayerInTown = g.isPlayerInTown();
	}
	
	private void collectPlayerInfo(Game g){
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
	
	private void collectStoreTownInfo(Game g){
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
	
	
	public String getDifficulty(){
		return GameDifficulty;
	}
	
	public int getCurrentPlayer(){
		return CurrentPlayer;
	}
	public int getCurrentTurn(){
		return CurrentTurn;
	}
	public int getTurnTime(){
		return TurnTime;
	}
	public boolean isPlayerInTown(){
		return PlayerInTown;
	}
	public Player[] getPlayers(){
		return Players;
	}
	public ArrayList<ArrayList<Point>> getPlayerTiles(){
		return PlayerTiles;
	}
	
	public ArrayList<ArrayList<Mule>> getPlayerMules(){
		return PlayerMules;
	}
	public int getFood(){
		return Food;
	}
	public int getEnergy(){
		return Energy;
	}
	public int getSmithore(){
		return Smithore;
	}
	public int getCrystite(){
		return Crystite;
	}
	public int getMule(){
		return Mule;
	}
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
