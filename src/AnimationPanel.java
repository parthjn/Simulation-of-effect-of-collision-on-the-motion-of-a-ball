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
	private double y1;
	private double u;
    private boolean once;
    private double Wi,He;
    private static double k=50.0,g=0.01;
    private double totalTime;
    public AnimationPanel() {
    	t1=new Timer(1,this);
    	e=1.0;
    	y1=50.0;
    	once=false;
    	totalTime=0.0;
    	u=0;
    	Wi=600;
    	He=400;
    }
	public void startAnimation() {
		t1.start();
	}
	public void setWi(double wi) {
		Wi=wi;
		repaint();
	}
	public void setHe(double he) {
		He=he;
		repaint();
	}
	public void pauseAnimation() {
		
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
		
		g2.drawString(e+"", 121, 211);
		g2.drawLine((int)(0.6*Wi), 200, 400, 200);
	}
	public int calTime() {
		return 0;
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		y1=k+u*1+g*1*1;
		u+=1*0.1;
		if(y1>170) {
			y1=170;
			u=-e*u;
			k=170;
			
		}
		repaint();
		
	}
	public double getE() {
		return e;
	}
	public void setE(double e) {
		this.e = e;
		repaint();
	}
	public double getY1() {
		return y1;
	}
	public void setY1(double y1) {
		this.y1 = y1;
	}

}
