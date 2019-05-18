package pinball.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import pinball.commons.*;
import pinball.view.TableArea;
public class CrashListener implements ActionListener {
	public CrashListener(Ball ball, GameConfiguration config, Racket racket,TableArea tableArea,MapGenerator map,ImageUtil imageUtil) {
		super();
		this.ball = ball;
		this.config = config;
		this.racket = racket;
		this.tableArea=tableArea;
		this.map=map;
		this.imageUtil=imageUtil;
	}
	private TableArea tableArea;
	private Ball ball;
	private GameConfiguration config;
	private Racket racket;
	private javax.swing.Timer timer;
	private MapGenerator map;
	private ImageUtil imageUtil;
	@Override
	public void actionPerformed(ActionEvent e) {
		// 如果小球碰到左右边框
		if (ball.getBallX()  <= 0 ){
			//解决卡缝的bug
			ball.setBallX(1);
			ball.setxSpeed(ball.getxSpeed()*(-1) );
		}
		else if( ball.getBallX() >= config.getTABLE_WIDTH() - ball.getBALL_SIZE()) {
			//解决卡缝的bug
			ball.setBallX(config.getTABLE_WIDTH() - ball.getBALL_SIZE()-1);
			ball.setxSpeed(ball.getxSpeed()*(-1) );
		}
		// 如果小球高度超出了球拍位置，且横向不在球拍范围之内，生命值-1。
		if (ball.getBallY() > racket.getRACKET_Y() - ball.getBALL_SIZE() &&
					(ball.getBallX() < racket.getRacketX()-ball.getBALL_SIZE()-10 || 
					ball.getBallX() > racket.getRacketX() + 
					racket.getRACKET_WIDTH()+10))
		{
			// 玩家生命值-1
			config.setLives(config.getLives()-1);
			// 如果生命值降为0，游戏结束
			if(config.getLives()==0) {
				timer.stop();
				// 设置游戏是否结束的旗标为true。
				config.setLose(true);
				tableArea.repaint();
			}
			else {
				// 重新初始化小球位置
				// ballX和ballY代表小球的坐标
				ball.setBallX(100);
				ball.setBallY(racket.getRACKET_Y()-ball.getBALL_SIZE()-2); 
				// racketX代表球拍的水平位置
				racket.setRacketX(ball.getBallX()+ball.getBALL_SIZE()/2-racket.getRACKET_WIDTH()/2);
				config.setStart(false);
			}
		}
		//如果小球撞到上边框
		else if (ball.getBallY()  <= 0) {
			//解决卡缝bug
			ball.setBallY(1);
			ball.setySpeed(ball.getySpeed()*(-1));
		}
		// 如果小球位于球拍之内，且到达球拍位置，小球反弹
		else if (ball.getBallY() >= (racket.getRACKET_Y() - ball.getBALL_SIZE())
				&& ball.getBallX() > racket.getRacketX() && ball.getBallX() 
				<= racket.getRacketX() + racket.getRACKET_WIDTH()){	
			ball.setBallY(racket.getRACKET_Y()-ball.getBALL_SIZE()-2);
			ball.setySpeed(ball.getySpeed()*(-1));
			ball.setxSpeed((int)(-(ball.getxSpeed()/Math.abs(ball.getxSpeed()))*(ball.getySpeed()*(Math.abs(0.02*(racket.getRacketX()+(racket.getRACKET_WIDTH())/2-ball.getBallX()))>1?(Math.abs(0.02*(racket.getRacketX()+(racket.getRACKET_WIDTH())/2-ball.getBallX()))):1))));
		}
		//如果小球撞到砖块
		for (Iterator<Brick> it = map.brickList.iterator(); it.hasNext(); ) {
		    Brick b = it.next();
		    if( ((b.getBrickY()<=ball.getBallY()&&ball.getBallY()<=(b.getBrickY()+Brick.getBrickHeight()))&&
					((b.getBrickX()<=ball.getBallX()&&ball.getBallX()<=(b.getBrickX()+Brick.getBrickWidth()))||
							(b.getBrickX()<=(ball.getBallX()+ball.getBALL_SIZE())
							&&(ball.getBallX()+ball.getBALL_SIZE())<=(b.getBrickX()+Brick.getBrickWidth()))) ||
					((b.getBrickY()<=(ball.getBallY()+ball.getBALL_SIZE())&&(ball.getBallY()+ball.getBALL_SIZE())<=(b.getBrickY()+Brick.getBrickHeight()))
							&&((b.getBrickX()<=ball.getBallX()&&ball.getBallX()<=(b.getBrickX()+Brick.getBrickWidth()))||
							(b.getBrickX()<=(ball.getBallX()+ball.getBALL_SIZE())&&(ball.getBallX()+ball.getBALL_SIZE())<=(b.getBrickX()+Brick.getBrickWidth()))))))
			{
				//小球反弹
				ball.setySpeed(ball.getySpeed()*(-1));
				//砖块生命值-1
				b.setBrickLives(b.getBrickLives()-1);
				//若消除砖块
				if(b.getBrickLives()==0) {
					it.remove();
					map.setBrickNum(map.getBrickNum()-1);
					// 如果屏幕不再剩余砖块
					if(map.getBrickNum()==0)
						//如果已到最后一关
						if(config.getLevel()==config.getTotalLevels()) {
							timer.stop();
							// 设置游戏是否胜利的旗标为true。
							config.setWin(true);
							tableArea.repaint();
						}
						else {
							tableArea.repaint();
							map.nextLevel(config,imageUtil,ball);
							// 重新初始化小球位置
							// ballX和ballY代表小球的坐标
							ball.setBallX(100);
							ball.setBallY(racket.getRACKET_Y()-ball.getBALL_SIZE()-2); 
							// racketX代表球拍的水平位置
							racket.setRacketX(ball.getBallX()+ball.getBALL_SIZE()/2-racket.getRACKET_WIDTH()/2);
							config.setStart(false);
							break;
						}
				}
			}
		}
		// 小球坐标增加
		if(config.isStart()){
			ball.setBallY(ball.getBallY()+ball.getySpeed());
			ball.setBallX(ball.getBallX()+ball.getxSpeed());
		}
		tableArea.repaint();
	}
	public void setTimer(javax.swing.Timer timer2) {
		this.timer = timer2;
	}
	
			
}
