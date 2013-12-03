package enforcedMULE.GUIModel;

public class StoreModel {

	private static final int FOOD_PRICE = 30, ENERGY_PRICE = 25;
	private static final int SMITHORE_PRICE = 50, CRYSTITE_PRICE = 100;
	private static final int MULE_PRICE = 100;
	private static final int FOODM_PRICE = 25, ENERGYM_PRICE = 50+MULE_PRICE;
	private static final int SMITHOREM_PRICE = 75+MULE_PRICE;
	private static final int CRYSTITEM_PRICE = 100+MULE_PRICE;
	
	private static int Food, Energy, Smithore, Crystite, Mule;
	private StoreModel() {
		
	}
	
	public void setUpStore(String difficulty) {
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
}
