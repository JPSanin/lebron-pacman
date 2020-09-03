package src;

import processing.core.PApplet;
import processing.core.PImage;

public class Referee extends Enemy {

	public Referee(PApplet app,int posX, int posY) {
		super(app,posX,posY);
	}

	@Override
	public void draw(PImage image) {
		getApp().image(image, getPosX(), getPosY(), getSize(),getSize());
	}
}
