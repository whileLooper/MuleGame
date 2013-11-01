

import java.awt.*;
import java.util.*;

import javax.swing.JPanel;

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
	
	private int food, energy, smithore, crystite, mule; 
	/**
	 * Constructor for Store Class
	 */
	
	public Store(String difficulty, Player p) {
		this.p = p;
		if (difficulty == "Beginner") {
			food = 16;
			energy = 16;
			smithore = 0;
			crystite = 0;
			mule = 25;
		}
		else {
			food = 0;
			energy = 0;
			smithore = 8;
			crystite = 0;
			mule = 14;
		}
	}
		
	public boolean buy(String type) {
		if (type == "food" && food>0 && mule>0) {
			if (p.buyResource("food", FOODM_PRICE)) {
				mule-=1;
				food-=1;
			}
			return true;
		}
		else if (type == "energy" && energy>0 && mule>0) {
			if (p.buyResource("energy", ENERGYM_PRICE)) {
				mule-=1;
				energy-=1;
			}
			return true;
		}
		else if (type == "smithore" && smithore > 0 && mule > 0) {
			if (p.buyResource("smithore", SMITHOREM_PRICE)) {
				mule-=1;
				smithore-=1;
			}
			return true;
		}
		else if (type == "crystite" && crystite > 0 && mule > 0) {
			
			if (p.buyResource("crystite", CRYSTITEM_PRICE)) {
				mule-=1;
				crystite-=1;
			}
			return true;
		}
		return false;
	}
	
	public void sell(String type) {
		if (type == "food" && p.sellResource("food")) {
			food+=1;
		}
		else if (type == "energy" && p.sellResource("energy")) {
			energy+=1;
		}
		else if (type == "smithore" && p.sellResource("smithore")) {
			smithore+=1;
			mule+=1;
		}
		else if (type == "crystite" && p.sellResource("crystite")) {
			crystite+=1;
		}
	}
	
	public int getFoodPrice() {
		return FOOD_PRICE;
	}
	
	public int getEnergyPrice() {
		return ENERGY_PRICE;
	}
	
	public int getSmithorePrice() {
		return SMITHORE_PRICE;
	}
	
	public int getCrystitePrice() {
		return CRYSTITE_PRICE;
	}
	
	public int getFoodMulePrice() {
		return FOODM_PRICE;
	}
	
	public int getEnergyMulePrice() {
		return ENERGYM_PRICE;
	}
	public int getSmithoreMulePrice() {
		return SMITHOREM_PRICE;
	}
	public int getCrystieMulePrice() {
		return CRYSTITEM_PRICE; 
	}
}