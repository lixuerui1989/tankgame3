package tankgame;

import java.util.Vector;

public class Metal extends Barrier{
boolean isLive =true;
Vector<Metal>metals= new Vector<>();
public Metal(int x, int y) {
	super(x, y);
	// TODO Auto-generated constructor stub
}

	public Vector<Metal> getMetals() {
	return metals;
}
public void setMetals(Vector<Metal> matels) {
	this.metals = metals;
}
public void setIsLive(boolean state) {
	this.isLive=state;
}
	
	public boolean getIsLive() {
		return isLive;
	}
}


