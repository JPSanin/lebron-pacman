package src;

public class Player {
	private String name;
	private int score;
	private int regularTime;
	private String time;
	
	public Player(String name) {
		this.name=name;
		score=0;
		time="";
		
	}
	
	public void calculateTime(int time) {
		String s="";
		int printTime= (int)time/60;
		int printTime2= time-printTime*60;
		s+=printTime+":"+printTime2;
		this.time=s;
	}
	public void increaseScore(int points) {
		score+=points;
		
	}
	public void decreaseScore(int points) {
		score-=points;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public int getRegularTime() {
		return regularTime;
	}

	public void setRegularTime(int regularTime) {
		this.regularTime = regularTime;
	}

}
