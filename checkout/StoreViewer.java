package checkout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StoreViewer extends JFrame{

	public static void main(String[] args) {
		
		final int FRAME_WIDTH = 100;
		final int FRAME_HEIGHT =100;
		JFrame frame = new JFrame();
		//frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.getContentPane().setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		frame.setTitle("Checkout Viewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JButton addCustomerBtn = new JButton("Add Customer");
		frame.add(addCustomerBtn);
		
		Store store = new Store();

		class ButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(addCustomerBtn)) {
					store.addCust();
				}
			}
			
		}
		
		ButtonListener btnList = new ButtonListener();
		addCustomerBtn.addActionListener(btnList);
		
		frame.setVisible(true);
		frame.pack();
	
	
	
	}
}
