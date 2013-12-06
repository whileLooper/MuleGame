import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BuyMuleTest {
	static Player p;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p=new Player("Y",Color.RED,"Human", "Beginner");
		System.out.println("Player has "+p.getMoney());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOne() {
		p.addMoney(-600);
		System.out.println("Player has "+p.getMoney());
		assertFalse(p.buyMule("Food Mule", 500));
		assertEquals(0,p.getMoney());
		assertEquals(null,p.getMule());
	}
	
	@Test
	public void testTwo() {
		p.addMoney(600);
		System.out.println("Player has "+p.getMoney());
		assertTrue(p.buyMule("Food Mule", 500));
		assertEquals(100, p.getMoney());	
	}
	
	@Test
	public void testThree() {
		p.addMoney(600);
		System.out.println("Player has "+p.getMoney());
		assertFalse(p.buyMule("Energy Mule", 500));
		assertEquals(700, p.getMoney());	
	}
	

}
