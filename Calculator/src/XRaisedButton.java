// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

public class XRaisedButton extends javax.swing.JButton {


	private Calculator _calculator; //peer object
	private XRaisedButton _container; // for inner classes use
	
	public XRaisedButton(Calculator aCalc){
		super("X^Y");
		
		_calculator = aCalc;
		_container = this;
		this.setOpaque(true);
	
		this.addActionListener(new XRaiseListener());
	
	}
	
	// sends message to calculator when clicked
	private class XRaiseListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
		_calculator.RaiseX();
		}
	}

}