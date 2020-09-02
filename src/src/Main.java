package src;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	PImage[] homescreens;
	PImage[] namescreens;
	int[][] map;
	int squareSize;
	Lebron lbj;
	private int screen;
	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(800, 600);
	}

	public void setup() {
		ellipseMode(CORNER);
	    map = new int[][]{ 
	    {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
	    {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
	    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	    {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
	    {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	    {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
	    {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
	    {0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
	    {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
	    {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
	    {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1},
	    {1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
	    {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
	    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	    };
	    squareSize=40;
	   
		homescreens= new PImage[4];
		homescreens[0]=loadImage("images/HomeScreen1.png");
		homescreens[1]=loadImage("images/HomeScreenInfo.png");
		homescreens[2]=loadImage("images/HomeScreenInfoBig.png");
		homescreens[3]=loadImage("images/HomeScreenPlay.png");
		
		namescreens=new PImage[3];
		namescreens[0]=loadImage("images/NameScreen.png");
		namescreens[1]=loadImage("images/NameScreenGo.png");
		namescreens[2]=loadImage("images/NameScreenError.png");
		
		lbj= new Lebron(this, 40, 120);
		screen=3;
	}

	public void draw() {
		background(255);

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
			
		case 3:
			for (int columns = 0; columns < 20; columns++) {
                for (int rows = 0; rows < 15; rows++) {
                if(map[rows][columns] == 0) {
                	noFill();
                    stroke(255);
                    rect(0+ (columns * squareSize), 0 + (rows * squareSize), squareSize, squareSize);	
                }
                if(map[rows][columns] == 1) {
                	fill(0);
                    stroke(255);
                    rect(0+ (columns * squareSize), 0 + (rows * squareSize), squareSize, squareSize);	
                }
                if(map[rows][columns] == 2) {
                	fill(255,0,0);
                    stroke(255);
                    rect(0+ (columns * squareSize), 0 + (rows * squareSize), squareSize, squareSize);	
                }  
                }
                lbj.draw();
                
			}
			
			break;
			
		}
		fill(0,255,0);
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
		case 2:
			if (mouseX > 275 && mouseX < 525 && mouseY > 350 && mouseY < 410) {
				screen=3;
			}
			break;

		}
	}

	public void keyPressed() {
		
		switch(screen) {
		case 3:
			if (key == CODED) {
			    if (keyCode == UP) {
			    	
			    	lbj.move(1);
			    }
			}
			if (key == CODED) {
			    if (keyCode == DOWN) {
			    	lbj.move(2);
			    }
			}
			if (key == CODED) {
			    if (keyCode == LEFT) {
			    	lbj.move(3);
			    }
			}
			if (key == CODED) {
			    if (keyCode == RIGHT) {
			    	lbj.move(4);
			    }
			}
			
		}
	}


}
