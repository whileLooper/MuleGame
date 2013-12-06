import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Town.java
 * Version 249. Copyright One-E
 * town class. contains all the events happen in the town,
 * including all the information relate to town.
 * @author Team: One-E
 *
 */
public class Town extends JPanel{
	
	private Game game;
	
	private Store store;
	
	private boolean playerInStore = false;
	
	/**
	 * This is the constructor for Town class
	 * @param g is the game
	 */
	public Town(Game g){
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Player player= game.getCurrentPlayer();
				Point p = player.getTownLocation();
				int x = p.x;
				int y = p.y;
				int key = e.getKeyCode();
				switch(key){
				case KeyEvent.VK_DOWN:{
					y += 10;
					break;
				}
				case KeyEvent.VK_UP:{
					y -= 10;
					break;
				}
				case KeyEvent.VK_RIGHT:{
					x += 10;
					break;
				}
				case KeyEvent.VK_LEFT:{
					x -= 10;
					break;
				}
				default:
				}
				
				if(x + 50 > 700 || x < 200 || y + 50 > 500 || y < 0){
					System.out.println("Leave Town");
					game.playerLeaveTown();
				}else if((x >= 200 && x + 50 <= 700 && y >= 200 && y + 50 <= 300) //horizontal movement
						|| (x >= 400 && x + 50 <= 500 && y >= 0 && y + 50 <= 500)){//vertical movement
					player.setTownLocation(new Point(x, y));
					repaint();
				}else if(x > 500 && x + 50 < 700 && y < 200){
					System.out.println("Enter Pub");
					game.playerEnterPub();
				}else if(x > 500 && x + 50 < 700 && y + 50 > 300){
					playerEnterStore();
				}
			}
		});
		game = g;
		setFocusable(true);
		setPreferredSize(new Dimension(900, 500));
		setVisible(true);
		repaint();
		store = new Store(game.getDifficulty(), this);
	}
	
	/**
	 * Brings the player out of the store if he is in the store.
	 */
	public void reset(){
		if(playerInStore){
			playerOutStore();
			store.reset();
		}
	}
	
	/**
	 * This method called when player enters store
	 */
	public void playerEnterStore(){
		add(store);
		revalidate();
		repaint();
		//MP3 mp3 = MP3Singleton.getInstance();
		//mp3.changeMusic("MM.mp3");
		playerInStore = true;
		store.playerEnterStore(game.getCurrentPlayer());
	}
	
	/**
	 * Moves the player out of the store.
	 */
	public void playerOutStore(){
		remove(store);
		revalidate();
		repaint();
		//MP3 mp3 = MP3Singleton.getInstance();
		//mp3.changeMusic("JY.mp3");
		playerInStore = false;
		
	}
	
	/**
	 * Checks if the player is in the store.
	 */
	public boolean isPlayerInStore(){
		return playerInStore;
	}
	
	/**
	 * Brings the player into store.
	 * @param pis true if the player wants to get into the store.
	 */
	public void setPlayerInStore(boolean pis){
		playerInStore = pis;
		if(playerInStore){
			playerEnterStore();
		}
	}
	/**
	 * This method used to get store object in Town class
	 * @return
	 */
	public Store getStore(){
		return store;
	}
	
	@Override
	/**
	 * This method overrides its superclass'
	 */
	protected void paintComponent(Graphics g){
		this.requestFocusInWindow();
		super.paintComponent(g);
		g.drawImage((new ImageIcon("Image/towna.png")).getImage(), 0,0, 900, 500, null);
		if(!playerInStore){
			game.getCurrentPlayer().drawOnTown(g);
		}
	}
}
