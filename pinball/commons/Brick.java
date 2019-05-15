package pinball.commons;

import java.awt.Color;
import java.awt.Graphics2D;

public class Brick {
	//砖块宽度
	static int brickWidth=80;
	//砖块高度
	static int brickHeight=25;
	//砖块横坐标
	private int brickX;
	//砖块纵坐标
	private int brickY;
	//砖块生命值
	private int brickLives=1;
	Brick(int x,int y,int life){
		brickX=x;
		brickY=y;
		brickLives=life;
	}
	
	
	
	void drawBrick(Graphics2D g) {
		g.setColor(Color.gray);
		g.fillRect(brickX, brickY, brickWidth, brickHeight);
	}



	public int getBrickX() {
		return brickX;
	}



	public void setBrickX(int brickX) {
		this.brickX = brickX;
	}



	public int getBrickY() {
		return brickY;
	}



	public void setBrickY(int brickY) {
		this.brickY = brickY;
	}



	public int getBrickLives() {
		return brickLives;
	}



	public void setBrickLives(int brickLives) {
		this.brickLives = brickLives;
	}



	public static int getBrickWidth() {
		return brickWidth;
	}



	public static void setBrickWidth(int brickWidth) {
		Brick.brickWidth = brickWidth;
	}



	public static int getBrickHeight() {
		return brickHeight;
	}



	public static void setBrickHeight(int brickHeight) {
		Brick.brickHeight = brickHeight;
	}
	
}
