// CSE1102 HW 07
// Fall 2012
// Steven Gerhard

// extends radio buttons to create color buttons 
// able to select color of next peg added
public class ColorButton extends javax.swing.JRadioButton {
	private java.awt.Color _color;
	private String _colorName;
	private Colorable _colorable; //peer object
	
	public ColorButton(java.awt.Color aColor, 
			String aColorName, Colorable aColorable, 
				javax.swing.ButtonGroup aGroup, boolean isSelected){
		
		super(aColorName, isSelected);
		_color = aColor;
		_colorable = aColorable;
		this.setBackground(aColor); // make button display its color
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.addActionListener(new ColorListener());
		aGroup.add(this);
	}
	
	// sets color when clicked
	private class ColorListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
			_colorable.setColor(_color);
		}
	}
	public String getColorName(){
		return _colorName;
	}
}
