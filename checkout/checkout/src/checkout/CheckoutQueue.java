package checkout;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 
 * @author Josh Gardner // eeub10
 *
 */
public class CheckoutQueue{
	
	private Queue<Customer> checkout = new LinkedList<>();
	private int aisleID;
	private int totalItems; 
	
	/**
	 * 
	 * @param number passes the ID of the queue
	 */
	public CheckoutQueue(int number) {
		aisleID = number;
		totalItems = 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getQueueID() {
		return aisleID;
	}
	
	/**
	 * 
	 * @param obj passes Customer to be added to the Queue
	 * updates totalItems 
	 */
	public void add(Customer obj) {
		checkout.add(obj);
		totalItems += obj.getItems();
	}
	
	
	/**
	 * 
	 * @return First Customer object in the Queue
	 */
	public Customer getCustomer() {
		return checkout.peek();
	}
	
	/**
	 * Removes first Customer in the Queue
	 */
	public void removeCustomer() {
		checkout.remove();
	}
	
	/**
	 * 
	 * @return the number of elements in the Queue
	 */
	public int getSize() {
		return checkout.size();
		
	}
	
	/**
	 * 
	 * @return total items in the queue
	 */
	public int getTotalItems() {
		return totalItems;
	}

	public void removeItem() {
		totalItems--;
		
	}
	
	

	
}