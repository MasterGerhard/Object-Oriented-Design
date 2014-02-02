
// CSE1102 HW 07
// Fall 2012
// Steven Gerhard

// Creates a panel that adds pegs in an offset grid when clicked on
public class LitePanel extends javax.swing.JPanel implements Colorable{
	
		private final int DIAMETER = 18;// attributes
		private final int WINDOW_WIDTH = 660;
		private final int WINDOW_HEIGHT = 370;
		private int _numPegs; // array length
		private int _i; // next peg location
		private boolean _PegSelected;
		private LitePanel _container;// components
		private java.awt.Color _saveColor;
		private SmartEllipse[] _Pegs; 

		public LitePanel () {
			super();
			this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			this.setBackground(java.awt.Color.BLACK);
			_container = this;
			_numPegs = 0;
			_i = 0;
			_Pegs = new SmartEllipse[_numPegs];
			_PegSelected = false;
			// creates the array of pegs of size 0
			
			this.addMouseListener(new MyMouseListener());
		}
			
		// gets selected color
		public java.awt.Color getColor(){
			return _saveColor;
		}
		
		//sets selected color
		public void setColor(java.awt.Color aColor){
			_saveColor = aColor;
			_PegSelected = true;
		}
		public void addPeg(){
			_numPegs++;
		}
		
		public void removePeg(){
			_numPegs--;
		}
		
		public void countPeg(){
			_i++;
		}
		
		public void uncountPeg(){
			_i--;;
		}
		
		//inner class controls the mouse methods for the grid of pegs
		// click on blank location new peg is added of selected color
		// click on a peg and it will be removed
		public class MyMouseListener extends java.awt.event.MouseAdapter {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				
				boolean isPeg = false;
					for (int i = 0; i < _i && !isPeg; i++){
						if(_Pegs[i].contains(e.getPoint())){
							_container.removePeg();
							_Pegs = shrinkArray(_Pegs,i);
							isPeg = true;
							_container.uncountPeg();
							_container.repaint();	
						}
					}
						 if (_PegSelected && !isPeg){
							_container.addPeg();
							_Pegs = growArray(_Pegs);
							int	diffX = e.getPoint().x % 20;
							int diffY = e.getPoint().y % 20;
							int col = e.getPoint().x - diffX;
							int row = e.getPoint().y - diffY;
								if (col % 40 == 0) {
									 _Pegs[_i] = new SmartEllipse(col,row,_container);
									} 
									else {
									_Pegs[_i] = new SmartEllipse(col,row+5,_container);
									}
					
							_Pegs[_i].setSize(DIAMETER,DIAMETER);
							_Pegs[_i].mouseClicked(e);
							_container.countPeg();
						}
					}
			}
		
			
		// clears the grid of pegs and resets the arrays
		public void clearPegs(){
			_numPegs = 0;
			_i = 0;
			this.shrinkArray(_Pegs,0);
			this.repaint();
		}
			
		// method for shrinking an array by 1
		// keeps all array objects except for the 1 specified
		public SmartEllipse[] shrinkArray(SmartEllipse array[], int pegLocation){
			SmartEllipse newArray[] = new SmartEllipse[_numPegs];
		
			for(int i = 0 ; i < pegLocation ; i++){
					newArray[i] = array[i];
			}
			for(int i = pegLocation; i < _numPegs; i++){
				newArray[i]= array[i+1];
			}
					return (newArray);
		}

		// method for expanding an array by 1
		public SmartEllipse[] growArray(SmartEllipse array[]){
			SmartEllipse newArray[] = new SmartEllipse[_numPegs];
			for(int i = 0 ; i < _numPegs -1 ; i++){
				newArray[i] = array[i];
		
			 }
			return (newArray);
			} 
		
		
		public void paintComponent (java.awt.Graphics aBrush) {
			super.paintComponent(aBrush);
			java.awt.Graphics2D pen = 
					(java.awt.Graphics2D) aBrush;
			for (int i = 0; i < _numPegs; i++)
				_Pegs[i].fill(pen);
				
			}
	
}
		
			
			
