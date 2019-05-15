package pinball.commons;
/**
 * 球拍对象
 * 
 */
public class Racket {
	//构造器
	public Racket(int rACKET_HEIGHT, int rACKET_WIDTH, int rACKET_Y,int racketX) {
		RACKET_HEIGHT = rACKET_HEIGHT;
		RACKET_WIDTH = rACKET_WIDTH;
		RACKET_Y = rACKET_Y;
		this.racketX = racketX;
	}
	
	//变量
	// 球拍的高度和宽度
	private final int RACKET_HEIGHT;
	private final int RACKET_WIDTH;
	// 球拍的垂直位置
	private final int RACKET_Y;
	// racketX代表球拍的水平位置
	private int racketX;
	
	
	
	//setter和getter
	public int getRacketX() {
		return racketX;
	}
	public void setRacketX(int racketX) {
		this.racketX = racketX;
	}
	public int getRACKET_HEIGHT() {
		return RACKET_HEIGHT;
	}
	public int getRACKET_WIDTH() {
		return RACKET_WIDTH;
	}
	public int getRACKET_Y() {
		return RACKET_Y;
	}
}
