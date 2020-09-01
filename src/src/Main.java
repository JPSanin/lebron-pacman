package src;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	PImage[] homescreens;
	PImage[] namescreens;

	private int screen;
	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(800, 600);
	}

	public void setup() {
		homescreens= new PImage[4];
		homescreens[0]=loadImage("images/HomeScreen1.png");
		homescreens[1]=loadImage("images/HomeScreenInfo.png");
		homescreens[2]=loadImage("images/HomeScreenInfoBig.png");
		homescreens[3]=loadImage("images/HomeScreenPlay.png");
		
		namescreens=new PImage[3];
		namescreens[0]=loadImage("images/NameScreen.png");
		namescreens[1]=loadImage("images/NameScreenGo.png");
		namescreens[2]=loadImage("images/NameScreenError.png");
		
		
		screen=0;
	}

	public void draw() {
		background(0);

		switch(screen) {

		case 0:
			image(homescreens[0],0,0,800,600);

			if (mouseX > 130 && mouseX < 380 && mouseY > 360 && mouseY < 420) {
				image(homescreens[1],0,0,800,600);
			}

			if (mouseX > 415 && mouseX < 665 && mouseY > 360 && mouseY < 420) {
				image(homescreens[3],0,0,800,600);
			}

			break;
		case 1:
			image(homescreens[2],0,0,800,600);
			break;
			
		case 2:
			image(namescreens[0],0,0,800,600);
			if (mouseX > 275 && mouseX < 525 && mouseY > 350 && mouseY < 410) {
				image(namescreens[1],0,0,800,600);
			}
			break;
		}
		fill(0);
		text("" + mouseX + "," + mouseY, mouseX, mouseY);
	}

	public void mousePressed() {
		switch(screen) {
		case 0:
			if (mouseX > 130 && mouseX < 380 && mouseY > 360 && mouseY < 420) {
				screen=1;
			}
			if (mouseX > 415 && mouseX < 665 && mouseY > 360 && mouseY < 420) {
				screen=2;
			}
			
			break;
		case 1:
			if (mouseX > 708 && mouseX < 738 && mouseY > 47 && mouseY < 77) {
				screen=0;
			}
		break;

		}
	}




}
