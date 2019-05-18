package pinball.commons;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageUtil {
	// 小球图片
	private BufferedImage ball_image;
	// 砖块图片
	private BufferedImage brick_image1;
	private BufferedImage brick_image2;
	private BufferedImage brick_image3;
	private BufferedImage brick_image4;
	private BufferedImage brick_image5;
	private BufferedImage brick_image6;
	// 背景图片
	private BufferedImage bg_image;
	// 胜利、失败图片
	private BufferedImage win_image;
	private BufferedImage lose_image;
	public ImageUtil(){
		try{
			win_image=ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/win.jpeg"));
			lose_image=ImageIO.read(this.getClass ().getResourceAsStream ("../../pinball_images/lose.jpeg"));
			
//			BufferedImage tempImage = ImageIO.read (this.getClass ().getResourceAsStream ("../../pinball_images/4.png"));
//			win_image = resize(tempImage,ball.getBALL_SIZE(),ball.getBALL_SIZE());
        }
        catch (IOException e){
            e.printStackTrace ();
        }		
	}
	// 修改图片尺寸
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}
	public BufferedImage getBall_image() {
		return ball_image;
	}
	public void setBall_image(BufferedImage ball_image) {
		this.ball_image = ball_image;
	}
	public BufferedImage getBrick_image1() {
		return brick_image1;
	}
	public void setBrick_image1(BufferedImage brick_image1) {
		this.brick_image1 = brick_image1;
	}
	public BufferedImage getBrick_image2() {
		return brick_image2;
	}
	public void setBrick_image2(BufferedImage brick_image2) {
		this.brick_image2 = brick_image2;
	}
	public BufferedImage getBrick_image3() {
		return brick_image3;
	}
	public void setBrick_image3(BufferedImage brick_image3) {
		this.brick_image3 = brick_image3;
	}
	public BufferedImage getWin_image() {
		return win_image;
	}
	public void setWin_image(BufferedImage win_image) {
		this.win_image = win_image;
	}
	public BufferedImage getLose_image() {
		return lose_image;
	}
	public void setLose_image(BufferedImage lose_image) {
		this.lose_image = lose_image;
	}
	public BufferedImage getBg_image() {
		return bg_image;
	}
	public void setBg_image(BufferedImage bg_image) {
		this.bg_image = bg_image;
	}
	public BufferedImage getBrick_image4() {
		return brick_image4;
	}
	public void setBrick_image4(BufferedImage brick_image4) {
		this.brick_image4 = brick_image4;
	}
	public BufferedImage getBrick_image5() {
		return brick_image5;
	}
	public void setBrick_image5(BufferedImage brick_image5) {
		this.brick_image5 = brick_image5;
	}
	public BufferedImage getBrick_image6() {
		return brick_image6;
	}
	public void setBrick_image6(BufferedImage brick_image6) {
		this.brick_image6 = brick_image6;
	} 
}
