package bb;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * @author Josh Gardner//eeub10 
 * @version 1
 * @since 29/11/2018
 * Extends JFrame
 * Creates JFrame to paint ball objects onto and UI
 */
public class BallFrame extends JFrame{
	private static final int LIMIT = 8;
	private int ballCount = 0;
	BallPanel ballPanel;
	BallRunnable r;
	private int speed;
	private boolean pause=false;
	BallCollision collide;
	private boolean collision;
	
	
	/**
	 * Builds Frame, adds panel,ball objects, listeners
	 * Calls and controls main program
	 */
	public BallFrame() {
		
		setPreferredSize(new Dimension(600,600));
		setTitle("Bouncing Balls");
		setResizable(false); // Doesn't allow for frame resize so everything stays in proportion
		setLayout(new BorderLayout());
		ballPanel = new BallPanel();
		JPanel buttonPanel = new JPanel();
		add(ballPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		JButton startButton = new JButton("Start");
		JButton pauseButton = new JButton("Pause");
		JButton stopButton = new JButton("Stop");
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL,1,5,1);
		slider.setMinorTickSpacing(2);  
		slider.setMajorTickSpacing(1);  
		slider.setPaintTicks(true);  
		slider.setPaintLabels(true);
		buttonPanel.add(startButton);
		buttonPanel.add(pauseButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(slider);
		
		
		
		class ButtonListener implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()== startButton) {	
						if(pause == true) {
							restartBall();
						}
						else {
						startBall();}
					}
				if(e.getSource()== stopButton) {
					stopBall();
				}
				if(e.getSource()== pauseButton) {
					pauseBall();
				}
				}
			}
		
		class SlideListener implements ChangeListener{
			public void stateChanged(ChangeEvent e) {
				speed = slider.getValue();
			}
				
		}
		
	
		ButtonListener action = new ButtonListener();
		SlideListener slideChange = new SlideListener();
		startButton.addActionListener(action);
		stopButton.addActionListener(action);
		pauseButton.addActionListener(action);
		slider.addChangeListener(slideChange);
		
	}
	/**
	 * add Ball obj to ballPanel and creates a runnable for the ball
	 */
	public void addBall(){
		
		Ball ball = new Ball(ballPanel.getBounds(),speed);
		ballPanel.addBall(ball);
	
		new BallRunnable(ball, ballPanel);
		
	
	}
	/**
	 * creates BallCollision Object and updates the list  
	 * @param list
	 */
	public void checkCollision(ArrayList<Ball> list) {
			if(collision == false) {
				
				collision = true;
				collide = new BallCollision(list);
			}
			else {
				collide.updateList(list);
			}
	}
	/**
	 * Exits program
	 */
	public void stopBall() {
		//start = false;
		//r.stop();
		System.exit(0);
		
	}
	/**
	 * adds ball objects through the addBall method
	 * adds as many as the slideValue minus what is already added
	 */
	public void startBall() {
			if(ballCount<LIMIT) {
				ballCount++;
				addBall();
				checkCollision(ballPanel.getList());
			}
			
	}
	/**
	 * pauses balls
	 */
	public void pauseBall() {
		pause = true;
		ArrayList<Ball> balls = ballPanel.getList();
		for(Ball b:balls) {
			b.stop();
		}
		
	}
	
	public void restartBall() {
		pause = false;
		ArrayList<Ball> balls = ballPanel.getList();
		for(Ball b:balls) {
			b.start();
		}
	}
	
	
	
}
