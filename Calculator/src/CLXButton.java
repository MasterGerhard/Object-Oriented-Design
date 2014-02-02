// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

public class CLXButton extends javax.swing.JButton {

	private Calculator _calculator; //peer object
	private CLXButton _container; // for inner classes use
	
	public CLXButton(Calculator aCalc){
		super("CL X");
		_calculator = aCalc;
		_container = this;
		this.setOpaque(true);
		this.addActionListener(new CLXListener());
	
	}
	
	// sends message to calculator when clicked
	private class CLXListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
		_calculator.clearDisplay();
		}
	}

}