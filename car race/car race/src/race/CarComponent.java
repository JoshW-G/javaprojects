package race;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JComponent;
/**
 * draws the car and implements a runnable to move it
 * @author eeub10
 *
 */
public class CarComponent extends JComponent implements Runnable {
	
	private Car myCar;
	private String name;
	private int delay;
	public CarComponent(int x, int y, String name) {
		
		myCar = new Car(x,y);
		this.name = name;
		delay =  (int) (25 + (Math.random()*50)) ;
	}
	
	public void paintComponent(Graphics g) {
		myCar.draw((Graphics2D) g);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int distance = 200;
		int count = 0;
		while(count < distance) {
			count++;
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myCar.move();
			repaint();
		}
		System.out.println(name + " Finished");
	}
}
