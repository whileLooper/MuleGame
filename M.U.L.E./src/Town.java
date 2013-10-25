import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Town extends JPanel implements KeyListener {
	private Image backGround = new ImageIcon("src/townBackground.png").getImage();
	private Game game;
	private Point pLocation;
	private Player player;
	
	public Town(Player p, Game g) {
		game = g;
		player = p;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(backGround, 0, 0, 1000, 1000, null); // Draws background
		g.drawImage(player.getImage(), 0, 0, 50, 50, null); // Draws player
	}
	
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'w' && pLocation.getY() > 0) {
			pLocation.setLocation(pLocation.getX(), pLocation.getY()-1);
		}
		else if (e.getKeyChar() == 's' && pLocation.getY() < backGround.getHeight(null)) {
			pLocation.setLocation(pLocation.getX(), pLocation.getY()+1);
		}
		else if (e.getKeyChar() == 'd' && pLocation.getX() < backGround.getWidth(null)) {
			pLocation.setLocation(pLocation.getX()+1, pLocation.getY());
		}
		else if (e.getKeyChar() == 'a' && pLocation.getX() > 0) {
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
