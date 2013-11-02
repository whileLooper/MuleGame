import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;


public class InfoPanel extends JPanel {
	
	JPanel TimerPanel = new JPanel();
	JPanel PlayerInfoPanel = new JPanel();
	JProgressBar pbar = new JProgressBar();;


	public InfoPanel(Player p1, Player p2, Player p3, Player p4, Store s){
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(900, 160));
		setLayout(null);
		
		TimerPanel.setBounds(0, 0, 900, 30);
		TimerPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		TimerPanel.setBackground(Color.GRAY);
		add(TimerPanel);
		
		PlayerInfoPanel.setBounds(0, 30, 900, 130);
		add(PlayerInfoPanel);
		PlayerInfoPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLayeredPane Player_1 = new JLayeredPane();
		Player_1.setToolTipText("Current Player Turn");
		Player_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PlayerInfoPanel.add(Player_1);
		
		JLabel lblPlayname = new JLabel("Player_1: " + p1.getName());
		lblPlayname.setBounds(10, 11, 200, 14);
		Player_1.add(lblPlayname);
		
		JLabel lblMoney_1 = new JLabel("Money: " + p1.getMoney());
		lblMoney_1.setBounds(10, 36, 200, 14);
		Player_1.add(lblMoney_1);
		
		JLabel lblFood_1 = new JLabel("Food: " + p1.getFood());
		lblFood_1.setBounds(10, 61, 200, 14);
		Player_1.add(lblFood_1);
		
		JLabel lblEnergy_1 = new JLabel("Energy: " + p1.getEnergy());
		lblEnergy_1.setBounds(10, 86, 200, 14);
		Player_1.add(lblEnergy_1);
		
		JLabel lblOre_1 = new JLabel("Ore: " + p1.getOre());
		lblOre_1.setBounds(10, 111, 200, 14);
		Player_1.add(lblOre_1);
		
		JLayeredPane Player_2 = new JLayeredPane();
		Player_2.setToolTipText("Current Money");
		Player_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PlayerInfoPanel.add(Player_2);
		
		JLabel lblMoney = new JLabel("Player_2: " + p2.getName());
		lblMoney.setBounds(10, 11, 200, 14);
		Player_2.add(lblMoney);
		
		JLabel label = new JLabel("Money: " + p2.getMoney());
		label.setBounds(10, 36, 200, 14);
		Player_2.add(label);
		
		JLabel label_1 = new JLabel("Food: " + p2.getFood());
		label_1.setBounds(10, 58, 200, 14);
		Player_2.add(label_1);
		
		JLabel label_2 = new JLabel("Energy: " + p2.getEnergy());
		label_2.setBounds(10, 83, 200, 14);
		Player_2.add(label_2);
		
		JLabel label_3 = new JLabel("Ore: " + p2.getOre());
		label_3.setBounds(10, 105, 200, 14);
		Player_2.add(label_3);
		
		JLayeredPane Player_3 = new JLayeredPane();
		Player_3.setToolTipText("Current Food Amount");
		Player_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PlayerInfoPanel.add(Player_3);
		
		JLabel lblFood = new JLabel("Player_3: " + p3.getName());
		lblFood.setBounds(10, 11, 200, 14);
		Player_3.add(lblFood);
		
		JLabel label_4 = new JLabel("Money: " + p3.getMoney());
		label_4.setBounds(10, 36, 200, 14);
		Player_3.add(label_4);
		
		JLabel label_5 = new JLabel("Food: " + p3.getFood());
		label_5.setBounds(10, 58, 200, 14);
		Player_3.add(label_5);
		
		JLabel label_6 = new JLabel("Energy: " + p3.getEnergy());
		label_6.setBounds(10, 81, 200, 14);
		Player_3.add(label_6);
		
		JLabel label_7 = new JLabel("Ore: " + p3.getOre());
		label_7.setBounds(10, 105, 200, 14);
		Player_3.add(label_7);
		
		JLayeredPane Player_4 = new JLayeredPane();
		Player_4.setToolTipText("Current Energy Amount");
		Player_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PlayerInfoPanel.add(Player_4);
		
		JLabel lblEnergy = new JLabel("Player_4: " + p4.getName());
		lblEnergy.setBounds(10, 11, 200, 14);
		Player_4.add(lblEnergy);
		
		JLabel label_8 = new JLabel("Money: " + p4.getMoney());
		label_8.setBounds(10, 36, 200, 14);
		Player_4.add(label_8);
		
		JLabel label_9 = new JLabel("Food: " + p4.getFood());
		label_9.setBounds(10, 58, 200, 14);
		Player_4.add(label_9);
		
		JLabel label_10 = new JLabel("Energy: " + p4.getEnergy());
		label_10.setBounds(10, 82, 200, 14);
		Player_4.add(label_10);
		
		JLabel label_11 = new JLabel("Ore: " + p4.getOre());
		label_11.setBounds(10, 105, 200, 14);
		Player_4.add(label_11);
		
		JLayeredPane Town = new JLayeredPane();
		Town.setToolTipText("Current Ore Amount");
		Town.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PlayerInfoPanel.add(Town);
		
		JLabel lblOre = new JLabel("Town");
		lblOre.setBounds(10, 11, 200, 14);
		Town.add(lblOre);
		
		JLabel lblMule = new JLabel("Mule: " + s.getMule());
		lblMule.setBounds(10, 34, 200, 14);
		Town.add(lblMule);
		
		JLabel label_12 = new JLabel("Food: " + s.getFood());
		label_12.setBounds(10, 59, 200, 14);
		Town.add(label_12);
		
		JLabel label_13 = new JLabel("Energy: " + s.getEnergy());
		label_13.setBounds(10, 84, 200, 14);
		Town.add(label_13);
		
		JLabel label_14 = new JLabel("Ore: " + s.getSmithore());
		label_14.setBounds(10, 105, 200, 14);
		Town.add(label_14);
		this.setVisible(true);


		TimerPanel.setLayout(null);
		pbar.setBounds(0, 0, 900, 30);
		pbar.setBackground(new Color(50, 205, 50));
		pbar.setForeground(Color.LIGHT_GRAY);
		
		TimerPanel.add(pbar);


	}


	
	/**
	 * this class draw a progress bar to showing the timing for turns.
	 * @param max the max value for the progress bar
	 * @param min the min value for the progress bar
	 */
	public void countDown(int max, int min){		
		pbar.setMinimum(min);
		pbar.setMaximum(max);

	    for (int i = min; i <= max; i++) {
		      final int percent = i;
		      if(i > (max - 10)) pbar.setBackground(new  Color(220,20,60));
		      
		      try {
		        SwingUtilities.invokeLater(new Runnable() {
		          public void run() {
						pbar.setValue(percent);
						TimerPanel.repaint();
		          }
		        });
		        java.lang.Thread.sleep(1000);
		      } catch (InterruptedException e) {
		        ;
		      }
		    }
	}
	
	  public static void main(String args[]) {
		  	Player p1 = new Player("bobo1", Color.RED, "human", "gameD");
		  	Player p2 = new Player("bobo2", Color.GREEN, "human", "gameD");
		  	Player p3 = new Player("bobo3", Color.YELLOW, "human", "gameD");
		  	Player p4 = new Player("bobo4", Color.BLACK, "human", "gameD");
		    final InfoPanel it = new InfoPanel(p1, p2, p3, p4, new Store("hello"));

		    JFrame frame = new JFrame("Progress Bar Example");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setContentPane(it);
		    frame.pack();
		    frame.setVisible(true);
		    it.countDown(20, 0);

		  }
}
