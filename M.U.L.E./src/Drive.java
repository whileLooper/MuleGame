import javax.swing.JFrame;


public class Drive extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Drive drive = new Drive();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		Game game = new Game(frame);
	    frame.setSize(905,528);
	    frame.setVisible(true);
	    frame.setResizable(false);
		
		
	}

	private int x = 905;
	private int y = 528;
	
	public Drive(){
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setSize(x,y);
		setVisible(true);
		setResizable(false);
	}
}
