package bingo;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
/**
 * Draws the ball object and repaints it when a new one is set
 * @author eeub10
 *
 */
public class BallComponent extends JComponent {

	private Ball ball;
	public BallComponent() {
		
	}
	
	public void setBall(Ball ball) {
		this.ball = ball;
		repaint();
	}
	public void paintComponent(Graphics g) {
		if(ball == null) {
			
		}
		else {
			
		
		ball.draw((Graphics2D) g);
		}
	}
}
