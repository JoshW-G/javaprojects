package dicegame;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.RoundRectangle2D.Double;

import javax.swing.JComponent;

public class DiceComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	// Positioning of dots of the dice.
	private Ellipse2D.Double[] dots = new Ellipse2D.Double[7]; //Deals with the dots on the dice.

	private Double box;
	private int xLeft;
	private int yTop;
	private int side;
	private int diceValue;
	private int colour;

	// Dice attributes
	/**
	 * @param s, side of dice
	 * @param x, x position of dice
	 * @param y, y position of dice
	 * @param v, dot value of dice
	 * @param c, colour of dice
	 */
	public DiceComponent(int s, int x, int y, int v, int c) {
		xLeft = x; // x position
		yTop = y; // y position
		side = s; // side
		diceValue = v;// dot value
		colour = c; // die colour
	}

	// Sets face of dice.
	public void setDiceFace(int v) {
		diceValue = v; // dot value
	}

	public void paintComponent(Graphics g) {
		
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Makes dice look pretty.

		Graphics2D g2 = (Graphics2D) g;
		box = new RoundRectangle2D.Double(xLeft, yTop, side, side, 20, 20);
		makeDots();

		// Sets dice colour.
		if (colour == 1) {
			g2.setColor(new Color(85, 37, 130));
			g2.fill(box);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(3));
			g2.draw(box);
			g2.setColor(new Color(253, 185, 39));
		}

		// Sets dice colour.
		if (colour == 2) {
			g2.setColor(new Color(0, 122, 51));
			g2.fill(box);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(3));
			g2.draw(box);
			// Black dots on white
			g2.setColor(new Color(139, 111, 78));
		}
		
		/*
		 * Draws dots. Each diceValue is a side of a dice.
		 */
		if (diceValue == 1) {
			g2.fill(dots[0]);
		} else if (diceValue == 2) {
			g2.fill(dots[1]);
			g2.fill(dots[2]);
		} else if (diceValue == 3) {
			g2.fill(dots[0]);
			g2.fill(dots[1]);
			g2.fill(dots[2]);
		} else if (diceValue == 4) {
			g2.fill(dots[1]);
			g2.fill(dots[2]);
			g2.fill(dots[3]);
			g2.fill(dots[4]);
		} else if (diceValue == 5) {
			g2.fill(dots[0]);
			g2.fill(dots[1]);
			g2.fill(dots[2]);
			g2.fill(dots[3]);
			g2.fill(dots[4]);
		} else if (diceValue == 6) {
			g2.fill(dots[1]);
			g2.fill(dots[2]);
			g2.fill(dots[3]);
			g2.fill(dots[4]);
			g2.fill(dots[5]);
			g2.fill(dots[6]);
		}

	}

	//Makes the dice. Setting the dots on the dice.
	public void makeDots() {
		int w = side / 6; // dot width
		int h = side / 6; // dot height

		dots[0] = new Ellipse2D.Double(xLeft + (2.5 * side) / 6, yTop + (2.5 * side) / 6, h, w);
		dots[1] = new Ellipse2D.Double(xLeft + (3.75 * side) / 6, yTop + (3.75 * side) / 6, h, w);
		dots[2] = new Ellipse2D.Double(xLeft + (1.25 * side) / 6, yTop + (1.25 * side) / 6, h, w);
		dots[3] = new Ellipse2D.Double(xLeft + (1.25 * side) / 6, yTop + (3.75 * side) / 6, h, w);
		dots[4] = new Ellipse2D.Double(xLeft + (3.75 * side) / 6, yTop + (1.25 * side) / 6, h, w);
		dots[5] = new Ellipse2D.Double(xLeft + (1.25 * side) / 6, yTop + (2.5 * side) / 6, h, w);
		dots[6] = new Ellipse2D.Double(xLeft + (3.75 * side) / 6, yTop + (2.5 * side) / 6, h, w);
	}

}