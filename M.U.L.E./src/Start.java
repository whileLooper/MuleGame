import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Button;

import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JMenu;

import java.awt.GridLayout;

//import net.miginfocom.swing.MigLayout;















import javax.swing.SpringLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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


public class Start extends JPanel{
	
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
	
	/**
	 * Setting the game start option.
	 */
	public Start(Game g){
		game = g;
		//playerSetting();
		
		setPreferredSize(new Dimension(900, 500));
		setVisible(true);
		gameSetting();
		//validate();
		//repaint();
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
	}
	
	/**
	 * Game setting method. 
	 * Setting game start menu elements panels
	 * */
	private void gameSetting(){
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		GridBagConstraints gbc_lblDifficulty = new GridBagConstraints();
		gbc_lblDifficulty.insets = new Insets(0, 0, 5, 5);
		gbc_lblDifficulty.gridx = 1;
		gbc_lblDifficulty.gridy = 2;
		add(lblDifficulty, gbc_lblDifficulty);
		
		JLabel lblMap = new JLabel("Map");
		GridBagConstraints gbc_lblMap = new GridBagConstraints();
		gbc_lblMap.insets = new Insets(0, 0, 5, 5);
		gbc_lblMap.gridx = 2;
		gbc_lblMap.gridy = 2;
		add(lblMap, gbc_lblMap);
		
		JLabel lblOfPlayers = new JLabel("# of Players");
		GridBagConstraints gbc_lblOfPlayers = new GridBagConstraints();
		gbc_lblOfPlayers.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfPlayers.gridx = 3;
		gbc_lblOfPlayers.gridy = 2;
		add(lblOfPlayers, gbc_lblOfPlayers);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Beginner", "Standard", "Tournament"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Standard", "Random"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 4;
		add(comboBox_1, gbc_comboBox_1);
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new Integer[] {2, 3, 4}));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 3;
		gbc_comboBox_2.gridy = 4;
		add(comboBox_2, gbc_comboBox_2);
		
		JButton btnNext = new JButton("Next");
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
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 0, 5);
		gbc_btnNext.gridx = 3;
		gbc_btnNext.gridy = 6;
		add(btnNext, gbc_btnNext);
	}

	
	/**
	 * Setting player name, player numbers panels.
	 */
	private void playerSetting(){
		removeAll();
		
		GridBagLayout gbl_setting = new GridBagLayout();
		gbl_setting.columnWidths = new int[]{32, 0, 0, 0, 0, 0};
		gbl_setting.rowHeights = new int[]{21, 0, 0, 0, 0, 0, 0};
		gbl_setting.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_setting.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_setting);
		JLabel lblPlayer = new JLabel();
		lblPlayer.setText("Player #"+ (currentPlayer+1));

		GridBagConstraints gbc_lblPlayer = new GridBagConstraints();
		gbc_lblPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer.gridx = 0;
		gbc_lblPlayer.gridy = 1;
		add(lblPlayer, gbc_lblPlayer);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		add(lblName, gbc_lblName);
		
		JLabel lblLabel = new JLabel("Race");
		GridBagConstraints gbc_lblLabel = new GridBagConstraints();
		gbc_lblLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabel.gridx = 2;
		gbc_lblLabel.gridy = 2;
		add(lblLabel, gbc_lblLabel);
		
		JLabel lblColor = new JLabel("Color");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 3;
		gbc_lblColor.gridy = 2;
		add(lblColor, gbc_lblColor);
		
		final JTextField textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Flapper", "Human", "Others"}));
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.gridx = 2;
		gbc_comboBox_3.gridy = 3;
		add(comboBox_3, gbc_comboBox_3);
		
		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Red", "Yellow", "Green", "Blue"}));
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_4.gridx = 3;
		gbc_comboBox_4.gridy = 3;
		add(comboBox_4, gbc_comboBox_4);
		
		JButton btnNext_1 = new JButton("Next");
		btnNext_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField_1.getText();
				String race = (String) comboBox_3.getSelectedItem();
				String c = (String) comboBox_4.getSelectedItem();
				Color color = null;
				switch(c){
				case "Red": color = Color.RED; break;
				case "Yellow": color = Color.YELLOW; break;
				case "Green": color = Color.GREEN; break;
				case "Blue": color = Color.BLUE; break;
				default:
				}
				players[currentPlayer] = new Player(name, color, race);
				System.out.println("Player #" + currentPlayer + " Name " + name + " Color: " + c + " Race" + race);
				currentPlayer ++;
				if(currentPlayer == numOfPlayers){
					//System.out.println("done");
					game.setUpMap();
				}else{
					playerSetting();
				}
			}
		});
		GridBagConstraints gbc_btnNext_1 = new GridBagConstraints();
		gbc_btnNext_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNext_1.gridx = 3;
		gbc_btnNext_1.gridy = 4;
		add(btnNext_1, gbc_btnNext_1);
		
		validate();
		repaint();
	}
	
}
