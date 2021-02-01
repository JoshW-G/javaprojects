package bb;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;


/**
 * @author Josh Gardner//eeub10 
 * @version 1
 * @since 29/11/2018
 * Extends JPanel
 * Provides methods to draw and store Ball objects
 *
 */
public class BallPanel extends JPanel {
	
	
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	/**
	 * @param new Ball object
	 * adds Ball object to balls ArrayList 
	 */
	public void addBall(Ball b) {
		
		balls.add(b);
	}
	/**
	 * paints each Ball object in balls
	 */
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;		
		for(Ball b : balls) {
			
			g2.fill(b.getShape());
			//gets unique rgb color from ball objects
			Color randomColor = new Color(b.getRed(), b.getGreen(), b.getBlue());
	        g2.setColor(randomColor);		
	        }
	}
	/**
	 * 
	 * @return ball ArrayList
	 */
	public ArrayList<Ball> getList(){
		return balls;
	}

}
