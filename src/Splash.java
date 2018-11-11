import java.awt.Graphics2D;
import java.awt.SplashScreen;

import javax.swing.JWindow;

public class Splash extends JWindow {
	public static void drawSplashFrame() {
		
	}
    public Splash() {
    	 final SplashScreen sp=SplashScreen.getSplashScreen();
    	 if(sp==null) {
    		 System.out.println("Loading failed" );
    		 return;
    	 }
    	 Graphics2D gr=(Graphics2D)sp.createGraphics();
    }
}
