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

import javax.swing.ButtonGroup;
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

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class Start extends JPanel implements ActionListener {

	/**
	 * @wbp.parser.entryPoint
	 */
	private String difficulty;
	private String map = "Standard";
	private int numOfPlayers;
	private int currentPlayer;
	private Player[] players;
	// private static int pn=1;
	private Game game;
	private JTextField textField;
	private JTextField textField_1;
	private Timer t;
	private int xCoor = 40;
	private boolean moveAction = true;
	private boolean moveAction2 = true;
	private int moveAction3 = 0;
    private int showMap = 0;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private int speed = 10;
	private boolean showRace = false;

	/**
	 * Setting the game start option.
	 */
	public Start(Game g) {
		game = g;
		

		setPreferredSize(new Dimension(910, 688));
		setVisible(true);
		//gameSetting();
		// playerSetting();
		firstScreen();

		t = new Timer(100, this);
		t.setInitialDelay(1500);
		t.start();

		// validate();
		// repaint();
	}

	/** 
	 * 
	 *
	 * 
	 **/
	public void actionPerformed(ActionEvent e) {

		if (xCoor > 1400) {
			xCoor = 1400;
			speed = -10;
			// t.stop();
			// t.start();
			moveAction = false;
		}
		if (xCoor < 0) {
			xCoor = 0;
			speed = 10;
			moveAction = true;

		}
		xCoor = xCoor + speed;
		repaint();
	}

	/**
	 * @return return the difficulty level.
	 * */
	public String getDifficulty() {
		return difficulty;
	}

	/**
	 * @return return map panel.
	 * */
	public String getMapType() {
		return map;
	}

	/**
	 * @return return the array of players
	 * */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * Setting the numbers of players.
	 * */
	private void playerInput() {
		players = new Player[numOfPlayers];
		currentPlayer = 0;
		playerSetting();
		showRace = true;
	}

	/**
	 * Game setting method. Setting game start menu elements panels
	 * */

	private void firstScreen() {
		showMap = 0;
		removeAll();
		setLayout(null);
		showRace = false;
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setForeground(new Color(0, 0, 0));
		btnLoadGame.setBackground(new Color(176, 224, 230));
		btnLoadGame.setFont(new Font("Euphemia", Font.PLAIN, 16));
		btnLoadGame.setBounds(371, 275, 150, 50);
		add(btnLoadGame);
		btnLoadGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean loadGame = game.loadLastGame();
				if (!loadGame) {
					JOptionPane.showMessageDialog(null, "No Record Found",
							"Load failed", 0);

				}
			}
		});

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBackground(new Color(176, 224, 230));
		btnNewGame.setFont(new Font("Euphemia", Font.PLAIN, 16));
		btnNewGame.setBounds(371, 340, 150, 50);
		add(btnNewGame);
		btnNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameSetting();
			}
		}

		);

	}

	private void gameSetting() {
		showMap = 1;
		removeAll();
		setLayout(null);
		showRace = false;

//		JButton btnStandardMap = new JButton("");
//		btnStandardMap.setIcon(new ImageIcon(Start.class.getResource("/startAnimate/StandardMap.png")));
//		btnStandardMap.setBounds(152, 151, 300, 200);
//		add(btnStandardMap);
//		btnStandardMap.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				map = "Standard";
//			}
//		});

		
		JRadioButton rdbtnStandard = new JRadioButton("Standard");
		rdbtnStandard.setOpaque(false);
		rdbtnStandard.setFont(new Font("Euphemia", Font.PLAIN, 16));
		rdbtnStandard.setBounds(238, 358, 109, 23);
		rdbtnStandard.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				map = "Standard";
			}
			
		} );
		add(rdbtnStandard);
		
		JRadioButton rdbtnRandom = new JRadioButton("Random");
		rdbtnRandom.setOpaque(false);
		rdbtnRandom.setFont(new Font("Euphemia", Font.PLAIN, 16));
		rdbtnRandom.setBounds(571, 358, 109, 23);
		rdbtnStandard.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				map = "Random";
			
			}
			
		} );
		add(rdbtnRandom);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnStandard);
		bg.add(rdbtnRandom);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setFont(new Font("Euphemia", Font.PLAIN, 16));
		lblDifficulty.setBounds(276, 425, 61, 22);
		add(lblDifficulty);

		JLabel lblMap = new JLabel("Map");
		lblMap.setFont(new Font("Candara", Font.PLAIN, 23));
		lblMap.setBounds(449, 111, 44, 29);
		add(lblMap);

		JLabel lblOfPlayers = new JLabel("# of Players");
		lblOfPlayers.setFont(new Font("Euphemia", Font.PLAIN, 16));
		lblOfPlayers.setBounds(260, 467, 98, 22);
		add(lblOfPlayers);

		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Euphemia", Font.PLAIN, 16));
		comboBox.setBackground(new Color(176, 224, 230));
		comboBox.setBounds(385, 466, 170, 38);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Beginner",
				"Standard", "Tournament" }));
		add(comboBox);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(176, 224, 230));
		comboBox_2.setFont(new Font("Euphemia", Font.PLAIN, 16));
		comboBox_2.setBounds(385, 417, 170, 38);
		comboBox_2
				.setModel(new DefaultComboBoxModel(new Integer[] { 2, 3, 4 }));
		add(comboBox_2);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Euphemia", Font.PLAIN, 16));
		btnPrevious.setBackground(new Color(176, 224, 230));
		btnPrevious.setBounds(681, 403, 130, 30);
		add(btnPrevious);
		btnPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			firstScreen();
			}
		});
		

		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Euphemia", Font.PLAIN, 16));
		btnNext.setBackground(new Color(176, 224, 230));
		btnNext.setBounds(681, 456, 130, 30);
		add(btnNext);

		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				difficulty = (String) comboBox.getSelectedItem();
				numOfPlayers = (int) comboBox_2.getSelectedItem();
				System.out.println("Difficulty: " + difficulty + " Map Type: "
						+ map + " # of Players: " + numOfPlayers);
				playerInput();
			}
		});
		validate();
		//repaint();

	}

	/**
	 * Setting player name, player numbers panels.
	 */

	private void playerSetting() {
		showMap = 0;
		removeAll();
		setLayout(null);

		int player = currentPlayer + 1;
		JLabel lblPlayer = new JLabel("Player#" + player);
		lblPlayer.setFont(new Font("Euphemia", Font.PLAIN, 22));
		lblPlayer.setBounds(407, 222, 94, 31);
		add(lblPlayer);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Euphemia", Font.PLAIN, 16));
		lblName.setBounds(350, 300, 42, 22);
		add(lblName);

		JLabel lblRace = new JLabel("Race");
		lblRace.setFont(new Font("Euphemia", Font.PLAIN, 16));
		lblRace.setBounds(350, 351, 35, 22);
		add(lblRace);

		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Euphemia", Font.PLAIN, 16));
		lblColor.setBounds(350, 403, 41, 22);
		add(lblColor);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Euphemia", Font.PLAIN, 16));
		btnPrevious.setBackground(new Color(176, 224, 230));
		btnPrevious.setBounds(681, 403, 130, 30);
		add(btnPrevious);
		btnPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			gameSetting();
			}
		});
		// textField = new JTextField();
		// textField.setBounds(92, 302, 137, 188);
		// add(textField);
		// textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(176, 224, 230));
		textField_1.setFont(new Font("Euphemia", Font.PLAIN, 16));
		textField_1.setBounds(441, 291, 149, 40);
		add(textField_1);
		textField_1.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setBackground(new Color(176, 224, 230));
		comboBox.setFont(new Font("Euphemia", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Human",
				"Flapper", "Pandarian", "MonkeyKing" }));
		comboBox.setBounds(441, 347, 149, 31);
		add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(176, 224, 230));
		comboBox_1.setFont(new Font("Euphemia", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Red",
				"Yellow", "Green", "Blue" }));
		comboBox_1.setBounds(441, 399, 149, 31);
		add(comboBox_1);

		JButton btnNext = new JButton("Next");
	
		btnNext.setBackground(new Color(176, 224, 230));
		btnNext.setFont(new Font("Euphemia", Font.PLAIN, 16));
		btnNext.setBounds(681, 456, 130, 30);

		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField_1.getText();
				String race = (String) comboBox.getSelectedItem();
				String c = (String) comboBox_1.getSelectedItem();
				Color color = null;
				switch (c) {
				case "Red":
					color = Color.RED;
					break;
				case "Yellow":
					color = Color.YELLOW;
					break;
				case "Green":
					color = Color.GREEN;
					break;
				case "Blue":
					color = Color.BLUE;
					break;
				default:
				}
				System.out.println("Player #" + currentPlayer + " Name " + name
						+ " Color: " + c + " Race" + race);

				if (sameColor(color) || sameName(name)) {
					
					playerSetting();
				} else if (name.length() > 12) {
					
					playerSetting();
				} else {
					players[currentPlayer] = new Player(name, color, race,
							difficulty);
					currentPlayer++;
					if (currentPlayer == numOfPlayers) {
						// System.out.println("done");
						game.setUpMap();
					} else {
						playerSetting();
					}
				}

			}
		});

		add(btnNext);

		validate();
		repaint();
	}

	/**
	 * @wbp.parser.entryPoint
	 */

	/**
	 * Check if color is in player list. Return true if there is, return false
	 * if there isn't.
	 */
	public boolean sameColor(Color c) {
		for (int n = 0; n < currentPlayer; n++) {
			if (players[n].getColor() == c) {
				System.out.println("Oops! The color has been chosen...");
				JOptionPane.showMessageDialog(null,
						"Oops! The color has been chosen...", "color Conflict",
						0);

				return true;
			}
		}
		return false;
	}

	/**
	 * Check if name is in player list. Return true if there is, return false if
	 * there isn't.
	 */
	public boolean sameName(String name) {
		if (name.equals("")) {
			System.out.println("Please enter a name");
			return true;
		}
		for (int i = 0; i < currentPlayer; i++) {
			if (players[i].getName() == name) {
				System.out.println("Oops! The name has been chosen...");
				JOptionPane
						.showMessageDialog(null,
								"Oops! The name has been chosen...",
								"Name Conflict", 0);

				return true;
			}
		}
		return false;
	}

	/**
	 * in charge of painting and animations
	 */

	public void paintComponent(Graphics page) {

		int row = 500;

		super.paintComponent(page);
	

		try {

			page.drawImage(
					ImageIO.read(new File("Image/startAnimate/start0.png")), 0,
					0, null);
			
			if (moveAction) {

				if (moveAction2) {
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/donkeyRun1right.png")),
							xCoor - 150, row, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/monkeyRun1right.png")),
							xCoor - 250, row, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/pandaRun1right.png")),
							xCoor - 350, row, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/humanRun1right.png")),
							xCoor - 450, row, null);

					moveAction2 = false;
				} else {
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/donkeyRun2right.png")),
							xCoor - 150, row, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/monkeyRun2right.png")),
							xCoor - 250, row, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/pandaRun2right.png")),
							xCoor - 350, row, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/humanRun2right.png")),
							xCoor - 450, row, null);
					moveAction2 = true;
				}

			} else {

				if (moveAction2) {
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/donkeyRun1left.png")),
							xCoor - 350, row, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/monkeyRun1left.png")),
							xCoor - 250, row, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/pandaRun1left.png")),
							xCoor - 150, row, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/humanRun1left.png")),
							xCoor - 50, row, null);
					moveAction2 = false;
				} else {
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/donkeyRun2left.png")),
							xCoor - 350, row, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/monkeyRun2left.png")),
							xCoor - 250, row, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/pandaRun2left.png")),
							xCoor - 150, row, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/humanRun2left.png")),
							xCoor - 50, row, null);
					moveAction2 = true;
				}

			}
			if (showRace) {
				page.setColor(Color.WHITE);
				page.fillRect(92, 300, 85, 120);
				String sColor = (String) comboBox_1.getSelectedItem();
				String s = (String) comboBox.getSelectedItem();
				if(sColor.equalsIgnoreCase("red")){
					page.setColor(Color.RED);
					page.drawRect(91, 299, 86, 121);
					page.drawRect(90, 298, 88, 123);
				}else if(sColor.equalsIgnoreCase("blue")){
					page.setColor(Color.BLUE);
					page.drawRect(91, 299, 86, 121);
					page.drawRect(90, 298, 88, 123);
				}else if (sColor.equalsIgnoreCase("yellow")){
					page.setColor(Color.YELLOW);		
					page.drawRect(91, 299, 86, 121);
					page.drawRect(90, 298, 88, 123);
				}else if(sColor.equalsIgnoreCase("green")){
					page.setColor(Color.GREEN);
					page.drawRect(91, 299, 86, 121);
					page.drawRect(90, 298, 88, 123);

				}
				
				if (s.equals("MonkeyKing")) {


					
					if (moveAction3 == 0) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/monkeyfront.png")), 92, 302,
								92 + 80, 302 + 115, 0, 0, 80, 115, Color.WHITE,
								null);
						validate();
						moveAction3 = 1;
					} else if (moveAction3 == 1) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/monkeyfront.png")), 92, 302,
								92 + 80, 302 + 115, 150, 0, 148 + 80, 0 + 115,
								Color.WHITE, null);
						moveAction3 = 2;
					} else if (moveAction3 == 2) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/monkeyfront.png")), 92, 302,
								92 + 80, 302 + 115, 300, 4, 298 + 80, 4 + 115,
								Color.WHITE, null);
						moveAction3 = 0;
					}

				} else if (s.equalsIgnoreCase("Pandarian")) {

					if (moveAction3 == 0) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/pandaFront.png")), 92, 302,
								92 + 80, 302 + 110, 0, 0, 80, 105, Color.WHITE,
								null);
						moveAction3 = 1;
					} else if (moveAction3 == 1) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/pandaFront.png")), 92, 302,
								92 + 80, 302 + 110, 0, 105, 88, 211,
								Color.WHITE, null);

						moveAction3 = 2;
					} else if (moveAction3 == 2) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/pandaFront.png")), 92, 302,
								92 + 80, 302 + 110, 256, 0, 340, 100,
								Color.WHITE, null);
						moveAction3 = 0;
					}
				} else if (s.equalsIgnoreCase("Human")) {

					if (moveAction3 == 0) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/humanFront.png")), 102, 302,
								102 + 52, 302 + 110, 308, 0, 362, 110,
								Color.WHITE, null);
						moveAction3 = 1;
					} else if (moveAction3 == 1) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/humanFront.png")), 101, 302,
								101 + 52, 302 + 110, 255, 0, 307, 110,
								Color.WHITE,

								null);

						moveAction3 = 2;
					} else if (moveAction3 == 2) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/humanFront.png")), 106, 302,
								105 + 50, 302 + 110, 207, 0, 207 + 49, 110,
								Color.WHITE, null);
						moveAction3 = 0;
					}
				}

				else if (s.equalsIgnoreCase("Flapper")) {

					if (moveAction3 == 0) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/flapperFront.png")), 92,
								302, 92 + 80, 302 + 115, 115, 0, 115 + 80, 115,
								Color.WHITE, null);
						moveAction3 = 1;
					} else if (moveAction3 == 1) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/flapperFront.png")), 92,
								302, 92 + 80, 302 + 115, 13, 0, 13 + 80, 115,
								Color.WHITE,

								null);

						moveAction3 = 2;
					} else if (moveAction3 == 2) {
						page.drawImage(ImageIO.read(new File(
								"Image/startAnimate/flapperFront.png")), 92,
								302, 92 + 80, 302 + 115, 322, 0, 322 + 80, 115,
								Color.WHITE, null);
						moveAction3 = 0;
					}

				}
			}
			if (showMap > 0) {

				if (showMap >= 1 && showMap <= 5) {
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/StandardMap.png")), 152, 151,
							300, 200, Color.WHITE, null);
					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/RandomMap1.png")), 486, 151,
							300, 200, Color.WHITE, null);
					showMap++;
					if (showMap == 5) {
						showMap = 6;
					}

				} else if (showMap >= 6 && showMap <= 11) {

					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/StandardMap.png")), 152, 151,
							300, 200, Color.WHITE, null);

					page.drawImage(ImageIO.read(new File(
							"Image/startAnimate/RandomMap2.png")), 486, 151,
							300, 200, Color.WHITE, null);
					showMap++;
					if (showMap == 11) {
						showMap = 1;
					}

				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
