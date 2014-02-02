
// CSE1102 HW 08
// Fall 2012
// Steven Gerhard

public class ButtonPanel extends javax.swing.JPanel {
	private NumberButton _0,_1,_2,_3,_4,_5,_6,
						_7,_8,_9,_decimal,_pi;
	private OperatorButton _subtract,_add,_divide,_multiply;
	private EnterButton _enter;
	private CLXButton _clx;
	private CHSButton _chs;
	private XRaisedButton _xRaised;
	private LogButton _log;
	private LNButton _ln;
	private eButton _e;
	private ClearAllButton _ClearAll;
	private Calculator _Container;
	
	public ButtonPanel(Calculator aCalc){
		
		super(new java.awt.GridLayout(0,1));
		// creates all buttons with calculator reference to send messages
		_Container = aCalc;
		_0 = new NumberButton("0", _Container);
		_1 = new NumberButton("1",_Container);
		_2 = new NumberButton("2",_Container);
		_3 = new NumberButton("3",_Container);
		_4 = new NumberButton("4",_Container);
		_5 = new NumberButton("5",_Container);
		_6 = new NumberButton("6",_Container);
		_7 = new NumberButton("7",_Container);
		_8 = new NumberButton("8",_Container);
		_9 = new NumberButton("9",_Container);
		_decimal = new NumberButton(".",_Container);
		_pi = new NumberButton("Pi", _Container);
		_subtract = new OperatorButton("-", _Container);
		_add = new OperatorButton("+",_Container);
		_multiply = new OperatorButton("*",_Container);
		_divide = new OperatorButton("/",_Container);
		_enter = new EnterButton(_Container);
		_chs = new CHSButton(_Container);
		_clx = new CLXButton(_Container);
		_xRaised = new XRaisedButton(_Container);
		_log = new LogButton(_Container);
		_ln = new LNButton(_Container);
		_e = new eButton(_Container);
		_ClearAll = new ClearAllButton(_Container);
		// adds the buttons to the panel
		// in individual rows
		
		javax.swing.JPanel TopRow = new javax.swing.JPanel();
		TopRow.setLayout(new java.awt.GridLayout(1,0));
		TopRow.add(_xRaised);
		TopRow.add(_log);
		TopRow.add(_ln);
		TopRow.add(_e);
		TopRow.add(_ClearAll);
		
		this.add(TopRow);
		
		javax.swing.JPanel enterRow = new javax.swing.JPanel();
		enterRow.setLayout(new java.awt.GridLayout(1,0));
		enterRow.add(_enter);
		enterRow.add(_chs);
		enterRow.add(_clx);
		
		this.add(enterRow);
		
		javax.swing.JPanel numberRow = new javax.swing.JPanel();
		numberRow.setLayout(new java.awt.GridLayout(4,4));
		
		numberRow.add(_subtract);
		numberRow.add(_7);
		numberRow.add(_8);
		numberRow.add(_9);	
		
		numberRow.add(_add);
		numberRow.add(_4);
		numberRow.add(_5);
		numberRow.add(_6);	
		
		numberRow.add(_multiply);
		numberRow.add(_1);
		numberRow.add(_2);
		numberRow.add(_3);
		
		numberRow.add(_divide);
		numberRow.add(_0);
		numberRow.add(_decimal);
		numberRow.add(_pi);
		
		
		this.add(numberRow);
		
	}
	
	
}
