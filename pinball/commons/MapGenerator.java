package pinball.commons;

//import java.awt.BasicStroke;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Random;

import javax.imageio.ImageIO;

import pinball.view.TableArea;

public class MapGenerator {
	//逻辑：遇到1就说明块还没有碰到球，遇到哪一块，那一块就置0
	private int map[][];
	//砖块行间距
	private int brickRowSpace=2;
	//砖块列间距
	private int brickColSpace=19+10;
	//砖块生成率，控制随机生成砖块的数量
	private double alpha=0.4;
	//砖块数
	private int brickNum=0;
	//砖块列表
	public ArrayList<Brick> brickList=new ArrayList<>();

	//level 1 map:
	  private int map1[][]=
	   {
	     //9*8
	     {0,1,1,1,1,1,1,1,0},
	     {0,1,1,1,1,1,1,1,0},
	     {0,0,1,1,1,1,1,0,0},
	     {0,0,1,1,1,1,1,0,0},
	     {0,0,0,1,1,1,0,0,0},
	     {0,0,0,0,1,0,0,0,0},
	     {0,0,0,0,0,0,0,0,0},
	     {0,0,0,0,0,0,0,0,0},

	   };
	  //level 2 map:
	  private int map2[][]=
	   {
	     {0,3,2,2,1,2,2,3,0},
	     {0,2,1,1,1,1,1,2,0},
	     {0,1,1,1,1,1,1,1,0},
	     {0,1,1,1,1,1,1,1,0},
	     {0,1,2,3,4,5,6,1,0},
	     {0,0,0,0,0,0,0,0,0},
	     {0,0,0,0,0,0,0,0,0},
	     {0,0,0,0,0,0,0,0,0},

	   };
	  //level 3 map:
	  private int map3[][]=
	   {
	     {3,3,2,2,2,2,2,3,3},
	     {0,0,2,2,2,2,2,0,0},
	     {0,0,0,3,4,3,0,0,0},
	     {0,0,0,0,4,0,0,0,0},
	     {0,0,0,0,4,0,0,0,0},
	     {0,0,0,3,4,3,0,0,0},
	     {0,0,2,2,2,2,2,0,0},
	     {3,3,2,2,2,2,2,3,3},

	   };
	  //level 4 map:
	  private int map4[][]=
	   {
	     {0,1,1,0,0,0,1,1,0},
	     {3,2,6,2,0,2,6,2,3},
	     {3,3,0,2,2,2,0,3,3},
	     {3,3,0,0,2,0,0,3,3},
	     {0,3,2,0,0,0,2,3,0},
	     {0,0,2,5,0,5,2,0,0},
	     {0,0,0,2,5,2,0,0,0},
	     {0,0,0,0,4,0,0,0,0}
	   };
	  //level 5 map:
	  private int map5[][]=
	   {
	    {0,1,1,0,0,0,1,1,0},
	    {3,2,2,2,0,2,2,2,3},
	    {3,3,3,6,6,6,3,3,3},
	    {3,3,3,5,4,5,3,3,3},
	    {0,3,2,2,4,2,2,3,0}, 
	    {0,0,2,1,1,1,2,0,0},
	    {0,0,0,2,1,2,0,0,0},
	    {0,0,0,0,1,0,0,0,0}
	   };
	  //level 6 map:
	  private int map6[][]=
	   {//14*21
			   //400*800
	     {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
	     {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
	     {0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0},
	     {0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0},
	     {0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0},
	     {0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0},
	     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
	     {1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1},
	     {1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
	     {1,0,0,1,0,1,1,1,0,1,0,1,0,1,1,1,0,0,1,0,1},
	     {1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1},
	     {1,0,1,1,0,1,1,1,1,0,1,0,0,1,1,1,1,0,1,1,1},
	     {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
	     {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0}
	  };

	public MapGenerator(Ball ball,ImageUtil imageUtil){
		//设置level1的砖块图片、背景图、小球图
		try {
			imageUtil.setBrick_image1(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/MidAutumnTheme/mooncake.png")));
			imageUtil.setBg_image(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/MidAutumnTheme/bg.png")));
			BufferedImage tempImage =ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/MidAutumnTheme/changee.png"));
			imageUtil.setBall_image(ImageUtil.resize(tempImage,ball.getBALL_SIZE(),ball.getBALL_SIZE()));
			
			// 提前放好level2的一些图片
			imageUtil.setBrick_image2(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/ElfTheme/1.3.png")));
			imageUtil.setBrick_image3(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/ElfTheme/1.4.png")));
			imageUtil.setBrick_image4(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/ElfTheme/1.1.png")));
			imageUtil.setBrick_image5(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/ElfTheme/1.5.png")));
			imageUtil.setBrick_image6(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/ElfTheme/1.6.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
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
	
	
		
	public void drawMap(TableArea tableArea,Graphics2D g,ImageUtil imageUtil){
		for(Brick b:brickList) 
			b.drawBrick(tableArea,g,imageUtil);
	}
	public void nextLevel(GameConfiguration config,ImageUtil imageUtil,Ball ball) {
		if(config.getLevel()==1) {
			//设置level2的砖块图片、背景图、小球图
			try {
				imageUtil.setBrick_image1(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/ElfTheme/1.2.png")));
				imageUtil.setBg_image(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/ElfTheme/bj1.jpg")));
				BufferedImage tempImage =ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/ElfTheme/1.7.png"));
				imageUtil.setBall_image(ImageUtil.resize(tempImage,ball.getBALL_SIZE(),ball.getBALL_SIZE()));
			} catch (IOException e) {
				e.printStackTrace();
			}
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
			//设置level3的砖块图片、背景图、小球图
			try {
				imageUtil.setBrick_image1(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/StarTheme/star1.png")));
				imageUtil.setBrick_image2(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/StarTheme/star2.png")));
				imageUtil.setBrick_image3(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/StarTheme/star3.png")));
				imageUtil.setBrick_image4(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/StarTheme/star4.png")));
				imageUtil.setBg_image(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/StarTheme/bg.png")));
				BufferedImage tempImage =ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/StarTheme/rocket.png"));
				imageUtil.setBall_image(ImageUtil.resize(tempImage,ball.getBALL_SIZE(),ball.getBALL_SIZE()));
			} catch (IOException e) {
				e.printStackTrace();
			}
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
			//设置level4的砖块图片、背景图、小球图
			try {
				imageUtil.setBrick_image1(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/FruitTheme/2.2.png")));
				imageUtil.setBrick_image2(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/FruitTheme/2.3.png")));
				imageUtil.setBrick_image3(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/FruitTheme/2.4.png")));
				imageUtil.setBrick_image4(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/FruitTheme/2.5.png")));
				imageUtil.setBrick_image5(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/FruitTheme/2.6.png")));
				imageUtil.setBrick_image6(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/FruitTheme/2.7.png")));
				imageUtil.setBg_image(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/FruitTheme/bj2.jpg")));
				BufferedImage tempImage =ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/FruitTheme/2.1.png"));
				imageUtil.setBall_image(ImageUtil.resize(tempImage,ball.getBALL_SIZE(),ball.getBALL_SIZE()));
			} catch (IOException e) {
				e.printStackTrace();
			}
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
			//设置level5的砖块图片、背景图、小球图
			try {
				imageUtil.setBrick_image1(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/JewelTheme/3.1.png")));
				imageUtil.setBrick_image2(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/JewelTheme/3.2.png")));
				imageUtil.setBrick_image3(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/JewelTheme/3.3.png")));
				imageUtil.setBrick_image4(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/JewelTheme/3.4.png")));
				imageUtil.setBrick_image5(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/JewelTheme/3.5.png")));
				imageUtil.setBrick_image6(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/JewelTheme/3.6.png")));
				imageUtil.setBg_image(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/JewelTheme/bj3.jpg")));
				BufferedImage tempImage =ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/JewelTheme/3.7.png"));
				imageUtil.setBall_image(ImageUtil.resize(tempImage,ball.getBALL_SIZE(),ball.getBALL_SIZE()));
			} catch (IOException e) {
				e.printStackTrace();
			}
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
			//设置level6的砖块图片、背景图、小球图
			try {
				imageUtil.setBrick_image1(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/UpTheme/up.png")));
				imageUtil.setBg_image(ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/UpTheme/bg.png")));
				BufferedImage tempImage =ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/UpTheme/girl.png"));
				imageUtil.setBall_image(ImageUtil.resize(tempImage,ball.getBALL_SIZE(),ball.getBALL_SIZE()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			//清空砖块列表和砖块总数
			brickList.clear();
			brickNum=0;
			//砖块行间距
			brickRowSpace=19-19;
			Brick.brickHeight=10+19;
			brickColSpace=10-1;
			Brick.brickWidth=28+1;
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
			config.setLevel(7);
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
