import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.gson.Gson;

public class Game{
	

	private JFrame drive;
	private Start start;
	private Map map;
	private Player[] playersList;
	private GameState gState;
	private TurnState tState;
	private InfoPanel info; 
	private String difficulty;
	
	private int currentPlayer;
	private int numOfTurn;
	
	public enum GameState {LandGrant, LandPurchase, PlayerTurns};
	public enum TurnState {};
	
	private boolean passLandPurchase = true;
	
	private int turnTime ;
	private Thread time;
	private Town town;
	
	private boolean playerInTown = false;
	private boolean isReload = false;
	
	
	/**
	 * This is the constructor for Game class
	 * @param d is the one instance of drive class
	 */
	public Game(JFrame d){
		drive = d;
		//drive.setLayout(new FlowLayout());
		start = new Start(this);
		start.setBounds(0, 0, 900, 500);
		drive.add(start);

	}
	
	/**
	 * This method used to change display, and allows changing of state from one location to another, eg. from map to town.
	 * @param toremove is the panel to remove from frame
	 * @param toadd is the panel to add to frame
	 */
	public void changeDisplay(JPanel toremove, JPanel toadd){
		toadd.setBounds(0, 0, 900, 500);
		drive.remove(toremove);
		//drive.remove(info);
		drive.add(toadd);
		//drive.add(info);
		drive.revalidate();
		drive.repaint();
	}
	
	/**
	 * Return the state of the game, whether it is landpurchase, landgrant, or playerturns.
	 */
	public GameState getGameState(){
		return gState;
	}
	
	/**
	 * @return the current player that is playing this turn.
	 */
	public int getCurrentPlayerInd(){
		return currentPlayer;
	}
	
	/**
	 * @return the current turn
	 */
	public int getCurrentTurn(){
		return numOfTurn;
	}
	
	/**
	 * 
	 * @return the turn time.
	 */
	public int getTurnTime(){
		return turnTime;
	}
	
	/**
	 * @return true if player is in town. false if player is not in town.
	 */
	public boolean isPlayerInTown(){
		return playerInTown;
	}
	
	/**
	 * @return the list of players that are currently in the game.
	 */
	public Player[] getPlayers(){
		return playersList;
	}
	
	/**
	 * 
	 * @return the town of the game.
	 */
	public Town getTown(){
		return town;
	}
	
	/**
	 * This method sets up the map
	 */
	public void setUpMap(){
		String mapType = start.getMapType();
		playersList = start.getPlayers();
		difficulty = start.getDifficulty();
		map = new Map(this, mapType);
		town = new Town(this);
		//info = new InfoPanel(playersList, town.getStore());
		currentPlayer = 0;
		numOfTurn = 0;
		gState = GameState.LandGrant;
		
		InfoPanel info = new InfoPanel(getPlayers(),new Store(getDifficulty(),getTown()));
		info.setBounds(0,500, 900, 160);
		drive.add(info);
		changeDisplay(start, map);

	}
	
	/**
	 * This method return current player
	 * @return the player in current turn
	 */
	public Player getCurrentPlayer(){
		return playersList[currentPlayer];
	}
	
	/**
	 * get the difficulty level
	 * @return difficulty level
	 */
	public String getDifficulty(){
		return difficulty;
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
		else if(gState == GameState.PlayerTurns) landprice = 300 + (new Random().nextInt(100));// need to be changed later 
		return currentPlayer.buyLand(landprice, land);
	}
	
	/**
	 * checking the player is able to buy resource or not
	 * @param type 
	 * @param price
	 * @return true if current player is able to buy resource
	 */
	public boolean playerBuyResourcec(String type, int price){
		return getCurrentPlayer().buyResource(type, price);
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
		if(currentPlayer == playersList.length){
			currentPlayer = 0;
			nextTurn();
		}else{
			if(isPlayerTurn()){
				System.out.println("Next Player");
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
				resourceConsume();
				sortPlayer();
				System.out.println("Next Turn");
				System.out.println("Round number: " + numOfTurn);
				harvest();
				//timerReduce(turnTime);
				
			}
		}
		

	}
	
	/**
	 * This method used to deduce players' food and energy every turn they need
	 */
	private void resourceConsume(){
		for(Player p: playersList){
			p.consumeFoodNEnergy(foodNeeded());
		}
	}
	
	/**
	 * This method sort the player according to player's money, player with least money start the turn
	 */
	private void sortPlayer(){
		Arrays.sort(playersList);
		for(Player p : playersList){
			System.out.println(p.getName()+p.getMoney());
		}
	}
	
