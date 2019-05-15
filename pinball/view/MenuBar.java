package pinball.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//创建菜单条
import java.util.*;
import javax.swing.*;
public class MenuBar{
	public JMenuBar creatMenuBar() {
             JMenuBar bar = new JMenuBar();
             // 创建菜单对象
             JMenu menu_menu = new JMenu("菜单");
             JMenu difficulty_menu = new JMenu("难度");
             JMenu help_menu = new JMenu("帮助");
             // 创建“菜单”选项里的对象
             JMenuItem star_item = new JMenuItem("开始");
             JMenuItem exit_item = new JMenuItem("退出");
             JMenuItem help_item = new JMenuItem("游戏说明");
             JMenuItem about_item = new JMenuItem("关于");
             // 创建单选选项
             JRadioButtonMenuItem easy_item = new JRadioButtonMenuItem(
                             "简单");
             JRadioButtonMenuItem middle_item = new JRadioButtonMenuItem(
                             "中等");
             JRadioButtonMenuItem hard_item = new JRadioButtonMenuItem(
                             "困难");
             // 创建一个按钮组
             ButtonGroup group = new ButtonGroup();
             // 将单选按钮添加到按钮组中
             group.add(easy_item);
             group.add(middle_item);
             group.add(hard_item);
             // 将单选按钮添加到菜单中
             difficulty_menu.add(easy_item);
             difficulty_menu.add(middle_item);
             difficulty_menu.add(hard_item);
             //创建动作监听器
             ActionListener listener = new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                    	 String command = e.getActionCommand();
                         // 如果选择开始，则创建线程对象
                         if (command.equals("开始") && list.size() == 0) {
                                 //开始弹球游戏的代码块
                         }
                         // 如果选择退出按钮，则退出程序
                         if (command.equals("退出")) {
                                 System.exit(0);
                         }
                         // 如果选择简单按钮
                         if (command.equals("简单") && list.size() == 0) {
                                 //开始简单级别的弹球游戏代码块（通过改弹球速度之类的？）
                         }
                         // 如果选择中等按钮
                         if (command.equals("中等") && list.size() == 0) {
                                 //开始中等级别的弹球游戏代码块
                         }
                         if (command.equals("困难") && list.size() == 0) {
                                 //开始困难级别的弹球游戏的代码块
                         }
                         if (command.equals("游戏说明")) {
                                 JOptionPane.showMessageDialog(null, "这是一个有趣的弹球游戏，通过移动鼠标来控制挡板位置，接住小球；一旦没接到小球，游戏就结束啦！\n您可以自主选择游戏难度，包括简单、中等、困难\n快来玩吧！");
                         }
                         if (command.equals("关于")) {
                                 JOptionPane.showMessageDialog(null,"这是“飞快组好的最强JAVA搞事小组”的JAVA大作业\n有任何问题及可改进的地方，欢迎联系我们哟！");
                         }
                     }
             };
             // 添加动作监听器
             star_item.addActionListener(listener);
             exit_item.addActionListener(listener);
             easy_item.addActionListener(listener);
             middle_item.addActionListener(listener);
             hard_item.addActionListener(listener);
             help_item.addActionListener(listener);
             about_item.addActionListener(listener);
             // 将菜单选项添加到菜单上
             menu_menu.add(star_item);
             menu_menu.add(exit_item);
             help_menu.add(help_item);
             help_menu.add(about_item);
             // 将菜单添加到菜单条上
             bar.add(menu_menu);
             bar.add(difficulty_menu);
             bar.add(help_menu);
             // 返回菜单条对象
             return bar;
     }
}