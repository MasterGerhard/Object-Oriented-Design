// CSE1102 HW 07
// Fall 2012
// Steven Gerhard

// button that sends clear message
public class ClearButton extends javax.swing.JButton {

	private String _colorName;
	private Colorable _colorable; //peer object
	
	public ClearButton(Colorable aColorable){
		
		super("Clear All Pegs");
		_colorable = aColorable;
		this.setBackground(java.awt.Color.GRAY);
		this.addActionListener(new ClearListener());
	
	}
	
	// sends clearmessage when clicked
	private class ClearListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
			_colorable.clearPegs();
		}
	}
	public String getColorName(){
		return _colorName;
	}
}