	/**
	 * This method used to collect players' mule production
	 */
	private void harvest(){
		Tile[][] tilemap = map.getMap();
		for(Player player : playersList){
			int energy = player.getEnergy();
			ArrayList<Mule> mules = player.getMules();
			for(int n = 0; n < mules.size(); n++){
				if(n == energy){
					break;
				}
				Mule mule = mules.get(n);
				String type = mule.getMuleType();
				Point loc = mule.getSetLocation();
				int amount = tilemap[loc.x][loc.y].products(type);
				player.addResource(type, amount);
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
			sortPlayer();
			//timerReduce(turnTime);
			
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
		//town= new Town(this);
		getDirection();
		changeDisplay(map, town);
		playerInTown = true;
	}
	
	/**
	 * This method will be called, when player leaves town
	 */
	public void playerLeaveTown(){
		changeDisplay(town, map);
		playerInTown = false;
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
		changeDisplay(town, map);
		int money = Pub.PubGambling(numOfTurn, turnTime);
		turnTime = 0;
		System.out.println("It's " + numOfTurn + ", and there are " + turnTime + " s left, so player gets " + money 
				+ " through gambling.");
		getCurrentPlayer().addMoney(money);
	}
	
	
	/**
	 * This method mainly control the game process, every player takes an turn to do their things;
	 */
	private void GameStart(){
		time = new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(gState == GameState.PlayerTurns){
					if(!isReload){
						displayReset();
					}
					isReload = false;
					map.setFocusable(true);
					turnTime = playerTime();
					while (turnTime > 0) {
						System.out.println(turnTime + "s left");
						turnTime -= 1;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					getCurrentPlayer().turnEnd();
					nextPlayer();
				}
				
			}
		});
		time.start();
	}
	
	/**
	 * resetting all the display on map
	 */
	private void displayReset(){
		getCurrentPlayer().resetMapLocation();
		map.repaint();
		if(playerInTown){
			changeDisplay(town, map);
			town.reset();
		}
	}
	
	/**
	 * This method decides player's turn time based on player's food amount 
	 * @return the seconds player gets on this turn
	 */
	private int playerTime(){
		Player player = getCurrentPlayer();
		int food = player.getFood();
		int need = foodNeeded();
		if(food >= need) return 50;
		if(food < need && food > 0) return 30;
		return 5;
	}
	
	/**
	 * This method decides how much of food player needs to get through the turn
	 * @return the amount of food need
	 */
	private int foodNeeded(){
		if(numOfTurn >= 1 && numOfTurn < 5){
			return 3;
		}else if(numOfTurn >= 5 && numOfTurn < 9){
			return 4;
		}else{
			return 5;
		}
	}
	
	
	
	/**
	 * when game stop to store the information from game
	 * @return
	 */
	public InfoStore stop(){
		InfoStore infostore = new InfoStore(this);
		return infostore;
	}
	

	/**
	 * the method to determine is it possible to load game
	 * from the saved memory
	 * @return true if be able to load last game record
	 */
	public boolean loadLastGame(){
		String toload = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("record.txt"));
			toload = reader.readLine();
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(toload != null){
			Gson gson = new Gson();
			InfoStore infostore = gson.fromJson(toload, InfoStore.class);
			Restore(infostore);
			return true;
		}else{
			System.out.println("Oops, no record");
			return false;
		}
		
	}
	

	/**
	 * Restore the game
	 * @param infostore is the information library
	 */
	private void Restore(InfoStore infostore){
		isReload = true;
		gState = GameState.PlayerTurns;
		map = new Map(this, "Standard"); // change later for the random map
		difficulty = infostore.getDifficulty();
		currentPlayer = infostore.getCurrentPlayer();
		numOfTurn = infostore.getCurrentTurn();
		turnTime = infostore.getTurnTime();
		playerInTown = infostore.isPlayerInTown();
		playersList = infostore.getPlayers();
		Tile[][] tilemap = map.getMap();
		ArrayList<ArrayList<Point>> tileList = infostore.getPlayerTiles();
		//ArrayList<ArrayList<Mule>> muleList = infostore.getPlayerMules();
		for(int n = 0; n < playersList.length; n++){
			Player player = playersList[n];
			ArrayList<Point> playertile = tileList.get(n); 
			ArrayList<Tile> toAdd = new ArrayList<Tile>();
			for(Point p : playertile){
				int x = p.x;
				int y = p.y;
				Tile tile = tilemap[x][y];
				tile.Restore(player);
				toAdd.add(tile);
			}
			ArrayList<Mule> mulelist = player.Restore(toAdd);
			for(Mule mule : mulelist){
				Point toSet = mule.Restore(player);
				int x = toSet.x;
				int y = toSet.y;
				tilemap[x][y].setMule(mule);
			}
		}
		Player player = getCurrentPlayer();
		map.repaint();
		town = new Town(this);
		town.getStore().Restore(infostore.getFood(), infostore.getEnergy(), infostore.getSmithore(), infostore.getCrystite(), infostore.getMule());
		town.setPlayerInStore(infostore.isPlayerInStore());
		changeDisplay(start, map);
		if(playerInTown){
			changeDisplay(map, town);
		}
		GameStart();
	}
	
}
