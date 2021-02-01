package checkout;

/**
 * 
 * @author Josh Gardner // eeub10
 *
 */
public class CheckoutRunnable implements Runnable {
	
	private CheckoutQueue queue;
	private Customer c;
	
	/**
	 * 
	 * @param q passes CheckoutQueue object to be interacted with
	 */
	public CheckoutRunnable(CheckoutQueue q) {
		this.queue = q;
		
	}
	
	
	@Override
	public void run() {
		
		for(;;) {
			if(queue.getSize()>0){
			
				c = queue.getCustomer(); //gets customer from front of the queue
				
				while(c.getItems()!=0) { 
					try {
						Thread.sleep((int) (200 + (Math.random()*400)));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					c.removeItem();
					queue.removeItem();
				}
				queue.removeCustomer();
				System.out.println("\nCustomer done in:" + queue.getQueueID() + "\nRemaining Customers: " + queue.getSize());
				
				//after all items are checked the next customer is got
			}
			else{ //if the queue is empty the thread is made to sleep for 2 seconds
				System.out.println("\nNo Customers in Checkout "+ queue.getQueueID());
				try {
					
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
