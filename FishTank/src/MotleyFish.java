import java.awt.Color;
import java.util.Random;
//CSE1102 HW06
//Fall 2012
//Steven Gerhard
// Subclass of Fish
// Creates a Fish with random Tail color

public class MotleyFish extends Fish implements Mover{

	
	public MotleyFish(java.awt.Color aColor,
                SmartRectangle aRectangle,int MOVE_LEN, int MOVE_WID, double size){
		super(aColor,aRectangle,MOVE_LEN,MOVE_WID,size);
		super.setBodyColor(aColor);
		super.setTailColor(randColor());
	}


public static java.awt.Color randColor(){
    Random r = new Random();
	Color  c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
	
	return c;
}
}