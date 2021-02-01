package dicegame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * @author Josh Gardner // eeub10
 * High or Low Dice Game.
 *
 */

public class DiceViewer {
	public static void main(String[] args) {
		// Build JFrame.
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());

		// Set frame size
		frame.getContentPane().setPreferredSize(new Dimension(500, 300));
		frame.setResizable(false); // Doesn't allow for frame resize so everything stays in proportion
		frame.setTitle("High or Low");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creates the dice. The dice on the left and on the right.
		DiceComponent dice1 = new DiceComponent(100, 70, 50, 6, 1);
		DiceComponent dice2 = new DiceComponent(100, 70, 50, 6, 2);
		
		// Throw button, set to disabled until a game type is selected
		JButton button = new JButton("Throw dice");
		button.setEnabled(false);

		// Panel that houses the 2 dice.
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.add(dice1);
		panel.add(dice2);
		frame.add(panel, BorderLayout.CENTER);

		/*
		 * Handling for the radio buttons(high,low, sevens).
		 * Manages betting amount (1, 5, 10).
		 */

		// Radio buttons that are used to select different betting values
		// The different buttons in the game.
		JRadioButton highButton = new JRadioButton("High");
		JRadioButton lowButton = new JRadioButton("Low");
		JRadioButton sevensButton = new JRadioButton("Sevens");
		
		// Manages the selected/unselected state for a set of buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(highButton); // Group buttons so that if another is selected, the previous is set to false
		group.add(lowButton);
		group.add(sevensButton);
		JPanel panelRadioButton = new JPanel(new GridLayout(3, 1)); // Adds radio button vertically.
		panelRadioButton.add(highButton);
		panelRadioButton.add(lowButton);
		panelRadioButton.add(sevensButton);
		panelRadioButton.setBorder(new TitledBorder(new EtchedBorder(), "Game")); // Extra feature I've added

		// Betting box.
		JLabel betLabel = new JLabel("Bet Amount:");
		Integer[] bets = { 1, 5, 10 };
		JComboBox<Integer> bet = new JComboBox<Integer>(bets);

		// Balance label
		int startBalance = 50;
		final int[] balance = new int[1];
		balance[0] = startBalance;
		JLabel balanceLabel = new JLabel("Balance =" + balance[0]);

		// Add game stuff setting tools to SOUTH of frame

		JPanel bottom = new JPanel();
		bottom.add(panelRadioButton);
		bottom.add(betLabel);
		bottom.add(bet);
		bottom.add(balanceLabel);
		bottom.add(button);
		frame.add(bottom, BorderLayout.SOUTH);

		// Create new instances of Dice
		Dice die1 = new Dice(6);
		die1.throwDice();
		Dice die2 = new Dice(6);
		die2.throwDice();

		// Button listener
		class DiceListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				die1.throwDice();
				die2.throwDice();
				dice1.setDiceFace(die1.getValue());
				dice2.setDiceFace(die2.getValue());

				dice1.repaint();
				dice2.repaint();
				frame.repaint();

				// Prevents player from betting more than they have
				if (((int) bet.getSelectedItem() == 10 && balance[0] < 10) || (balance[0] < 5 && ((int) bet.getSelectedItem() == 5 || (int) bet.getSelectedItem() == 10))) {
					notEnough();
				}

				// Get betting amount.
				int betAmount = (int) bet.getSelectedItem();

				// When 'High' is selected
				if (highButton.isSelected()) {
					int one = die1.getValue();
					int two = die2.getValue();
					int sum = one + two;

					if (sum >= 8) {
						System.out.println("You've won!");
						balance[0] = balance[0] + betAmount;
						balanceLabel.setText("Balance:" + balance[0]);
					} else {
						System.out.println("You've lost!");
						balance[0] = balance[0] - betAmount;
						balanceLabel.setText("Balance:" + balance[0]);
					}
				}

				// When 'Low' is selected
				if (lowButton.isSelected()) {
					int one = die1.getValue();
					int two = die2.getValue();
					int sum = one + two;
					if (sum <= 6) {
						System.out.println("You've won!");
						balance[0] = balance[0] + betAmount;
						balanceLabel.setText("Balance:" + balance[0]);
					} else {
						System.out.println("You've lost!");
						balance[0] = balance[0] - betAmount;
						balanceLabel.setText("Balance:" + balance[0]);
					}
				}

				// When 'Sevens' is selected
				if (sevensButton.isSelected()) {
					int one = die1.getValue();
					int two = die2.getValue();
					int sum = one + two;

					if (sum == 7) {
						System.out.println("You've won!");
						balance[0] = balance[0] + betAmount * 4;
						balanceLabel.setText("Balance:" + balance[0]);
					} else {
						System.out.println("You've lost, ha ha ha!");
						balance[0] = balance[0] - betAmount;
						balanceLabel.setText("Balance:" + balance[0]);
					}
				}

				// End game if balance is 100 or 0

				if (balance[0] >= 100) {
					JOptionPane.showMessageDialog(frame, "You have actually won!" + balance[0] + "\n" + "\u1F4B8");

					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
				if (balance[0] <= 0) {

					JOptionPane.showMessageDialog(frame,
							"Hey, you have no money left, LOL.\nGoodbye!" + "\n" + "\u1F62D");
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

				}
			}

			//  Only displays if there is not enough money to place a particular bet.
			private void notEnough() {
				JOptionPane.showMessageDialog(frame, "Not enough funds to place this bet you donkey!");
			}
		}

		//	ActionListener for dice.
		ActionListener listener = new DiceListener();
		button.addActionListener(listener);

		// SetUp listener
		class ChoiceListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				// Enable throw button only when a game type is selected
				if (highButton.isSelected() || lowButton.isSelected() || sevensButton.isSelected()) {
					button.setEnabled(true);
				}
			}
		}

		//	ActionListener for radio buttons.
		ActionListener parameterListener = new ChoiceListener();
		highButton.addActionListener(parameterListener);
		lowButton.addActionListener(parameterListener);
		sevensButton.addActionListener(parameterListener);

		frame.setVisible(true);
		frame.pack();
	}

}
