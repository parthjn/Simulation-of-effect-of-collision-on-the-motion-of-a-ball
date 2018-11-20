package com.company;
import java.awt.Graphics;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel{
     public void painComponent(Graphics g) {
    	 super.paintComponent(g);
    	 try {
    	 g.drawImage(ImageIO.read(new File("/home/aditya/Pictures/back.jpg")), 0,0,this);
    	 }catch(Exception e) {
    		 e.getStackTrace();
    	 }
    	 
     }
}
