// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

public class eButton extends javax.swing.JButton {


	private Calculator _calculator; //peer object
	private eButton _container; // for inner classes use
	
	public eButton(Calculator aCalc){
		super("e^x");
		
		_calculator = aCalc;
		_container = this;
		this.setOpaque(true);
		this.addActionListener(new eListener());
	
	}
	
	// sends message to calculator when clicked
	private class eListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
		_calculator.RaisedE();
		}
	}

}