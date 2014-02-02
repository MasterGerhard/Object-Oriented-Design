// CSE1102 HW06
// Fall 2012
// Steven Gerhard

// Creates a Snail
// Moves back and fort along bottom of tank

public class Snail implements Mover{

      private double BODY_DIAMETER; // attributes
	  private double HEAD_DIAMETER;
	  private double SNAIL_WIDTH; 
	  private double SNAIL_HEIGHT;
	  private int _changeX, _changeY; 
	  private double _rotation;
	  private SmartEllipse _body,_head; // components
	  private SmartRectangle _tank; // peer object
	  
	  public Snail(java.awt.Color aColor,SmartRectangle aRectangle){
			super();
			_changeX = 2;
			_changeY = 0; // snail swims horizontally
			_rotation = 0;
			_body = new SmartEllipse(aColor);
			_head = new SmartEllipse(java.awt.Color.BLACK);
			_tank = aRectangle;
			BODY_DIAMETER = 20;
			HEAD_DIAMETER= 12;
			SNAIL_WIDTH = (BODY_DIAMETER + HEAD_DIAMETER-5);
			SNAIL_HEIGHT = (BODY_DIAMETER);
			_body.setSize(BODY_DIAMETER, BODY_DIAMETER);
			_head.setSize(HEAD_DIAMETER, HEAD_DIAMETER); 
			this.setRotation(3*Math.PI/4);
		    }
		  
	  public void move() {
			int nextX = (int)this.getX() + _changeX;
			int nextY = (int)this.getY() + _changeY;
			
			
			if (nextX <= this.getMinBoundX()) {
			    _changeX *= -1;
			   this.setRotation(3*(Math.PI)/4);
			}
			else if (nextX >= this.getMaxBoundX()) {
			    _changeX *= -1;
			    this.setRotation(0);
			
			}
			
	
			this.setLocation(nextX, nextY);			
	    }
  	
	  public void setLocation (int x, int y) {
			_body.setLocation(x+5, y);
			_head.setLocation(x, y);
		    }
	 
	  public int getX () {
			return (int) _head.getX();
		    }
	  
	  public int getY() {
			return (int) _head.getY();
		    }
	 
	   public double getCenterX () {
	    	return this.getX() + SNAIL_WIDTH/2;
	        }
	  
	   public double getCenterY () {
		    return this.getY() + SNAIL_HEIGHT/2;
	        }
	   
	   public int getMinBoundX() {
			return (int) _tank.getX();
		    }
		   
	   public int getMaxBoundX() {
		    return (int) (_tank.getX() + _tank.getWidth()
				      - SNAIL_WIDTH);
		    }
		  
	   public int getMinBoundY() {
			return (int) _tank.getY();
		    }
		    
	   public int getMaxBoundY() {
			return (int) (_tank.getY() + _tank.getHeight()
				      - SNAIL_HEIGHT);
		    }
		
	  
	   public void setRotation (double aNumberDegrees) {
			_rotation = aNumberDegrees;
		    }
	 
	   public void fill (java.awt.Graphics2D aBrush){
	    	aBrush.rotate(_rotation, 
	                      this.getCenterX(),this.getCenterY());
	    	_body.fill(aBrush);
	    	_head.fill(aBrush);
	    	aBrush.rotate(-_rotation, 
	                      this.getCenterX(),this.getCenterY());
	        }
	      
	   public void draw (java.awt.Graphics2D aBrush){
	    	aBrush.rotate(_rotation, 
	                      this.getCenterX(),this.getCenterY());
	    	_body.draw(aBrush);
	    	_head.draw(aBrush);
	    	aBrush.rotate(-_rotation, 
	                      this.getCenterX(),this.getCenterY());
	        }
	  
}
