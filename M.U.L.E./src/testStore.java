import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import org.junit.Test;

public class testStore {
	Tile t = new Tile(null, 1, 1, 1, 1, new Point(1, 1));
	Player p = new Player("Y",Color.RED,"Human", "Beginner");
	
	@Test(timeout = 300)
	/**
	 * Land belongs to someone else, money is enough, false.
	 */
	public void testBuy0() {
		t.bought = true;
		p.addMoney(300);
		assertFalse(p.buyLand(100, t));
		assertEquals(900,p.getMoney());
		assertEquals(t.owner,null);
	}
	
	@Test(timeout = 300)
	/**
	 * Land belongs to someone else, money not enough, false.
	 */
	public void testBuy1() {
		t.bought = true;
		p.addMoney(1);
		assertFalse(p.buyLand(300, t));
		assertEquals(601,p.getMoney());
		assertEquals(t.owner,null);
	}
	
	@Test(timeout = 300)
	/**
	 * Land does not belong to anyone, money enough, true.
	 */
	public void testBuy2() {
		t.bought = false;
		p.addMoney(1000);
		assertTrue(p.buyLand(100, t));
		assertEquals(p, t.owner);
		assertEquals(1500, p.getMoney());
	}
	
	@Test(timeout = 300)
	/**
	 * Land does not belong to anyone, money not enough, false.
	 */
	public void testBuy3() {
		t.bought = false;
		p.addMoney(1);
		assertFalse(p.buyLand(100, t));
		assertEquals(null, t.owner);
		assertEquals(1500, p.getMoney());
	}
	
}
