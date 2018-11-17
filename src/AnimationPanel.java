import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener{
	private Timer t1;
	private double e;
	private double y1,h;
	private double u,v;
    private boolean once;
    private double Wi,He;
    private static double k=50.0,g=0.01;
    private double totalTime;
    private int touchdown;
    private boolean pauseFlag;
    private final double gravity=0.001;
    private boolean temp;
    public AnimationPanel() {
    	h=0;
    	t1=new Timer(1,this);
    	e=1.0;
    	y1=0;
    	once=false;
    	totalTime=0.0;
    	u=0;
    	v=0;
    	Wi=600;
    	He=400;
    	touchdown=0;
    	pauseFlag=false;
    	temp=false;
    	setSize(300,200);
    }
	public void startStopAnimation() {
	    if(!pauseFlag) {
	    	t1.start();
	    	pauseFlag=true;
	    }
	    else {
	    	t1.stop();
	    	pauseFlag=false;
	    }
	}
	public void setWi(double wi) {
		Wi=wi;
	}
	public void setHe(double he) {
		He=he;
	}
	public boolean isOnce() {
		return once;
	}
	public void setOnce(boolean once) {
		this.once = once;
	}
   
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.fillOval((int)(0.6*Wi),(int)y1,30,30);		
		//g2.drawString(e+"", 121, 211);
		g2.drawLine((int)(0.6*Wi), 280,(int)(0.8*Wi), 280);
	}
	public int calTime() {
		return 0;
	}
	private ActionListener ac=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(y1>200) {
				temp=true;
				y1=720;
				v=v*e;
			}
			else if(v<=0||y1<=0) {
				temp=false;
			}
			if(temp==false) {
				v+=gravity;
				y1+=v;
			}else if(temp==true) {
				v-=gravity;
				y1-=v;
			}
			repaint();
		}
		
	};
	public void setE(double e) {
		this.e = e;
		//repaint();
	}
	public double getY1() {
		return y1;
	}
	public void setY1(double y1) {
		this.y1 = y1;
		repaint();
	}
	public void caltime() {
		
	}
	public void setH(double h) {
		this.h=h;
		repaint();
	}
	public boolean getFlag() {
		return pauseFlag;
	}
	public void restartAnimation() {
		y1=0+h;
		u=0;
		repaint();
		if(pauseFlag)
		  t1.restart();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

			if(y1>250) {
				temp=true;
				y1=250;
				v=v*e;
			}
			else if(v<=0) {
				temp=false;
			}
			if(temp==false) {
				v+=gravity;
				y1+=v;
			}else if(temp==true) {
				v-=gravity;
				y1-=v;
			}
			repaint();
			
	}

}
