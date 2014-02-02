// CSE1102 HW 07
// Fall 2012
// Steven Gerhard

import java.awt.Color;

// this panel holds all the buttons
// color buttons set color
// "clear" clears all pegs
public class ColorButtonPanel extends javax.swing.JPanel {
	private Colorable _aPanel;
	private ColorButton _red,_green,_blue,_yellow,_white,
						_cyan,_pink,_magenta, _orange;
	private ClearButton _clear;
	
	
	public ColorButtonPanel(Colorable aPanel){
		super(new java.awt.GridLayout(0,1));
		_aPanel = aPanel;
		
		// creates button group
		javax.swing.ButtonGroup group = new javax.swing.ButtonGroup();
		
		// defines the buttons
		_red = new ColorButton(Color.RED, "Red", _aPanel, group, false);
		_green = new ColorButton(Color.GREEN, "Green", _aPanel, group, false);
		_blue = new ColorButton(Color.BLUE, "Blue", _aPanel, group, false);
		_yellow = new ColorButton(Color.YELLOW, "Yellow", _aPanel, group, false);
		_white = new ColorButton(Color.WHITE, "White", _aPanel, group, false);
		_cyan = new ColorButton(Color.CYAN, "Cyan", _aPanel, group, false);
		_pink = new ColorButton(Color.PINK, "Pink", _aPanel, group, false);
		_magenta = new ColorButton(Color.MAGENTA, "Magenta", _aPanel, group, false);
		_orange = new ColorButton(Color.ORANGE, "Orange", _aPanel, group, false);
		_clear = new ClearButton(_aPanel);
		
		// sets the buttons in two seprate rows
		javax.swing.JPanel colorRow = new javax.swing.JPanel();
		javax.swing.JPanel clearRow = new javax.swing.JPanel();
		colorRow.add(_red);
		colorRow.add(_orange);
		colorRow.add(_yellow);
		colorRow.add(_green);
		colorRow.add(_blue);
		colorRow.add(_cyan);
		colorRow.add(_pink);
		colorRow.add(_magenta);
		colorRow.add(_white);
		
	
		
		
		clearRow.add(_clear);
		this.add(colorRow);
		this.add(clearRow);
	
	
		
		
}
}
