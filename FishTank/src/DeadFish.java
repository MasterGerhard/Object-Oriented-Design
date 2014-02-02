// CSE1102 HW06
// Fall 2012
// Steven Gerhard
// Subclass of Fish
// Models a dead fish that floats at the top of the tank
public class DeadFish extends Fish implements Mover{
	private int _changeX; // attributes
	private int _changeY;
	// constructor
	public DeadFish(SmartRectangle aRectangle){
		super(java.awt.Color.BLACK, aRectangle,0, -1, .8);
		_changeX = 0;
		_changeY = -1;
		this.setLocation(this.getMinBoundX() + 50, this.getMaxBoundY()+100);
	}
	// move method
	 public void move() {
			int nextX = (int)this.getX() + _changeX;
			int nextY = (int)this.getY() + _changeY;
			
			if (_changeY < 0 && nextY <= this.getMinBoundY()){
				    _changeY = 2;
				    this.setRotation(-(Math.PI)/6);
				}
			
			if (_changeY > 0 && nextY >= this.getMinBoundY()+5){
				this.setRotation((Math.PI)/6);
				_changeY = -1;
				}
					
			 if (nextY >= this.getMaxBoundY()){
			    _changeY = -1;
			}
		
			this.setLocation(nextX, nextY);			
	    }
 	
	 
}
