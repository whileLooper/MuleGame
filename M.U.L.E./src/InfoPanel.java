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

/**
 * @author One-E
 * 
 * The information panel of the game that displays every player's information and town's information.
 * 
 */
public class InfoPanel extends JPanel {
	
	JPanel TimerPanel = new JPanel();
	JPanel PlayerInfoPanel = new JPanel();
	JProgressBar pbar = new JProgressBar();;

	/**
	 * Constructor for the info panel
	 * @param playerList the list of players that are currently in the game.
	 * @param s the store of the game which holds the information such as number of food left in the shop.
	 */
	public InfoPanel(Player[] playerList, Store s){
		//System.out.println(playerList.length);
		if (playerList.length == 2) {
			Player[] tmp = {playerList[0], playerList[1], null, null};
			playerList = tmp;
		}
		else if (playerList.length == 3) {
			Player[] tmp = {playerList[0], playerList[1], playerList[2], null};
			playerList = tmp;
		}
		
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
		Player_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PlayerInfoPanel.add(Player_1);
		
		JLabel lblPlayname = new JLabel("Player_1: " + playerList[0].getName());
		lblPlayname.setBounds(10, 11, 170, 14);
		Player_1.add(lblPlayname);
		
		JLabel lblMoney_1 = new JLabel("Money: " + playerList[0].getMoney());
		lblMoney_1.setBounds(10, 36, 170, 14);
		Player_1.add(lblMoney_1);
		
		JLabel lblFood_1 = new JLabel("Food: " + playerList[0].getFood());
		lblFood_1.setBounds(10, 61, 170, 14);
		Player_1.add(lblFood_1);
		
		JLabel lblEnergy_1 = new JLabel("Energy: " + playerList[0].getEnergy());
		lblEnergy_1.setBounds(10, 86, 170, 14);
		Player_1.add(lblEnergy_1);
		
		JLabel lblOre_1 = new JLabel("Ore: " + playerList[0].getOre());
		lblOre_1.setBounds(10, 111, 170, 14);
		Player_1.add(lblOre_1);
		
		JLayeredPane Player_2 = new JLayeredPane();
		Player_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PlayerInfoPanel.add(Player_2);
		
		JLabel lblMoney = new JLabel("Player_2: " + playerList[1].getName());
		lblMoney.setBounds(10, 11, 170, 14);
		Player_2.add(lblMoney);
		
		JLabel label = new JLabel("Money: " + playerList[1].getMoney());
		label.setBounds(10, 36, 170, 14);
		Player_2.add(label);
		
		JLabel label_1 = new JLabel("Food: " + playerList[1].getFood());
		label_1.setBounds(10, 58, 170, 14);
		Player_2.add(label_1);
		
		JLabel label_2 = new JLabel("Energy: " + playerList[1].getEnergy());
		label_2.setBounds(10, 83, 170, 14);
		Player_2.add(label_2);
		
		JLabel label_3 = new JLabel("Ore: " + playerList[1].getOre());
		label_3.setBounds(10, 105, 170, 14);
		Player_2.add(label_3);
		
		if (playerList[3] == null && playerList[2] == null) {
			JLayeredPane Player_3 = new JLayeredPane();
			Player_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			PlayerInfoPanel.add(Player_3);
				
			JLabel lblFood = new JLabel("Player_3: ");
			lblFood.setBounds(10, 11, 170, 14);
			Player_3.add(lblFood);
				
			JLabel label_4 = new JLabel("Money: ");
			label_4.setBounds(10, 36, 170, 14);
			Player_3.add(label_4);
				
			JLabel label_5 = new JLabel("Food: ");
			label_5.setBounds(10, 58, 170, 14);
			Player_3.add(label_5);
				
			JLabel label_6 = new JLabel("Energy: ");
			label_6.setBounds(10, 81, 170, 14);
			Player_3.add(label_6);
				
			JLabel label_7 = new JLabel("Ore: ");
			label_7.setBounds(10, 105, 170, 14);
			Player_3.add(label_7);
			
			JLayeredPane Player_4 = new JLayeredPane();
			Player_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			PlayerInfoPanel.add(Player_4);
				
			JLabel lblEnergy = new JLabel("Player_4: ");
			lblEnergy.setBounds(10, 11, 170, 14);
			Player_4.add(lblEnergy);
				
			JLabel label_8 = new JLabel("Money: ");
			label_8.setBounds(10, 36, 170, 14);
			Player_4.add(label_8);
				
			JLabel label_9 = new JLabel("Food: ");
			label_9.setBounds(10, 58, 170, 14);
			Player_4.add(label_9);
				
			JLabel label_10 = new JLabel("Energy: ");
			label_10.setBounds(10, 82, 170, 14);
			Player_4.add(label_10);
				
			JLabel label_11 = new JLabel("Ore: ");
			label_11.setBounds(10, 105, 170, 14);
			Player_4.add(label_11);
		}
		
		else if (playerList[3] == null) {
			JLayeredPane Player_3 = new JLayeredPane();
			Player_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			PlayerInfoPanel.add(Player_3);
			
			JLabel lblFood = new JLabel("Player_3: " + playerList[2].getName());
			lblFood.setBounds(10, 11, 170, 14);
			Player_3.add(lblFood);
			
			JLabel label_4 = new JLabel("Money: " + playerList[2].getMoney());
			label_4.setBounds(10, 36, 170, 14);
			Player_3.add(label_4);
			
			JLabel label_5 = new JLabel("Food: " + playerList[2].getFood());
			label_5.setBounds(10, 58, 170, 14);
			Player_3.add(label_5);
			
			JLabel label_6 = new JLabel("Energy: " + playerList[2].getEnergy());
			label_6.setBounds(10, 81, 170, 14);
			Player_3.add(label_6);
			
			JLabel label_7 = new JLabel("Ore: " + playerList[2].getOre());
			label_7.setBounds(10, 105, 170, 14);
			Player_3.add(label_7);
		
			JLayeredPane Player_4 = new JLayeredPane();
			Player_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			PlayerInfoPanel.add(Player_4);
			
			JLabel lblEnergy = new JLabel("Player_4: ");
			lblEnergy.setBounds(10, 11, 170, 14);
			Player_4.add(lblEnergy);
			
			JLabel label_8 = new JLabel("Money: ");
			label_8.setBounds(10, 36, 170, 14);
			Player_4.add(label_8);
			
			JLabel label_9 = new JLabel("Food: ");
			label_9.setBounds(10, 58, 170, 14);
			Player_4.add(label_9);
			
			JLabel label_10 = new JLabel("Energy: ");
			label_10.setBounds(10, 82, 170, 14);
			Player_4.add(label_10);
			
			JLabel label_11 = new JLabel("Ore: ");
			label_11.setBounds(10, 105, 170, 14);
			Player_4.add(label_11);
		}
		
		else {
			JLayeredPane Player_3 = new JLayeredPane();
			Player_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			PlayerInfoPanel.add(Player_3);
			
			JLabel lblFood = new JLabel("Player_3: " + playerList[2].getName());
			lblFood.setBounds(10, 11, 170, 14);
			Player_3.add(lblFood);
			
			JLabel label_4 = new JLabel("Money: " + playerList[2].getMoney());
			label_4.setBounds(10, 36, 170, 14);
			Player_3.add(label_4);
			
			JLabel label_5 = new JLabel("Food: " + playerList[2].getFood());
			label_5.setBounds(10, 58, 170, 14);
			Player_3.add(label_5);
			
			JLabel label_6 = new JLabel("Energy: " + playerList[2].getEnergy());
			label_6.setBounds(10, 81, 170, 14);
			Player_3.add(label_6);
			
			JLabel label_7 = new JLabel("Ore: " + playerList[2].getOre());
			label_7.setBounds(10, 105, 170, 14);
			Player_3.add(label_7);
		
			JLayeredPane Player_4 = new JLayeredPane();
			Player_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			PlayerInfoPanel.add(Player_4);
			
			JLabel lblEnergy = new JLabel("Player_4: " + playerList[3].getName());
			lblEnergy.setBounds(10, 11, 170, 14);
			Player_4.add(lblEnergy);
			
			JLabel label_8 = new JLabel("Money: " + playerList[3].getMoney());
			label_8.setBounds(10, 36, 170, 14);
			Player_4.add(label_8);
			
			JLabel label_9 = new JLabel("Food: " + playerList[3].getFood());
			label_9.setBounds(10, 58, 170, 14);
			Player_4.add(label_9);
			
			JLabel label_10 = new JLabel("Energy: " + playerList[3].getEnergy());
			label_10.setBounds(10, 82, 170, 14);
			Player_4.add(label_10);
			
			JLabel label_11 = new JLabel("Ore: " + playerList[3].getOre());
			label_11.setBounds(10, 105, 170, 14);
			Player_4.add(label_11);
		}
		
		JLayeredPane Town = new JLayeredPane();
		Town.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PlayerInfoPanel.add(Town);
		
		JLabel lblOre = new JLabel("Town");
		lblOre.setBounds(10, 11, 170, 14);
		Town.add(lblOre);
		
		JLabel lblMule = new JLabel("Mule: " + s.getMule());
		lblMule.setBounds(10, 34, 170, 14);
		Town.add(lblMule);
		
		JLabel label_12 = new JLabel("Food: " + s.getFood());
		label_12.setBounds(10, 59, 170, 14);
		Town.add(label_12);
		
		JLabel label_13 = new JLabel("Energy: " + s.getEnergy());
		label_13.setBounds(10, 84, 170, 14);
		Town.add(label_13);
		
		JLabel label_14 = new JLabel("Ore: " + s.getSmithore());
		label_14.setBounds(10, 105, 170, 14);
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
	
	/**
	 * A testing method for info panel.
	 * @param args
	 */
	 /* public static void main(String args[]) {
		  	Player p1 = new Player("bobo1", Color.RED, "human", "gameD");
		  	Player p2 = new Player("bobo2", Color.GREEN, "human", "gameD");
		  	Player p3 = new Player("bobo3", Color.YELLOW, "human", "gameD");
		  	Player p4 = new Player("bobo4", Color.BLACK, "human", "gameD");
		  	Player[] playerList = {p1, p2, p3, p4};
		  	InfoPanel it = new InfoPanel(playerList, new Store("hello", new Town(new Game(new JFrame()))));

		    JFrame frame = new JFrame("Progress Bar Example");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setContentPane(it);
		    frame.pack();
		    frame.setVisible(true);
		    it.countDown(20, 0);

		  }*/
}
