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
import javax.swing.SwingConstants;
import javax.swing.JMenu;

import java.awt.GridLayout;

//import net.miginfocom.swing.MigLayout;








import javax.swing.SpringLayout;

import java.awt.Color;
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


public class Start extends JPanel{
	
	private JTextField textField;
	private JTextField textField_1;
	private String difficulty;
	private String map;
	private int nP;
	private Player[] players;
	private static int pn=1;
	//private Game game;
	private int countPlayer = 0;
	private JPanel gsetting;
	private JPanel psetting;
	
	/**
	 * Setting the game start option.
	 * */
	public Start(){
		setForeground(Color.WHITE);

		gameSetting();
		setBackground(new Color(0,0,0,0));
		add(gsetting);
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
		players = new Player[nP];
		playerSetting();
	}
	
	/**
	 * Game setting method. 
	 * Setting game start menu elements panels
	 * */
	private void gameSetting(){
		gsetting = new JPanel();
		gsetting.setSize(500,300);
		gsetting.setForeground(Color.DARK_GRAY);
		gsetting.setOpaque(true);
		gsetting.setBackground(new Color(0,0,0,0));
		GridBagLayout gbl_gsetting = new GridBagLayout();
		gbl_gsetting.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0};
		gbl_gsetting.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_gsetting.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_gsetting.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gsetting.setLayout(gbl_gsetting);
		
		JLabel lblNewLabel = new JLabel("Difficulty");
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 4;
		gsetting.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblMapType = new JLabel("Map Type");
		lblMapType.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblMapType = new GridBagConstraints();
		gbc_lblMapType.anchor = GridBagConstraints.WEST;
		gbc_lblMapType.insets = new Insets(0, 0, 5, 5);
		gbc_lblMapType.gridx = 4;
		gbc_lblMapType.gridy = 4;
		gsetting.add(lblMapType, gbc_lblMapType);
		
		JLabel lblPlayerNumber = new JLabel("Player Number");
		lblPlayerNumber.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPlayerNumber = new GridBagConstraints();
		gbc_lblPlayerNumber.anchor = GridBagConstraints.WEST;
		gbc_lblPlayerNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerNumber.gridx = 6;
		gbc_lblPlayerNumber.gridy = 4;
		gsetting.add(lblPlayerNumber, gbc_lblPlayerNumber);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Beginner", "Standard", "Tournament"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 5;
		gsetting.add(comboBox, gbc_comboBox);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Standard", "Random"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 5;
		gsetting.add(comboBox_1, gbc_comboBox_1);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = (String) comboBox.getSelectedItem();
				map = (String) comboBox_1.getSelectedItem();
				nP = Integer.parseInt((String) comboBox_1.getSelectedItem());
				System.out.println("" + difficulty + " " + map + " " + nP);
				playerInput();
				//////////////////////////
			//	removeAll();
			//	playerSetting();
				
				
			}
		});
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.gridx = 6;
		gbc_comboBox_2.gridy = 5;
		gsetting.add(comboBox_2, gbc_comboBox_2);
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.anchor = GridBagConstraints.EAST;
		gbc_btnNext.insets = new Insets(0, 0, 5, 5);
		gbc_btnNext.gridx = 9;
		gbc_btnNext.gridy = 7;
		gsetting.add(btnNext, gbc_btnNext);
		
		
	}

	
	/**
	 * Setting player name, player numbers panels.
	 * */
	private void playerSetting(){
		psetting = new JPanel();
		psetting.setSize(905,528);
		
		GridBagLayout gbl_setting = new GridBagLayout();
		gbl_setting.columnWidths = new int[]{32, 0, 0, 0, 0, 0};
		gbl_setting.rowHeights = new int[]{21, 0, 0, 0, 0, 0, 0};
		gbl_setting.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_setting.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		psetting.setLayout(gbl_setting);
		JLabel lblPlayer = new JLabel();
		lblPlayer.setText("Player #"+pn);

		GridBagConstraints gbc_lblPlayer = new GridBagConstraints();
		gbc_lblPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer.gridx = 0;
		gbc_lblPlayer.gridy = 1;
		psetting.add(lblPlayer, gbc_lblPlayer);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		psetting.add(lblName, gbc_lblName);
		
		JLabel lblLabel = new JLabel("Race");
		GridBagConstraints gbc_lblLabel = new GridBagConstraints();
		gbc_lblLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabel.gridx = 2;
		gbc_lblLabel.gridy = 2;
		psetting.add(lblLabel, gbc_lblLabel);
		
		JLabel lblColor = new JLabel("Color");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 3;
		gbc_lblColor.gridy = 2;
		psetting.add(lblColor, gbc_lblColor);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		psetting.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Flapper", "Human", "Others"}));
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.gridx = 2;
		gbc_comboBox_3.gridy = 3;
		psetting.add(comboBox_3, gbc_comboBox_3);
		
		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Red", "Yellow", "Green", "Blue"}));
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_4.gridx = 3;
		gbc_comboBox_4.gridy = 3;
		psetting.add(comboBox_4, gbc_comboBox_4);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_1.getText();
				String race = (String) comboBox_3.getSelectedItem();
				String color = (String) comboBox_4.getSelectedItem();
				Color c = null;
				if (color.equals("Red")) c = Color.red;
				if (color.equals("Yellow")) c = Color.yellow;
				if (color.equals("Green")) c = Color.green;
				if (color.equals("Blue")) c = Color.blue;
			//	if (sameColor(c) || sameName(name)) {
			//		playerSetting();
			//	}
			//	else {
					Player player = new Player(name, c, race);
					countPlayer+=1;
					System.out.println("" + name + " " + race + " " + color + " " + pn);
					nP -= 1;
					players[nP] = player;
					
					pn++;
			//	}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 4;
		psetting.add(btnNewButton, gbc_btnNewButton);
		System.out.println("players");
	//	display.changeDisp(psetting);
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	
	/**
	 * Check if color is in player list. Return true if there is, return false if there isn't.
	 */
//	public boolean sameColor(Color c) {
//		Player[] playerList = new Player[countPlayer];
//		for (int i = 0; i < countPlayer; i++) {
//			playerList[i] = getPlayerList()[getPlayerList().length-1];
//		}
//		for (int j = 0; j < playerList.length; j++) {
//			if (c.equals(playerList[j].getColor())) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	/**
//	 * Check if name is in player list. Return true if there is, return false if there isn't.
//	 */
//	public boolean sameName(String name) {
//		if (name.equals("")) {
//			
//			return true;
//		}
//		Player[] playerList = new Player[countPlayer];
//		for (int i = 0; i < countPlayer; i++) {
//			playerList[i] = getPlayerList()[getPlayerList().length-1];
//		}
//		for (int j = 0; j < playerList.length; j++) {
//			if (name.equals(playerList[j].getName())) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	public void paintComponent(Graphics page)
	{
	    super.paintComponent(page);
	    BufferedImage img = null;
	    try {
	   		page.drawImage(ImageIO.read(new File("LeatherHoles-Plain.png")), 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
