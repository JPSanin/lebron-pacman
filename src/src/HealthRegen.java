package src;

import processing.core.PApplet;
import processing.core.PImage;

public class HealthRegen extends PowerUp {
	
	public HealthRegen (PApplet app, int posX, int posY) {
		super(app, posX,posY);
	}

	@Override
	public void draw(PImage power) {
		getApp().image(power, getPosX(), getPosY(), getSize(),getSize());
	}

}
