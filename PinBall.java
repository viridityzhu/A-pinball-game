import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinBall
{
	// 桌面的宽度
	private final int TABLE_WIDTH = 1000;
	// 桌面的高度
	private final int TABLE_HEIGHT = 800;
	// 球拍的垂直位置
	private final int RACKET_Y = TABLE_HEIGHT-50;
	// 下面定义球拍的高度和宽度
	private final int RACKET_HEIGHT = 30;
	private final int RACKET_WIDTH = 200;
	// 小球的大小
	private final int BALL_SIZE = 24;
	private Frame f = new Frame("弹球游戏");
	Random rand = new Random();
	// 小球纵向的运行速度
	private int ySpeed = -20;
	// 返回一个-0.5~0.5的比率，用于控制小球的运行方向。
	private double xyRate = rand.nextDouble() - 0.5;
	// 小球横向的运行速度
	public int xSpeed = (int)(ySpeed * xyRate * 2);
	// ballX和ballY代表小球的坐标
	private int ballX = 100;
	private int ballY = RACKET_Y-BALL_SIZE*2;
	// racketX代表球拍的水平位置
	private int racketX = ballX+BALL_SIZE/2-RACKET_WIDTH/2;
	// 玩家的生命值
	private int lives=3;
	// 生命值显示的字体（之后可以用红心图片代替）
	Font LifeFont= new Font("TimesRoman",Font.BOLD,30);
	private MyCanvas tableArea = new MyCanvas();
	Timer timer;
	// 游戏是否结束的旗标
	private boolean isLose = false;
	// 游戏是否开始的旗标
	private boolean isStart = false;
	public void init(){
		//按下关闭按钮，退出程序
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// 设置桌面区域的最佳大小
		tableArea.setPreferredSize(
			new Dimension(TABLE_WIDTH , TABLE_HEIGHT));
		f.add(tableArea);
		// 定义键盘监听器
		KeyAdapter keyProcessor = new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				if(isStart) {
					// 按下向左、向右键时，球拍水平坐标分别减少、增加
					if (ke.getKeyCode() == KeyEvent.VK_LEFT){
						if (racketX > 0)
						racketX -= 50;
					}
					if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
						if (racketX < TABLE_WIDTH - RACKET_WIDTH)
						racketX += 50;
					}
				}

			}
		};
		// 为窗口和tableArea对象分别添加键盘监听器
		f.addKeyListener(keyProcessor);
		tableArea.addKeyListener(keyProcessor);
		// 定义每0.1秒执行一次的事件监听器。
		ActionListener taskPerformer = evt ->{
			// 如果小球碰到左右边框
			if (ballX  <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE){
				xSpeed = -xSpeed;
			}
			// 如果小球高度超出了球拍位置，且横向不在球拍范围之内，生命值-1。
			if (ballY >= RACKET_Y - BALL_SIZE &&
				(ballX < racketX-BALL_SIZE || ballX > racketX + RACKET_WIDTH+BALL_SIZE)){
				// 玩家生命值-1
				lives--;
				// 如果生命值降为0，游戏结束
				if(lives==0) {
					timer.stop();
					// 设置游戏是否结束的旗标为true。
					isLose = true;
					tableArea.repaint();
				}
				else {
					// ballX和ballY代表小球的坐标
					ballX = 100;
					ballY = RACKET_Y-BALL_SIZE*2;
					// racketX代表球拍的水平位置
					racketX = ballX+BALL_SIZE/2-RACKET_WIDTH/2;
					isStart=false;
				}
			}
			//如果小球撞到上边框
			else if (ballY  <= 0) {
				ySpeed = -ySpeed;
			}
			// 如果小球位于球拍之内，且到达球拍位置，小球反弹----------------------------------------------------start
			else if (ballY >= RACKET_Y - BALL_SIZE
					&& ballX > racketX && ballX <= racketX + RACKET_WIDTH){	
				ySpeed = -ySpeed;
				xSpeed = (int)(-(xSpeed/Math.abs(xSpeed))*(ySpeed*(Math.abs(0.02*(racketX+(RACKET_WIDTH)/2-ballX))>1?(Math.abs(0.02*(racketX+(RACKET_WIDTH)/2-ballX))):1)));
			}
			// 小球坐标增加
			if(isStart){
				ballY += ySpeed;
				ballX += xSpeed;
			}
			tableArea.repaint();
		};
		timer = new Timer(50, taskPerformer);
		timer.start();
		
		// 添加鼠标事件监听器，按下左键，游戏开始
		tableArea.addMouseListener(new MouseAdapter (){
			public void mousePressed(MouseEvent e) {
				if(!isStart) {
					isStart = true;
				}
			}
		});
		// 添加鼠标移动事件监听器，使杆与小球的位置跟随鼠标
		tableArea.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				if(!isStart) {
					ballX=e.getX()-BALL_SIZE/2;
					racketX=e.getX()-RACKET_WIDTH/2;
				}
			}
		});
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args){
		new PinBall().init();
	}
	class MyCanvas extends Canvas{
		// 重写Canvas的paint方法，实现绘画
		public void paint(Graphics g){
			// 如果游戏已经结束
			if (isLose)
			{
				g.setColor(new Color(255, 0, 0));
				g.setFont(new Font("Times" , Font.BOLD, 30));
				g.drawString("游戏已结束！" , TABLE_WIDTH/2-80 ,TABLE_HEIGHT/2);
			}
			// 如果游戏还未结束
			else{
				// 设置颜色，并绘制小球
				g.setColor(new Color(230, 230, 80));
				g.fillOval(ballX , ballY , BALL_SIZE, BALL_SIZE);
				// 设置颜色，并绘制球拍
				g.setColor(new Color(80, 80, 200));
				g.fillRect(racketX , RACKET_Y
					, RACKET_WIDTH , RACKET_HEIGHT);
				// 设置颜色，并绘制生命值
				g.setColor(Color.red);
				g.setFont(LifeFont);
				g.drawString("Life:"+lives, 20,30);
			}
		}
	}
}
