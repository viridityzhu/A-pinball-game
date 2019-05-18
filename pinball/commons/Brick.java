package pinball.commons;


import java.awt.Graphics2D;


import pinball.view.TableArea;

public class Brick {
	//砖块宽度
	static int brickWidth=70-10;
	//砖块高度
	static int brickHeight=20+30;
	//砖块横坐标
	private int brickX;
	//砖块纵坐标
	private int brickY;
	//砖块生命值
	private int brickLives;
	Brick(int x,int y,int life){
		brickX=x;
		brickY=y;
		brickLives=life;
	}

	void drawBrick(TableArea tableArea,Graphics2D g,ImageUtil imageUtil) {
		if(brickLives==1)
			g.drawImage(imageUtil.getBrick_image1(),brickX,brickY,brickWidth,brickHeight,tableArea);
		else if(brickLives==2)
			g.drawImage(imageUtil.getBrick_image2(),brickX,brickY,brickWidth,brickHeight,tableArea);
		else if(brickLives==3)
			g.drawImage(imageUtil.getBrick_image3(),brickX,brickY,brickWidth,brickHeight,tableArea);
		else if(brickLives==4)
			g.drawImage(imageUtil.getBrick_image4(),brickX,brickY,brickWidth,brickHeight,tableArea);
		else if(brickLives==5)
			g.drawImage(imageUtil.getBrick_image5(),brickX,brickY,brickWidth,brickHeight,tableArea);
		else if(brickLives==6)
			g.drawImage(imageUtil.getBrick_image6(),brickX,brickY,brickWidth,brickHeight,tableArea);
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
