package race;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
/**
 * runs the gui for the cars
 * @author eeub10
 *
 */
public class CarViewer {
	
	

	

	public static void main(String[] args) {
		
		final int FRAME_WIDTH = 400;
		final int FRAME_HEIGHT = 400;
		JFrame frame = new JFrame();
		//frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.getContentPane().setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		frame.setTitle("Car Viewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		GridLayout grid = new GridLayout(3,0);
		frame.setLayout(grid);
		
		
		CarComponent car1 = new CarComponent(0,10, "car 1");
		CarComponent car2 = new CarComponent(0,10, "car 2");
		CarComponent car3 = new CarComponent(0,10, "car 2");
		Thread thread1 = new Thread(car1);
		Thread thread2 = new Thread(car2);
		Thread thread3 = new Thread(car3);
		thread1.start();
		thread2.start();
		thread3.start();
		
		frame.add(car1,1,0);
		frame.add(car2, 2,0);
		frame.add(car3, 3,0);
		
		frame.setVisible(true);
		frame.pack();
	}
}
