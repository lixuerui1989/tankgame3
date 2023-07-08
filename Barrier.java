package tankgame;


public class Barrier {
private int x;
private int y;
private int size=40;
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public Barrier(int x, int y) {
	super();
	this.x = x;
	this.y = y;
}
public int getSize() {
	return size;
}
}
