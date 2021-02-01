package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;




/**
 * @author Josh Gardner/ eeub10
 * CalculatorFrame draws calculator ui and implements input to the calculator class
 */
public class CalculatorFrame {
	
	//memory
	static String textfCopy = ""; // stores the contents of the textfield so it can be pasted in later
	static String mem = ""; //
	static boolean setMinus;
 /**
 * @param args
 */
/**
 * @param args
 */
public static void main(String[] args) { 
	 // Build JFrame.
	 	JFrame frame = new JFrame(); 
	    frame.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		JPanel buttonPanel2 = new JPanel();
		JPanel buttonPanel = new JPanel();
		GridLayout grid = new GridLayout(4,6);
		buttonPanel.setLayout(grid);
		grid.setHgap(5);
		grid.setVgap(10);  
		GridLayout grid2 = new GridLayout(1,3);
		grid2.setHgap(5);
		buttonPanel2.setLayout(grid2);
		// Set frame size
		frame.getContentPane().setPreferredSize(new Dimension(350,240 ));
		frame.setResizable(false); // Doesn't allow for frame resize so everything stays in proportion
		frame.setTitle("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel,BorderLayout.CENTER);
		panel.add(buttonPanel2);
		panel.add(buttonPanel);
		JTextField textfield = new JTextField(20);
		textfield.setHorizontalAlignment(SwingConstants.RIGHT);
		textfield.setForeground(Color.red);
		textfield.setEnabled(false);
		frame.add(textfield, BorderLayout.NORTH);
		
		//build menu
		JMenu menu,menu2, menu3;  
        JMenuItem i1, i2,i3,i4,i5,i6,i7; 
		JMenuBar mb=new JMenuBar();  
        menu=new JMenu("Edit");
        menu2 = new JMenu("View");
        menu3 = new JMenu("Help");
     
        i1=new JMenuItem("Copy");  
        i2=new JMenuItem("Paste");  
        i3=new JMenuItem("Standard");
        i4=new JMenuItem("Scientific");
        i5=new JMenuItem("Digit Grouping");
        i6=new JMenuItem("Help Topics");
        i7=new JMenuItem("About Calculator");
        menu.add(i1); menu.add(i2);
        menu2.add(i3); menu2.add(i4); menu2.add(i5);
        menu3.add(i6); menu3.add(i7);
        
        mb.add(menu);
        mb.add(menu2);
        mb.add(menu3);
        frame.setJMenuBar(mb);  
		
        
		
		
		JButton oneButton = new JButton("1");
		JButton twoButton = new JButton("2");
		JButton threeButton = new JButton("3");
		JButton fourButton = new JButton("4");
		JButton fiveButton = new JButton("5");
		JButton sixButton = new JButton("6");
		JButton sevenButton = new JButton("7");
		JButton eightButton = new JButton("8");
		JButton nineButton = new JButton("9");
		JButton zeroButton = new JButton("0");
		JButton divButton = new JButton("/");
		JButton multButton = new JButton("*");
		JButton plusButton = new JButton("+");
		JButton minButton = new JButton("-");
		JButton decButton = new JButton(".");
		JButton equalsButton = new JButton("=");
		
		JButton SQButton = new JButton("\u221A");
		JButton MODButton = new JButton("%");
		JButton plusminButton = new JButton("+/-");
		JButton invButton = new JButton("1/x");
		
		
		JButton MCButton = new JButton("MC");
		JButton MRButton = new JButton("MR");
		JButton MSButton = new JButton("MS");
		JButton MPButton = new JButton("M+");
		JButton BSButton = new JButton("BS");
		JButton CEButton = new JButton("CE");
		JButton CButton = new JButton("C");
		
		oneButton.setForeground(Color.BLUE);
		twoButton.setForeground(Color.BLUE);
		threeButton.setForeground(Color.BLUE);
		fourButton.setForeground(Color.BLUE);
		fiveButton.setForeground(Color.BLUE);
		sixButton.setForeground(Color.BLUE);
		sevenButton.setForeground(Color.BLUE);
		eightButton.setForeground(Color.BLUE);
		nineButton.setForeground(Color.BLUE);
		zeroButton.setForeground(Color.BLUE);
		decButton.setForeground(Color.BLUE);
		SQButton.setForeground(Color.BLUE);
		MODButton.setForeground(Color.BLUE);
		plusminButton.setForeground(Color.BLUE);
		invButton.setForeground(Color.BLUE);
		
		
		
		equalsButton.setForeground(Color.RED);
		plusButton.setForeground(Color.RED);
		minButton.setForeground(Color.RED);
		divButton.setForeground(Color.RED);
		multButton.setForeground(Color.RED);
		MCButton.setForeground(Color.RED);
		MRButton.setForeground(Color.RED);
		MSButton.setForeground(Color.RED);
		MPButton.setForeground(Color.RED);
		BSButton.setForeground(Color.RED);
		CEButton.setForeground(Color.RED);
		CButton.setForeground(Color.RED);
		
		
		buttonPanel2.add(BSButton);
		buttonPanel2.add(CEButton);
		buttonPanel2.add(CButton);
		
		
		buttonPanel.add(MCButton);
		buttonPanel.add(sevenButton);
		buttonPanel.add(eightButton);
		buttonPanel.add(nineButton);
		buttonPanel.add(divButton);
		buttonPanel.add(SQButton);
		buttonPanel.add(MRButton);
		buttonPanel.add(fourButton);
		buttonPanel.add(fiveButton);
		buttonPanel.add(sixButton);
		buttonPanel.add(multButton);
		buttonPanel.add(MODButton);
		buttonPanel.add(MSButton);
		buttonPanel.add(oneButton);
		buttonPanel.add(twoButton);
		buttonPanel.add(threeButton);
		buttonPanel.add(minButton);
		buttonPanel.add(invButton);
		buttonPanel.add(MPButton);
		buttonPanel.add(zeroButton);
		buttonPanel.add(plusminButton);
		buttonPanel.add(decButton);
		buttonPanel.add(plusButton);
		buttonPanel.add(equalsButton);
		
		
		
		
	
	
	class InsertActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == oneButton){textfield.setText(textfield.getText() + "1");}
			if(e.getSource() == twoButton) { textfield.setText(textfield.getText() + "2");}
			if(e.getSource() == threeButton) { textfield.setText(textfield.getText() + "3");}
			if(e.getSource() == fourButton) {textfield.setText(textfield.getText() + "4");}
			if(e.getSource() == fiveButton) {textfield.setText(textfield.getText() + "5");}
			if(e.getSource() == sixButton) {textfield.setText(textfield.getText() + "6");}
			if(e.getSource() == sevenButton) {textfield.setText(textfield.getText() + "7");}
			if(e.getSource() == eightButton) {textfield.setText(textfield.getText() + "8");}
			if(e.getSource() == nineButton) {textfield.setText(textfield.getText() + "9");}
			if(e.getSource() == zeroButton) {textfield.setText(textfield.getText() + "0");}
			if(e.getSource() == divButton) {textfield.setText(textfield.getText() + "/");}
			if(e.getSource() == multButton) {textfield.setText(textfield.getText() + "*");}
			if(e.getSource() == plusButton) {textfield.setText(textfield.getText() + "+");}
			if(e.getSource() == decButton) {textfield.setText(textfield.getText() + ".");}
			if(e.getSource() == minButton) {textfield.setText(textfield.getText() + "-");}
			//if(e.getSource() == equalsButton) {textfield.setText(textfield.getText() + "=");} not needed
			
			if(e.getSource()== SQButton) {textfield.setText(textfield.getText() + "\u221A");}
			if(e.getSource()== MODButton) {textfield.setText(textfield.getText() + "%");}
			if(e.getSource()== plusminButton) {textfield.setText(textfield.getText() + "-");}
			if(e.getSource()== invButton) {textfield.setText(textfield.getText() + "1/");}
			//add functions
			//memory
			
			if(e.getSource()== MRButton) {textfield.setText(textfield.getText() + mem);}
			
			
			if(e.getSource()== BSButton) {
			char[] text = textfield.getText().toCharArray();
			String string = "";
			for (int i = 0; i < text.length - 1; i++) string += text[i];
			textfield.setText(string);}
			
			if(e.getSource()== CEButton) {
				
			}
			if(e.getSource()== CButton) {textfield.setText("");}
			
			//menu
			if(e.getSource()== i2) {textfield.setText(textfield.getText() + textfCopy); } //pastes contents of the copy var into the textfield
			
			if(e.getSource()== i5) { //loop through textfield adding commas
				double amount = Double.parseDouble(textfield.getText());
				DecimalFormat formatter = new DecimalFormat("#,###,###,###,###,###");

				textfield.setText(formatter.format(amount));

			}
			if(e.getSource()== i6) {try {
				readHelp();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			
			if(e.getSource()== i7) {createAbout();}
			
			
			
			
		}
		
		
	}
	
	class OperatorActionListener implements ActionListener{
		Calculator calc = new Calculator();
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == oneButton){ if(setMinus==true) {calc.calculate(-1);setMinus=false;} else{calc.calculate(1);}}
			if(e.getSource() == twoButton) {if(setMinus==true) {calc.calculate(-2);setMinus=false;} else{calc.calculate(2);}}
			if(e.getSource() == threeButton) {if(setMinus==true) {calc.calculate(-3);setMinus=false;} else{calc.calculate(3);}}
			if(e.getSource() == fourButton) {if(setMinus==true) {calc.calculate(-4);setMinus=false;} else{calc.calculate(4);}}
			if(e.getSource() == fiveButton) {if(setMinus==true) {calc.calculate(-5);setMinus=false;} else{calc.calculate(5);}}
			if(e.getSource() == sixButton) {if(setMinus==true) {calc.calculate(-6);setMinus=false;} else{calc.calculate(6);}}
			if(e.getSource() == sevenButton) {if(setMinus==true) {calc.calculate(-7);setMinus=false;} else{calc.calculate(7);}}
			if(e.getSource() == eightButton) {if(setMinus==true) {calc.calculate(-8);setMinus=false;} else{calc.calculate(8);}}
			if(e.getSource() == nineButton) {if(setMinus==true) {calc.calculate(-9);setMinus=false;} else{calc.calculate(9);}}
			if(e.getSource() == zeroButton) {calc.calculate(0);}
			
			if(e.getSource() == divButton) {calc.setLastOperator("/");}
			if(e.getSource() == multButton) {calc.setLastOperator("*");}
			if(e.getSource() == plusButton) {calc.setLastOperator("+");}
			if(e.getSource() == decButton) {calc.setLastOperator(".");}
			if(e.getSource() == minButton) {calc.setLastOperator("-");}
			if(e.getSource() == equalsButton) {textfield.setText(Double.toString(calc.getResult()));}
			
			//advanced 
			if(e.getSource()== SQButton) {calc.setLastOperator("\u221A");}
			if(e.getSource()== MODButton) {calc.setLastOperator("%");}
			if(e.getSource()== plusminButton) {if(setMinus==true){setMinus=false;}else{setMinus=true;}}
			if(e.getSource()== invButton) {calc.setLastOperator("1/x");}
			
			//menu
			if(e.getSource()== i1) {textfCopy = textfield.getText(); } // copies textfield contents
			if(e.getSource()==i6) {try {
				readHelp();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			//memory
			if (e.getSource()== MCButton) {mem = "";}
			if (e.getSource()== MSButton) {mem = textfield.getText();}
			if (e.getSource()== MPButton) {mem += textfield.getText();}
			
			if(e.getSource()== CButton) {calc.setLastOperator(""); calc.setResult(0);}//needs to clear from calculator
			
			
			//implement way of backspace removing from calcualtion
			//could find a way to read text field and calculate eah bit 
		}
	
	}
	
	InsertActionListener insertAction = new InsertActionListener();
	OperatorActionListener operatorAction = new OperatorActionListener();
	
	oneButton.addActionListener(insertAction);
	twoButton.addActionListener(insertAction);
	threeButton.addActionListener(insertAction);
	fourButton.addActionListener(insertAction);
	fiveButton.addActionListener(insertAction);
	sixButton.addActionListener(insertAction);
	sevenButton.addActionListener(insertAction);
	eightButton.addActionListener(insertAction);
	nineButton.addActionListener(insertAction);
	zeroButton.addActionListener(insertAction);
	divButton.addActionListener(insertAction);
	multButton.addActionListener(insertAction);
	plusButton.addActionListener(insertAction);
	minButton.addActionListener(insertAction);
	decButton.addActionListener(insertAction);
	
	
	SQButton.addActionListener(insertAction);
	MODButton.addActionListener(insertAction);
	plusminButton.addActionListener(insertAction);
	invButton.addActionListener(insertAction);
	MCButton.addActionListener(operatorAction);
	MRButton.addActionListener(insertAction);
	MSButton.addActionListener(operatorAction);
	MPButton.addActionListener(operatorAction);
	BSButton.addActionListener(insertAction);
	CEButton.addActionListener(insertAction);
	CButton.addActionListener(insertAction);
	
	
	CButton.addActionListener(operatorAction);
	SQButton.addActionListener(operatorAction);
	MODButton.addActionListener(operatorAction);
	plusminButton.addActionListener(operatorAction);
	invButton.addActionListener(operatorAction);
	oneButton.addActionListener(operatorAction);
	twoButton.addActionListener(operatorAction);
	threeButton.addActionListener(operatorAction);
	fourButton.addActionListener(operatorAction);
	fiveButton.addActionListener(operatorAction);
	sixButton.addActionListener(operatorAction);
	sevenButton.addActionListener(operatorAction);
	eightButton.addActionListener(operatorAction);
	nineButton.addActionListener(operatorAction);
	zeroButton.addActionListener(operatorAction);
	divButton.addActionListener(operatorAction);
	multButton.addActionListener(operatorAction);
	plusButton.addActionListener(operatorAction);
	minButton.addActionListener(operatorAction);
	decButton.addActionListener(operatorAction);
	equalsButton.addActionListener(operatorAction);
	
	
	i1.addActionListener(operatorAction);
	i2.addActionListener(insertAction);
	i5.addActionListener(insertAction);
	i6.addActionListener(insertAction);
	i7.addActionListener(insertAction);
	
	frame.setVisible(true);
	frame.pack();
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	@SuppressWarnings("resource")
	public static void readHelp() throws IOException{
		
            String line;
            BufferedReader in;

            in = new BufferedReader(new FileReader("README.txt"));
            line = in.readLine();

            while(line != null)
            {
                   System.out.println(line);
                   line = in.readLine();
            }

            System.out.println(line);
	}
	public static void createAbout(){
		JDialog dialog = new JDialog();
		JPanel dPanel = new JPanel();
		JLabel dLabel = new JLabel();
		dPanel.setLayout(new BorderLayout());
		dialog.getContentPane().setPreferredSize(new Dimension(450,20 ));
		dialog.setResizable(false); // Doesn't allow for frame resize so everything stays in proportion
		dialog.setTitle("Calculator");
		dialog.add(dPanel);
		dPanel.add(dLabel, BorderLayout.NORTH);
		dLabel.setText("About Calculator/CalculatorFrame.java programmed by Josh Gardner eeub10 ");
		
		dialog.pack();
		dialog.setVisible(true);
	}
}
