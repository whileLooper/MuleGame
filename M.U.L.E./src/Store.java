

import java.awt.*;
import java.util.*;

public class Store {
	/**
	 * This is the Store Class
	 */
	
	private final int FOOD_PRICE = 30, ENERGY_PRICE = 25;
	private final int SMITHORE_PRICE = 50, CRYSTITE_PRICE = 100;
	private final int MULE_PRICE = 100;
	private final int FOODM_PRICE = 25, ENERGYM_PRICE = 50+MULE_PRICE;
	private final int SMITHOREM_PRICE = 75+MULE_PRICE;
	private final int CRYSTITEM_PRICE = 100+MULE_PRICE;
	
	private int food, energy, smithore, crystite, mule; 
	/**
	 * Constructor for Store Class
	 */
	
	public Store() {
		if (Game.getDifficulty() == "Beginner") {
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
	
	public static boolean checkSufficient(Player p, int n) {
		if (p.getMoney() > n) {
			return true;
		}
		return false;
	}
	
	public static void deductFunds(Player p, int n) {
		p.deductMoney(-n);
	}
	
	public int buy(String type, Player p) {
		if (type == "foodM" && p.getMoney() > FOODM_PRICE && food>0 && mule>0 && p.getMule() == 0) {
			p.addFood();
			p.addMule();
			p.deductMoney(FOODM_PRICE);
			mule-=1;
			food-=1;
		}
		else if (type == "energym" && p.getMoney() > ENERGYM_PRICE && energy>0 && mule>0 && p.getMule() == 0) {
			p.addEnergy();
			p.addMule();
			p.deductMoney(ENERGYM_PRICE);
			mule-=1;
			energy-=1;
		}
		else if (type == "smithorem" && p.getMoney() > SMITHOREM_PRICE && smithore > 0 && mule > 0 && p.getMule() == 0) {
			p.addSmithore();
			p.addMule();
			p.deductMoney(SMITHOREM_PRICE);
			mule-=1;
			smithore-=1;
		}
		else if (type == "crystitem" && p.getMoney() > CRYSTITEM_PRICE && crystite > 0 && mule > 0 && p.getMule() == 0) {
			p.addCrystite();
			p.addMule();
			p.deductMoney(CRYSTITEM_PRICE);
			mule0=1;
			crystite-=1;
		}
		return p.getMoney();
	}
	
	public int sell(String type, Player p) {
		if (type == "food" && p.getFood() > 0) {
			p.deductFood();
			p.addMoney(FOOD_PRICE);
			food+=1;
		}
		else if (type == "energy" && p.getEnergy() > 0) {
			p.deductEnergy();
			p.addMoney(ENERGY_PRICE);
			energy+=1;
		}
		else if (type == "smithore" && p.getSmithore() > 0) {
			p.deductSmithore();
			p.addMoney(SMITHORE_PRICE);
			smithore+=1;
			mule+=1;
		}
		else if (type == "crystite" && p.getCrystite() > 0) {
			p.deductCrystite();
			p.addMoney(CRYSTITE_PRICE);
			crystite+=1;
		}
		return p.getMoney();
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
	
	
}