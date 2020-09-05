package src;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class PowerUp {
	private int posX;
	private int posY;
	private int size;
	private boolean used;
	private PApplet app;
	
	public PowerUp(PApplet app,int posX,int posY) {
		this.app=app;
		this.posX=posX;
		this.posY=posY;
		size=40;
		used=false;
	}

	public abstract void draw(PImage power);
	
	public PApplet getApp() {
		return app;
	}
	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getSize() {
		return size;
	}

	
	
}
