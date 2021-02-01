package dicegame;


import java.util.Random;

/**
 * @author Josh Gardner // eeub10
 *  Random dice generator
 *
 */
public class Dice {
	private Random generator;
	private int sides;
	private int value;

	/**
	 * @param noSides, number of sides on the dice.
	 */
	public Dice(int noSides) {
		generator = new Random();
		sides = noSides;
		value = 1 + generator.nextInt(sides);
	}

	public int throwDice() {
		value = 1 + generator.nextInt(sides);
		return value;
	}

	/**
	 * @return dice value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param v, sets dice value
	 */
	public void setValue(int v) {
		value = v;
	}
}