package bb;
import java.util.ArrayList;
/**
 * @author Josh Gardner//eeub10 
 * @version 1
 * @since 29/11/2018
 * Checks if ball objects are in the same vicinity 
 */
public class BallCollision implements Runnable {
	
	Thread thread;
	ArrayList<Ball> balls;
	double x,y;
	public BallCollision(ArrayList<Ball> b) {
		this.balls = b;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(Ball b1 : balls) {
			
			for(Ball b2 : balls) {
				if(b1.getX()==b2.getX() && b1.getY()==b2.getY()) {
					b1.reverseVel();
					b2.reverseVel();
				}
			}
		}
	}
	
	public void updateList(ArrayList<Ball> b) {
		this.balls = b;
	}
}
