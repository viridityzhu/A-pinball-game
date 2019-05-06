package pinball.commons;

//import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class MapGenerator {
	private int map[][];
	private int brickWidth;
	private int brickHeight;
	//砖块行间距
	private int brickRowSpace=8;
	//砖块列间距
	private int brickColSpace=4;
	//砖块生成率，控制随机生成砖块的数量
	private double alpha=0.4;

	
	public MapGenerator(int row,int col,GameConfiguration config){
		/*
		 * s.length是针对java中数组的，length是数组的一个属性，用来表示数组的长度
		   s.length()则是字符串的一个方法，用来返回字符串的长度的
		      字符串是没有length属性的，只有length()方法
		      数组有length属性，而没有length()方法 
		*/
		Random rand = new Random();
		map = new int [row][col];
		for(int i=0;i<map.length;i++){
			for(int j = 0;j<map[0].length;j++){
				//随机生成砖块
				map[i][j]=(int)(rand.nextDouble()+alpha);
				//逻辑：遇到1就说明块还没有碰到球，遇到哪一块，那一块就置0
			}
		}
		brickWidth=config.getTABLE_WIDTH()/col-brickRowSpace*row;
		brickHeight=config.getTABLE_HEIGHT()/3/row-brickColSpace*(col-1);
		
	}
		
	public void draw(Graphics2D g){
			for(int i=0;i<map.length;i++){
				for(int j = 0;j<map[0].length;j++){
					if(map[i][j]>0){
						g.setColor(Color.gray);
						g.fillRect(j*(brickWidth+brickRowSpace), i*(brickHeight+brickColSpace), brickWidth, brickHeight);				}
					//逻辑：遇到1就说明块还没有碰到球，遇到哪一块，那一块就置0
					/*填充矩形的原方法应该是：public void fillRect(int,int int,int );4个参数的意思分别为，起始X坐标，起始Y坐标，宽度，高度。*/
					
//					//为这些白色的边框设置边界
//					g.setStroke(new BasicStroke(1));
//					g.setColor(Color.black);
//					g.drawRect(j*brickWidth, i*brickHeight, brickWidth, brickHeight);
					/*
					 * BasicStroke是JDK中提供的一个基本的画笔类,我们对他设置画笔的粗细，就可以在drawPanel上任意画出自己想要的图形了。
					 * */
				}
			}
		}
	//下面为修改砖块的值，实现消块做准备
	public void setBrickValue(int value,int row,int col){
		map[row][col]=value;
	}
}
