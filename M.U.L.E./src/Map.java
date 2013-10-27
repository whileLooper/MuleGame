import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;


public class Map extends JPanel{

	
	private Tile[][] tiles = new Tile[5][9];
	
	/**
	 * This is constructor of the Map class
	 * @param mapType is the type of map to initiate
	 */
	public Map(String mapType){
		createMap(mapType);
		setPreferredSize(new Dimension(900, 500));
		setLayout(new GridLayout(5, 9, 0, 0));
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
	
	
}
