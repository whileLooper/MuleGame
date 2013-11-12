import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;
import javax.swing.Timer;



public class Start extends JPanel implements ActionListener{
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private String difficulty;
	private String map;
	private int numOfPlayers;
	private int currentPlayer;
	private Player[] players;
	//private static int pn=1;
	private Game game;
	private JTextField textField;
	private JTextField textField_1;
	private Timer t;
	private int xCoor = 40;
	private boolean moveAction = true;
	private boolean moveAction2 =true;
	private int moveAction3 =0;

	private JComboBox comboBox;
	private int speed = 10;
	private boolean showRace = false;
	/**
	 * Setting the game start option.
	 */
	public Start(Game g){
		game = g;
		//playerSetting();
		
		setPreferredSize(new Dimension(900, 500));
		setVisible(true);
		gameSetting();
		t = new Timer(100,this);
		
		
		t.setInitialDelay(1500);
		t.start();
		
		
	//playerSetting();
		//validate();
		//repaint();
	}
	/** 
	 * 
	 *
	 * 
	 **/
	public void actionPerformed(ActionEvent e) {
		
        if (xCoor >1400) {
        	xCoor = 1400;
        	speed = -10;
      //  	t.stop();
        //	t.start();
        	moveAction =false;
        }
        if(xCoor < 0){
        	xCoor = 0;
        	speed =  10;
        	moveAction = true;
        	
        }
        xCoor  =  xCoor + speed;
        repaint();
	}

	
	/**
	 * @return return the difficulty level.
	 * */
	public String getDifficulty(){
		return difficulty;
	}
	
	/**
	 * @return return map panel.
	 * */
	public String getMapType(){
		return map;
	}
	
	/**
	 * @return return the array of players
	 * */
	public Player[] getPlayers(){
		return players;
	}

	/**
	 * Setting the numbers of players.
	 * */
	private void playerInput(){
		players = new Player[numOfPlayers];
		currentPlayer = 0;
		playerSetting();
		showRace= true;
	}
	
