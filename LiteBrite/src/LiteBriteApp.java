// CSE1102 HW 07
// Fall 2012
// Steven Gerhard

// Creates a LiteBrite Simulation

public class LiteBriteApp extends javax.swing.JFrame{
	   	public LiteBriteApp (String title) {
			super(title);  
			this.setSize(710, 500);
			this.setBackground(java.awt.Color.WHITE);
			this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
			LitePanel litepanel = new LitePanel();
			ColorButtonPanel buttons = new ColorButtonPanel(litepanel);
			this.add(litepanel,java.awt.BorderLayout.CENTER);
			this.add(buttons, java.awt.BorderLayout.SOUTH);
			this.setVisible(true);
		    }
		 
		
		    public static void main (String [ ] args) {
			LiteBriteApp app = new LiteBriteApp("LiteBrite");
		    }
		    
		 
		  
	}

