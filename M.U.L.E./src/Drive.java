import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;

import com.google.gson.Gson;


@SuppressWarnings("serial")
public class Drive extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Drive drive = new Drive();
		Drive drive = new Drive();
	    
	}
	
	private int x = 910;
	private int y = 688;
	private Game game;
	
	public Drive(){
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		game = new Game(this);
		setSize(910,688);
	    setVisible(true);
	    setResizable(false);
	    addWindowListener(new WindowClosed());
	}
	
	
	private class WindowClosed extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e){
			Gson gson = new Gson();
			InfoStore store = game.stop();
			String tostore = gson.toJson(store);
			System.out.println(game == null);
			System.out.println(tostore);
			store = gson.fromJson(tostore, InfoStore.class);
		}
	}
}
