// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

// button that enters a number or decimal
import java.text.*;
public class NumberButton extends javax.swing.JButton {

	private String _number;
	private Calculator _calculator; //peer object
	private NumberButton _container; // for inner classes use
	
	public NumberButton(String aNumber, Calculator aCalc){
		super(aNumber);
		_number = aNumber;
		_calculator = aCalc;
		_container = this;
		this.setOpaque(true);
		this.addActionListener(new NumberListener());
	
	}
	
	// sends message to calculator when clicked
	private class NumberListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
		_calculator.numberEnter(_container.getNumber());
		}
	}
	public String getNumber(){
		if(_number == "Pi")
			_number = Double.toString(this.roundThreeDecimals(Math.PI));
		return _number;
	}
	
	public double roundThreeDecimals(double d) {
		DecimalFormat threeDForm = new DecimalFormat("#.###");
        return Double.valueOf(threeDForm.format(d));
	}
}
