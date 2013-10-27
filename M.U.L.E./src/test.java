import javax.swing.JFrame;



public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		Map map = new Map("Standard");
	    frame.getContentPane().add(map);
	    frame.setSize(905,528);
	    frame.setVisible(true);
	    frame.setResizable(false);
	}

}
