

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Store.java
 * Version 252. Copyright One-E
 * Store class that is in-charge of everything that is related to store.
 * @author One-E
 * 
 * 
 */
public class Store extends JPanel {
	
	private final int FOOD_PRICE = 30, ENERGY_PRICE = 25;
	private final int SMITHORE_PRICE = 50, CRYSTITE_PRICE = 100;
	private final int MULE_PRICE = 100;
	private final int FOODM_PRICE = 25, ENERGYM_PRICE = 50+MULE_PRICE;
	private final int SMITHOREM_PRICE = 75+MULE_PRICE;
	private final int CRYSTITEM_PRICE = 100+MULE_PRICE;

	private boolean success = false;
	private int successDis = 0;
	private Player p;
	private Town town;

	private int Food, Energy, Smithore, Crystite, Mule; 
	/**
	 * Constructor for Store Class
	 */
	public Store(String difficulty, Town t) {
		setPreferredSize(new Dimension(500, 300));
		setVisible(true);
		setOpaque(false);
		town = t;
		if (difficulty == "Beginner") {
			Food = 16;
			Energy = 16;
			Smithore = 0;
			Crystite = 0;
			Mule = 25;
		}
		else {
			Food = 0;
			Energy = 0;
			Smithore = 8;
			Crystite = 0;
			Mule = 14;
			
		}
		window1();

	}
	/**
	 * draw window 1
	 */
	private void window1() {
		removeAll();
		setLayout(null);

		JButton btnBuyMule = new JButton("Buy Mule");
		btnBuyMule.setBounds(161, 90, 137, 23);
		add(btnBuyMule);

		JButton btnBuysellResource = new JButton("Buy/Sell Resource");
		btnBuysellResource.setBounds(161, 155, 137, 23);
		add(btnBuysellResource);

		btnBuyMule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window2();
			}
		});
		btnBuysellResource.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				window3();
			}
		});
		validate();
		repaint();
	}
	/**
	 * draw the window2
	 */
	private void window2(){
		removeAll();
		setLayout(null);
		
		JButton btnFoodMule = new JButton("Food Mule");
		btnFoodMule.setBounds(157, 52, 119, 23);
		add(btnFoodMule);
		btnFoodMule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(buyMule("Food Mule", FOODM_PRICE))
				success = true;
			window4();
			}
		});
		
		
		JButton btnEne = new JButton("Energy Mule");
		btnEne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(buyMule("Energy Mule", ENERGYM_PRICE))
				success = true;
			window4();
			}
		});
		btnEne.setBounds(157, 101, 119, 23);
		add(btnEne);
		
		JButton btnOreMule = new JButton("Smithore Mule");
		btnOreMule.setBounds(157, 153, 119, 23);
		add(btnOreMule);
		btnOreMule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			if(buyMule("Smithore Mule", SMITHOREM_PRICE))
				success = true;
			window4();
			}
		});
		
		JButton btnNewButton = new JButton("Crystite Mule");
		btnNewButton.setBounds(157, 208, 119, 23);
		add(btnNewButton);
		
		JButton btnPreviousPage = new JButton("Previous Page");
		btnPreviousPage.setBounds(31, 23, 119, 23);
		btnPreviousPage.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
			window1();
			}
		});
		add(btnPreviousPage);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(buyMule("Crystite Mule", CRYSTITEM_PRICE))
				success = true;
			window4();
			}
		});
		validate();
		repaint();

	}
	/**
	 * draw window 3
	 */
	private void window3(){
		removeAll();
		setLayout(null);
		
		JButton btnFood = new JButton("Food");
		btnFood.setBounds(68, 54, 89, 23);
		add(btnFood);
		
		JButton btnEnergy = new JButton("Energy");
		btnEnergy.setBounds(68, 97, 89, 23);
		add(btnEnergy);
		
		JButton btnSmithore = new JButton("Smithore");
		btnSmithore.setBounds(68, 145, 89, 23);
		add(btnSmithore);
		
		JButton btnCrystite = new JButton("Crystite");
		btnCrystite.setBounds(68, 189, 89, 23);
		add(btnCrystite);
		
		JButton button = new JButton("+");
		button.setBounds(232, 54, 41, 23);
		add(button);
		button.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("buy", "Food");
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("sell", "Food");
			}
			
		});
		btnNewButton_1.setBounds(272, 54, 41, 23);
		add(btnNewButton_1);
		
		JButton button_1 = new JButton("+");
		button_1.setBounds(232, 97, 41, 23);
		add(button_1);
		button_1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("buy", "Energy");
			}
			
		});
		
		JButton button_2 = new JButton("-");
		button_2.setBounds(272, 97, 41, 23);
		add(button_2);
		button_2.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("sell", "Energy");
			}
			
		});
		
		JButton button_3 = new JButton("+");
		button_3.setBounds(232, 145, 41, 23);
		add(button_3);
		button_3.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("buy", "Smithore");
			}
			
		});
		
		JButton button_4 = new JButton("-");
		button_4.setBounds(272, 145, 41, 23);
		add(button_4);
		button_4.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				sell("Smithore");
			}
			
		});
		
		JButton button_5 = new JButton("+");
		button_5.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("buy", "Crystite");
			}
			
		});
		button_5.setBounds(232, 189, 41, 23);
		add(button_5);
		
		JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.setBounds(272, 189, 41, 23);
		add(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("sell", "Crystite");
			}
			
		});
		
		JLabel lblNewLabel = new JLabel("" + FOOD_PRICE);
		lblNewLabel.setBounds(167, 58, 46, 14);
		add(lblNewLabel);
		
		JLabel lblE = new JLabel("" + ENERGY_PRICE);
		lblE.setBounds(167, 101, 46, 14);
		add(lblE);
		
		JLabel lblSm = new JLabel("" + SMITHORE_PRICE);
		lblSm.setBounds(167, 149, 46, 14);
		add(lblSm);
		
		JLabel lblCr = new JLabel("" + CRYSTITE_PRICE);
		lblCr.setBounds(167, 193, 46, 14);
		add(lblCr);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(167, 26, 46, 14);
		add(lblPrice);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(325, 242, 89, 23);
		btnDone.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				commands.clear();
				successDis = 1;
				window4();
			}
			
			
		});
		add(btnDone);
		validate();
		repaint();
	}
	/**
	 * draw window 4
	 */
	private void window4(){
		removeAll();
	    setLayout(null);
		
		JLabel lblTrueFalse = new JLabel("");
		if(successDis == 1){
			lblTrueFalse.setText("");
			successDis =0;
		}
		else if(success){
			lblTrueFalse.setText("Purchase Successful");
			success = false;
		}else if (!success){
			lblTrueFalse.setText("Purchase Failed");
		}
		lblTrueFalse.setBounds(131, 71, 206, 28);
		add(lblTrueFalse);
		
		JLabel lblDoYouNeed = new JLabel("Do you need anything else?");
		lblDoYouNeed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoYouNeed.setBounds(113, 142, 244, 49);
		add(lblDoYouNeed);
		
		JButton btnYes = new JButton("Yes");
		btnYes.setBounds(113, 189, 89, 23);
		btnYes.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				window1();
			}
			
		});
		add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(202, 189, 89, 23);
		btnNo.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				removeAll();
				window1();
				town.playerOutStore();
				validate();
				repaint();
			}
			
		});
		add(btnNo);
		validate();
		repaint();
	}
	/**
	 * buy resource method
	 * 
	 * @param type is the type of food the player bought
	 * @return true if the purchase is successful, false if it failed.
	 */
	public boolean buy(String type) {
		if (type == "Food" && Food>0) {
			if (p.buyResource("Food", FOODM_PRICE)) {
				Food-=1;
			}
			return true;
		}
		else if (type == "Energy" && Energy>0) {
			if (p.buyResource("Energy", ENERGYM_PRICE)) {
				Energy-=1;
			}
			return true;
		}
		else if (type == "Smithore" && Smithore > 0) {
			if (p.buyResource("Smithore", SMITHOREM_PRICE)) {
				Smithore-=1;
			}
			return true;
		}
		else if (type == "Crystite" && Crystite > 0) {
			
			if (p.buyResource("Crystite", CRYSTITEM_PRICE)) {
				Crystite-=1;
			}
			return true;
		}
		System.out.println("Transition failed, since Store doesn't have enough resource");
		return false;
	}
	
	/**
	 * sell resource 
	 * 
	 * @param type the type of resource the player is selling.
	 */
	public boolean sell(String type) {
		if (type == "Food" && p.sellResource("Food", FOOD_PRICE)) {
			Food+=1;
			return true;
		}
		else if (type == "Energy" && p.sellResource("Energy", ENERGY_PRICE)) {
			Energy+=1;
			return true;
		}
		else if (type == "Smithore" && p.sellResource("Smithore", SMITHORE_PRICE)) {
			Smithore+=1;
			Mule+=1;
			return true;
		}
		else if (type == "Crystite" && p.sellResource("Crystite", CRYSTITE_PRICE)) {
			Crystite+=1;
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return the price of food
	 */
	public int getFoodPrice() {
		return FOOD_PRICE;
	}
	
	/**
	 * 
	 * @return the price of energy
	 */
	public int getEnergyPrice() {
		return ENERGY_PRICE;
	}
	
	/**
	 * 
	 * @return the price of smithore
	 */
	public int getSmithorePrice() {
		return SMITHORE_PRICE;
	}
	
	/**
	 * 
	 * @return the price of crystite
	 */
	public int getCrystitePrice() {
		return CRYSTITE_PRICE;
	}
	
	/**
	 * 
	 * @return the price of food + mule
	 */
	public int getFoodMulePrice() {
		return FOODM_PRICE;
	}
	
	/**
	 * 
	 * @return the price of energy + mule
	 */
	public int getEnergyMulePrice() {
		return ENERGYM_PRICE;
	}
	
	/**
	 * 
	 * @return the price of smithore + mule
	 */
	public int getSmithoreMulePrice() {
		return SMITHOREM_PRICE;
	}
	
	/**
	 * 
	 * @return the price of crystite + mule
	 */
	public int getCrystiteMulePrice() {
		return CRYSTITEM_PRICE; 
	}
	
	/**
	 * @return the number of food
	 */
	public int getFood() {
		return Food;
	}
	
	/**
	 * @return the number of energy
	 */
	public int getEnergy() {
		return Energy;
	}
	/**
	 * @return the number of Crystite
	 */
	public int getCrystite() {
		return Crystite;
	}
	
	/**
	 * @return the number of Smithore
	 */
	public int getSmithore() {
		return Smithore;
	}
	/**
	 * @return the number of Mule
	 */
	public int getMule() {
		return Mule;
	}
	/**
	 * buy mule method
	 *  
	 * @param m string of mule type
	 * @param price  mule price
	 * @return weather purchase successful or not
	 */
	public boolean buyMule(String m, int price) {
		if(Mule > 0){
			if (p.buyMule(m, price)) {
				Mule-=1;
			    return true;
			}
		}else{
			System.out
					.println("Transition failed, since Store doesn't have enough mule");
			return false;
		}
		return false;
		
	}
	
	private ArrayList<Command> commands = new ArrayList<Command>();
	/**
	 * This is the prosessor for the command pattern
	 * @param bs indicate whether the command is selling or buying
	 * @param type indicate the type of good to buy or sell
	 */
	private void doCommand(String bs, String type){
		Command command = new Command(bs, type);
		if(command.doIt()){
			commands.add(command);
		}
	}
	
	/**
	 * This method is used to undo last transition
	 */
	private void undoLastOne(){
		if(!commands.isEmpty()){
			Command toundo = commands.get(commands.size() - 1);
			toundo.undo();
		}
	}
	
	/**
	 * This method is used to undo all transitions player makes in story
	 */
	private void undoAll(){
		while(! commands.isEmpty()){
			undoLastOne();
		}
	}
	/**
	 * choose player
	 * 
	 * @param p player
	 */
	public void playerEnterStore(Player p) {
		this.p = p;
	}
	/**
	 * reset the gui to window1
	 */
	public void reset(){
	 window1();
	}
	
	/**
	 * Load from saved file
	 * @param f the food in saved file
	 * @param g the energy in saved file
	 * @param s the smithore in saved file
	 * @param c the crystite in saved file
	 * @param m the mule in saved file
	 */
	public void Restore(int f, int g, int s, int c, int m){
		Food = f;
		Energy = g;
		Smithore = s;
		Crystite = c;
		Mule = m;
	}
	
	private class Command{
		
		private String bos;
		private String type;
		
		public Command(String bs, String t){
			bos = bs;
			type = t;
		}
		
		public boolean doIt(){
			if(bos.equals("buy")){
				return buy(type);
			}else{
				return sell(type);
			}
		}
		
		public void undo(){
			if(bos.equals("buy")){
				sell(type);
			}else{
				buy(type);
			}
		}
	}
}