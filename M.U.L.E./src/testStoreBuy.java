import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class testStoreBuy {

	Store newStore;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("**********************************************");
		System.out.println("       Store Buy method test begins...");
		System.out.println("**********************************************");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("**********************************************");
		System.out.println("    Junit Test is completed successfully...");
		System.out.println("**********************************************");
	}



	@Before
	public void setUp() throws Exception {
		newStore = new Store("Beginner", new Town(new Game(new Drive())));
		newStore.playerEnterStore(new Player("Chong", Color.GREEN, 
				"Human", "Beginner"));
	}

	@Test
	public void testBuy1() {
		assertTrue(newStore.buy("Food"));
		assertTrue(newStore.buy("Energy"));
		assertTrue(newStore.buy("Smithore"));
		assertTrue(newStore.buy("Crystite"));		
	}
	
	@Test
	public void testBuy2(){
		
		newStore.Restore(0, 0, 0, 0, 0);
		assertFalse(newStore.buy("Food"));
		assertFalse(newStore.buy("Energy"));
		assertFalse(newStore.buy("Smithore"));
		assertFalse(newStore.buy("Crystite"));
	}

}
