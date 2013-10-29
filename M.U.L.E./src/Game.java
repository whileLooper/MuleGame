import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JFrame;


public class Game {

	private JFrame drive;
	private Start start;
	private Map map;
	private Player[] players;
	private GameState gState;
	private TurnState tState;
	private InfoPanel info; 
	
	private int currentPlayer;
	private int numOfTurn;
	
	public enum GameState {LandGrant, LandPurchase, PlayerTurns};
	public enum TurnState {};
	
	private boolean passLandPurchase = true;
	
	private int turnTime;
	
	/**
	 * This is the constructor for Game class
	 * @param d is the one instance of drive class
	 */
	public Game(JFrame d){
		drive = d;
		drive.setLayout(new FlowLayout());
		start = new Start(this);
		info = new InfoPanel();
		d.getContentPane().add(start);
		d.getContentPane().add(info);
	}
	
	/**
	 * This method sets up the map
	 */
	public void setUpMap(){
		String mapType = start.getMapType();
		players = start.getPlayers();
		map = new Map(this, mapType);
		//drive.getContentPane().remove(start);
		//start.setVisible(false);
		drive.remove(start);
		drive.remove(info);
		drive.add(map);
		drive.add(info);
		drive.revalidate();
		currentPlayer = 0;
		numOfTurn = 0;
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
	 * of the land is decided by game turn, and at last it will return a boolean value to indicate whether the deal is successful
	 * @param land is the tile selected by player;
	 */
	public boolean playerBuyLand(Tile land){
		Player currentPlayer = getCurrentPlayer();
		int landprice = 0;
		if(gState == GameState.LandPurchase) landprice = 300;
		else if(gState == GameState.PlayerTurns) landprice = 300;// need to be changed later 
		return currentPlayer.buyLand(landprice, land);
	}
	
	/**
	 * This method decided what to do after player click mouse
	 * @param land is the tile people clicked on
	 */
	public void mouseClicked(Tile land){
		if(gState == GameState.LandGrant){
			if(playerBuyLand(land)){
				nextPlayer();
			}
		}else if(gState == GameState.LandPurchase){
			if(playerBuyLand(land)){
				passLandPurchase = false;
				nextPlayer();
			}else if(land.getClass() == TownT.class){
				nextPlayer();
			}
		}
	}
	
	
	/**
	 * This method will be called, when one player finishes his turn, and process to next player
	 */
	private void nextPlayer(){
		currentPlayer ++;
		if(currentPlayer == players.length){
			currentPlayer = 0;
			nextTurn();
		}else{
			if(isPlayerTurn()){
				System.out.println("Next Player");
				GameStart();
			}
		}
	}
	
	/**
	 * This method will be called, after all players finish their turns in a round, and process to next round
	 */
	private void nextTurn(){
		numOfTurn ++;
		if(gState == GameState.LandGrant){
			if(numOfTurn == 2) nextGameState();
		}else if(gState == GameState.LandPurchase){
			if(passLandPurchase) nextGameState();
			else passLandPurchase = true;
		}else if(gState == GameState.PlayerTurns){
			if(numOfTurn == 12){
				// end of game!
			}else{
				System.out.println("Next Player");
				GameStart();
			}
		}
	}
	
	/**
	 * This method will be called if the game should move on to next game state.
	 */
	private void nextGameState(){
		numOfTurn = 0;
		if(gState == GameState.LandGrant) gState = GameState.LandPurchase;
		else if(gState == GameState.LandPurchase){
			gState = GameState.PlayerTurns;
			map.repaint();
			GameStart();
		}
	}
	
	/**
	 * This method check whether the game is in the player turns
	 * @return true if it's in player turns, false if not
	 */
	public boolean isPlayerTurn(){
		if(gState == GameState.PlayerTurns) return true;
		return false;
	}
	
	/**
	 * This method will be called, when player touches town tile, and player will enter town, the town panel will be display
	 */
	public void playerEnterTown(){
		Town town= new Town(this);
		getDirection();
		drive.remove(map);
		drive.add(town);
		drive.revalidate();
	}
	
	/**
	 * This method will be called, when player leaves town
	 */
	public void playerLeaveTown(){
		
	}
	
	/**
	 * This method determines the direction player enter town
	 */
	private void getDirection(){
		Player player = getCurrentPlayer();
		Point pOnM = player.getMapLocation();
		int x = pOnM.x;
		int y = pOnM.y;
		if(y > 150 && y < 300 && x < 350){
			player.setTownLocation(new Point(0, 125));
		}else if(x > 350 && x < 500 && y < 200){
			player.setTownLocation(new Point(225, 0));
		}else if(y > 150 && y < 300 && x > 500){
			player.setTownLocation(new Point(450, 125));
		}else{
			player.setTownLocation(new Point(225, 250));
		}
	}
	
	/**
	 * This method will be called, when player enters pub
	 */
	public void playerEnterPub(){
		
	}
	
	
	/**
	 * This method mainly control the game process, every player takes an turn to do their things;
	 */
	private void GameStart(){
		map.setFocusable(true);
		
		Thread time = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				turnTime = 50;
				while(turnTime > 0){
					System.out.println(turnTime + "s left");
					turnTime -= 1;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				nextPlayer();
			}
		});
		time.start();
	}
	
}
