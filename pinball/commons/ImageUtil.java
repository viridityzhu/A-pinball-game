package pinball.commons;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageUtil {
	public BufferedImage cxy_image;
	//构造方法
	public ImageUtil (Ball ball) {
		try{
			BufferedImage tempImage = ImageIO.read (this.getClass ().getResourceAsStream ("../../pinball_images/4.png"));
			cxy_image = resize(tempImage,ball.getBALL_SIZE(),ball.getBALL_SIZE());
        }
        catch (IOException e){
            e.printStackTrace ();
        }		
	}
	//修改图片的方法
	public void changingImage (String s) {
		try{
			cxy_image = ImageIO.read (this.getClass().getResourceAsStream (s));
        }
        catch (IOException e){
            e.printStackTrace ();
        }	
	}
	//修改图片尺寸
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	} 
}
