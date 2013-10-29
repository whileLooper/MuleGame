import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Town extends JPanel{
	
	private Game game;
	
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
				
				if(x + 50 >= 500 || x <= 0 || y + 50 >= 300 && y <= 0){
					System.out.println("Leave Town");
					game.playerLeaveTown();
				}else if((x > 0 && x + 50 < 500 && y >= 100 && y + 50 <= 200) || (x >= 200 && x + 50 <= 300 && y > 0 && y + 50 < 300)){
					player.setTownLocation(new Point(x, y));
					repaint();
				}else if(x > 310 && x + 50 < 390 && y + 50 > 200){
					System.out.println("Enter Pub");
					game.playerEnterPub();
				}
			}
		});
		game = g;
		setFocusable(true);
		setPreferredSize(new Dimension(500, 300));
		setVisible(true);
		repaint();
	}
	
	@Override
	/**
	 * This method overrides its superclass'
	 */
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage((new ImageIcon("townp.png")).getImage(), 0,0, 500, 300, null);
		game.getCurrentPlayer().drawOnTown(g);
	}
}
