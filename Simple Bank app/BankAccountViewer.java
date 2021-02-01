package com.mycompany.mavenproject1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class BankAccountViewer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static BankAccount account;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					account = new BankAccount(1);
					BankAccountViewer frame = new BankAccountViewer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BankAccountViewer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblBankOfBangor = new JLabel("Bank of Bangor");
		panel.add(lblBankOfBangor);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel Actionpanel = new JPanel();
		Actionpanel.setBorder(null);
		panel_1.add(Actionpanel);
		Actionpanel.setLayout(new GridLayout(2, 2, 40, 20));
		
		final JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Actionpanel.add(btnDeposit);
		
		textField_1 = new JTextField();
		Actionpanel.add(textField_1);
		textField_1.setEditable(true);
		textField_1.setColumns(10);
		
		final JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		Actionpanel.add(btnWithdraw);
		
		textField = new JTextField();
		Actionpanel.add(textField);
		textField.setEditable(true);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 20));
		
		final JButton btnBal = new JButton("Show Balance");
		btnBal.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.add(btnBal);
		
		final JLabel label = new JLabel("Your balance is: ");
		panel_4.add(label);
		
		
		class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnDeposit) { try {
					account.deposit(Double.parseDouble(textField_1.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				textField_1.setText("");
				} 
				if (e.getSource()==btnWithdraw) { try {
					account.withdraw(Double.parseDouble(textField.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField.setText("");	
				}
				if(e.getSource()==btnBal) {try {
					label.setText("Your balance is: " + account.getBalance());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				//balance
			}
			
		}
		ButtonListener btnList = new ButtonListener();
		btnDeposit.addActionListener(btnList);
		btnWithdraw.addActionListener(btnList);
		btnBal.addActionListener(btnList);
		
		
		
	}

}
