package src;

public class Player {
	private String name;
	private int score;
	private String time;
	
	public Player(String name) {
		this.name=name;
		score=0;
		time="0:00";
		
	}
	
	public void calculateTime() {}
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

}
