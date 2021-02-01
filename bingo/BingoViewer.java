package bingo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Establishes gui, socket connection and functionality
 * @author eeub10
 *
 */
public class BingoViewer {

	private static String serverName = "localhost";
	private static int port = 8888;
	
	
	static BallComponent ballComp;
	static Socket s;
	
	public static void main(String[] args) {
		try {
			s = new Socket(serverName, port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final int FRAME_WIDTH = 400;
		final int FRAME_HEIGHT = 400;
		JFrame frame = new JFrame();
		//frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.getContentPane().setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		frame.setTitle("Bingo Balls");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.setLayout(new BorderLayout());
		JButton button = new JButton("Get Ball");
		frame.add(button, BorderLayout.SOUTH);
		
		JLabel label = new JLabel("Bingo!");
		frame.add(label, BorderLayout.NORTH);
		
		ballComp = new BallComponent();
		//JPanel panel = new JPanel();
		
		frame.add(ballComp, BorderLayout.CENTER);
		//test code
		//Ball ball = new Ball(2);
		//ballComp.setBall(ball);
		
		class ButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button) {
					try {
						getBall();
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
		}
		
		ButtonListener listener = new ButtonListener(); 
		
		button.addActionListener(listener);
		
		frame.setVisible(true);
		frame.pack();
	}
	
	static ObjectInputStream objIn;
	public static  void getBall() throws UnknownHostException, IOException {
		
		Ball b;
		objIn = new ObjectInputStream(new FileInputStream("Ball.dat"));
		try {
			b = (Ball) objIn.readObject();
			ballComp.setBall(b);
			objIn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Ball b = new Ball(4); test code
		//ballComp.setBall(b);
	}
	
}
