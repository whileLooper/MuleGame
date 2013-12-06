import java.util.Random;

import javax.swing.ImageIcon;


public class RandomEvent {
	/**
	 * 
 	 * @param round the current round the game is at
 	 * @param p the player that is going to get a randomEvent
 	 * @param currentPlayer the player's rank
 	 * Random an int from 1 to 100, 27% chance of event occuring.
 	 * If any event occur, 1/7 chance for any event to occur.
 	 * @return p the new player with new stats.
	 */
	public static Player randomEvent(int round, Player p, int currentPlayer) {
		round+=1;
		System.out.println("randomEvent method");
		boolean event;
		int factor;
		
		switch (round) {
		case 1: factor = 25; break;
		case 2: factor = 25; break;
		case 3: factor = 25; break;
		case 4: factor = 50; break;
		case 5: factor = 50; break;
		case 6: factor = 50; break;
		case 7: factor = 50; break;
		case 8: factor = 75; break;
		case 9: factor = 75; break;
		case 10: factor = 75; break;
		case 11: factor = 75; break;
		case 12: factor = 100; break;
		default: factor = 0;
		}
		String[] events = {"YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.",
				"A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.",
				"THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $ " + 8*factor + ".",
				"YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $ " +2*factor+".",
				"FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $ "+ 4*factor+".",
				"MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.",
				"YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $ "+6*factor+" TO CLEAN IT UP."
		};
		Random gen = new Random();
		int rand = gen.nextInt(100);
		System.out.println("The random number is: " + rand);
		if (rand >= 0 && rand <= 27) {
			
			event = true;
			System.out.println("Event true" + rand);
		}
		else {
			event = false;
			System.out.println("Event false");
		}
		if (event) {
			int eventSelection;
			if(currentPlayer == 0){
				eventSelection = gen.nextInt(4)+1;
			}else{
				eventSelection = gen.nextInt(7)+1;
			}
			//System.out.println(events[eventSelection]);
			System.out.println("eventSelection: " + eventSelection);
			if (eventSelection == 1) {
				p.addFood(3);
				p.addEnergy(2);
			}
			else if (eventSelection == 2) {
				p.addOre(2);
			}
			else if (eventSelection == 3) {
				p.addMoney(8*factor);
			}
			else if (eventSelection == 4) {
				p.addMoney(2*factor);
			}
			
			else if (eventSelection >= 5 && eventSelection <= 7){
				if (eventSelection == 5) {
					p.deduceMoney(4*factor);
				}
				else if (eventSelection == 6) {
					p.deductFood(p.getFood()/2);
				}
				else if (eventSelection == 7) {
					p.deduceMoney(6*factor);
				}
			}
			
		}
		return p;
	}
	
	public static void randomWorldEvent(Player[] p) {
		String[] events = {"SPACE PIRATES ARRIVED IN TOWN. EVERYONE LOSES 20% OF THEIR MONEY.",
				"SANTA CLAUS IS HERE AND GIVES EVERYONE 3 FOOD AND 200 MONEY.",
				"SNOW IS COMING. ENERGY DECREASES BY 50% FOR EVERYONE.",
				"FREE PIZZA BY PAPA HUTMINO PIZZA SHOP. EVERYONE GAIN 2 FOOD AND 3 ENERGY.",
				"DIVIDENDS BY THE TOWN. EVERYONE GAINS 500 MONEY."};
		
		Random gen = new Random();
		int rand = gen.nextInt(100);
		if (rand >= 0 && rand <= 10) {
			System.out.println("world random event");
			int rand2 = gen.nextInt(5)+1;
			if (rand2 == 1) {
				System.out.println(events[0]);
				for (int i = 0; i < p.length; i++) {
					p[i].deduceMoney((int)(p[i].getMoney()*0.2));
				}
			}
			else if (rand2 == 2) {
				System.out.println(events[1]);
				for (int i = 0; i < p.length; i++) {
					p[i].addMoney(200);
					p[i].addFood(3);
				}
			}
			else if (rand2 == 3) {
				System.out.println(events[2]);
				for (int i = 0; i < p.length; i++) {
					p[i].deductEnergy((int)(p[i].getEnergy()*0.5));
				}
			}
			else if (rand2 == 4) {
				System.out.println(events[3]);
				for (int i = 0; i < p.length; i++) {
					p[i].addFood(2);
					p[i].addEnergy(3);
				}
			}
			else if (rand2 == 5) {
				System.out.println(events[4]);
				for (int i = 0; i < p.length; i++) {
					p[i].addMoney(500);
				}
			}
			else {System.out.println("THIS SHOULD NOT APPEAR. ERROR.");}
		}
	}
	
	public static void randomCrystal(Map m) {
		Tile[][] p = m.getMap();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if (p[i][j].getType() == "Mountains") {
					int rand = new Random().nextInt(100);
					if (rand >= 1 && rand <= 3) {
						p[i][j].setCrystite(true);
						//m.repaint();
						//System.out.println("setCrystite");
					}
				}
				if(p[i][j].getType() == "River") {
					int rand = new Random().nextInt(100);
					if (rand >= 1 && rand <= 10) {
						p[i][j].setFish(true);
						//m.repaint();
						//System.out.println("setFish");
					}
				}
			}
		}
	}
}
