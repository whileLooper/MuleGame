import java.awt.Point;
import java.util.ArrayList;




public class InfoStore {

	private String GameDifficulty;
	private Game.GameState GameState;
	private int CurrentPlayer;
	private int CurrentTurn;
	private int TurnTime;
	private boolean PlayerInTown;
	private Player[] Players;
	private ArrayList<ArrayList<Point>> PlayerTiles = new ArrayList<ArrayList<Point>>();
	private ArrayList<ArrayList<Mule>> PlayerMules = new ArrayList<ArrayList<Mule>>();
	
	public InfoStore(Game g){
		collectGameInfo(g);
		collectPlayerInfo(g);
	}
	
	private void collectGameInfo(Game g){
		GameDifficulty = g.getDifficulty();
		GameState = g.getGameState();
		CurrentPlayer = g.getCurrentPlayerInd();
		CurrentTurn = g.getCurrentTurn();
		TurnTime = g.getTurnTime();
		PlayerInTown = g.isPlayerInTown();
	}
	
	private void collectPlayerInfo(Game g){
		Players = g.getPlayers();
		for(Player player: Players){
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
}
