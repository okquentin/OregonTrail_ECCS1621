package oregon_trail;

/**
* Store class for Oregon Trail project
* Keeps track of buying while in stores.
* Also calls wagon class to keep track of inventory, food, and money.
*/
/**
* @author Nathan Johnson
* @version MVP
* @since 4/4/2023
*/

public class storeClass {
	
	wagonClass wagon = new wagonClass();
	
	/**
	* When called, outputs a string containing store inventory and prices.
	* Prices increase based on the number of forts passed.
	* @param fortsPassed
	* @return storeInventory
	*/
	public String getStoreInventory (int fortsPassed) {
		double priceModifier = 1 + fortsPassed * .25;
		
		String storeInventory = "[1] Oxen "+Double.toString(40*priceModifier)+"\n"+
								"[2] Food "+Double.toString(.2*priceModifier)+"\n"+
								"[3] Clothing "+Double.toString(10*priceModifier)+"\n"+
								"[4] Ammunition "+Double.toString( 2*priceModifier)+"\n"+
								"[5] Wagon Wheel "+Double.toString(10*priceModifier)+"\n"+
								"[6] Wagon Axle "+Double.toString(10*priceModifier)+"\n"+
								"[7] Wagon Tongue "+Double.toString(10*priceModifier);
		
		return (storeInventory);
	}
	
	/**
	* Takes the item wanted and the number of forts passed to return that item's price.
	* @param itemNumber
	* @param fortsPassed
	* @return itemPricez
	*/
	private double storeItemPrice (int itemNumber, int fortsPassed) {
		double itemPrice = 0;
		double priceModifier = 1 + fortsPassed * .25;
		
		if (itemNumber == 1) {itemPrice = 40 * priceModifier;}
		if (itemNumber == 2) {itemPrice = .2 * priceModifier;}
		if (itemNumber == 3) {itemPrice = 10 * priceModifier;}
		if (itemNumber == 4) {itemPrice = 2 * priceModifier;}
		if (itemNumber == 5) {itemPrice = 10 * priceModifier;}
		if (itemNumber == 6) {itemPrice = 10 * priceModifier;}
		if (itemNumber == 7) {itemPrice = 10 * priceModifier;}
		
		return(itemPrice);
	}
	/**
	* Calls storeItemPrice and adds the amount of that item bought to calculate total money spent.
	* @param itemNumber
	* @param amountBought
	* @param fortsPassed
	* @return moneySpent
	*/
	public double moneySpentPerItem (int itemNumber, int amountBought, int fortsPassed) {
		double itemPrice = storeItemPrice(itemNumber, fortsPassed);
		double moneySpent = itemPrice * amountBought;
		
		wagon.money -= moneySpent;
	
		return(moneySpent);
	}
	
	/**
	* Adds items to the wagon's inventory.
	* Uses a function in the wagon class.
	* @param itemNumber
	* @param amountBought
	*/
	public void addItemsToWagon (int itemNumber, int amountBought) {
		if(itemNumber != 2) {
			wagon.inventoryAdder(itemNumber, amountBought);
		}
		else {
			wagon.food += amountBought;
		}
	}
	
	/**
	* Gets the amount of food.
	* Food is a public integer in the wagon class.
	* @return food
	*/
	public int getFood() {
		return(wagon.food);
	}
	
	/**
	* Gets the amount of money.
	* Money is a public double in the wagon class.
	* @return money
	*/
	public double getMoney() {
		return(wagon.money);
	}
	
	/**
	* When called, gets the player's inventory, including money and food.
	* @return inventory
	*/
	public String getInventory() {
		int amountOfAnItem[];
		amountOfAnItem = new int[8];
		
		for(int i = 1; i <= 7; i++) {
			 for(int j = 0; j < wagon.inventory.size(); j++) {
				 if (wagon.inventory.get(j) == i) {amountOfAnItem[i]++;}
			}
		}
		
		String inventory = amountOfAnItem[1] + " pairs of Oxen" + "\n" +
						   wagon.food + " lb. of Food" + "\n" +
						   amountOfAnItem[3] + " sets of Clothes" + "\n" +
						   amountOfAnItem[4] + " boxes of Ammo" + "\n" +
						   amountOfAnItem[5] + " Wagon Wheels" + "\n" +
						   amountOfAnItem[6] + " Wagon Axles" + "\n" +
						   amountOfAnItem[7] + " Wagon Tongues" + "\n" +
						   wagon.money + " Dollars";
		
		return(inventory);
	}
	
	/**
	* Gets the amount of one item that is in the wagon's inventory.
	* @param item
	* @return numberOfAnItem
	*/
	public int getAmountOfItem(int item) {
		int numberOfAnItem = 0;
		
		for(int i = 0; i < wagon.inventory.size(); i++) {
			if (wagon.inventory.get(i) == item) {numberOfAnItem++;}
		}
			
		return(numberOfAnItem);
	}


}


