import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test BuyResource method in Player class
 * @author Qian Shao
 *
 */
public class PlayerBuyResourceTest {

	Player player;
	
	@Before
	public void setUp() throws Exception{
		player = new Player("Test", Color.BLUE, "Human", "Beginner");
	}
	
	
	@Test
	public void testBuyResource1() {
		Assert.assertEquals("Food Transition Failed", true, player.buyResource("Food", 100) );
		Assert.assertEquals("Food amount wrong", 9, player.getFood());
		Assert.assertEquals("Money amount wrong", 500, player.getMoney());
		
		Assert.assertEquals("Energy Transition Failed", true, player.buyResource("Energy", 100) );
		Assert.assertEquals("Energy amount wrong", 5, player.getEnergy());
		Assert.assertEquals("Money amount wrong", 400, player.getMoney());
	}
	
	@Test
	public void testBuyResource2() {
		for(int n = 0; n < 6; n++){
			player.buyResource("Food", 100);
		}
		Assert.assertEquals("Food Transition should be false", false, player.buyResource("Food", 100) );
		Assert.assertEquals("Food amount wrong", 14, player.getFood());
		Assert.assertEquals("Money amount wrong", 0, player.getMoney());

	}

}
