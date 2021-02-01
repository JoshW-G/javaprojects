package bingo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;



public class Ball implements Serializable {
	
	/**Creates a ball object
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xCentre;
	private int yCentre;
	private int radius;
	private int value;
	
	public Ball(int val) {
		xCentre = 100;
		yCentre = 100;
		radius = 50;
		value  = val;
		
	}
	
	public void draw(Graphics2D g2) {
		Ellipse2D.Double ball = new Ellipse2D.Double(xCentre-radius, yCentre-radius, radius*2, radius*2);
		g2.setColor(Color.red);
		g2.draw(ball);
		g2.setColor(Color.BLACK);
		g2.drawString(" " + value + " ", xCentre-7, yCentre+5);
	}
}
