import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class Map extends JPanel{

	
	private Tile[][] tiles = new Tile[5][9];
	private Game game;
	
	/**
	 * This is constructor of the Map class
	 * @param mapType is the type of map to initiate
	 */
	public Map(Game g, String mapType){
		game = g;
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("mouse pressed");
				Point point = e.getPoint();
				int x = point.x / 100;
				int y = point.y / 100;
				//System.out.println(x + " " + y + " " + tiles[y][x]);
				game.mouseClicked(tiles[y][x]);
			}
		});
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("Key pressed");
				if(game.isPlayerTurn()){
					Player player= game.getCurrentPlayer();
					Point p = player.getMapLocation();
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
					
					if(x + 50 > 400 && x < 500 && y + 50 > 200 && y < 300){
						System.out.println("enter town");
						game.playerEnterTown();
					}else if(x >= 0 && x + 50 <= 900 && y >= 0 && y + 50 <= 500){
						player.setMapLocation(new Point(x, y));
						repaint();
					}
				}
			}
		});
		
		setFocusable(true);
		setPreferredSize(new Dimension(900, 500));
		setLayout(new GridLayout(5, 9, 0, 0));
		createMap(mapType);
		setVisible(true);
		validate();
		repaint();
	}
	
	/**
	 * This method decides which type of the map to create, and call the responding method
	 * @param mapType is the type of the map
	 */
	private void createMap(String mapType){
		switch(mapType){
		case "Standard":{
			standardMap();
			break;
		}
		case "Ramdon":{
			randomMap();
			break;
		}
		}
	}
	
	/**
	 * This method initiates a standard map
	 */
	private void standardMap(){
		String[][] cmap = { {"P","P","M1","P","R","P","M3","P","P"},
				            {"P","M1","P","P","R","P","P","P","M3"},
				            {"M3","P","P","P","Town","P","P","P","M1"},
				            {"P","M2","P","P","R","P","M2","P","P"},
				            {"P","P","M2","P","R","P","P","P","M2"}};		

		for(int i = 0; i < 5; i ++){
			for(int j = 0; j < 9; j++){
				String tileS = cmap[i][j];
				Tile tile;
				switch(tileS){
					case "P":{
						tile = new Plain();
						break;
					}
					case "R":{
						tile = new River();
						break;
					}
					case "M1":{
						tile = new M1();
						break;
					}
					case "M2":{
						tile = new M2();
						break;
					}
					case "M3":{
						tile = new M3();
						break;
					}
					case "Town":{
						tile = new TownT();
						break;
					}
					default:{
						tile = null;
					}
				}
				tiles[i][j] = tile;
				add(tile);
			}
		}
	}
	
	/**
	 * This method initiates a random map
	 */
	private void randomMap(){
		
	}
	
	@Override
	/**
	 * This method overrides the one in superclass to draw player
	 */
	protected void paintChildren(Graphics g) {
        super.paintChildren(g);
        if(game.isPlayerTurn()){
        	game.getCurrentPlayer().drawOnMap(g);
        }
    } 
}
