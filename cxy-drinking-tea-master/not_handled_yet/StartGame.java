import java.awt.*;
import java.javax.*;
import javax.swing.*;
public class StartGame{
	public void startGame() {
                // 设置标题
                this.setTitle("有趣的弹球小游戏");
                // 设置大小
                this.setSize(610, 635);
                // 设置关闭退出程序
                this.setDefaultCloseOperation(3);
                // 设置打开窗体时在屏幕中间显示
                this.setLocationRelativeTo(null);
                // 设置窗体的流式布局管理器
                this.setLayout(new java.awt.FlowLayout());
                // 设置窗体背景颜色
                this.getContentPane().setBackground(java.awt.Color.black);
                // 创建文本标签对象
                text_field = new javax.swing.JLabel();
                javax.swing.JLabel lable = new javax.swing.JLabel("时间 ：");
                // 设置文本标签前景颜色
                lable.setForeground(java.awt.Color.red);
                text_field.setForeground(java.awt.Color.red);
                // 创建进度条对象
                pBar = new javax.swing.JProgressBar(0, 330);
                // 创建按钮对象
                button = new javax.swing.JToggleButton();
                button.setMargin(new Insets(0, 0, 0, 0));
                button.setIcon(new javax.swing.ImageIcon("Pause.jpg"));
                button.setActionCommand("暂停");
  		          //创建动作监听器
                java.awt.event.ActionListener button_listener = new java.awt.event.ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                String com = e.getActionCommand();
                                if (com.equals("暂停")) {
                                        button.setMargin(new Insets(0, 0, 0, 0));
                                        button.setIcon(new javax.swing.ImageIcon("Pause.jpg"));
                                        button.setActionCommand("继续");
                                        for (int i = 0; i < list.size(); i++) {
                                                list.get(i).PauseThread();
                                        }
                                }
                                if (com.equals("继续")) {
                                        button.setMargin(new Insets(0, 0, 0, 0));
                                        button.setIcon(new javax.swing.ImageIcon("Pause.jpg"));
                                        button.setActionCommand("暂停");
                                        for (int i = 0; i < list.size(); i++) {
                                                list.get(i).ContinueThread();
                                        }
                                }
                        }
                };
                button.addActionListener(button_listener);
                this.add(button);
                this.add(lable);
                this.add(pBar);
                this.add(text_field);
                // 菜单条
                JMenuBar bar = creatMenuBar();
                // 为窗体设置菜单条
                this.setJMenuBar(bar);
                // 设置窗体的可见性
                this.setVisible(true);
        }
}