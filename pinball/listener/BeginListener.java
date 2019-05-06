package pinball.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import pinball.commons.*;
/**
 * 开始监听器对象
 * 监听游戏开始时使用鼠标设置球拍位置，并单击左键游戏开始的动作
 */
public class BeginListener extends MouseAdapter {
	
	//构造器
	public BeginListener(GameConfiguration config, Ball ball, Racket racket) {
		super();
		this.config = config;
		this.ball = ball;
		this.racket = racket;
	}
	
	//变量
	private GameConfiguration config;
	private Ball ball;
	private Racket racket;
	
	//方法
	//单击左键，游戏开始
	public void mousePressed(MouseEvent e) {
		if(!config.isStart()) {
			config.setStart(true);
		}
	}
	//移动鼠标，设置小球和球拍的位置
	public void mouseMoved(MouseEvent e) {
		if(!config.isStart()) {
			ball.setBallX(e.getX()-ball.getBALL_SIZE()/2);
			racket.setRacketX(e.getX()-racket.getRACKET_WIDTH()/2);
		}
	}
}
