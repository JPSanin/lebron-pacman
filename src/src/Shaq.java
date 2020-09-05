package src;

import processing.core.PApplet;
import processing.core.PImage;

public class Shaq extends Enemy{
	
	public Shaq(PApplet app,int posX, int posY) {
		super(app,posX,posY);
	}

	@Override
	public void draw(PImage image) {
		getApp().noTint();
		getApp().image(image, getPosX(), getPosY(), getSize(),getSize());
	}

}
