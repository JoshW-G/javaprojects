package bb;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * @author Josh Gardner//eeub10 
 * @version 1
 * @since 29/11/2018
 * Provides methods to draw and move a circle 
 */

public class Ball{
	
	private static final int XSIZE = 20;
	private static final int YSIZE = 20;
	
	private double x = 250;
	private double y = 250;
	private double yVel;
	private double xVel;
	private Rectangle bounds;
	Random randomGenerator = new Random();
    int red = randomGenerator.nextInt(256);
    int green = randomGenerator.nextInt(256);
    int blue = randomGenerator.nextInt(256);
	Graphics2D g2;
	int speed;
	private double oldXVel;
	private double oldYVel;
	
	/**
	 * @param JPanel boundaries set as Rectangle bounds
	 * Constructor method
	 */
	public Ball(Rectangle bounds,int s) {
		this.speed = s;
		xVel = getRandomSpeed()*getRandomDirection();
		yVel= getRandomSpeed()*getRandomDirection();
		this.bounds = bounds;
		
	}
	
	/**
	 * move method increments x & y values by xVel & yVel
	 * Checks if coords hit the boundaries of the JPanel
	 */
	public void move() {
		x += xVel;
		y += yVel;
		if(x < bounds.getMinX()) {
			x = bounds.getMinX();
			xVel = -xVel;
		}
		if(y <  bounds.getMinY()) {
			y = bounds.getMinY();
			yVel = -yVel;
			
		}
		if(x + XSIZE > bounds.getMaxX()) {
			x = bounds.getMaxX() - XSIZE;
			xVel = -xVel;
		}
		if(y + YSIZE > bounds.getMaxY()) {
			y = bounds.getMaxY() - YSIZE;
			yVel = -yVel;
		}
		
	}
	
	/**
	 * 
	 * @return integer 1 or -1
	 */
	public int getRandomDirection(){
		int rand = (int)(Math.random()*2);
		if(rand==1)
			return 1;
		else 
			return -1;
	}
	/**
	 * 
	 * @return  random integer 
	 */
	public double getRandomSpeed(){
		return(Math.random()* speed + 2);
	}
	/**
	 * 
	 * @return Ellipse2D shape object
	 */
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
	}
	/**
	 * 
	 * @return x coords
	 */
	public double getX() {
		return x;
	}
	/**
	 * 
	 * @return y coords
	 */
	public double getY() {
		return y;
	}
	/**
	 * inverses xVel & yVel
	 */
	public void reverseVel() {
		xVel = -xVel;
		yVel = -yVel;
	}
	/**
	 * 
	 * @return random rgb code for red unique to each ball instantiation
	 */
	public int getRed() {
		return red;
	}
	/**
	 * 
	 * @return random rgb code for green unique to each ball instantiation 
	 */
	public int getGreen() {
		return green;
	}
	/**
	 * 
	 * @return random rgb code for blue unique to each ball instantiation 
	 */
	public int getBlue() {
		return blue;
	}
	/**
	 * stops balls moving
	 */
	public void stop() {
		oldXVel = xVel;
		oldYVel = yVel;
		xVel=0;
		yVel=0;
	}
	/**
	 * resets speed
	 */
	public void start() {
		xVel=oldXVel;
		yVel=oldYVel;
	}

}
