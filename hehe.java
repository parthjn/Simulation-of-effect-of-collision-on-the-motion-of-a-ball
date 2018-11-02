import java.util.*;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
 class Test //implements ActionListener 
{

    
 
 //static JButton b1;
 //static JFrame f;
//static JTextField t1; 

/*Test()
{
    f=new JFrame("Welcome");

  t1=new JTextField("Welcome to our application");
  b1=new JButton("Proceed");
  t1.setBounds(140,50,300,50);
  b1.setBounds(220,400,140,50);
  Font font = new Font("Verdana", Font.BOLD, 18);
  Font font1 = new Font("Verdana", Font.ITALIC, 18); 
  t1.setFont(font);
  //b1.setFont(font1);
  b1.addActionListener(this);
  t1.setBackground(Color.yellow);
  //b1.setBackground(Color.green);
  f.add(t1);
  f.add(b1);
   t1.setEditable(false);
  f.setSize(600,600);
  
  f.setLayout(null);
  f.setVisible(true);
  f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        
        

} */ 

    public static void main(String... args)
    {

        new ball();       
    }


/*public void actionPerformed(ActionEvent e)
   {

    
        if(e.getSource()==b1)
        {  
            new ball();      
        }  

        
        

   }*/

    
}

/*class hy{

    hy()
    {
        new ball();
    }
}*/


 class ball{


   JFrame frame;
    panel dp;

    private static int x = 40;
    private static int y = 20;

    boolean up = false;
    boolean down = true;


    ball()
    {
        frame = new JFrame("Test");
        

        dp = new panel();

        frame.getContentPane().add(BorderLayout.CENTER, dp);

        frame.setResizable(false);
        frame.setSize(600, 600);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        motion();
    }


    public void motion()
    {   int p=1;
        while (true)
        {int f=20*p;
            
            if (y >= 591)
            {   p=p+3;
                up = true;
                down = false;
            }
            if (y <= 20*p)
            {
                up = false;
                down = true;
            }
            if(f>=585)
                {x=40;
                y=585;
                break;}
            if (up) y=y-1;
            if (down) y=y+1;
        
            try
            {
                Thread.sleep(2);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            frame.repaint();
        }
    }
   
   public static int retx()
   {
    return(x);
   }


   public static int rety()
   {
    return(y);
   }


 }




    class panel extends JPanel
    {
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g)
        {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
           
            g.setColor(Color.RED);
            g.fillOval(ball.retx(),ball.rety(), 16, 16);
        }
    }


class welcome implements ActionListener{
 
 JButton b1;
 JFrame f;
JTextField t1;
welcome()
{
f=new JFrame("Welcome");

  t1=new JTextField("Welcome to our application");
  b1=new JButton("Proceed");
  t1.setBounds(140,50,300,50);
  b1.setBounds(220,400,140,50);
  Font font = new Font("Verdana", Font.BOLD, 18);
  Font font1 = new Font("Verdana", Font.ITALIC, 18); 
  t1.setFont(font);
  //b1.setFont(font1);
  b1.addActionListener(this);
  t1.setBackground(Color.yellow);
  //b1.setBackground(Color.green);
  f.add(t1);
  f.add(b1);
   t1.setEditable(false);
  f.setSize(600,600);
  
  f.setLayout(null);
  f.setVisible(true);
  f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);



}

public void actionPerformed(ActionEvent e)
   {

    
        if(e.getSource()==b1)
        {  
            new ball();      
        }  

        
        

   }




}