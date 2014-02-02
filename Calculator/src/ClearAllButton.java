// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

public class ClearAllButton extends javax.swing.JButton {


	private Calculator _calculator; //peer object
	private ClearAllButton _container; // for inner classes use
	
	public ClearAllButton(Calculator aCalc){
		super("CLR");
		
		_calculator = aCalc;
		_container = this;
		this.setOpaque(true);
		this.addActionListener(new ClearAllListener());
	
	}
	
	// sends message to calculator when clicked
	private class ClearAllListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
		_calculator.ClearAll();
		}
	}

}