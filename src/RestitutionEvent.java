import java.util.EventObject;

public class RestitutionEvent extends EventObject {
    private double e;
    private double height;
	public RestitutionEvent(Object source,double e,double height) {
		super(source);
		// TODO Auto-generated constructor stub
		this.e=e;
		this.height=height;
	}
	public double getE() {
		return e;
	}
	public void setE(double e) {
		this.e = e;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
   
}
