package src;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Main extends PApplet{
	
	//Variable declaration
	
	private PImage[] homescreens;
	private PImage[] namescreens;
	private PImage bigBall;
	private PImage littleBall;
	private PImage mapScreen; 
	private PImage[] lebronImages;
	private PImage heart;
	private PImage inv;
	private PImage leaderBoardScreen1;
	private PImage leaderBoardScreen2;
	private Invisibility invisible;
	private int invX;
	private int invY;
	private int hX;
	private int hY;
	private HealthRegen health;
	private PImage[] enemiesPics;
	private PFont scoreBoard;
	private int[][] map;
	private int[][] winMap;
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
	private int freezeTimeFinal;
	private int invisibleTimeFinal;
	private int invisibleTime;
	private boolean hitRef;
	private boolean hitShaq;
	private boolean hitCovid;
	private boolean hitFreeze;
	
	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(800, 600);
	}

	public void setup() {
		//Variable initialization
		
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
		
		winMap= new int[][] {
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
			{0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
			{1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1},
			{1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
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
		inv=loadImage("images/invisibility.png");
		
		enemiesPics=new PImage[4];
		enemiesPics[0]=loadImage("images/ref.png");
		enemiesPics[1]=loadImage("images/shaq.png");
		enemiesPics[2]=loadImage("images/covid.png");
		enemiesPics[3]=loadImage("images/freeze.png");
		
		leaderBoardScreen1=loadImage("images/leaderBoard1.png");
		leaderBoardScreen2=loadImage("images/leaderBoard2.png");
		
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
		
		do {
			invX= (int) random(1,19);
			invY= (int) random(4,14);
			hX= (int) random(1,19);
			hY= (int) random(4,14);	
			
		}while(enemyMap[invY][invX]==1 || enemyMap[hY][hX]==1 || hX==invX || hY==invX);
		
		
		invisible= new Invisibility (this,invX*40,invY*40);
		health= new HealthRegen(this, hX*40, hY*40);
		lbj= new Lebron(this, 40, 120);
		dir=4;
		screen=0;
		
	}

	public void draw() {
		background(0);
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
			if(gameOver(lbj)) {
				screen=5;
			}
			if(win()) {
				order();
				screen=6;
			}
			int realTime=gameTime-holdTime;
			
			players.get(playerNumber-1).calculateTime(realTime);
			players.get(playerNumber-1).setRegularTime(realTime);
			noTint();
			image(mapScreen,0,0,800,600);
			drawHealth(lbj.getHealth());
			paintMatrix();
			if(invisible.isUsed()==false) {
				invisible.draw(inv);	
			}
			if(health.isUsed()==false) {
				health.draw(heart);
			}
			
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
			
			if(hitShaq==true) {
				hitTime2=millis()/1000;
				hitTimeFinal=(hitTime2-hitTime1);
				if (hitTimeFinal >= 2) {
                    hitShaq = false;
                }
			}else {
				validateHit(lbj,enemies[1]);
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
				freezeTimeFinal=millis()/1000-freezeTime;
				if(freezeTimeFinal==5) {
					lbj.setStatus(1);
				}
				
			}
			
			if(lbj.getStatus()==3) {
				invisibleTimeFinal=millis()/1000-invisibleTime;
				if(invisibleTimeFinal==7) {
					lbj.setStatus(1);
				}
				
			}
			activatePower(lbj,invisible);
			activatePower(lbj,health);
			
			fill(225,0,0);
			textFont(scoreBoard);
			textSize(32);
			text(players.get(playerNumber-1).getTime(),460,55);
			text( players.get(playerNumber-1).getScore(),700, 55);
			
			break;
		case 5:
			
			fill(225,0,0);
			textFont(scoreBoard);
			textSize(32);
			text("Game Over",400,300);
			textSize(15);
			text("Losers will not be added to leaderboards",400,325);
			if((millis()/1000)%2==0) {
				
				text("Click anywhere to continue",400,350);	
			}	
			break;
		case 6:
			fill(225,0,0);
			textFont(scoreBoard);
			textSize(32);
			text("WINNER",400,300);
			textSize(15);
			text("Score will be added to leaderboard",400,325);
			if((millis()/1000)%2==0) {
				
				text("Click anywhere to continue",400,350);	
			}
			
			break;
		case 7:
			image(leaderBoardScreen1,0,0,800,600);
			
			if (mouseX > 275 && mouseX <525 && mouseY > 480 && mouseY < 540) {
				image(leaderBoardScreen2,0,0,800,600);
			}
			
			fill(225,0,0);
			textFont(scoreBoard);
			textSize(24);
			for(int i=0; i<players.size() && i<7; i++){
				text(players.get(i).getName(),245,225+(i*35));
				text(players.get(i).getTime(),475,225+(i*35));
				text(players.get(i).getScore(),630,225+(i*35));
			}
			
			
			break;
			
		

		}

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
		case 5:
			players.remove(playerNumber-1);
			screen=7;
			break;
		case 6:
			screen=7;
			break;
		case 7:
			if (mouseX > 275 && mouseX <525 && mouseY > 480 && mouseY < 540) {
				reset();
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
			if(lbj.getStatus()!=2) {
				moveUp();
				moveDown();
				moveLeft();
				moveRight();
			}


		}
	}

	/** Method for drawing the matrix of basketballs  <br>
	
	<b> pre: </b> <br>
	<b> post: </b> basketballs are drawn<br>
	
	*/
	public void paintMatrix() {
		for (int columns = 0; columns < 20; columns++) {
			for (int rows = 0; rows < 15; rows++) {
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
	
	/** Method for typing player name on screen  <br>
	
	<b> pre: </b> <br>
	<b> post: </b> Player name is drawn and saved<br>
	
	*/
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
	
	
	/** Method for moving up and scoring<br>
	
	<b> pre: </b> <br>
	<b> post: </b> Lebron moves up and scores if needed<br>
	
	*/
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
	
	/** Method for moving down and scoring<br>
	
	<b> pre: </b> <br>
	<b> post: </b> Lebron moves down and scores if needed<br>
	
	*/
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
	
	/** Method for moving left and scoring<br>
	
	<b> pre: </b> <br>
	<b> post: </b> Lebron moves left and scores if needed<br>
	
	*/
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
	
	/** Method for moving right and scoring<br>
	
	<b> pre: </b> <br>
	<b> post: </b> Lebron moves right and scores if needed<br>
	
	*/
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

	
	/** Method for validating hits between lebron and enemies<br>
	
	<b> pre: </b> <br>
	<b> post: </b> Lebron reacts to being hit if hit by an enemy<br>
	@param lbj, Lebron object that has been initialized
	@param bed, enemy object that has been initialized
	*/
	public void validateHit(Lebron lbj, Enemy bad) {
		if(lbj.getStatus()!=3) {
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
				players.get(playerNumber-1).decreaseScore(100);
				lbj.setHealth(lbj.getHealth()-1);
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
				freezeTime=gameTime;
				hitFreeze=true;
				lbj.setStatus(2);
				}

		}
		}
	}
	
	
	/** Method for activating power ups<br>
	
	<b> pre: </b> <br>
	<b> post: </b> Lebron activates powerup if it can be used<br>
	@param lbj, Lebron object that has been initialized
	@param power, PowerUp object that has been initialized
	*/
	public void activatePower(Lebron lbj, PowerUp power) {

		if(power.isUsed()==false) {
			if(power instanceof Invisibility) {
				if (dist(lbj.getPosX(), lbj.getPosY(), power.getPosX(), power.getPosY()) < 40) {
					invisibleTime=gameTime;
					power.setUsed(true);
					lbj.setStatus(3);
				}
			}
			
			if(power instanceof HealthRegen) {
				if(lbj.getHealth()!=3) {
					if (dist(lbj.getPosX(), lbj.getPosY(), power.getPosX(), power.getPosY()) < 40) {
						power.setUsed(true);
						lbj.setHealth(lbj.getHealth()+1);
					}	
				}
			}
			
		}
		
	}
	
	
	/** Method for validating if the player has lost yet<br>
	
	<b> pre: </b> <br>
	<b> post: </b> returns a boolean that indicates if the player lost<br>
	@param lbj, Lebron object that has been initialized
	@return lose, boolean indicating if the player has lost
	*/
	public boolean gameOver(Lebron lbj) {
		boolean lose=false;
		if(lbj.getHealth()==0) {
			lose= true;
		}
		return lose;
	}
	
	/** Method for validating if the player has won yet<br>
	
	<b> pre: </b> <br>
	<b> post: </b> returns a boolean that indicates if the player won<br>
	@return win, boolean indicating if the player has won
	*/
	public boolean win() {
		boolean win=true;
		
		 for(int i = 0; i < 20 && win==true; i++){  
             for(int j = 0; j < 15; j++){  
               if(map[j][i] != winMap[j][i]){ 
            	   win= false; 
               }
               
             }
		 }
	
		
		return win;
	}
	
	/** Method for ordering the leaderboard<br>
	
	<b> pre: </b> <br>
	<b> post: </b> Organizes the leaderboard <br>
	*/
	public void order() {
		
		 for(int i=players.size()-1;i >0; i--){
		      for(int j=0; j<i; j++){
		    	 if(players.get(j+1).getScore()==players.get(j).getScore()){
		    		 if(players.get(j).getRegularTime()>players.get(j+1).getRegularTime()){
				          Player p=players.get(j+1);
				          players.set(j+1,players.get(j));
				          players.set(j,p);
				        }
		    	 }else if(players.get(j+1).getScore()>players.get(j).getScore()){
		          Player p=players.get(j+1);
		          players.set(j+1,players.get(j));
		          players.set(j,p);
		        }
		      }
		    }
	}
	
	/** Method for reseting the game<br>
	
	<b> pre: </b> <br>
	<b> post: </b> Resets the game to initial state<br>
	*/
	public void reset() {
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
		
		hitRef=false;
		hitShaq=false;
		hitCovid=false;
		hitFreeze=false;
		
		do {
			invX= (int) random(1,19);
			invY= (int) random(4,14);
			hX= (int) random(1,19);
			hY= (int) random(4,14);	
			
		}while(enemyMap[invY][invX]==1 || enemyMap[hY][hX]==1 || hX==invX || hY==invX);
		enemies= new Enemy[4];
		enemies[0]=new Referee(this,320,240);
		enemies[1]=new Shaq(this,320,320);
		enemies[2]=new Covid(this,400,240);
		enemies[3]=new Freeze(this,400,320);
		name="";
		invisible= new Invisibility (this,invX*40,invY*40);
		health= new HealthRegen(this, hX*40, hY*40);
		lbj= new Lebron(this, 40, 120);
		dir=4;
		screen=0;
		
	}
}
