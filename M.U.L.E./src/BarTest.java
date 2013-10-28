import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class BarTest extends JPanel{
	JProgressBar pbar;

	  static final int MY_MINIMUM = 0;

	  static final int MY_MAXIMUM = 10;

	  public BarTest() {
	    // initialize Progress Bar
	    pbar = new JProgressBar();
	    pbar.setMinimum(MY_MINIMUM);
	    pbar.setMaximum(MY_MAXIMUM);
	    pbar.setStringPainted(false);
	    pbar.setBackground(Color.GREEN);
	    pbar.setForeground(Color.WHITE);
	    
	    // add to JPanel
	    add(pbar);
	  }

	  public void updateBar(int newValue) {
		  
	    pbar.setValue(newValue);
	  }

	  public static void main(String args[]) {

	    final BarTest it = new BarTest();

	    JFrame frame = new JFrame("Progress Bar Example");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setContentPane(it);
	    frame.pack();
	    frame.setVisible(true);

	    // run a loop to demonstrate raising
	    for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
	      final int percent = i;
	      try {
	        SwingUtilities.invokeLater(new Runnable() {
	          public void run() {
	            it.updateBar(percent);
	          }
	        });
	        java.lang.Thread.sleep(1000);
	      } catch (InterruptedException e) {
	        ;
	      }
	    }
	  }
}
