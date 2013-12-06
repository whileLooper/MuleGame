import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EtchedBorder;

/**
 * TimerBar.java
 * Version 291. Copyright One-E
 * @author One-E
 *
 * The timer bar that calculates the time for the player.
 */

public class TimerBar extends JPanel {
	
	 JProgressBar pbar = new JProgressBar();
	
	 /**
	  * Constructor for the TimerBar.
	  */
	public TimerBar(){
		setLayout(null);
		this.setSize(900, 30);
		setBounds(0, 0, 900, 30);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(Color.GRAY);
		pbar.setStringPainted(true);
		
		pbar.setBounds(0, 0, 900, 30);
		pbar.setBackground(new Color(50, 205, 50));
		pbar.setForeground(Color.LIGHT_GRAY);
		add(pbar);
		

	}
	
	/**
	 * this class draw a progress bar to showing the timing for turns.
	 * @param max the max value for the progress bar
	 * @param min the min value for the progress bar
	 */
/*	public void countDown(final int max, final int min){		
		pbar.setMinimum(min);
		pbar.setMaximum(max);


	   Thread time = new Thread(new Runnable(){
		   public void run(){
			   for (int i = min; i <= max; i++) {
				      final int percent = i;
				      if(i > (max - 10)) pbar.setBackground(new  Color(220,20,60));
				      
				      try {
				        SwingUtilities.invokeLater(new Runnable() {
				          public void run() {
								pbar.setValue(percent);
								repaint();
				          }
				        });
				        java.lang.Thread.sleep(1000);
				      } catch (InterruptedException e) {
				        ;
				      }
				    }
		   }
	   });
	   time.start();
	}*/
	
	
	/**
	 * A testing method for info panel.
	 * @param args
	 */
	public static void main(String args[]) {
		  	
		  	TimerBar it = new TimerBar();

		    JFrame frame = new JFrame("Progress Bar Example");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setContentPane(it);
		    frame.setSize(900, 30);
		    frame.pack();
		    frame.setVisible(true);

		  }
}
