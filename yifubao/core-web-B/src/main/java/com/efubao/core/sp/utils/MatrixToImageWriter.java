package com.efubao.core.sp.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/**
 *生成二维码 
 */
public class MatrixToImageWriter {
	private static final int BLACK = 0xFF000000;  
	private static final int WHITE = 0xFFFFFFFF;  
	   
	private MatrixToImageWriter() {}  
	   
	public static BufferedImage toBufferedImage(BitMatrix matrix) {  
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}  
	   
    /** 
     *  最终调用该方法生成二维码图片 
     * @param url 要生成二维码的url 
     * @param imgPath 二维码生成的绝对路径 
     * @param logoPath 二维码中间logo绝对地址 
     * @throws Exception 
     */  
    public static void c2CodeImage(String url,String imgPath,String logoPath) throws Exception{  
        String format = "png";  
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();   
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");    
        BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 600, 600, hints);
        File qrcodeFile = new File(imgPath);    
        MatrixToImageWriter.writeToFile(bitMatrix, format, qrcodeFile, logoPath);    
    } 
	
    /** 
     *  
     * @param matrix 二维码矩阵相关 
     * @param format 二维码图片格式 
     * @param file 二维码图片文件 
     * @param logoPath logo路径 
     * @throws IOException 
     */  
    public static void writeToFile(BitMatrix matrix,String format,File file,String logoPath) throws IOException {  
        BufferedImage image = toBufferedImage(matrix);  
        Graphics2D g = image.createGraphics();  
        
        /**
        * 读取Logo图片
        */
        BufferedImage logo = ImageIO.read(new File(logoPath));

        float pos =  (float)logo.getWidth()/(float)logo.getHeight();
        int widthLogo = image.getWidth()/7, heightLogo = image.getHeight()/7;
        float logoWid = heightLogo/pos;
        heightLogo = (int)logoWid;
        // 计算图片放置位置
        int x = (image.getWidth() - widthLogo) / 2;
        int y = (image.getHeight() - heightLogo) / 2;
        
        //开始绘制图片
        g.drawImage(logo, x, y, widthLogo, heightLogo, null);
        
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.WHITE);
        g.drawRoundRect(x, y, widthLogo, heightLogo, 5, 5);
        //g.drawRect(x, y, widthLogo, heightLogo);
        

        g.dispose();
        
        
        logo.flush();  
        if(!ImageIO.write(image, format, file)){  
            throw new IOException("Could not write an image of format " + format + " to " + file);    
        }  
    }  
      
	
    
	/**
	 * 将二维码生成到文件 
	 */
	public static void writeToFile(BitMatrix matrix, String format, File file)
			throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format "
					+ format + " to " + file);
		}
	}

	/**
	 * 将二维码生成到输出流 
	 */
	public static void writeToStream(BitMatrix matrix, String format,
			OutputStream stream) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format "
					+ format);
		}
	}
	
	/**
	 * 将二维码生成到输出流 ,带logo
	 */
	public static void writeToStream(BitMatrix matrix, String format,
			OutputStream stream,InputStream is) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		
		Graphics2D g = image.createGraphics();
		/**
		 * 读取Logo输入流
		 */
		if(is != null){
			BufferedImage logo = ImageIO.read(is);
			float pos = (float) logo.getWidth() / (float) logo.getHeight();
			int widthLogo = image.getWidth() / 7, heightLogo = image.getHeight() / 7;
			float logoWid = heightLogo / pos;
			heightLogo = (int) logoWid;
			// 计算图片放置位置
			int x = (image.getWidth() - widthLogo) / 2;
			int y = (image.getHeight() - heightLogo) / 2;
	
			// 开始绘制图片
			g.drawImage(logo, x, y, widthLogo, heightLogo, null);
	
			g.setStroke(new BasicStroke(3));
			g.setColor(Color.WHITE);
			g.drawRoundRect(x, y, widthLogo, heightLogo, 5, 5);
			// g.drawRect(x, y, widthLogo, heightLogo);
	
			g.dispose();
			logo.flush();
		}
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format "
					+ format);
		}
	}
}
