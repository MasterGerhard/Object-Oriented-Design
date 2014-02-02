/**
 * Chapter 7: FishPanel.java
 * The JPanel in which the fish tank and fish are displayed.
 */
// CSE1102 HW06
// Fall 2012
// Steven Gerhard
// FishPanel
// Creates a JPanel that displays multiple fish moving within a rectangle
public class FishPanel extends javax.swing.JPanel implements Mover {
    private final int TANK_X = 75; // attributes
    private final int TANK_Y = 75;
    private final int TANK_WIDTH = 400;
    private final int TANK_HEIGHT = 300;
    private final int INTERVAL = 100;
    private SmartRectangle _tank; // components
    private Fish _redfish,_bluefish,_onefish,_deadfish,_greenfish;
    private Snail _snail;
    private MoveTimer _timer;
 
    //constructor
    public FishPanel () {
	super();
	_tank = new SmartRectangle(java.awt.Color.blue);
	_deadfish = new DeadFish(_tank);
	_redfish = new MotleyFish(java.awt.Color.YELLOW, _tank, 20, 10, 1);
	_onefish = new Fish(java.awt.Color.white, _tank, 15, 15,.8);
	_bluefish = new MotleyFish(java.awt.Color.cyan, _tank, 7,7,.9);
	_greenfish = new MotleyFish(java.awt.Color.green, _tank, 20,20, .85);
	_snail = new Snail(java.awt.Color.ORANGE, _tank);
	_timer = new MoveTimer(INTERVAL, this);
	this.setBackground(java.awt.Color.white);
	_tank.setBorderColor(java.awt.Color.black);
	_tank.setLocation(TANK_X, TANK_Y);
	_tank.setSize(TANK_WIDTH, TANK_HEIGHT);
	_deadfish.setLocation(TANK_X + (TANK_HEIGHT/2)-30, TANK_Y + TANK_HEIGHT - 30);
	_redfish.setLocation(0,0);
	_onefish.setLocation(75, 200);
	_bluefish.setLocation(100,100);
	_greenfish.setLocation(120,75);
	_snail.setLocation(TANK_X,TANK_Y + TANK_HEIGHT - 21);
	_timer.start();
    }
    // move method
    public void move() {
	_deadfish.move();
	_redfish.move();
	_onefish.move();
	_snail.move();
	_bluefish.move();
	_greenfish.move();
	this.repaint();
    }
    
    public void paintComponent(java.awt.Graphics aBrush){
	super.paintComponent(aBrush);
	java.awt.Graphics2D betterBrush = 
	    (java.awt.Graphics2D) aBrush;
	_tank.fill(betterBrush);
	_tank.draw(betterBrush);
	_deadfish.fill(betterBrush);
	_redfish.fill(betterBrush);
	_onefish.fill(betterBrush);
	_snail.fill(betterBrush);
	_bluefish.fill(betterBrush);
	_greenfish.fill(betterBrush);
    }
}
