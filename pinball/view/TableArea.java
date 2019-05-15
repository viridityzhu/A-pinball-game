package pinball.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import pinball.commons.Ball;
import pinball.commons.GameConfiguration;
import pinball.commons.MapGenerator;
import pinball.commons.Racket;
import pinball.commons.ImageUtil;

public class TableArea extends Canvas implements ImageObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public TableArea(GameConfiguration config, Ball ball, Racket racket,MapGenerator map,ImageUtil images) {
		super();
		this.config = config;
		this.ball = ball;
		this.racket = racket;
		this.map=map;
		this.images = images;
	}
	
	
	private GameConfiguration config;
	private Ball ball;
	private Racket racket;
	private MapGenerator map;
	public ImageUtil images;
	
	
	// 重写Canvas的paint方法，实现绘画
	public void paint(Graphics g){
		// 生命值显示的字体（之后可以用红心图片代替）
		Font LifeFont= new Font("TimesRoman",Font.BOLD,30);
		// 如果游戏已经结束
		if (config.isLose())
		{
			g.setColor(new Color(255, 0, 0));
			g.setFont(new Font("Times" , Font.BOLD, 30));
			g.drawString("游戏已结束！" , config.getTABLE_WIDTH()/2-80 ,config.getTABLE_HEIGHT()/2);
		}
		// 如果游戏通关
		else if(config.isWin()) {
			g.setColor(new Color(255, 0, 0));
			g.setFont(new Font("Times" , Font.BOLD, 30));
			g.drawString("You Win!!!!！" , config.getTABLE_WIDTH()/2-80 ,config.getTABLE_HEIGHT()/2);
		}
		// 如果游戏还未结束
		else{
			// 设置颜色，并绘制小球
			g.drawImage(images.cxy_image,ball.getBallX(),ball.getBallY(),images.cxy_image.getWidth(),images.cxy_image.getHeight(),this);
			
			// 设置颜色，并绘制球拍
			g.setColor(new Color(80, 80, 200));
			g.fillRect(racket.getRacketX() , racket.getRACKET_Y()
				, racket.getRACKET_WIDTH() , racket.getRACKET_HEIGHT());
			//绘制砖块
			map.drawMap((Graphics2D)g);
			// 设置颜色，并绘制生命值
			g.setColor(Color.red);
			g.setFont(LifeFont);
			g.drawString("Life:"+config.getLives(), 20,30);
			
		}
	}
}