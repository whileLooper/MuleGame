import javax.swing.JFrame;



public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
	    frame.add(new Start(new Game(new Drive())));
	    frame.setSize(905,528);
	    frame.setVisible(true);
	    frame.setResizable(false);
	}

}
