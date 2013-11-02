

import java.awt.*;
import java.util.*;

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
	
	public Store(String difficulty, Player p) {
		this.p = p;
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
	}
	/**
	 * 
	 * @param type is the type of food the player bought
	 * @return true if the purchase is successful, false if it failed.
	 */
	public boolean buy(String type) {
		if (type == "Food" && Food>0 && Mule>0) {
			if (p.buyResource("Food", FOODM_PRICE)) {
				Mule-=1;
				Food-=1;
			}
			return true;
		}
		else if (type == "Energy" && Energy>0 && Mule>0) {
			if (p.buyResource("Energy", ENERGYM_PRICE)) {
				Mule-=1;
				Energy-=1;
			}
			return true;
		}
		else if (type == "Smithore" && Smithore > 0 && Mule > 0) {
			if (p.buyResource("Smithore", SMITHOREM_PRICE)) {
				Mule-=1;
				Smithore-=1;
			}
			return true;
		}
		else if (type == "Crystite" && Crystite > 0 && Mule > 0) {
			
			if (p.buyResource("Crystite", CRYSTITEM_PRICE)) {
				Mule-=1;
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
}