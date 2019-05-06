package pinball.commons;

import java.util.Random;
/**
 * 小球对象
 * 
 */
public class Ball {
	public Ball(int BALL_SIZE, int ballX, int RACKET_Y) {
		this.BALL_SIZE = BALL_SIZE;
		this.ballX = ballX;
		this.ballY = RACKET_Y-BALL_SIZE*2;
	}
	
	
	// 小球的大小
	private final int BALL_SIZE;
	// 小球纵向的运行速度
	private int ySpeed = -20;
	// 返回一个-0.5~0.5的比率，用于控制小球的运行方向。
	Random rand = new Random();
	private double xyRate = rand.nextDouble() - 0.5;
	// 小球横向的运行速度
	private int xSpeed = (int)(ySpeed * xyRate * 2);
	// ballX和ballY代表小球的坐标
	private int ballX;
	private int ballY;
	
	
	
	public int getySpeed() {
		return ySpeed;
	}
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	public Random getRand() {
		return rand;
	}
	public void setRand(Random rand) {
		this.rand = rand;
	}
	public double getXyRate() {
		return xyRate;
	}
	public void setXyRate(double xyRate) {
		this.xyRate = xyRate;
	}
	public int getxSpeed() {
		return xSpeed;
	}
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	public int getBallX() {
		return ballX;
	}
	public void setBallX(int ballX) {
		this.ballX = ballX;
	}
	public int getBallY() {
		return ballY;
	}
	public void setBallY(int ballY) {
		this.ballY = ballY;
	}
	public int getBALL_SIZE() {
		return BALL_SIZE;
	}
}
