package tankgame;

import java.util.Vector;

public class Wood extends Barrier{
boolean isLive =true;
Vector<Wood> woods= new Vector<>();

	public Vector<Wood> getWoods() {
	return woods;
}
public void setWoods(Vector<Wood> woods) {
	this.woods = woods;
}
public void setIsLive(boolean state) {
	this.isLive=state;
}
	public Wood(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public boolean getIsLive() {
		return isLive;
	}
}

