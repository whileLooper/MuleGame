
public class Game {

	private Drive drive;
	private Start start;
	private Map map;
	private Player[] players;
	private GameState gState;
	private TurnState tState;
	
	private int currentPlayer;
	
	public enum GameState {LandGrant, LandPurchase, PlayerTurns};
	public enum TurnState {};
	
	/**
	 * This is the constructor for Game class
	 * @param d is the one instance of drive class
	 */
	public Game(Drive d){
		drive = d;
		start = new Start(this);
		d.add(start);
	}
	
	/**
	 * This method sets up the map
	 */
	public void setUpMap(){
		String mapType = start.getMapType();
		players = start.getPlayers();
		map = new Map(mapType);
		drive.removeAll();
		drive.add(map);
		currentPlayer = 0;
		gState = GameState.LandGrant;
	}
	
	/**
	 * This method return current player
	 * @return the player in current turn
	 */
	public Player getCurrentPlayer(){
		return players[currentPlayer];
	}
	
	/**
	 * This method is used to do land purchase, price of the land will be decided by current game state, 0 for land grand,
	 * 300 for land purchase period, and during players' turns, which means that player buy land from land office, the price
	 * of the land is decided by game turn
	 * @param land is the tile selected by player;
	 */
	public void playerBuyLand(Tile land){
		Player currentPlayer = getCurrentPlayer();
		int landprice = 0;
		if(gState == GameState.LandPurchase) landprice = 300;
		else if(gState == GameState.PlayerTurns) landprice = 300;// need to be changed later 
		currentPlayer.buyLand(landprice, land);
	}
}
