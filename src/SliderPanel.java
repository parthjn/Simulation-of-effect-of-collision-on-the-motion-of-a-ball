import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderPanel extends JPanel{
    private JSlider eSlider;
    private JSlider heightSlider;
    private JLabel restitution;
    private JLabel height;
    private JTextField e;
    private JTextField h;
    private RestitutionEventListener el;
    private JButton pause;
    private JButton restart;
    private cueL al;
    private int count=0;
    public SliderPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        restitution =new JLabel("Coefficient of restitution  : ");
        eSlider =new JSlider(JSlider.HORIZONTAL);
        height=new JLabel("Height :");
        e=new JTextField("0.5",5);
        h=new JTextField("50",5);
        pause=new JButton("Play");
        restart=new JButton("Rsetart");
        count=0;
        pause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				al.start();
				count=1;
			}
			
        	
        });
        restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				al.restart();
				
			}
        	
        });
        
        setSize(600,300);
        Border inner=BorderFactory.createTitledBorder("Set Parameters");
        Border outer=BorderFactory.createEmptyBorder(5, 30, 5, 30);
        setBorder(new CompoundBorder(outer,inner));
        
        heightSlider=new JSlider(JSlider.HORIZONTAL);
        
        gc.gridx=0;
        gc.gridy=0;
        gc.weightx=1;
        gc.weighty=1;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.CENTER;
        
        

        
        eSlider.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent ev) {
        		e.setText(eSlider.getValue()/100.0+"");
        		
        			RestitutionEvent event=new RestitutionEvent(this,Double.parseDouble(e.getText()),Double.parseDouble(e.getText()));
        			
        		if(el!=null)
        			el.restitutionEventOccurred(event);
        	}
        });
        heightSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent ev) {
				h.setText(heightSlider.getValue()+"");
				RestitutionEvent event=new RestitutionEvent(this,Double.parseDouble(e.getText()),Double.parseDouble(h.getText()));
				if(el!=null)
					el.restitutionEventOccurred(event);
			}
        	
        });
        add(pause,gc);
        
        gc.gridx=1;
        gc.gridy=0;
        gc.anchor=GridBagConstraints.LINE_END;
        add(restitution,gc);
        
        gc.gridx=2;
        gc.gridy=0;
        gc.anchor=GridBagConstraints.LINE_START;
        add(e,gc);
        
        gc.gridx=1;
        gc.gridy=1;
        gc.anchor=GridBagConstraints.ABOVE_BASELINE_TRAILING;
        add(eSlider,gc);
        
        
        final int jh=89;
        
        gc.gridx=0;
        gc.gridy=2;
        gc.anchor=GridBagConstraints.CENTER;
        add(restart,gc);
        
        gc.gridx=1;
        gc.gridy=2;
        gc.weightx =5;
        gc.weighty=5;
        gc.anchor=GridBagConstraints.EAST;
        add(height,gc);
        
        //gc.gridx=1;
        //gc.gridy=0;
        //gc.anchor=GridBagConstraints.LINE_START;
        
        gc.gridx=2;
        gc.gridy=2;
        gc.anchor=GridBagConstraints.LINE_START;
        add(h,gc);
        
        gc.gridx=1;
        gc.gridy=3;
        gc.anchor=GridBagConstraints.ABOVE_BASELINE_TRAILING;
        add(heightSlider,gc);
        
        
    }
    public void setl(cueL l) {
    	al=l;
    }
    public void setEEvent(RestitutionEventListener el) {
    	this.el=el;
    }
    public void changeButton(boolean pauseFlag) {
    	if(!pauseFlag)
    		pause.setText("Play");
    	else
    		pause.setText("Pause");
    }
	
}
