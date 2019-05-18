package pinball.commons;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Select extends JFrame {
	public Select() {
		JButton j1 = new JButton("第一关");
		JButton j2 = new JButton("第二关");
		JButton j3 = new JButton("第三关");
		JButton j4 = new JButton("第四关");
		JButton j5 = new JButton("第五关");
		JButton j6 = new JButton("第六关");
		MyPanel mp = new MyPanel();
		j1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {			
				//进入关卡界面,将本界面画板和按钮隐藏，进入新面板				
				mp.setVisible(false);				
				j1.setVisible(false);
				j2.setVisible(false);
				j3.setVisible(false);
				j4.setVisible(false);
				j5.setVisible(false);
				j6.setVisible(false);
				//把面板传过去			
				}

			
			}
		);		
		j2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {			
				//进入关卡界面,将本界面画板和按钮隐藏，进入新面板				
				mp.setVisible(false);				
				j1.setVisible(false);
				j2.setVisible(false);
				j3.setVisible(false);
				j4.setVisible(false);
				j5.setVisible(false);
				j6.setVisible(false);
				//config.setlevel(2);
				//把面板传过去			
				}

			
			}
		);	
		j3.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {			
				//进入关卡界面,将本界面画板和按钮隐藏，进入新面板				
				mp.setVisible(false);				
				j1.setVisible(false);
				j2.setVisible(false);
				j3.setVisible(false);
				j4.setVisible(false);
				j5.setVisible(false);
				j6.setVisible(false);
				//把面板传过去			
				}

			
			}
		);
		j4.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {			
				//进入关卡界面,将本界面画板和按钮隐藏，进入新面板				
				mp.setVisible(false);				
				j1.setVisible(false);
				j2.setVisible(false);
				j3.setVisible(false);
				j4.setVisible(false);
				j5.setVisible(false);
				j6.setVisible(false);
				//把面板传过去			
				}

			
			}
		);	
		j5.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {			
				//进入关卡界面,将本界面画板和按钮隐藏，进入新面板				
				mp.setVisible(false);				
				j1.setVisible(false);
				j2.setVisible(false);
				j3.setVisible(false);
				j4.setVisible(false);
				j5.setVisible(false);
				j6.setVisible(false);
				//把面板传过去			
				}

			
			}
		);	
		j6.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {			
				//进入关卡界面,将本界面画板和按钮隐藏，进入新面板				
				mp.setVisible(false);				
				j1.setVisible(false);
				j2.setVisible(false);
				j3.setVisible(false);
				j4.setVisible(false);
				j5.setVisible(false);
				j6.setVisible(false);
				//把面板传过去			
				}

			
			}
		);		
		//this.setLayout(null);			
		this.add(j1);
		this.add(j2);
		this.add(j3);
		this.add(j4);
		this.add(j5);
		this.add(j6);
		this.add(mp);		

		j1.setBounds(80, 350, 160, 80);	
		j2.setBounds(320,350, 160, 80);
		j3.setBounds(560, 350, 160, 80);
		j4.setBounds(80, 450, 160, 80);
		j5.setBounds(320, 450, 160, 80);
		j6.setBounds(560, 450, 160, 80);
				
		//界面设置		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		this.setSize(800, 600);		
		this.setLocationRelativeTo(null);		
		this.setVisible(true);	
		
	}

}

//创建初始界面
class MyPanel extends JPanel{	
	public void paint(Graphics g){		
		super.paint(g);
//这里放一张 初始界面的图片	
		g.drawImage(new ImageIcon("./4.jpg").getImage(),0,0, 800,600, null);	
		}
	}