	/**
	 * Game setting method. 
	 * Setting game start menu elements panels
	 * */
	private void gameSetting(){
		setLayout(null);
		
		JButton btnLoad = new JButton("Load Game");
		btnLoad.setBounds(82, 62, 130, 36);
		add(btnLoad);
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean loadGame = game.loadLastGame();
				if(!loadGame){
					JOptionPane.showMessageDialog(null, "No Record Found","Load failed", 0);

				}
			}
		});
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setBounds(314, 50, 83, 14);
		add(lblDifficulty);
		
		JLabel lblMap = new JLabel("Map");
		lblMap.setBounds(314, 99, 69, 14);
		add(lblMap);
		
		JLabel lblOfPlayers = new JLabel("# of Players");
		lblOfPlayers.setBounds(314, 141, 83, 14);
		add(lblOfPlayers);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(389, 45, 101, 25);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Beginner", "Standard", "Tournament"}));
		add(comboBox);
				
				final JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setBounds(389, 94, 101, 25);
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Standard", "Random"}));
				add(comboBox_1);
		
				
				final JComboBox comboBox_2 = new JComboBox();
				comboBox_2.setBounds(389, 136, 101, 25);
				comboBox_2.setModel(new DefaultComboBoxModel(new Integer[] {2, 3, 4}));
				add(comboBox_2);
		
		JButton btnNext = new JButton("Next\u2192");
		btnNext.setBounds(509, 192, 91, 31);
		add(btnNext);
		
	
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				difficulty = (String) comboBox.getSelectedItem();
				map = (String) comboBox_1.getSelectedItem();
				numOfPlayers = (int) comboBox_2.getSelectedItem();
				System.out.println("Difficulty: " + difficulty + " Map Type: " + map + " # of Players: " + numOfPlayers);
				playerInput();
			}
		});
		

	}

	
	
	  
	/**
	 * Setting player name, player numbers panels.
	 */

	private void playerSetting(){
		removeAll();
		setLayout(null);
		
		int player = currentPlayer + 1;
		JLabel lblPlayer = new JLabel("Player#" + player);
		lblPlayer.setBounds(109, 48, 64, 14);
		add(lblPlayer);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(334, 48, 86, 14);
		add(lblName);
		
		JLabel lblRace = new JLabel("Race");
		lblRace.setBounds(334, 88, 67, 14);
		add(lblRace);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(334, 131, 61, 14);
		add(lblColor);
//		
//		textField = new JTextField();
//		textField.setBounds(92, 66, 137, 188);
//		add(textField);
//		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(425, 45, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Human","Flapper", "Pandarian", "MonkeyKing"}));
		comboBox.setBounds(426, 85, 86, 20);
		add(comboBox);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Red", "Yellow", "Green", "Blue"}));
		comboBox_1.setBounds(425, 128, 86, 17);
		add(comboBox_1);
		
		JButton btnNewButton = new JButton("NEXT\u2192");
		btnNewButton.setBounds(539, 180, 86, 30);

		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField_1.getText();
				String race = (String) comboBox.getSelectedItem();
				String c = (String) comboBox_1.getSelectedItem();
				Color color = null;
				switch(c){
				case "Red": color = Color.RED; break;
				case "Yellow": color = Color.YELLOW; break;
				case "Green": color = Color.GREEN; break;
				case "Blue": color = Color.BLUE; break;
				default:
				}
				System.out.println("Player #" + currentPlayer + " Name " + name + " Color: " + c + " Race" + race);
				
				
				if (sameColor(color) || sameName(name)) {
					playerSetting();
				}
				else if (name.length() > 12) {
					playerSetting();
				}
				else{
					players[currentPlayer] = new Player(name, color, race, difficulty);
					currentPlayer ++;
					if (currentPlayer == numOfPlayers) {
						// System.out.println("done");
						game.setUpMap();
					} else {
						playerSetting();
					}
				}
				
			}
		});

		add(btnNewButton);
		
		validate();
		repaint();
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	
	/**
	 * Check if color is in player list. Return true if there is, return false if there isn't.
	 */
	public boolean sameColor(Color c) {
		for(int n = 0; n < currentPlayer; n++){
			if(players[n].getColor() == c){
				System.out.println("Oops! The color has been chosen...");
				JOptionPane.showMessageDialog(null, "Oops! The color has been chosen...","color Conflict", 0);

				return true;
			}
		}
		return false;
	}
	
	/**
	 * Check if name is in player list. Return true if there is, return false if there isn't.
	 */
	public boolean sameName(String name) {
		if (name.equals("")) {
			System.out.println("Please enter a name");
			return true;
		}
		for (int i = 0; i < currentPlayer; i++) {
			if(players[i].getName() == name) {
				System.out.println("Oops! The name has been chosen...");
				JOptionPane.showMessageDialog(null, "Oops! The name has been chosen...", "Name Conflict", 0);

				return true;
			}
		}
		return false;
	}

	/**
	 * in charge of painting and animations
	 */
	
		    
	 public void paintComponent(Graphics page)
     {
		  
		 
		 
         super.paintComponent(page);
         BufferedImage img = null;
        
         try {

			page.drawImage(ImageIO.read(new File("start.png")), 0, 0, null);
			
			if (moveAction) {
				
				if (moveAction2) {
					page.drawImage(ImageIO.read(new File("Image/startAnimate/donkeyRun1right.png")),
							xCoor - 150, 300, null);
					page.drawImage(
							ImageIO.read(new File("Image/startAnimate/monkeyRun1right.png")),
							xCoor - 250, 300, null);
					page.drawImage(
							ImageIO.read(new File("Image/startAnimate/pandaRun1right.png")),
							xCoor - 350, 300, null);	
					page.drawImage(
							ImageIO.read(new File("Image/startAnimate/humanRun1right.png")),
							xCoor - 450, 300, null);	
					
					
					moveAction2 = false;
				} else {
					page.drawImage(ImageIO.read(new File("Image/startAnimate/donkeyRun2right.png")),
							xCoor - 150, 300, null);
					page.drawImage(
							ImageIO.read(new File("Image/startAnimate/monkeyRun2right.png")),
							xCoor - 250, 300, null);
					page.drawImage(
							ImageIO.read(new File("Image/startAnimate/pandaRun2right.png")),
							xCoor - 350, 300, null);
					page.drawImage(
							ImageIO.read(new File("Image/startAnimate/humanRun2right.png")),
							xCoor - 450, 300, null);	
					moveAction2 = true;
				}
				
			} else {
		
				
				if (moveAction2) {
					page.drawImage(ImageIO.read(new File("Image/startAnimate/donkeyRun1left.png")),
							xCoor - 350, 300, null);
					page.drawImage(
							ImageIO.read(new File("Image/startAnimate/monkeyRun1left.png")),
							xCoor - 250, 300, null);
					page.drawImage(
							ImageIO.read(new File("Image/startAnimate/pandaRun1left.png")),
							xCoor - 150, 300, null);
					page.drawImage(
							ImageIO.read(new File("Image/startAnimate/humanRun1left.png")),
							xCoor   - 50, 300, null);
					moveAction2 = false;
				} else {
					page.drawImage(ImageIO.read(new File("Image/startAnimate/donkeyRun2left.png")),
							xCoor - 350, 300, null);
					page.drawImage(
							ImageIO.read(new File("Image/startAnimate/monkeyRun2left.png")),
							xCoor - 250, 300, null);
					page.drawImage(
							ImageIO.read(new File("Image/startAnimate/pandaRun2left.png")),
							xCoor - 150, 300, null);
					page.drawImage(
							ImageIO.read(new File("Image/startAnimate/humanRun2left.png")),
							xCoor -50, 300, null);
					moveAction2 = true;
				}
		
			}
			if (showRace) {
				page.setColor(Color.WHITE);
				page.fillRect(92,66,85,120);
				String s = (String) comboBox.getSelectedItem();
				
				if (s.equals("MonkeyKing")) {
					
					if(moveAction3==0)
						{
						page.drawImage(ImageIO.read(new File("Image/startAnimate/monkeyfront.png")),
							92, 66, 92 + 80, 66 + 115, 0, 0, 80, 115,
							Color.WHITE, null);
						validate();
						moveAction3=1;
						}else if(moveAction3 ==1){
							page.drawImage(ImageIO.read(new File("Image/startAnimate/monkeyfront.png")),
									92, 66, 92 + 80, 66 + 115, 150, 0, 148 +80, 0+115,
									Color.WHITE, null);
							moveAction3= 2;
						}else if(moveAction3 ==2){
							page.drawImage(ImageIO.read(new File("Image/startAnimate/monkeyfront.png")),
									92, 66, 92 + 80, 66 + 115, 300, 4, 298 +80, 4+115,
									Color.WHITE, null);
							moveAction3 = 0;
						}
					
					
				} else if (s.equalsIgnoreCase("Pandarian")) {
					
					if (moveAction3 == 0) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/pandaFront.png")), 92, 66,
								92 + 80, 66 + 110, 0, 0, 80, 105, Color.WHITE,
								null);
						moveAction3 = 1;
					} else if (moveAction3 == 1) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/pandaFront.png")), 92, 66,
								92 + 80, 66 + 110, 0, 105, 88, 211, Color.WHITE,
								null);

						moveAction3 = 2;
					} else if (moveAction3 == 2) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/pandaFront.png")), 92, 66,
								92 + 80, 66 + 110, 256, 0, 340, 100, Color.WHITE,
								null);
						moveAction3 = 0;
					}
				} else if (s.equalsIgnoreCase("Human")) {

					if (moveAction3 == 0) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/humanFront.png")), 102, 67,
								102 + 52, 67 + 110, 308, 0, 362, 110,
								Color.WHITE, null);
						moveAction3 = 1;
					} else if (moveAction3 == 1) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/humanFront.png")), 101, 67,
								101 + 52, 67 + 110, 255, 0, 307, 110,
								Color.WHITE,

								null);

						moveAction3 = 2;
					} else if (moveAction3 == 2) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/humanFront.png")), 106, 67,
								105 + 50, 67 + 110, 207, 0, 207+49, 110,
								Color.WHITE, null);
						moveAction3 = 0;
					}
				}

				else if (s.equalsIgnoreCase("Flapper")) {

		
					
					
					if (moveAction3 == 0) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/flapperFront.png")), 92,
								66, 92 + 80, 66 + 115, 115, 0, 115 + 80, 115,
								Color.WHITE, null);
						moveAction3 = 1;
					} else if (moveAction3 == 1) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/flapperFront.png")), 92,
								66, 92 + 80, 66 + 115, 13, 0, 13 + 80, 115,
								Color.WHITE,

								null);

						moveAction3 = 2;
					} else if (moveAction3 == 2) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/flapperFront.png")), 92,
								66, 92 + 80, 66 + 115, 322, 0, 322 + 80, 115,
								Color.WHITE, null);
						moveAction3 = 0;
					}

				}
			}
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
