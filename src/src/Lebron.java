package src;

import processing.core.PApplet;
import processing.core.PImage;

public class Lebron {
	private final static int NORMAL=1;
	private final static int FROZEN=2;
	private final static int INVISIBLE=3;
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
	/** Method for drawing lebron in the different ways required<br>
	
	<b> pre: </b> <br>
	<b> post: </b> Lebron is drawn correctly<br>
	@param lbjLeft, left facing image of lebron
	@param lbjRight, right facing image of lebron
	@param lbjUp, up facing image of lebron
	@param lbjDown, down facing image of lebron
	@param lbjFrozen, frozen image of lebron
	@param movement, integer representing where lebron is moving
	*/
	
	public void draw(PImage lbjLeft,PImage lbjRight,PImage lbjDown,PImage lbjUp, PImage lbjFrozen, int movement) {
		if(status==FROZEN) {
			app.noTint();
			app.image(lbjFrozen,posX, posY, size, size);
		}else if(status==INVISIBLE){
			app.tint(255, 128);
			switch(movement) {
			case UP:				
				app.image(lbjUp,posX, posY, size, size);
				break;
			case DOWN:				
				app.image(lbjDown,posX, posY, size, size);
				break;
			case LEFT:				
				app.image(lbjLeft,posX, posY, size, size);
				break;
			case RIGHT:				
				app.image(lbjRight ,posX, posY, size, size);
				break;
			}
		}else{
			app.noTint();
			switch(movement) {
			case UP:
				app.image(lbjUp,posX, posY, size, size);
				break;
			case DOWN:
				app.image(lbjDown,posX, posY, size, size);
				break;
			case LEFT:
				app.image(lbjLeft,posX, posY, size, size);
				break;
			case RIGHT:
				app.image(lbjRight ,posX, posY, size, size);
				break;
			
			}
		}
	
		
	}
	
/** Method for moving lebron <br>
	
	<b> pre: </b> <br>
	<b> post: </b> Lebron moves<br>
	@param dir, integer representing the direction lebron is moving to
	
	*/
	public void move(int dir) {
		if(status!=FROZEN) {
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
			
		
	}
	
	/** Method for teleporting lebron  <br>
	
	<b> pre: </b> <br>
	<b> post: </b> Lebron teleports<br>
	
	*/
	public void teleportLeft() {
		matX=19;
		posX=760;
	}
	
	/** Method for teleporting lebron  <br>
	
	<b> pre: </b> <br>
	<b> post: </b> Lebron teleports<br>
	
	*/
	public void teleportRight() {
		matX=0;
		posX=0;
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
	
	public int getMatX() {
		return matX;
	}

	public void setMatX(int matX) {
		this.matX = matX;
	}

	public int getMatY() {
		return matY;
	}

	public void setMatY(int matY) {
		this.matY = matY;
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
