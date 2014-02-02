// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

public class EnterButton extends javax.swing.JButton {

	private Calculator _calculator; //peer object
	private EnterButton _container; // for inner classes use
	
	public EnterButton(Calculator aCalc){
		super("Enter");
		
		_calculator = aCalc;
		_container = this;
		this.setOpaque(true);
		this.addActionListener(new EnterListener());
	
	}
	
	// sends message to calculator when clicked
	private class EnterListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
		_calculator.enter();
		}
	}

}