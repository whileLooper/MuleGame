import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import com.google.gson.Gson;


@SuppressWarnings("serial")
/**
 * Drive.java
 * Version 264, Copyright One-E
 * @author One-E
 * 
 * The driver for the game.
 * 
 */
public class Drive extends JFrame{

	/**
	 * This method is the main method of the game and starts the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Drive drive = new Drive();
		Drive drive = new Drive();
	    
	}
	
	private int x = 910;
	private int y = 688;
	private Game game;
	
	/**
	 * Constructor for the drive class. Creates the frame and add the window listener.
	 */
	public Drive(){
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		game = new Game(this);
		setSize(910,688);
	    setVisible(true);
	    setResizable(false);
	    
	    addWindowListener(new WindowClosed());
	    
	}
	
	/**
	 * 
	 * @author One-E
	 * 
	 * Allows the window to be closed with empty record (No information saved.)
	 *
	 */
	private class WindowClosed extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e){
			if(game.getGameState() == Game.GameState.PlayerTurns){
				Gson gson = new Gson();
				InfoStore store = game.stop();
				String tostore = gson.toJson(store);
				FileWriter writer;
				try {
					writer = new FileWriter("record.txt");
					writer.write(tostore);
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
