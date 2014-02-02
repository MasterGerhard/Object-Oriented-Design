
// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

public class CHSButton extends javax.swing.JButton {

	private Calculator _calculator; //peer object
	private CHSButton _container; // for inner classes use
	
	public CHSButton(Calculator aCalc){
		super("+/-");
		_calculator = aCalc;
		_container = this;
		this.setOpaque(true);
		this.addActionListener(new CHSListener());
	
	}
	
	// sends message to calculator when clicked
	private class CHSListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
		_calculator.changeSign();
		}
	}

}