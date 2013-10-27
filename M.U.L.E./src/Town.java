import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import StorePackage.Pub;

public class Town extends JPanel implements KeyListener {
	private Image backGround;
	private Game game;
	private Point pLocation;
	private Player player;
	private String direction;
	private final int PLAYER_SIZE = 50;
	
	/**
	 * Constructor for town.
	 * 
	 * @param p Player
	 * @param g Game
	 * @param direction Direction of player when entering town.
	 */
	public Town(Player p, Game g, String d) {
		game = g;
		player = p;
		backGround = new ImageIcon("src/townBackground.png").getImage();
		switch(d) {
			case "NORTH": pLocation=new Point(200+PLAYER_SIZE/2, 0);
			case "SOUTH": pLocation=new Point(200+PLAYER_SIZE/2, backGround.getHeight(null)-PLAYER_SIZE);
			case "EAST": pLocation=new Point(0,100+PLAYER_SIZE/2);
			case "WEST": pLocation=new Point(backGround.getWidth(null)-PLAYER_SIZE, 100+PLAYER_SIZE/2);
			default:
				
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(backGround, 0, 0, 1000, 1000, null); // Draws background
		g.drawImage(player.getImage(), (int)pLocation.getX(), (int)pLocation.getY(), PLAYER_SIZE, PLAYER_SIZE, null); // Draws player
	}
	
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}b
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_UP && pLocation.getY() > 0) {
			pLocation.setLocation(pLocation.getX(), pLocation.getY()-1);
		}
		else if (e.getKeyChar() == KeyEvent.VK_DOWN && pLocation.getY() < backGround.getHeight(null)) {
			pLocation.setLocation(pLocation.getX(), pLocation.getY()+1);
		}
		else if (e.getKeyChar() == KeyEvent.VK_RIGHT && pLocation.getX() < backGround.getWidth(null)) {
			pLocation.setLocation(pLocation.getX()+1, pLocation.getY());
		}
		else if (e.getKeyChar() == KeyEvent.VK_LEFT && pLocation.getX() > 0) {
			pLocation.setLocation(pLocation.getX()-1, pLocation.getY());
		}
		if (pLocation.getY() == backGround.getHeight(null)) {
			if (pLocation.getX() > 100 && pLocation.getX() < 100) {
				game.playerOutTown(); // Player get back to Map
			}
		}
		repaint();
	}
}
