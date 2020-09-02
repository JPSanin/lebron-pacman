package src;

import processing.core.PApplet;

public class Lebron {
	private final static int NORMAL=1;
	private final static int FROZEN=2;
	private final static int SLOWED=3;
	private final static int UP=1;
	private final static int DOWN=2;
	private final static int LEFT=3;
	private final static int RIGHT=4;
	private int posX;
	private int posY;
	private int matX;
	private int matY;
	private int vel;
	private int size;
	private int acceleration;
	private int health;
	private int status;
	private PApplet app;
	
	public Lebron(PApplet app, int posX, int posY) {
		this.app=app;
		this.posX=posX;
		this.posY=posY;
		this.matX= posX/40;
		this.matY= posY/40;
		vel=40;
		size=40;
		acceleration=1;
		health=3;
		status=NORMAL;
	}
	
	public void draw() {
		app.fill(255,0,0);
		app.ellipse(posX, posY, size, size);
		
	}
	
	public void move(int dir) {
		if(status==FROZEN) {
			acceleration=0;
		}
			switch(dir) {
			case UP:
				moveUp();
				break;
			case DOWN:
				moveDown();
				break;
			case LEFT:
				moveLeft();
				break;
			case RIGHT:
				moveRight();
				break;
			}
		
	}
	
	private void moveUp() {
        this.posY-= this.vel*this.acceleration;
        matY-=1;
	}
	private void moveDown() {
        this.posY+= this.vel*this.acceleration;
        matY+=1;
	}
	private void moveLeft() {
        this.posX-= this.vel*this.acceleration;
        matX-=1;
	}
	private void moveRight() {
        this.posX+= this.vel*this.acceleration;
        matX+=1;
	}
	
	public void loseHealth() {}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
