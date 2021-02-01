package bb;
import java.awt.EventQueue;

import javax.swing.JFrame;
 
/**
 * @author Josh Gardner//eeub10 
 * @version 1
 * @since 29/11/2018
 * Instantiates BallFrame 
 */
public class BallViewer {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
			JFrame frame = new BallFrame();
	    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		frame.setVisible(true);
	    		frame.pack();
			}
		});
	}
}
