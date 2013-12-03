package enforcedMULE.GUIView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import enforcedMULE.GUIModel.PlayerModel;
import enforcedMULE.GUIPresenter.PlayerPresenter;
import enforcedMULE.GUIPresenter.StartInterface;

public class StartView extends JPanel implements StartInterface{

	private int showMap = 0;
	private boolean showRace = false;
	private boolean moveAction = true;
	private boolean moveAction2 = true;
	private int moveAction3 = 0;
	
	public StartView(){
		setPreferredSize(new Dimension(910, 688));
		setVisible(true);
		newGame();
		start();
		
	}
	
	
	@Override
	public void newGame() {
		// TODO Auto-generated method stub
		
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


		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBackground(new Color(176, 224, 230));
		btnNewGame.setFont(new Font("Euphemia", Font.PLAIN, 16));
		btnNewGame.setBounds(371, 340, 150, 50);
		add(btnNewGame);
		btnNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				start();
			}
		}

		);

	
		
	}

	@Override
	public String[] getGameInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void newPlayerMemu (int playerNum) {
		// TODO Auto-generated method stub
	
		showMap = 0;
		removeAll();
		setLayout(null);

		
		JLabel lblPlayer = new JLabel("Player#" + playerNum);
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
			start();
			}
		});
		// textField = new JTextField();
		// textField.setBounds(92, 302, 137, 188);
		// add(textField);
		// textField.setColumns(10);

		final JTextField textField_1 = new JTextField();
		textField_1.setBackground(new Color(176, 224, 230));
		textField_1.setFont(new Font("Euphemia", Font.PLAIN, 16));
		textField_1.setBounds(441, 291, 149, 40);
		add(textField_1);
		textField_1.setColumns(10);

		final JComboBox raceBox = new JComboBox();
		raceBox.setBackground(new Color(176, 224, 230));
		raceBox.setFont(new Font("Euphemia", Font.PLAIN, 16));
		raceBox.setModel(new DefaultComboBoxModel(new String[] { "Human",
				"Flapper", "Pandarian", "MonkeyKing" }));
		raceBox.setBounds(441, 347, 149, 31);
		add(raceBox);

		final JComboBox colorBox = new JComboBox();
		colorBox.setBackground(new Color(176, 224, 230));
		colorBox.setFont(new Font("Euphemia", Font.PLAIN, 16));
		colorBox.setModel(new DefaultComboBoxModel(new String[] { "Red",
				"Yellow", "Green", "Blue" }));
		colorBox.setBounds(441, 399, 149, 31);
		add(colorBox);

		JButton btnNext = new JButton("Next");
	
		btnNext.setBackground(new Color(176, 224, 230));
		btnNext.setFont(new Font("Euphemia", Font.PLAIN, 16));
		btnNext.setBounds(681, 456, 130, 30);

//		btnNext.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				String name = textField_1.getText();
//				String race = (String) raceBox.getSelectedItem();
//				String c = (String) colorBox.getSelectedItem();
//				Color color = null;
//				switch (c) {
//				case "Red":
//					color = Color.RED;
//					break;
//				case "Yellow":
//					color = Color.YELLOW;
//					break;
//				case "Green":
//					color = Color.GREEN;
//					break;
//				case "Blue":
//					color = Color.BLUE;
//					break;
//				default:
//				}
//				System.out.println("Player #" + currentPlayer + " Name " + name
//						+ " Color: " + c + " Race" + race);
//
//				if (sameColor(color) || sameName(name)) {
//					
//					playerSetting();
//				} else if (name.length() > 12) {
//					
//					playerSetting();
//				} else {
//					players[currentPlayer] = new Player(name, color, race,
//							difficulty);
//					currentPlayer++;
//					if (currentPlayer == numOfPlayers) {
//						// System.out.println("done");
//						game.setUpMap();
//					} else {
//						playerSetting();
//					}
//				}
//
//			}
//		});

		add(btnNext);

		validate();
		repaint();
	}

	@Override
	public PlayerPresenter getPlayerInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListener(MouseListener mouselistener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		showMap = 1;
		removeAll();
		setLayout(null);
		showRace = false;
		
		final JRadioButton rdbtnStandard = new JRadioButton("Standard");
		rdbtnStandard.setOpaque(false);
		rdbtnStandard.setFont(new Font("Euphemia", Font.PLAIN, 16));
		rdbtnStandard.setBounds(238, 358, 109, 23);
//		rdbtnStandard.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (rdbtnStandard.isSelected()){
//					map="Standard";
//				}
//			}
//			
//		} );
		add(rdbtnStandard);
		
		final JRadioButton rdbtnRandom = new JRadioButton("Random");
		rdbtnRandom.setOpaque(false);
		rdbtnRandom.setFont(new Font("Euphemia", Font.PLAIN, 16));
		rdbtnRandom.setBounds(571, 358, 109, 23);
		
//		rdbtnRandom.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (rdbtnRandom.isSelected()){
//					map = "Random";
//				}
//			}
//			
//		} );
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
		comboBox_2.setModel(new DefaultComboBoxModel(new Integer[] { 2, 3, 4 }));
		add(comboBox_2);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Euphemia", Font.PLAIN, 16));
		btnPrevious.setBackground(new Color(176, 224, 230));
		btnPrevious.setBounds(681, 403, 130, 30);
		add(btnPrevious);
		btnPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			newGame();
			}
		});
		

		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Euphemia", Font.PLAIN, 16));
		btnNext.setBackground(new Color(176, 224, 230));
		btnNext.setBounds(681, 456, 130, 30);
		add(btnNext);

//		btnNext.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				difficulty = (String) comboBox.getSelectedItem();
//				numOfPlayers = (int) comboBox_2.getSelectedItem();
//				System.out.println("Difficulty: " + difficulty + " Map Type: "
//						+ map + " # of Players: " + numOfPlayers);
//				playerInput();
//			}
//		});
		
		validate();
		
	}


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
