package src;

public abstract class Enemy {
private int posX;
private int posY;
private int vel;
private int size;
private int dir;


public Enemy(int posX,int posY) {
	this.posX=posX;
	this.posY=posY;
	vel=5;
	size=40;
	dir=1;
	
}

public void move() {}
public abstract void draw();

}
