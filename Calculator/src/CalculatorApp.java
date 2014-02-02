// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

// Creates a GUI Calculator

import java.awt.*;

public class CalculatorApp extends javax.swing.JFrame{
	   	public CalculatorApp (String title) {
			super(title);
			this.setLayout(new java.awt.GridBagLayout());
	   		GridBagConstraints c = new GridBagConstraints();
	   		c.fill = GridBagConstraints.HORIZONTAL;
	   		this.setSize(450, 450);
			this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
			Calculator calculator = new Calculator();
			c.gridx = 0;
			c.gridy = 0;
			this.add(calculator, c);
			ButtonPanel buttons = new ButtonPanel(calculator);
			c.gridx = 0;
			c.gridy = 1;
			this.add(buttons, c);
			this.setVisible(true);
		    }
		 
	   	
		
		    public static void main (String [ ] args) {
			CalculatorApp app = new CalculatorApp("HP-35 Sim");
		    }
		    
		 
		  
	}

