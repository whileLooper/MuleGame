import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;


public class Map extends JPanel{

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
				Tile tile = new Tile(cmap[i][j]);
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
