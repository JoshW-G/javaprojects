package race;

import java.awt.Graphics2D;
/**
 * creates a car model & implements a move method
 * 
 */
public class Car {
	private int xLeft;
	private int yTop;
	
	public Car(int x, int y) {
		this.yTop = y;
		this.xLeft = x;
	}
	
	public void draw(Graphics2D g2) {
		//g2.fill(Color.BLUE);
		g2.drawRect(xLeft, yTop, 30, 10); //roof of car
		g2.drawLine(xLeft+30, yTop, xLeft + 35, yTop + 10); // windscreen
		g2.drawRect(xLeft, yTop+10, 60, 10);//body of car
		g2.drawOval(xLeft+5, yTop+20, 10, 10); //back wheel
		g2.drawOval(xLeft+45, yTop+20, 10, 10); //front wheel
		
	}

	public void move() {
		// TODO Auto-generated method stub
		
		xLeft+=1;
	}
}
