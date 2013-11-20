import java.util.Random;

/**
 * Pub.java
 * Version 85. Copyright One-E
 * @author One-E
 */

public class Pub {

	/**
	 * This is a static method used to calculate the money bonus player earns through gambling
	 * @param round is the current number of round
	 * @param time is the time player left
	 * @return the final bonus calculated
	 */
	public static int PubGambling(int round, int time){
		int rB = 0;
		int tB = 0;
		switch(round){
		case 1: rB = 50; break;
		case 2: rB = 50; break;
		case 3: rB = 50; break;
		case 4: rB = 100; break;
		case 5: rB = 100; break;
		case 6: rB = 100; break;
		case 7: rB = 100; break; 
		case 8: rB = 150; break;
		case 9: rB = 150; break;
		case 10: rB = 150; break;
		case 11: rB = 150; break;
		case 12: rB = 200; break;
		default:
		}
		Random rand = new Random();
		if(time < 50 && time >= 37) tB = rand.nextInt(200);
		else if(time < 37 && time >= 25) tB = rand.nextInt(150);
		else if(time < 25 && time >= 12) tB = rand.nextInt(100);
		else if(time < 12 && time >= 0) tB = rand.nextInt(50);
		int result = rB + tB;
		if(result > 250) return 250;
		return result;
	}
}
