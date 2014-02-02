// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

public class LogButton extends javax.swing.JButton {


	private Calculator _calculator; //peer object
	private LogButton _container; // for inner classes use
	
	public LogButton(Calculator aCalc){
		super("log(10)");
		
		_calculator = aCalc;
		_container = this;
		this.setOpaque(true);
	
		this.addActionListener(new LogListener());
	
	}
	
	// sends message to calculator when clicked
	private class LogListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
		_calculator.Log();
		}
	}

}