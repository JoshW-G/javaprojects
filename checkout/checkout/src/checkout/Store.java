package checkout;

/**
 * 
 * @author Josh Gardner // eeub10
 *
 */
public class Store {
	
	private CheckoutQueue c1, c2, c3;
	private CheckoutRunnable r1 ,r2, r3;
	private Thread t1,t2,t3;
	
	public Store() {
		c1 = new CheckoutQueue(1);
		c2 = new CheckoutQueue(2);
		c3 = new CheckoutQueue(3);
		r1 = new CheckoutRunnable(c1);
		r2 = new CheckoutRunnable(c2);
		r3 = new CheckoutRunnable(c3);
		t1 = new Thread(r1);
		t2 = new Thread(r2);
		t3 = new Thread(r3);
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	/**
	 * 
	 * @param cust passes Customer object
	 * calculates which CheckoutQueue has the least amount of items to add the new customer to
	 */
	private void addToQueue(Customer cust) {
		
		
		if (c1.getTotalItems() <= c2.getTotalItems() && c1.getTotalItems() <= c3.getTotalItems()) {
		    System.out.println("Customer added to checkout 1");
		    c1.add(cust);
		    
		} else if(c2.getTotalItems() <= c3.getTotalItems() && c2.getTotalItems() <= c1.getTotalItems()) {
		    System.out.println("Customer added to Checkout 2");
		    c2.add(cust);
		    
		} else {
		     System.out.println("Customer added to Checkout 3");
		     
		     c3.add(cust);
		   
		}
		System.out.println("Checkout 1: "+ c1.getSize() +  " Customers");
		System.out.println("Checkout 2: "+ c2.getSize() +  " Customers");
		System.out.println("Checkout 3: "+ c3.getSize() +  " Customers");
	}
	
	/**
	 * creates a new Customer to add to the queue with a specified no. items
	 * @param items 
	 */
	public void addCust(int items) {
		System.out.println("\nNew Customer items:" + items);
		Customer c = new Customer(items);
		addToQueue(c);
		
		
	}
	
	/**
	 * creates a new customer to add to the queue with a random number of items between 1-30
	 */
	public void addCust() {
		int items = (int) (1 + (Math.random()*30));
		System.out.println("\nNew Customer items:"+items);
		Customer c = new Customer(items);
		addToQueue(c);
	}
	
	
	
}
