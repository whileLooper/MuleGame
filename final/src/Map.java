import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
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
import java.util.Random;

/**
 * Map.java
 * Version 279. Copyright One-E
 * @author One-E
 *
 */
public class Map extends JPanel{
	
	private Tile[][] tiles = new Tile[5][9];
	private Game game;
	
	/**
	 * This is constructor of the Map class
	 * @param mapType is the type of map to initiate
	 * @param g the current game.
	 */
	public Map(Game g, String mapType){
		game = g;
		this.requestFocusInWindow();
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
		
		this.requestFocusInWindow(true);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println("Key pressed");
				if (game.isPlayerTurn()) {
					Player player = game.getCurrentPlayer();
					Point p = player.getMapLocation();
					int x = p.x;
					int y = p.y;
					int key = e.getKeyCode();
					switch (key) {
					case KeyEvent.VK_DOWN: {
						y += 10;
						break;
					}
					case KeyEvent.VK_UP: {
						y -= 10;
						break;
					}
					case KeyEvent.VK_RIGHT: {
						x += 10;
						break;
					}
					case KeyEvent.VK_LEFT: {
						x -= 10;
						break;
					}
					case KeyEvent.VK_SPACE: {
						Tile tile = (Tile) getComponentAt(new Point(x, y));
						player.setMule(tile);
						//repaint();
						break;
					}
					case KeyEvent.VK_C: {
						Tile tile = (Tile) getComponentAt(new Point(x, y));
						player.crystiteMining(tile);
						player.riverFishing(tile);
						//repaint();
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
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(900, 500));
		this.setLayout(new GridLayout(5, 9, 0, 0));
		this.createMap(mapType);
		this.setVisible(true);
		this.validate();
		this.repaint();

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
		case "Random":{
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
						tile = new Plain(new Point(i,j));
						break;
					}
					case "R":{
						tile = new River(new Point(i,j));
						break;
					}
					case "M1":{
						tile = new M1(new Point(i,j));
						break;
					}
					case "M2":{
						tile = new M2(new Point(i,j));
						break;
					}
					case "M3":{
						tile = new M3(new Point(i,j));
						break;
					}
					case "Town":{
						tile = new TownT(new Point(i,j));
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
		Random gen = new Random();
		int M1Count = 0;
		int M2Count = 0;
		int M3Count = 0;
		int River = 0;
		int Plain = 0;
		for(int i = 0; i < 5; i ++){
			for(int j = 0; j < 9; j++){
				int rand = gen.nextInt(5);
			if (i == 2 && j == 4) {
				add(new TownT(new Point(i,j)));
			}
			else {
				if (rand == 1) {
					add(new Plain(new Point(i,j)));
					Plain+=1;
				}
				else if (rand == 2) {
					add(new M1(new Point(i, j)));
					M1Count+=1;
				}
				else if (rand == 3) {
					add(new M2(new Point(i, j)));
					M2Count+=1;
				}
				else if (rand == 4) {
					add(new M3(new Point(i, j)));
					M3Count+=1;
				}
				else if (rand == 0) {
					add(new River(new Point(i, j)));
					River+=1;
				}
				System.out.println(Plain + " " + M1Count + " " + M2Count + " " + M3Count + " " + River);
			}
			}
		}
	}
	
	/**
	 * Getter of a 2d array of the map
	 * @return the map
	 */
	public Tile[][] getMap(){
		return tiles;
	}
	
	@Override
	/**
	 * This method overrides the one in superclass to draw player
	 */
	protected void paintChildren(Graphics g) {
		this.requestFocusInWindow();
        super.paintChildren(g);
        if(game.isPlayerTurn()){
        	game.getCurrentPlayer().drawOnMap(g);
        	for(int i = 0; i < 5; i++){
        		for(int j = 0; j < 9; j++){
        			Tile tile = tiles[i][j];
        			if(! tile.isEmpty()){
        				tile.getMule().drawOnMap(g);
        			}
        		}
        	}
        }
    } 
}
