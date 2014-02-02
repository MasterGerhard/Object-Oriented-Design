// CSE1102 HW 07
// Fall 2012
// Steven Gerhard

import java.util.Random;
import java.awt.Color;

// Creates a smart ellipse that knows how to draw itself
// and has mouseClicked methods to be created with various colors

public class SmartEllipse extends java.awt.geom.Ellipse2D.Double {
	private java.awt.Color _borderColor, _fillColor; // attributes
	private final int STROKE_WIDTH = 2;
	private LitePanel _panel;

	public SmartEllipse(int x, int y , LitePanel aPanel){ 
		_borderColor = Color.BLACK;
		_fillColor = Color.BLACK; // solid color to start
		_panel = aPanel;
		this.setLocation(x, y);
	}

	// methods not provided by Java
	
	public void setColor(java.awt.Color aColor){
		_borderColor = aColor;
		_fillColor = aColor;
	}
	
	public Color getColor(){
		return _fillColor;
	}
	

	// more readable versions of methods provided by Java
	public void setLocation (double x, double y) {
		this.setFrame (x, y, this.getWidth(), this.getHeight());
	}
	public void setSize (int aWidth, int aHeight) {
		this.setFrame(this.getX(), this.getY(), aWidth, aHeight);
	}

	public void fill (java.awt.Graphics2D aBetterBrush){
		java.awt.Color savedColor = aBetterBrush.getColor();
		aBetterBrush.setColor(_fillColor);
		aBetterBrush.fill(this); // paint a solid ellipse
		aBetterBrush.setColor(savedColor);
	}

	// sets color based on mouseMethod sent from container LitePanel
	public void mouseClicked(java.awt.event.MouseEvent e){
		
		this.setColor(_panel.getColor());
		_panel.repaint();
	}
	
	public void draw (java.awt.Graphics2D aBrush) {
		java.awt.Color savedColor = aBrush.getColor();
		aBrush.setColor(_borderColor);
		java.awt.Stroke savedStroke = aBrush.getStroke();
		aBrush.setStroke(new java.awt.BasicStroke(STROKE_WIDTH));
		aBrush.draw(this);
		aBrush.setStroke(savedStroke);
		aBrush.setColor(savedColor);
	}
}