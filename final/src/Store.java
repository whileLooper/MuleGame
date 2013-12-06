

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.print.attribute.AttributeSetUtilities;
import javax.swing.ImageIcon;
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
		setPreferredSize(new Dimension(900, 500));
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
		btnBuyMule.setBackground(new Color(176, 224, 230));
		btnBuyMule.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnBuyMule.setBounds(359, 120, 170, 29);
		add(btnBuyMule);

		JButton btnBuysellResource = new JButton("Buy/Sell Resource");
		btnBuysellResource.setBackground(new Color(176, 224, 230));
		btnBuysellResource.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnBuysellResource.setBounds(359, 184, 170, 29);
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
		btnFoodMule.setBackground(new Color(176, 224, 230));
		btnFoodMule.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnFoodMule.setBounds(424, 117, 141, 29);
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
		btnEne.setBackground(new Color(176, 224, 230));
		btnEne.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnEne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(buyMule("Energy Mule", ENERGYM_PRICE))
				success = true;
			window4();
			}
		});
		btnEne.setBounds(424, 166, 141, 29);
		add(btnEne);
		
		JButton btnOreMule = new JButton("Smithore Mule");
		btnOreMule.setBackground(new Color(176, 224, 230));
		btnOreMule.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnOreMule.setBounds(424, 218, 141, 29);
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
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnNewButton.setBounds(424, 273, 141, 29);
		add(btnNewButton);
		
		JButton btnPreviousPage = new JButton("Previous Page");
		btnPreviousPage.setBackground(new Color(176, 224, 230));
		btnPreviousPage.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnPreviousPage.setBounds(265, 88, 141, 29);
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
		btnFood.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnFood.setBackground(new Color(176, 224, 230));
		btnFood.setBounds(305, 136, 89, 23);
		add(btnFood);
		
		JButton btnEnergy = new JButton("Energy");
		btnEnergy.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnEnergy.setBackground(new Color(176, 224, 230));
		btnEnergy.setBounds(305, 179, 89, 23);
		add(btnEnergy);
		
		JButton btnSmithore = new JButton("Smithore");
		btnSmithore.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnSmithore.setBackground(new Color(176, 224, 230));
		btnSmithore.setBounds(305, 227, 89, 23);
		add(btnSmithore);
		
		JButton btnCrystite = new JButton("Crystite");
		btnCrystite.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnCrystite.setBackground(new Color(176, 224, 230));
		btnCrystite.setBounds(305, 271, 89, 23);
		add(btnCrystite);
		
		JButton button = new JButton("+");
		button.setFont(new Font("Euphemia", Font.PLAIN, 14));
		button.setBackground(new Color(176, 224, 230));
		button.setBounds(469, 136, 52, 32);
		add(button);
		button.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("buy", "Food");
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(176, 224, 230));
		btnNewButton_1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("sell", "Food");
			}
			
		});
		btnNewButton_1.setBounds(520, 136, 52, 32);
		add(btnNewButton_1);
		
		JButton button_1 = new JButton("+");
		button_1.setFont(new Font("Euphemia", Font.PLAIN, 14));
		button_1.setBackground(new Color(176, 224, 230));
		button_1.setBounds(469, 179, 52, 29);
		add(button_1);
		button_1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("buy", "Energy");
			}
			
		});
		
		JButton button_2 = new JButton("-");
		button_2.setFont(new Font("Euphemia", Font.PLAIN, 14));
		button_2.setBackground(new Color(176, 224, 230));
		button_2.setBounds(520, 179, 52, 29);
		add(button_2);
		button_2.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("sell", "Energy");
			}
			
		});
		
		JButton button_3 = new JButton("+");
		button_3.setFont(new Font("Euphemia", Font.PLAIN, 14));
		button_3.setBackground(new Color(176, 224, 230));
		button_3.setBounds(469, 227, 52, 29);
		add(button_3);
		button_3.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("buy", "Smithore");
			}
			
		});
		
		JButton button_4 = new JButton("-");
		button_4.setFont(new Font("Euphemia", Font.PLAIN, 14));
		button_4.setBackground(new Color(176, 224, 230));
		button_4.setBounds(520, 227, 52, 29);
		add(button_4);
		button_4.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				sell("Smithore");
			}
			
		});
		
		JButton button_5 = new JButton("+");
		button_5.setFont(new Font("Euphemia", Font.PLAIN, 14));
		button_5.setBackground(new Color(176, 224, 230));
		button_5.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("buy", "Crystite");
			}
			
		});
		button_5.setBounds(469, 271, 52, 29);
		add(button_5);
		
		JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnNewButton_2.setBackground(new Color(176, 224, 230));
		btnNewButton_2.setBounds(520, 271, 52, 29);
		add(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				doCommand("sell", "Crystite");
			}
			
		});
		
		JLabel lblNewLabel = new JLabel("" + FOOD_PRICE);
		lblNewLabel.setFont(new Font("Euphemia", Font.PLAIN, 14));
		lblNewLabel.setBackground(new Color(176, 224, 230));
		lblNewLabel.setBounds(404, 140, 46, 14);
		add(lblNewLabel);
		
		JLabel lblE = new JLabel("" + ENERGY_PRICE);
		lblE.setFont(new Font("Euphemia", Font.PLAIN, 14));
		lblE.setBackground(new Color(176, 224, 230));
		lblE.setBounds(404, 183, 46, 14);
		add(lblE);
		
		JLabel lblSm = new JLabel("" + SMITHORE_PRICE);
		lblSm.setFont(new Font("Euphemia", Font.PLAIN, 14));
		lblSm.setBackground(new Color(176, 224, 230));
		lblSm.setBounds(404, 231, 46, 14);
		add(lblSm);
		
		JLabel lblCr = new JLabel("" + CRYSTITE_PRICE);
		lblCr.setFont(new Font("Euphemia", Font.PLAIN, 14));
		lblCr.setBackground(new Color(176, 224, 230));
		lblCr.setBounds(404, 275, 46, 14);
		add(lblCr);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Euphemia", Font.PLAIN, 16));
		lblPrice.setBackground(new Color(176, 224, 230));
		lblPrice.setBounds(404, 100, 46, 29);
		add(lblPrice);
		
		JButton btnDone = new JButton("Done");
		btnDone.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnDone.setBackground(new Color(176, 224, 230));
		btnDone.setBounds(564, 357, 89, 23);
		btnDone.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				commands.clear();
				successDis = 1;
				window4();
			}
			
			
		});
		add(btnDone);
		
		JButton btnCancelAll = new JButton("Cancel All");
		btnCancelAll.setBackground(new Color(176, 224, 230));
		btnCancelAll.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnCancelAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				undoAll();
			}
		});
		btnCancelAll.setBounds(249, 321, 122, 29);
		add(btnCancelAll);
		
		JButton btnCancelLast = new JButton("Cancel Last");
		btnCancelLast.setBackground(new Color(176, 224, 230));
		btnCancelLast.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnCancelLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				undoLastOne();
			}
		});
		btnCancelLast.setBounds(249, 354, 122, 29);
		add(btnCancelLast);
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
		lblTrueFalse.setBackground(new Color(176, 224, 230));
		lblTrueFalse.setFont(new Font("Euphemia", Font.PLAIN, 14));
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
		lblTrueFalse.setBounds(358, 105, 206, 28);
		add(lblTrueFalse);
		
		JLabel lblDoYouNeed = new JLabel("Do you need anything else?");
		lblDoYouNeed.setBackground(new Color(176, 224, 230));
		lblDoYouNeed.setFont(new Font("Euphemia", Font.PLAIN, 14));
		lblDoYouNeed.setBounds(358, 183, 188, 20);
		add(lblDoYouNeed);
		
		JButton btnYes = new JButton("Yes");
		btnYes.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnYes.setBackground(new Color(176, 224, 230));
		btnYes.setBounds(358, 230, 79, 29);
		btnYes.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				window1();
			}
			
		});
		add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.setFont(new Font("Euphemia", Font.PLAIN, 14));
		btnNo.setBackground(new Color(176, 224, 230));
		btnNo.setBounds(447, 230, 79, 29);
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
			Command toundo = commands.remove(commands.size() - 1);
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

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage((new ImageIcon("Image/townb.png")).getImage(), 0,0, 900, 500, null);
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