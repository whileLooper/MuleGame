import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class testSellResource {

	static Player newPlayer;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("**********************************************");
		System.out.println("  Player sell resource method test begins...");
		System.out.println("**********************************************");

		newPlayer = new Player("BoChen", Color.GREEN, 
				"Human", "Beginner");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("**********************************************");
		System.out.println("    Junit Test is completed successfully...");
		System.out.println("**********************************************");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * test the player class initialization first
	 */
	@Test
	public void testInitiate() {
		assertEquals("Human", newPlayer.getRace());
		assertEquals(Color.GREEN, newPlayer.getColor());
		assertEquals("BoChen", newPlayer.getName());
		assertEquals(600, newPlayer.getMoney());
		System.out.println("testInitiate Done...");
	}
	
	/**
	 * test sell food with enough resource
	 */
	@Test
	public void testSellResource1(){
		assertTrue(newPlayer.sellResource("Food", 300));
		assertTrue(newPlayer.sellResource("Energy", 2000000000));
		assertTrue(newPlayer.sellResource("Smithore",  Integer.MAX_VALUE));
		assertTrue(newPlayer.sellResource("Food", Integer.MIN_VALUE));	
		System.out.println("testSellResource1 Done...");
	}

	/**
	 * test sell food with no enough resource
	 */
	@Test
	public void testSellResource2(){
		newPlayer.addFood(Integer.MIN_VALUE);
		newPlayer.addEnergy(Integer.MIN_VALUE);
		assertFalse(newPlayer.sellResource("Food", 200));
		assertFalse(newPlayer.sellResource("Energy", 2000000000));
		assertFalse(newPlayer.sellResource("Food",  Integer.MAX_VALUE));
		assertFalse(newPlayer.sellResource("Food", Integer.MIN_VALUE));	
		System.out.println("testSellResource2 Done...");		
	}
	
	/**
	 * test after seel resource, if the player have right amount money
	 */
	@Test
	public void testRightAmount(){
		int balance = newPlayer.getMoney();
		newPlayer.sellResource("Energy", 300);
		assertEquals(balance + 300, newPlayer.getMoney());
		
		balance = newPlayer.getMoney();
		newPlayer.sellResource("Energy", 1);		
		assertEquals(balance + 1, newPlayer.getMoney());
		
		balance = newPlayer.getMoney();
		newPlayer.sellResource("Food", Integer.MAX_VALUE);
		assertEquals(balance + (Integer.MAX_VALUE), newPlayer.getMoney());
		
		balance = newPlayer.getMoney();
		newPlayer.sellResource("Energy", -100);
		assertEquals(balance + (-100), newPlayer.getMoney());
		System.out.println("testRightAmount Done...");
	}
}
