package pinball.commons;

//import java.awt.BasicStroke;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class MapGenerator {
	//逻辑：遇到1就说明块还没有碰到球，遇到哪一块，那一块就置0
	private int map[][];
	//砖块行间距
	private int brickRowSpace=50;
	//砖块列间距
	private int brickColSpace=30;
	//砖块生成率，控制随机生成砖块的数量
	private double alpha=0.4;
	//砖块数
	private int brickNum=0;
	private int brickNum1=0;
	//砖块列表
	public ArrayList<Brick> brickList=new ArrayList<>();
	public ArrayList<Brick> brickList1=new ArrayList<>();
	
	
	
	
	
	//level 1 map:
	private int map1[][]=
		{
				{0,0,0,3,0,0,0},
				{0,0,2,2,2,0,0},
				{0,1,1,1,1,1,0}
		};
	
	
	
	
	
	{
		//level1砖块地图
		for(int i=0;i<map1.length;i++){
			for(int j = 0;j<map1[0].length;j++){
				if(map1[i][j]>=1) {
					//创建砖块对象，并存入砖块列表中
					Brick brick=new Brick(j*(Brick.brickWidth+brickColSpace),i*(Brick.brickHeight+brickRowSpace),map1[i][j]);
					brickList1.add(brick);
					brickNum1++;
//					System.out.println(brick.getBrickLives());
				}
			}
		}
		
		
		//随机砖块地图
		map=new int[3][8];
		Random rand = new Random();
		for(int i=0;i<map.length;i++){
			for(int j = 0;j<map[0].length;j++){
				//随机生成砖块
				map[i][j]=(int)(rand.nextDouble()+alpha);
				
				if(map[i][j]>=1) {
					//创建砖块对象，并存入砖块列表中
					Brick brick=new Brick(j*(Brick.brickWidth+brickColSpace),i*(Brick.brickHeight+brickRowSpace),1);
					brickList.add(brick);
					brickNum++;
				}
			}
		}
	}
	public MapGenerator(int row,int col,GameConfiguration config){
		System.out.println(Brick.brickHeight);
		System.out.println(Brick.brickWidth);		
	}
		
	public void drawMap(Graphics2D g){
		for(Brick b:brickList1) 
			b.drawBrick(g);
	}
	public void nextLevel(GameConfiguration config) {
		if(config.getLevel()==1) {
		}
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public int getBrickRowSpace() {
		return brickRowSpace;
	}

	public void setBrickRowSpace(int brickRowSpace) {
		this.brickRowSpace = brickRowSpace;
	}

	public int getBrickColSpace() {
		return brickColSpace;
	}

	public void setBrickColSpace(int brickColSpace) {
		this.brickColSpace = brickColSpace;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public int getBrickNum() {
		return brickNum;
	}

	public void setBrickNum(int brickNum) {
		this.brickNum = brickNum;
	}

	public int getBrickNum1() {
		return brickNum1;
	}

	public void setBrickNum1(int brickNum1) {
		this.brickNum1 = brickNum1;
	}

	public ArrayList<Brick> getBrickList() {
		return brickList;
	}

	public void setBrickList(ArrayList<Brick> brickList) {
		this.brickList = brickList;
	}

	public ArrayList<Brick> getBrickList1() {
		return brickList1;
	}

	public void setBrickList1(ArrayList<Brick> brickList1) {
		this.brickList1 = brickList1;
	}

	public int[][] getMap1() {
		return map1;
	}

	public void setMap1(int[][] map1) {
		this.map1 = map1;
	}


}
