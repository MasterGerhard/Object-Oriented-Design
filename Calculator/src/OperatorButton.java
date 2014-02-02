// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

public class OperatorButton extends javax.swing.JButton {

	private String _operator;
	private Calculator _calculator; //peer object
	private OperatorButton _container; // for inner classes use
	
	public OperatorButton(String operator, Calculator aCalc){
		super(operator);
		_operator = operator;
		_calculator = aCalc;
		_container = this;
		this.setOpaque(true);
	
		this.addActionListener(new OperatorListener());
	
	}
	
	// sends message to calculator when clicked
	private class OperatorListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
		_calculator.operatorEnter(_container.getSign());
		}
	}
	public String getSign(){
		return _operator;
	}
}