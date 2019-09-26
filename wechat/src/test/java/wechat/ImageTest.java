package wechat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class ImageTest {

	private static Logger log = Logger.getLogger(ImageTest.class);
	
	public static int[] getImgWidth(File file) {
		try {
			log.info("");
			InputStream is = null;
			BufferedImage src = null;
			int result[] = { 0, 0 };
			is = new FileInputStream(file);
			src = ImageIO.read(is);
			result[0] = src.getWidth(null);         // 得到源图宽 
			result[1] = src.getHeight(null);        // 得到源图高
			is.close();
			return result;
		} catch (Exception e) {
			log.error("系统异常",e);
			return null; 
		}
	}
}
