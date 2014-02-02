// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

public class Calculator extends javax.swing.JPanel {
	private javax.swing.JTextField _display;
	private Stack<Double> _stack;
	private String _operator;
	private String _x; // current display
	private double _xD,_yD,_z; //used for calculations
	private boolean _clearDisp; //determines if display will be cleared when new number entered
	
	public Calculator(){
		_display = new javax.swing.JTextField(35);
		this.add(_display);
		this.clearDisplay();
		_stack = new Stack<Double>();
		_clearDisp = false;
	}
	// number enter methods
	public void numberEnter(String number){
		
		_x = _display.getText();
		if(_x.contains("Error"))
				this.clearDisplay();
		if (_clearDisp){
			
			_stack.push(Double.parseDouble(_x));
			this.clearDisplay();
			_clearDisp = false;
		}
			
		_x = _display.getText();
		if (_x.contains(".") && number == ".")
			this.setDisplay("Error");
		else
		_display.setText(_x + number);
		_x = _display.getText();
	}
	// operator methods
	public void operatorEnter(String operator){
		_operator = operator;
		_yD = _stack.pop();
		_xD = Double.parseDouble(_x);
		String disp = String.valueOf((Operation(_yD, _xD, _operator)));
		if (disp.contains("Infinity") || disp.contains("NaN"))
		disp = "Error Inf or NaN";
		this.setDisplay(disp);
		_clearDisp = true;
		
	}
	// stores display in stack
	// display doesnt change untill next button press
	public void enter(){
		_x = _display.getText();
		//throw new RuntimeException("Error");
		try {
		_stack.push(Double.parseDouble(_x));
		}
		catch(RuntimeException e){
		this.setDisplay("Error");
		}
		_clearDisp = true;
		
	}
	// clears only the display
	public void clearDisplay(){
		_display.setText(null);
		_x = null;
		_clearDisp = false;
	}
	// changes neg to positive and positive to neg
	public void changeSign(){
		_x  = _display.getText();
		if(_x.contains("-"))
			_display.setText(_x.substring(1));
		else
			_display.setText("-" + _x);
		_x  = _display.getText();
	}
	// sets display string
	public void setDisplay(String string){
		_display.setText(string);
		_x = _display.getText();
	}
	// x^y methods
	public void RaiseX(){
		
		try{_xD = Double.parseDouble(_x);}
		catch(RuntimeException e){this.setDisplay("Error");}
		try{_yD = _stack.pop();}
		catch(RuntimeException e){this.setDisplay("Error");}
		
		this.setDisplay(String.valueOf(Math.pow(_xD,_yD)));
	}
	// log base 10 methods
	public void Log(){
		try{_xD = Double.parseDouble(_x);}
		catch(RuntimeException e){}
		String disp = String.valueOf(Math.log(_xD)/Math.log(10));
		if(_xD <= 0)
		disp = "NonReal Error";
		this.setDisplay(disp);
		
	}
	//ln methods
	public void NaturalLog(){
		try{_xD = Double.parseDouble(_x);}
		catch(RuntimeException e){}
		String disp = String.valueOf(Math.log(_xD));
		if(_xD <= 0)
		disp = "NonReal Error";
		this.setDisplay(disp);
	}
	// e^x methods
	public void RaisedE(){
		try{_xD = Double.parseDouble(_x);}
		catch(RuntimeException e){this.setDisplay("Error");
		}
		this.setDisplay(String.valueOf(Math.pow(2.71828,_xD)));
	}
	
	// clears stacks and display
	public void ClearAll(){
		_stack = new Stack<Double>();
		this.clearDisplay();
		
	}
	
	// this performs arithmetic
	public double Operation(double x, double y, String operator){
		
		
		if (operator.equals("+")){
			_z = x + y;
		}
			
		else if (operator.equals("-")){
			_z = x - y;
		 }
			
		else if (operator.equals("*")){
			_z = x * y;
		 }
		else if (operator.equals("/")){
			_z = x/y;
		}
		return _z;
		}
}
