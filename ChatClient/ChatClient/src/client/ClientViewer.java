package client;
import java.awt.EventQueue;

import javax.swing.JFrame;

//works for chatserver3 & chatserver 4

public class ClientViewer {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
			JFrame frame = new ClientFrame();
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.setVisible(true);
	    	frame.pack();
			}
		});
	}
	
}