package client;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class ClientFrame extends JFrame{
	
	String username, hostname;
	int port;
	ClientTextArea msgArea;
	Client client;
	public boolean connected = false;
	public ClientFrame() {
		// set content pane size instead of frame size
		getContentPane().setPreferredSize(new Dimension(800, 600));
		setTitle("Chat");
		setResizable(false); // Doesn't allow for frame resize so everything stays in proportion
		setLayout(new BorderLayout());
		
		JPanel userPanel = new JPanel();
		JLabel nameLabel = new JLabel("UserName:");
		//JLabel pwdLabel  = new JLabel("Password:");
		JTextField nameField = new JTextField(10);
		JLabel hostLabel = new JLabel("           Host:");
		JLabel portLabel = new JLabel("            Port:");
		JTextField hostField = new JTextField(15);
		JTextField portField = new JTextField(5);
		JButton connectButton = new JButton("Connect");
		userPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		userPanel.add(nameLabel,c);
		
		c.gridx = 1;
		c.gridy = 0;
		userPanel.add(nameField,c);
		
		c.gridx = 0;
		c.gridy = 1;
		userPanel.add(hostLabel,c);
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		userPanel.add(hostField,c);
		
		c.gridx = 0;
		c.gridy = 2;
		userPanel.add(portLabel,c);
		
		c.gridx = 1;
		c.gridy = 2;
		userPanel.add(portField,c);
		c.gridx = 1;
		c.gridy = 3;
		
		userPanel.add(connectButton,c);
		add(userPanel, BorderLayout.WEST);
		
		msgArea = new ClientTextArea();
		msgArea.setEnabled(false);
		JTextField inputText = new JTextField(100);
		inputText.setEnabled(false);//must connect first to allow input
		JScrollPane scrollArea = new JScrollPane(msgArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollArea.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		JPanel scrollpanel = new JPanel(); 
		
		scrollpanel.add(scrollArea);
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		inputPanel.add(inputText, BorderLayout.CENTER);
		JButton sendButton = new JButton("Send");
		inputPanel.add(sendButton, BorderLayout.EAST);
		
		
		
		add(scrollArea, BorderLayout.CENTER);
		add(inputPanel,BorderLayout.SOUTH);
		msgArea.displayMsg("Console: Type in username, hostname & port number to connect to server");
		class actionListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==sendButton) {
					
					if(inputText.getText().equals("")) {
						
					}
					else {
						
						client.sendMsg(username+ ": " + inputText.getText()); 
						//displayMsg(username + ": "+ inputText.getText());
						inputText.setText("");
					}
					
				}
				
				if(e.getSource()==connectButton) {
					if(!connected) {
						if(nameField.getText().equals("") && hostField.getText().equals("") && portField.getText().equals("")) {
							msgArea.displayMsg("Console: please enter correct details to connect to server");
						}
						else {
						
							username = nameField.getText();
							hostname = hostField.getText();
							port =Integer.parseInt(portField.getText());
							try {
								client = new Client(hostname,port);
								ClientRunnable handler = new ClientRunnable(client, msgArea);
								connected = true;
								
							    inputText.setEnabled(true);
							    msgArea.displayMsg("Console: Establishing connection. Please wait ...");
							    msgArea.displayMsg("Console: Client socket created: " + client.getSocket());
							    msgArea.displayMsg("Console: Type .help for commands");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							;
						}
					}
					else {
						msgArea.displayMsg("Console: You are already connected");
					}
				}
			}
			
		}
		
		actionListener action = new actionListener();
		
		sendButton.addActionListener(action);
		connectButton.addActionListener(action);
	}
	
	
}
