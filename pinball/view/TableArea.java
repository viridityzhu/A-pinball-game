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
		this.imageUtil = images;
	}
	
	
	private GameConfiguration config;
	private Ball ball;
	private Racket racket;
	private MapGenerator map;
	public ImageUtil imageUtil;
	
	
	// 重写Canvas的paint方法，实现绘画
	public void paint(Graphics g){
		// 背景图片
		g.drawImage(imageUtil.getBg_image(),0,0,config.getTABLE_WIDTH(),config.getTABLE_HEIGHT(),this);
		
		// 生命值显示的字体（之后可以用红心图片代替）
		Font LifeFont= new Font("TimesRoman",Font.BOLD,30);
		// 如果游戏已经结束
		if (config.isLose())
		{
			g.drawImage(imageUtil.getLose_image(),0,0,config.getTABLE_WIDTH(),config.getTABLE_HEIGHT(),this);
		}
		// 如果游戏通关
		else if(config.isWin()) {
			g.drawImage(imageUtil.getWin_image(),0,0,config.getTABLE_WIDTH(),config.getTABLE_HEIGHT(),this);
		}
		// 如果游戏还未结束
		else{
			// 绘制小球
			g.drawImage(imageUtil.getBall_image(),ball.getBallX(),ball.getBallY(),imageUtil.getBall_image().getWidth(),imageUtil.getBall_image().getHeight(),this);
			
			// 设置颜色，并绘制球拍
			g.setColor(new Color(80, 80, 200));
			g.fillRect(racket.getRacketX() , racket.getRACKET_Y()
				, racket.getRACKET_WIDTH() , racket.getRACKET_HEIGHT());
			//绘制砖块
			map.drawMap(this,(Graphics2D)g,imageUtil);
			// 设置颜色，并绘制生命值
			g.setColor(Color.LIGHT_GRAY);
			g.setFont(LifeFont);
			g.drawString("Life:"+config.getLives(), 20,30);
			g.drawString("Level:"+config.getLevel(), 20, 60);
			
		}
	}
}