

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
 * Author: One-E
 * Last update: 1/11/2013
 * Store class that is in-charge of everything that is related to store.
 */
public class Store extends JPanel {
	/**
	 * This is the Store Class
	 */
	
	private final int FOOD_PRICE = 30, ENERGY_PRICE = 25;
	private final int SMITHORE_PRICE = 50, CRYSTITE_PRICE = 100;
	private final int MULE_PRICE = 100;
	private final int FOODM_PRICE = 25, ENERGYM_PRICE = 50+MULE_PRICE;
	private final int SMITHOREM_PRICE = 75+MULE_PRICE;
	private final int CRYSTITEM_PRICE = 100+MULE_PRICE;
	private Player p;
	
	private int Food, Energy, Smithore, Crystite, Mule; 
	/**
	 * Constructor for Store Class
	 */
	
	public Store(String difficulty) {
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
		//window1();
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
				buy("Food");
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(272, 54, 41, 23);
		add(btnNewButton_1);
		
		JButton button_1 = new JButton("+");
		button_1.setBounds(232, 97, 41, 23);
		add(button_1);
		
		JButton button_2 = new JButton("-");
		button_2.setBounds(272, 97, 41, 23);
		add(button_2);
		
		JButton button_3 = new JButton("+");
		button_3.setBounds(232, 145, 41, 23);
		add(button_3);
		
		JButton button_4 = new JButton("-");
		button_4.setBounds(272, 145, 41, 23);
		add(button_4);
		
		JButton button_5 = new JButton("+");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_5.setBounds(232, 189, 41, 23);
		add(button_5);
		
		JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.setBounds(272, 189, 41, 23);
		add(btnNewButton_2);
		
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
		validate();
		repaint();
	}
	private void window1() {
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
	}
	private void window2(){
		removeAll();
		setLayout(null);
		
		JButton btnFoodMule = new JButton("Food Mule");
		btnFoodMule.setBounds(157, 52, 119, 23);
		add(btnFoodMule);
		
		JButton btnEne = new JButton("Energy Mule");
		btnEne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEne.setBounds(157, 101, 119, 23);
		add(btnEne);
		
		JButton btnOreMule = new JButton("Smithore Mule");
		btnOreMule.setBounds(157, 153, 119, 23);
		add(btnOreMule);
		
		JButton btnNewButton = new JButton("Crystite Mule");
		btnNewButton.setBounds(157, 208, 119, 23);
		add(btnNewButton);
		validate();
		repaint();

	}
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
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(272, 54, 41, 23);
		add(btnNewButton_1);
		
		JButton button_1 = new JButton("+");
		button_1.setBounds(232, 97, 41, 23);
		add(button_1);
		
		JButton button_2 = new JButton("-");
		button_2.setBounds(272, 97, 41, 23);
		add(button_2);
		
		JButton button_3 = new JButton("+");
		button_3.setBounds(232, 145, 41, 23);
		add(button_3);
		
		JButton button_4 = new JButton("-");
		button_4.setBounds(272, 145, 41, 23);
		add(button_4);
		
		JButton button_5 = new JButton("+");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_5.setBounds(232, 189, 41, 23);
		add(button_5);
		
		JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.setBounds(272, 189, 41, 23);
		add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(167, 58, 46, 14);
		add(lblNewLabel);
		validate();
		repaint();
	}
	/**
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
		return false;
	}
	
	/**
	 * @param type the type of resource the player is selling.
	 */
	public void sell(String type) {
		if (type == "Food" && p.sellResource("Food")) {
			Food+=1;
		}
		else if (type == "Energy" && p.sellResource("Energy")) {
			Energy+=1;
		}
		else if (type == "Smithore" && p.sellResource("Smithore")) {
			Smithore+=1;
			Mule+=1;
		}
		else if (type == "Crystite" && p.sellResource("Crystite")) {
			Crystite+=1;
		}
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
	
	public int getEnergy() {
		return Energy;
	}
	
	public int getCrystite() {
		return Crystite;
	}
	
	public int getSmithore() {
		return Smithore;
	}
	
	public int getMule() {
		return Mule;
	}
	
	public void buyMule() {
		Mule-=1;
	}
	
	public void playerEnterTown(Player p) {
		this.p = p;
	}
}