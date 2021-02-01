package client;
import javax.swing.JTextArea;

public class ClientTextArea extends JTextArea {
	
	/*
	 * Dispalys message on screen
	 */
	public void displayMsg(String aMsg) {
		if(getText().equals("")) {
			setText(aMsg);
		}
		else {
			setText(getText() +"\n"+ aMsg); 
		}
		
	}
}
