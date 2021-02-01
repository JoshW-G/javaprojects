package checkout;

/**
 * 
 * @author Josh Gardner // eeub10
 *
 */
public class Customer {
	
	private int items;
	
	/**
	 * 
	 * @param items passes number of items the customer object will store
	 */
	public Customer(int items) {
		
		this.items = items;
		
	}
	
	/**
	 * 
	 * @return items of the customer
	 */
	public int getItems() {
		
		return items;
	}
	
	/**
	 * decrements items the customer stores
	 */
	public void removeItem() {
		
		items--;
	}
	
}
