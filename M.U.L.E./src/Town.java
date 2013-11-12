import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


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
				
				if(x + 50 > 500 || x < 0 || y + 50 > 300 || y < 0){
					System.out.println("Leave Town");
					game.playerLeaveTown();
				}else if((x >= 0 && x + 50 <= 500 && y >= 100 && y + 50 <= 200) || (x >= 200 && x + 50 <= 300 && y >= 0 && y + 50 <= 300)){
					player.setTownLocation(new Point(x, y));
					repaint();
				}else if(x > 310 && x + 50 < 490 && y < 100){
					System.out.println("Enter Pub");
					game.playerEnterPub();
				}else if(x > 310 && x + 50 < 490 && y + 50 > 200){
					playerEnterStore();
				}
			}
		});
		game = g;
		setFocusable(true);
		setPreferredSize(new Dimension(500, 300));
		setVisible(true);
		repaint();
		store = new Store(game.getDifficulty(), this);
	}
	
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
		playerInStore = true;
		store.playerEnterTown(game.getCurrentPlayer());
	}
	
	public void playerOutStore(){
		remove(store);
		revalidate();
		repaint();
		playerInStore = false;
	}
	
	public boolean isPlayerInStore(){
		return playerInStore;
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
		super.paintComponent(g);
		g.drawImage((new ImageIcon("townp.png")).getImage(), 0,0, 500, 300, null);
		if(!playerInStore){
			game.getCurrentPlayer().drawOnTown(g);
		}
	}
}
