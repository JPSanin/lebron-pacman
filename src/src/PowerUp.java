package src;

public abstract class PowerUp {
	private int posX;
	private int posY;
	
	public PowerUp(int posX,int posY) {
		this.posX=posX;
		this.posY=posY;
	}
	
	public abstract void draw();
	
}
