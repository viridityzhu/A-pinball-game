package pinball.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import pinball.commons.*;
import pinball.view.TableArea;
public class CrashListener implements ActionListener {
	public CrashListener(Ball ball, GameConfiguration config, Racket racket,TableArea tableArea) {
		super();
		this.ball = ball;
		this.config = config;
		this.racket = racket;
		this.tableArea=tableArea;
	}
	private TableArea tableArea;
	private Ball ball;
	private GameConfiguration config;
	private Racket racket;
	private javax.swing.Timer timer;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 如果小球碰到左右边框
		if (ball.getBallX()  <= 0 || ball.getBallX() >= config.getTABLE_WIDTH() - ball.getBALL_SIZE()){
			ball.setxSpeed(ball.getxSpeed()*(-1) );
		}
		// 如果小球高度超出了球拍位置，且横向不在球拍范围之内，生命值-1。
		if (ball.getBallY() >= racket.getRACKET_Y() - ball.getBALL_SIZE() &&
			(ball.getBallX() < racket.getRacketX()-ball.getBALL_SIZE() || ball.getBallX() > racket.getRacketX() + racket.getRACKET_WIDTH()+ball.getBALL_SIZE())){
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
				// ballX和ballY代表小球的坐标
				ball.setBallX(100);
				ball.setBallY(racket.getRACKET_Y()-ball.getBALL_SIZE()*2); 
				// racketX代表球拍的水平位置
				racket.setRacketX(ball.getBallX()+ball.getBALL_SIZE()/2-racket.getRACKET_WIDTH()/2);
				config.setStart(false);
			}
		}
		//如果小球撞到上边框
		else if (ball.getBallY()  <= 0) {
			ball.setySpeed(ball.getySpeed()*(-1));
		}
		// 如果小球位于球拍之内，且到达球拍位置，小球反弹----------------------------------------------------start
		else if (ball.getBallY() >= racket.getRACKET_Y() - ball.getBALL_SIZE()
				&& ball.getBallX() > racket.getRacketX() && ball.getBallX() <= racket.getRacketX() + racket.getRACKET_WIDTH()){	
			ball.setySpeed(ball.getySpeed()*(-1));
			ball.setxSpeed((int)(-(ball.getxSpeed()/Math.abs(ball.getxSpeed()))*(ball.getySpeed()*(Math.abs(0.02*(racket.getRacketX()+(racket.getRACKET_WIDTH())/2-ball.getBallX()))>1?(Math.abs(0.02*(racket.getRacketX()+(racket.getRACKET_WIDTH())/2-ball.getBallX()))):1))));
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
