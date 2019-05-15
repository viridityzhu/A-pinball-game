package pinball.commons;
/**
 * 保存游戏配置的对象
 * 
 */
public class GameConfiguration {
	// 提供一个构造器
	public GameConfiguration(int TABLE_WIDTH, int TABLE_HEIGHT) {
		this.TABLE_WIDTH = TABLE_WIDTH;
		this.TABLE_HEIGHT = TABLE_HEIGHT;
	}
	
	// 桌面的宽度
	private final int TABLE_WIDTH;
	// 桌面的高度
	private final int TABLE_HEIGHT;
	// 玩家的生命值
	private int lives=3;
	// 当前关卡
	private int level=1;
	// 游戏总关卡数
	final private int totalLevels=1;
	// 游戏是否结束的旗标
	private boolean isLose = false;
	// 游戏是否开始的旗标
	private boolean isStart = false;
	// 游戏是否胜利的旗标
	private boolean isWin=false;
	
	
	
	public int getTABLE_WIDTH() {
		return TABLE_WIDTH;
	}
	public int getTABLE_HEIGHT() {
		return TABLE_HEIGHT;
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
	public boolean isLose() {
		return isLose;
	}
	public void setLose(boolean isLose) {
		this.isLose = isLose;
	}
	public boolean isStart() {
		return isStart;
	}
	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public boolean isWin() {
		return isWin;
	}
	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}
	public int getTotalLevels() {
		return totalLevels;
	}

}
