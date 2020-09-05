package src;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Main extends PApplet{
	private PImage[] homescreens;
	private PImage[] namescreens;
	private PImage bigBall;
	private PImage littleBall;
	private PImage mapScreen; 
	private PImage[] lebronImages;
	private PImage heart;
	private PImage invisibility;
	private PImage[] enemiesPics;
	private PFont scoreBoard;
	private int[][] map;
	private int[][] enemyMap;
	private int squareSize;
	private Lebron lbj;
	private int screen;
	private String name;
	private ArrayList<Player> players;
	private int playerNumber;
	private int gameTime;
	private int holdTime;
	private int dir;
	private Enemy[] enemies;
	private int hitTime1;
	private int hitTime2;
	private int hitTimeFinal;
	private int freezeTime;
	private int freezeTime2;
	private int freezeTimeFinal;
	private boolean hitRef;
	private boolean hitShaq;
	private boolean hitCovid;
	private boolean hitFreeze;
	/*private Shaq shaq;
	private Freeze freeze;
	private Covid covid;
	private Referee ref;*/

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(800, 600);
	}

	public void setup() {
		ellipseMode(CORNER);
		textAlign(CENTER);
		map = new int[][]{ 
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 1},
			{1, 4, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 4, 1},
			{1, 4, 1, 4, 1, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
			{1, 4, 1, 4, 1, 4, 5, 4, 1, 1, 1, 4, 1, 4, 1, 1, 4, 1, 4, 1},
			{1, 4, 1, 4, 1, 4, 1, 4, 1, 1, 1, 4, 1, 5, 4, 4, 4, 1, 4, 1},
			{0, 4, 1, 5, 1, 4, 1, 4, 1, 1, 1, 4, 1, 1, 1, 1, 4, 1, 4, 0},
			{1, 4, 1, 4, 1, 4, 4, 4, 4, 4, 4, 5, 4, 4, 4, 4, 4, 1, 4, 1},
			{1, 4, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1},
			{1, 4, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 1, 4, 4, 4, 5, 1, 4, 1},
			{1, 4, 1, 1, 1, 1, 4, 5, 4, 1, 1, 4, 4, 4, 1, 1, 1, 1, 4, 1},
			{1, 5, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 5, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		};
		enemyMap= new int[][]{ 
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1},
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
		mapScreen=loadImage("images/Map.png");
		scoreBoard= createFont("fonts/60s Scoreboard.ttf", 32);
		bigBall=loadImage("images/bigBall.png");
		littleBall=loadImage("images/littleBall.png");
		lebronImages=new PImage[5];
		lebronImages[0]=loadImage("images/lbj.png");
		lebronImages[1]=loadImage("images/lbjRight.png");
		lebronImages[2]=loadImage("images/lbjDown.png");
		lebronImages[3]=loadImage("images/lbjUp.png");
		lebronImages[4]=loadImage("images/lbjFrozen.png");
		heart=loadImage("images/heart.png");
		invisibility=loadImage("images/invisibility.png");
		/*ref=new Referee(this,320,240);
		shaq=new Shaq(this,320,320);
		covid=new Covid(this,400,240);
		freeze=new Freeze(this,400,320);*/
		enemiesPics=new PImage[4];
		enemiesPics[0]=loadImage("images/ref.png");
		enemiesPics[1]=loadImage("images/shaq.png");
		enemiesPics[2]=loadImage("images/covid.png");
		enemiesPics[3]=loadImage("images/freeze.png");
		enemies= new Enemy[4];
		enemies[0]=new Referee(this,320,240);
		enemies[1]=new Shaq(this,320,320);
		enemies[2]=new Covid(this,400,240);
		enemies[3]=new Freeze(this,400,320);
		name="";
		hitRef=false;
		hitShaq=false;
		hitCovid=false;
		hitFreeze=false;
		playerNumber=0;
		players= new ArrayList<Player>();
		lbj= new Lebron(this, 40, 120);
		dir=4;
		screen=2;
	}

	public void draw() {
		background(255);
		gameTime=millis()/1000;

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
			fill(0);
			textFont(scoreBoard);
			text(name, 400, 306);
			break;
		case 3:
			image(namescreens[2],0,0,800,600);
			break;

		case 4:
			int realTime=gameTime-holdTime;
			
			players.get(playerNumber-1).calculateTime(realTime);

			image(mapScreen,0,0,800,600);
			drawHealth(lbj.getHealth());
			paintMatrix();
			lbj.draw(lebronImages[0],lebronImages[1],lebronImages[2],lebronImages[3],lebronImages[4],dir);
			for (int i=0;i< enemies.length;i++) {
				enemies[i].draw(enemiesPics[i]);
				if (frameCount % 12 == 0) {
					enemies[i].move(enemyMap);
				}

			}
			if(hitRef==true) {
				hitTime2=millis()/1000;
				hitTimeFinal=(hitTime2-hitTime1);
				if (hitTimeFinal >= 2) {
                    hitRef = false;
                }
			}else {
				validateHit(lbj,enemies[0]);
			}
			
			
			if(hitCovid==true) {
				hitTime2=millis()/1000;
				hitTimeFinal=(hitTime2-hitTime1);
				if (hitTimeFinal >= 2) {
                    hitCovid = false;
                }
			}else {
				validateHit(lbj,enemies[2]);
			}
			
			if(hitFreeze==true) {
				hitTime2=millis()/1000;
				hitTimeFinal=(hitTime2-hitTime1);
				if (hitTimeFinal >= 2) {
                    hitFreeze = false;
                }
			}else {
				validateHit(lbj,enemies[3]);
			}
			if(lbj.getStatus()==2) {
				freezeTime=millis()/1000;
				//freezeTime2=(freezeTime-realTime);
				freezeTimeFinal=millis()/1000-freezeTime;
				
			}
			/*ref.draw(enemiesPics[0]);
				shaq.draw(enemiesPics[1]);
				covid.draw(enemiesPics[2]);
				freeze.draw(enemiesPics[3]);
				if (frameCount % 12 == 0) {
					ref.move(enemyMap);
					shaq.move(enemyMap);
					covid.move(enemyMap);
					freeze.move(enemyMap);
				}*/
			fill(225,0,0);
			textFont(scoreBoard);
			textSize(32);
			text(players.get(playerNumber-1).getTime(),460,55);
			text( players.get(playerNumber-1).getScore(),700, 55);
			//System.out.println(shaq.getR());
			//System.out.println(shaq.getMatX()+","+shaq.getMatY());
			System.out.println(freezeTimeFinal);

			break;

		}
		fill(0);
		textSize(12);
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
			if (mouseX > 275 && mouseX < 525 && mouseY > 350 && mouseY < 410 && name.equals("")) {
				screen=3;
			}else if (mouseX > 275 && mouseX < 525 && mouseY > 350 && mouseY < 410) {
				players.add(new Player(name));
				playerNumber++;
				holdTime=gameTime;
				screen=4;
			}
			break;
		case 3:
			if (mouseX > 562 && mouseX < 592 && mouseY > 185 && mouseY < 215) {
				screen=2;
			}
			break;

		}
	}

	public void keyPressed() {

		switch(screen) {
		case 2:
			typeName();
			break;
		case 4:
			if(lbj.getStatus()==1) {
				moveUp();
				moveDown();
				moveLeft();
				moveRight();
			}

		}
	}

	public void paintMatrix() {
		for (int columns = 0; columns < 20; columns++) {
			for (int rows = 0; rows < 15; rows++) {
				if(map[rows][columns] == 0) {
					/*noFill();
					stroke(0);
					rect(0+ (columns * squareSize), 0 + (rows * squareSize), squareSize, squareSize);	*/
				}
				if(map[rows][columns] == 1) {
					/*fill(0);
					stroke(255);
					rect(0+ (columns * squareSize), 0 + (rows * squareSize), squareSize, squareSize);*/	
				}
				if(map[rows][columns] == 2) {
					/*fill(0);
					noStroke();
					rect(0+ (columns * squareSize), 0 + (rows * squareSize), squareSize, squareSize);	*/
				}  
				if(map[rows][columns] == 3) {
					/*fill(0,255,0);
					stroke(255);
					rect(0+ (columns * squareSize), 0 + (rows * squareSize), squareSize, squareSize);	*/
				}  
				if(map[rows][columns] == 4) {
					fill(0,0,255);
					stroke(255);
					image(littleBall,0+ (columns * squareSize),0 + (rows * squareSize),squareSize,squareSize);
				}
				if(map[rows][columns] == 5) {
					fill(0,0,255);
					stroke(255);

					image(bigBall,0+ (columns * squareSize),0 + (rows * squareSize),squareSize,squareSize);	
				}
			}
		}
	}
	public void typeName() {
		if(key==BACKSPACE) {
			if (name != null && name.length() > 0 ) {
				name = name.substring(0, name.length() - 1);
			}
		}else if(key!=CODED){
			if(name.length()<=15) {
				name+=key;
			}

		}
	}
	public void moveUp() {
		if (key == CODED) {
			if (keyCode == UP) {
				if (lbj.getMatY() - 1 > -1 && map[lbj.getMatY() - 1][lbj.getMatX()] == 4) {
					lbj.move(1);
					map[lbj.getMatY()][lbj.getMatX()]=0;
					players.get(playerNumber-1).increaseScore(10);
					dir=1;
				}else if(lbj.getMatY() - 1 > -1 && map[lbj.getMatY() - 1][lbj.getMatX()] == 5) {
					lbj.move(1);
					map[lbj.getMatY()][lbj.getMatX()]=0;
					players.get(playerNumber-1).increaseScore(50);
					dir=1;
				}else if(lbj.getMatY() - 1 > -1 && map[lbj.getMatY() - 1][lbj.getMatX()] == 0) {
					lbj.move(1);
					dir=1;
				}
			}
		}
	}
	public void moveDown() {
		if (key == CODED) {
			if (keyCode == DOWN) {
				if (lbj.getMatY() + 1 < 15 && map[lbj.getMatY() + 1][lbj.getMatX()] == 4) {
					lbj.move(2);
					map[lbj.getMatY()][lbj.getMatX()]=0;
					players.get(playerNumber-1).increaseScore(10);
					dir=2;
				}else if(lbj.getMatY() + 1 < 15 && map[lbj.getMatY() + 1][lbj.getMatX()] == 5) {
					lbj.move(2);
					map[lbj.getMatY()][lbj.getMatX()]=0;
					players.get(playerNumber-1).increaseScore(50);
					dir=2;
				}else if (lbj.getMatY() + 1 < 15 && map[lbj.getMatY() + 1][lbj.getMatX()] == 0) {
					lbj.move(2);
					dir=2;
				}
			}
		}
	}
	public void moveLeft() {
		if (key == CODED) {
			if (keyCode == LEFT) {
				if(lbj.getMatX() ==0 &&  lbj.getMatY()==8) {
					lbj.teleportLeft();
				}else {
					if (lbj.getMatX() - 1 > -1 && map[lbj.getMatY()][lbj.getMatX()-1] == 4) {
						lbj.move(3);
						map[lbj.getMatY()][lbj.getMatX()]=0;
						players.get(playerNumber-1).increaseScore(10);
						dir=3;
					}else if(lbj.getMatX() - 1 > -1 && map[lbj.getMatY()][lbj.getMatX()-1] == 5) {
						lbj.move(3);
						map[lbj.getMatY()][lbj.getMatX()]=0;
						players.get(playerNumber-1).increaseScore(50);
						dir=3;
					}else if (lbj.getMatX() - 1 > -1 && map[lbj.getMatY()][lbj.getMatX()-1] == 0) {
						lbj.move(3);
						dir=3;
					}

				}
			}
		}}
	public void moveRight() {
		if (key == CODED) {
			if (keyCode == RIGHT) {
				if(lbj.getMatX() ==19 &&  lbj.getMatY()==8) {
					lbj.teleportRight();
				}else {
					if (lbj.getMatX() + 1 < 20 && map[lbj.getMatY()][lbj.getMatX()+1] == 4) {
						lbj.move(4);
						map[lbj.getMatY()][lbj.getMatX()]=0;
						dir=4;
						players.get(playerNumber-1).increaseScore(10);
					}else if(lbj.getMatX() + 1 < 20 && map[lbj.getMatY()][lbj.getMatX()+1] == 5) {
						lbj.move(4);
						map[lbj.getMatY()][lbj.getMatX()]=0;
						players.get(playerNumber-1).increaseScore(50);
						dir=4;
					}else if (lbj.getMatX() + 1 < 20 && map[lbj.getMatY()][lbj.getMatX()+1] == 0) {
						lbj.move(4);
						dir=4;
					}
				}
			}
		}

	}

	public void drawHealth(int health) {
		switch(health) {
		case 1:
			image(heart,40,23,squareSize,squareSize);
			break;
		case 2:
			image(heart,40,23,squareSize,squareSize);
			image(heart,90,23,squareSize,squareSize);
			break;
		case 3: 
			image(heart,40,23,squareSize,squareSize);
			image(heart,90,23,squareSize,squareSize);
			image(heart,140,23,squareSize,squareSize);
			break;
		}

	}

	public void validateHit(Lebron lbj, Enemy bad) {
		if(bad instanceof Referee) {
			if (dist(lbj.getPosX(), lbj.getPosY(), bad.getPosX(), bad.getPosY()) < 40) {
				hitTime1=millis()/1000;
				hitRef=true;
				players.get(playerNumber-1).decreaseScore(100);
				}
			
		}
		if(bad instanceof Shaq) {
			if (dist(lbj.getPosX(), lbj.getPosY(), bad.getPosX(), bad.getPosY()) < 40) {
				hitTime1=millis()/1000;
				hitShaq=true;
				
				}

		}
		if(bad instanceof Covid) {
			if (dist(lbj.getPosX(), lbj.getPosY(), bad.getPosX(), bad.getPosY()) < 40) {
				hitTime1=millis()/1000;
				hitCovid=true;
				lbj.setHealth(lbj.getHealth()-1);
				}
		}
		if(bad instanceof Freeze) {
			if (dist(lbj.getPosX(), lbj.getPosY(), bad.getPosX(), bad.getPosY()) < 40) {
				hitTime1=millis()/1000;
				hitFreeze=true;
				lbj.setStatus(2);
				}

		}
	}
}
