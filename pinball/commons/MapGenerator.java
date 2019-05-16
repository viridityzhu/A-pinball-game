package pinball.commons;

//import java.awt.BasicStroke;

import java.awt.Graphics2D;
import java.util.ArrayList;
//import java.util.Random;

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
	//砖块列表
	public ArrayList<Brick> brickList=new ArrayList<>();

	//level 1 map:
	private int map1[][]=
		{
				{0,0,0,0,0,0,0},
				{0,0,1,0,0,0,0},
				{0,0,0,0,0,0,0}
		};
	//level 2 map:
	private int map2[][]=
		{
				{0,0,0,0,0,0,0},
				{0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0}
		};
	//level 3 map:
	private int map3[][]=
		{
				{0,0,1,0,0,0,0},
				{0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0}
		};
	//level 4 map:
	private int map4[][]=
		{
				{1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0}
		};
	//level 5 map:
	private int map5[][]=
		{
				{0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0},
				{0,0,0,0,0,1,0}
		};
	//level 6 map:
	private int map6[][]=
		{
				{0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0},
				{0,0,0,1,0,0,0}
		};

	
	
	
	{

		//由level1砖块地图生成砖块列表
		for(int i=0;i<map1.length;i++){
			for(int j = 0;j<map1[0].length;j++){
				if(map1[i][j]>=1) {
					//创建砖块对象，并存入砖块列表中
					Brick brick=new Brick(j*(Brick.brickWidth+brickColSpace),i*(Brick.brickHeight+brickRowSpace),map1[i][j]);
					brickList.add(brick);
					brickNum++;
				}
			}
		}

		
		
//		//随机砖块地图
//		map=new int[3][8];
//		Random rand = new Random();
//		for(int i=0;i<map.length;i++){
//			for(int j = 0;j<map[0].length;j++){
//				//随机生成砖块
//				map[i][j]=(int)(rand.nextDouble()+alpha);
//				
//				if(map[i][j]>=1) {
//					//创建砖块对象，并存入砖块列表中
//					Brick brick=new Brick(j*(Brick.brickWidth+brickColSpace),i*(Brick.brickHeight+brickRowSpace),1);
//					brickList.add(brick);
//					brickNum++;
//				}
//			}
//		}
	}
	
	
		
	public void drawMap(Graphics2D g){
		for(Brick b:brickList) 
			b.drawBrick(g);
	}
	public void nextLevel(GameConfiguration config) {
		if(config.getLevel()==1) {
			//清空砖块列表和砖块总数
			brickList.clear();
			brickNum=0;
			//由level2砖块地图生成砖块列表
			for(int i=0;i<map2.length;i++){
				for(int j = 0;j<map2[0].length;j++){
					if(map2[i][j]>=1) {
						//创建砖块对象，并存入砖块列表中
						Brick brick=new Brick(j*(Brick.brickWidth+brickColSpace),i*(Brick.brickHeight+brickRowSpace),map2[i][j]);
						brickList.add(brick);
						brickNum++;
					}
				}
			}
			config.setLevel(2);
		}
		else if(config.getLevel()==2) {
			//清空砖块列表和砖块总数
			brickList.clear();
			brickNum=0;
			//由level3砖块地图生成砖块列表
			for(int i=0;i<map3.length;i++){
				for(int j = 0;j<map3[0].length;j++){
					if(map3[i][j]>=1) {
						//创建砖块对象，并存入砖块列表中
						Brick brick=new Brick(j*(Brick.brickWidth+brickColSpace),i*(Brick.brickHeight+brickRowSpace),map3[i][j]);
						brickList.add(brick);
						brickNum++;
					}
				}
			}
			config.setLevel(3);
		}
		else if(config.getLevel()==3) {
			//清空砖块列表和砖块总数
			brickList.clear();
			brickNum=0;
			//由level4砖块地图生成砖块列表
			for(int i=0;i<map4.length;i++){
				for(int j = 0;j<map4[0].length;j++){
					if(map4[i][j]>=1) {
						//创建砖块对象，并存入砖块列表中
						Brick brick=new Brick(j*(Brick.brickWidth+brickColSpace),i*(Brick.brickHeight+brickRowSpace),map4[i][j]);
						brickList.add(brick);
						brickNum++;
					}
				}
			}
			config.setLevel(4);
		}
		else if(config.getLevel()==4) {
			//清空砖块列表和砖块总数
			brickList.clear();
			brickNum=0;
			//由level5砖块地图生成砖块列表
			for(int i=0;i<map5.length;i++){
				for(int j = 0;j<map5[0].length;j++){
					if(map5[i][j]>=1) {
						//创建砖块对象，并存入砖块列表中
						Brick brick=new Brick(j*(Brick.brickWidth+brickColSpace),i*(Brick.brickHeight+brickRowSpace),map5[i][j]);
						brickList.add(brick);
						brickNum++;
					}
				}
			}
			config.setLevel(5);
		}
		else if(config.getLevel()==5) {
			//清空砖块列表和砖块总数
			brickList.clear();
			brickNum=0;
			//由level6砖块地图生成砖块列表
			for(int i=0;i<map6.length;i++){
				for(int j = 0;j<map6[0].length;j++){
					if(map6[i][j]>=1) {
						//创建砖块对象，并存入砖块列表中
						Brick brick=new Brick(j*(Brick.brickWidth+brickColSpace),i*(Brick.brickHeight+brickRowSpace),map6[i][j]);
						brickList.add(brick);
						brickNum++;
					}
				}
			}
			config.setLevel(6);
		}
		else if(config.getLevel()==6) {
			config.setWin(true);
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

	public ArrayList<Brick> getBrickList() {
		return brickList;
	}

	public void setBrickList(ArrayList<Brick> brickList) {
		this.brickList = brickList;
	}

	public int[][] getMap1() {
		return map1;
	}

	public void setMap1(int[][] map1) {
		this.map1 = map1;
	}


}
