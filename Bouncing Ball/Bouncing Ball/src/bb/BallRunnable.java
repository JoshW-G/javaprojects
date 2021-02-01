package bb;
import java.util.ArrayList;

/**
 * @author Josh Gardner//eeub10 
 * @version 1
 * @since 29/11/2018
 * Creates a Runnable to update ball objects positions through calling move method
 *
 */
public class BallRunnable implements Runnable {

	private BallPanel panel;
	private Ball b;
	private Thread thread;
	
	/**
	 * 
	 * @param b Ball object
	 * @param panel JPanel 
	 */
	public BallRunnable(Ball b, BallPanel panel) {
		this.b = b;
		this.panel = panel;
		thread = new Thread(this);
		thread.start();
	}
	/**
	 * infinitely loops calling ball objects move method & repaints
	 */
	@Override
	public void run(){
		for(;;) {
		b.move();
		panel.paint(panel.getGraphics());
		try {
			thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
}
