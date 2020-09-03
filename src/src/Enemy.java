package src;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Enemy {
	private int posX;
	private int posY;
	private int matX;
	private int matY;
	private int vel;
	private int size;
	private int r;
	private PApplet app;


	public Enemy(PApplet app,int posX,int posY) {
		this.app=app;
		this.posX=posX;
		this.posY=posY;
		this.matX= posX/40;
		this.matY= posY/40;
		vel=40;
		size=40;
		r=1;

	}

	public void move(int[][]map) {
		switch(r) {
		case 1:
			randomUp(map);
			break;
		case 2: 
			randomDown(map);
			break;
		case 3:
			randomRight(map);
			break;
		case 4:
			randomLeft(map);
			break;


		}
	}

	private void randomUp(int[][] map) {
		if (this.matY + 1 < 15 && (map[this.matY + 1][this.matX] == 0
				|| map[this.matY + 1][this.matX] == 5 || map[this.matY + 1][this.matX] == 4)) {
			this.matY += 1;
			this.posY += this.vel;

		} else {
			this.r = (int)(app.random(1, 5));
		}
	}

	private void randomDown(int[][] map) {
		if (this.matY - 1 < -1 && (map[this.matY - 1][this.matX] == 0
				|| map[this.matY - 1][this.matX] == 5 || map[this.matY - 1][this.matX] == 4)) {
			this.matY -= 1;
			this.posY -= this.vel;

		} else {
			this.r = (int)(app.random(1, 5));
		}
	}
	
	private void randomRight(int[][] map) {
		if (this.matX + 1 < 20 && (map[this.matY][this.matX+1] == 0
				|| map[this.matY][this.matX+1] == 5 || map[this.matY ][this.matX+1] == 4)) {
			this.matX += 1;
			this.posX += this.vel;

		} else {
			this.r = (int)(app.random(1, 5));
		}
		
	}
	
	public void randomLeft(int [][] map) {
		if (this.matX - 1 < -1 && (map[this.matY ][this.matX- 1] == 0
				|| map[this.matY ][this.matX- 1] == 5 || map[this.matY ][this.matX- 1] == 4)) {
			this.matX -= 1;
			this.posX -= this.vel;

		} else {
			this.r = (int)(app.random(1, 5));
		}
	}
	public abstract void draw(PImage image);

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

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

}
