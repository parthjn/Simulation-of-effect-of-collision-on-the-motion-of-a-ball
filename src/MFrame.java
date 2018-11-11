import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MFrame extends JFrame{
     private SliderPanel sliderpanel;
     private AnimationPanel anipanel;
     private Image back;
     private WindowStateListener l=new WindowStateListener() {

		@Override
		public void windowStateChanged(WindowEvent e) {
			anipanel.setWi(MFrame.this.getWidth());
			anipanel.setHe(MFrame.this.getHeight());
			//repaint();
			System.out.println("yo");
			
		}
    	 
     };
     public MFrame() {
    	 super("Ball Motion Simulation");
    	 setLayout(new BorderLayout());
    	 setLocationRelativeTo(null);
    	 try {
    		 //BufferedImage img=ImageIO.read(new File("Background/bb.png"));
    	     
    		 //BufferedImage myPicture = ImageIO.read(new File("/Background/bb.png"));
    		 //JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    		 //add(picLabel);
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }
    	 //back=new Background();
    	 obtainImage();
    	 add(new JLabel(new ImageIcon("/Background/bb.png")),BorderLayout.EAST);
    	 sliderpanel=new SliderPanel();
    	 anipanel=new AnimationPanel();
    	 
    	 sliderpanel.setl(new cueL() {

			@Override
			public void start() {
				anipanel.startAnimation();
				
			}
    		 
    	 });
    	 sliderpanel.setEEvent(new RestitutionEventListener() {

			@Override
			public void restitutionEventOccurred(RestitutionEvent ev) {
				double e=ev.getE();
				double height=ev.getHeight();
				if(anipanel.isOnce()) {
					anipanel.setE(e);
					anipanel.setY1(height);
					anipanel.setOnce(true);
				}
				else
					anipanel.setE(e);
				
			}
    		 
    	 });
    	 setLayout(new BorderLayout());
    	 makeMenu();
    	  
    	 //addWindowStateListener(this);
    	 add(sliderpanel,BorderLayout.SOUTH);
    	 add(anipanel,BorderLayout.CENTER);
    	 setSize(600,400);
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 setMinimumSize(new Dimension(400,300));
    	 //setSize(601,401);
    	 
    	 setSize(600,400);
    	 
    	 setVisible(true);
    	 //setSize(601,401);
     }
     private void obtainImage() {
    	
    		 back=new ImageIcon("/Background/bb.png").getImage();
    	     if(back==null)
    	    	 System.out.println("yo");
    
    		 repaint();
    	
    	 
	
	}
   /* public void paint(Graphics g) {
    	//super.paint(g);
    	g.drawImage(back,0,0,null);
    }*/
    
     
	public void makeMenu() {
    	 JMenuBar jmb=new JMenuBar();
    	 
    	 JMenu file=new JMenu("File");
    	 JMenuItem exit=new JMenuItem("Exit");
         exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
        	 
         });
    	 
    	 file.add(exit);
    	 jmb.add(file);
    	 add(jmb,BorderLayout.NORTH);
    	 
     }
}
