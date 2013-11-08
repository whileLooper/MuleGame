import java.awt.FlowLayout;
import java.awt.Point;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game {

	private JFrame drive;
	private Start start;
	private Map map;
	private Player[] players;
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
	private final int requireFood = 10;
	private Thread time;
	private Town town;
	
	private boolean playerInTown = false;
	
	/**
	 * This is the constructor for Game class
	 * @param d is the one instance of drive class
	 */
	public Game(JFrame d){
		drive = d;
		drive.setLayout(new FlowLayout());
		start = new Start(this);
		d.getContentPane().add(start);
		//d.getContentPane().add(info);
	}
	
	/**
	 * This method used to change display
	 * @param toremove is the panel to remove from frame
	 * @param toadd is the panel to add to frame
	 */
	public void changeDisplay(JPanel toremove, JPanel toadd){
		drive.remove(toremove);
		//drive.remove(info);
		drive.add(toadd);
		//drive.add(info);
		drive.revalidate();
		drive.repaint();
	}
	
	/**
	 * This method sets up the map
	 */
	public void setUpMap(){
		String mapType = start.getMapType();
		players = start.getPlayers();
		difficulty = start.getDifficulty();
		map = new Map(this, mapType);
		town = new Town(this);
		info = new InfoPanel(players, town.getStore());
		changeDisplay(start, map);
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
		if(currentPlayer == players.length){
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
				System.out.println("Next Turn");
				sortPlayer();
				//timerReduce(turnTime);
				
			}
		}
	}
	
	/**
	 * This method sort the player according to player's money, player with least money start the turn
	 */
	private void sortPlayer(){
		Arrays.sort(players);
		for(Player p : players){
			System.out.println(p.getName()+p.getMoney());
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
		nextPlayer();
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
					displayReset();
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
	 * 
 	 * @param round the current round the game is at
 	 * Random an int from 1 to 100, 27% chance of event occuring.
 	 * If any event occur, 1/7 chance for any event to occur.
	 */
	public void randomEvent(int round) {
		Player p = getCurrentPlayer();
		boolean event;
		int factor;
		
		switch (round) {
		case 1: factor = 25; break;
		case 2: factor = 25; break;
		case 3: factor = 25; break;
		case 4: factor = 50; break;
		case 5: factor = 50; break;
		case 6: factor = 50; break;
		case 7: factor = 50; break;
		case 8: factor = 75; break;
		case 9: factor = 75; break;
		case 10: factor = 75; break;
		case 11: factor = 75; break;
		case 12: factor = 100; break;
		default: factor = 0;
		}
		String[] events = {"YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.",
				"A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.",
				"THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $ " + 8*factor + ".",
				"YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $ " +2*factor+".",
				"FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $ "+ 4*factor+".",
				"MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.",
				"YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $ "+6*factor+" TO CLEAN IT UP."
		};
		Random gen = new Random(99);
		Random gen1 = new Random(6);
		int rand = gen.nextInt()+1;
		int eventSelection = gen1.nextInt()+1;
		if (rand >= 1 && rand <= 27) {
			event = true;
		}
		else {
			event = false;
		}
		if (event) {
			System.out.println(events[eventSelection]);
			if (eventSelection == 1) {
				p.addFood(3);
				p.addEnergy(2);
			}
			else if (eventSelection == 2) {
				p.addOre(2);
			}
			else if (eventSelection == 3) {
				p.addMoney(8*factor);
			}
			else if (eventSelection == 4) {
				p.addMoney(2*factor);
			}
			else if (eventSelection == 5) {
				p.addMoney(-4*factor);
			}
			else if (eventSelection == 6) {
				p.addFood(p.getFood()/2*-1);
			}
			else if (eventSelection == 7) {
				p.addMoney(-6*factor);
			}
		}
	}
	
}
