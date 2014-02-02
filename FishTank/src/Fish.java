/**
 * Chapter 7: Fish.java
 * Models a fish in a fish tank.
 */

// CSE1102 HW06
// Fall 2012
// Steven Gerhard
// Fish
// Creates a composite object that models a fish
// Has a move method

import java.util.Random;

public class Fish implements Mover {
    private double BODY_WIDTH; // attributes
    private double TAIL_WIDTH;
    private double FISH_WIDTH; 
    private double FISH_HEIGHT; 
    private int _changeX, _changeY; 
    private double _rotation;
    private SmartEllipse _body; // components
    private SmartArc _tail;
    private SmartRectangle _tank; // peer object
    //constructor
    public Fish(java.awt.Color aColor,
                SmartRectangle aRectangle,int MOVE_LEN, int MOVE_WID, double size ){
	super();
	_changeX = MOVE_LEN;
	_changeY = MOVE_WID;
	_rotation = 0;
	_body = new SmartEllipse(aColor);
	_tail = new SmartArc(90, 180,java.awt.geom.Arc2D.PIE, aColor);
	_tank = aRectangle;
	BODY_WIDTH = 34 *size;
	TAIL_WIDTH = 12 *size;
	FISH_WIDTH = (BODY_WIDTH + TAIL_WIDTH)-(size*5);
	FISH_HEIGHT = 20 *size;
	_body.setSize(BODY_WIDTH, FISH_HEIGHT);
	_tail.setSize(TAIL_WIDTH, FISH_HEIGHT); 
    }
    // sets tail color
    public void setTailColor(java.awt.Color aColor){
    	_tail.setFillColor(aColor);
    }
    // sets body color
    public void setBodyColor(java.awt.Color aColor){
    	_body.setFillColor(aColor);
    }
    // method that moves the fish in response to a movetimer
    public void move() {
			int nextX = (int)this.getX() + _changeX;
			int nextY = (int)this.getY() + _changeY;
			
			if (nextX <= this.getMinBoundX()) {
			    _changeX *= -1;
			    nextX = this.getMinBoundX();
			}
			else if (nextX >= this.getMaxBoundX()) {
			    _changeX *= -1;
			    nextX = this.getMaxBoundX();
			}
			if (nextY <= this.getMinBoundY()) {
			    _changeY *= -1;
			    nextY  = this.getMinBoundY();
			}
			else if (nextY >= this.getMaxBoundY()){
			    _changeY *= -1;
			    nextY = this.getMaxBoundY();
			}
		
			// calculates rotation
			double rot = Math.atan(_changeY*1.0/_changeX*1.0);
		
			if (_changeX < 0 && _changeY > 0){
				rot = Math.PI + Math.atan(_changeY*1.0/_changeX*1.0);
			}
			else if (_changeX < 0 && _changeY < 0){
				rot = Math.PI + Math.atan(_changeY*1.0/_changeX*1.0);
			}
				if (_changeX == 0){
						if(_changeY < 0) {
						rot = -Math.PI/2;
						}
						else if(_changeY > 0){
						rot = Math.PI/2;
						}
					}
				if (_changeY == 0){
						if(_changeX < 0) {
							rot = Math.PI;
						}
						else if(_changeY > 0){
							rot = -Math.PI;
						}
				}
			
			this.setRotation(rot);
			this.setLocation(nextX, nextY);			
	    }
    	
    	
    
    
    // sets x speed
    	public void setSpeedX(int x) {
    		_changeX = x;
    	}
    	// sets y speed
    	public void setSpeedY(int y) {
    		_changeY = y;
    	}
    	// returns the x speed
    	public int getSpeedX(){
    		return _changeX;
    	}
    	// returns the y speed
    	public int getSpeedY(){
    		return _changeY;
    	}
    	
	    public int getMinBoundX() {
		return (int) _tank.getX();
	    }
	    
	    public int getMaxBoundX() {
	    	
	    	
	    	return (int) (_tank.getX() + _tank.getWidth()
			      - FISH_WIDTH);
	    }
	  
	    public int getMinBoundY() {
		return (int) _tank.getY();
	    }
	    
	    public int getMaxBoundY() {
		return (int) (_tank.getY() + _tank.getHeight()
			      - FISH_HEIGHT);
	    }
	    // sets Location
	    public void setLocation (int x, int y) {
		_body.setLocation(x+5, y);
		_tail.setLocation(x, y);
	    }
	   // returns fish location
	    public int getX () {
		return (int) _tail.getX();
	    }
	  // returns fish location
	    public int getY() {
		return (int) _tail.getY();
	    }
   
	    // sets the rotation
	public void setRotation (double aNumberDegrees) {
	_rotation = aNumberDegrees;
    }
   
	public double getCenterX () {
	return this.getX() + FISH_WIDTH/2;
    }
    public double getCenterY () {
	   return this.getY() + FISH_HEIGHT/2;
    }

    public void fill (java.awt.Graphics2D aBrush){
	aBrush.rotate(_rotation, 
                  this.getCenterX(),this.getCenterY());
	_body.fill(aBrush);
	_tail.fill(aBrush);
	aBrush.rotate(-_rotation, 
                  this.getCenterX(),this.getCenterY());
    }
    public void draw (java.awt.Graphics2D aBrush){
	aBrush.rotate(_rotation, 
                  this.getCenterX(),this.getCenterY());
	_body.draw(aBrush);
	_tail.draw(aBrush);
	aBrush.rotate(-_rotation, 
                  this.getCenterX(),this.getCenterY());
    }
}
