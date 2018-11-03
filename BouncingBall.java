import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
class BouncingBall extends JPanel implements ActionListener {
  Timer t = new Timer(1,this);
  double x = 230,y = 0;
  double acc = 10;
  double u = 0,v = 0;
  double ti = 0,start = 0;
  boolean temp = false;  
  int i = 0;
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    Ellipse2D.Double circle = new Ellipse2D.Double(x,y,40,40);
    g2.fill(circle);
    t.start();
  }
  public void actionPerformed(ActionEvent e){
    if(y > 720 )
    {
        temp = true;
        u = v;
        v = 0;
        start = 720;
        i = 0;
        ti = 0;
        acc = -acc;
    }
    else if(y < 0)
    {
        temp = false;
        u =0;
        ti = 0;
        start = 0;
        v = 0;
        acc = -acc;
    }
    if(temp == false)
    {
        ti += 0.01;
        y =start + u*ti + (0.05)*acc*(ti)*ti;
        v = u + acc*ti;
    }
    else if(temp = true)
    {
        ti += 0.001;
        u -= 0.045;
        y = start -(u*ti + (0.5)*acc*(ti)*ti);
    }
    //System.out.printf("%f\n",v);
    repaint();
  }
}
class Temp{
  public static void main(String[] args) {
    new Start();
  }
}

class Start implements ActionListener{
  JFrame f;
  JButton b;
  Start(){
    f = new JFrame("WINDOW");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(null);
    b = new JButton("START");
    b.setBounds(100,100,200,50);
    f.add(b);
    f.setBounds(100,100,400,400);
    f.setVisible(true);
    b.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == b)
    {
      f.dispose();
      JFrame fa = new JFrame("moving ball");
      fa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fa.add(new BouncingBall());
      fa.setSize(500,800);
      fa.setVisible(true);
    }
  }
}