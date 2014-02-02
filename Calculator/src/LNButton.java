
// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

public class LNButton extends javax.swing.JButton {


	private Calculator _calculator; //peer object
	private LNButton _container; // for inner classes use
	
	public LNButton(Calculator aCalc){
		super("ln");
		_calculator = aCalc;
		_container = this;
		this.setOpaque(true);
		this.addActionListener(new LNListener());
	
	}
	
	// sends message to calculator when clicked
	private class LNListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
		_calculator.NaturalLog();
		}
	}

}