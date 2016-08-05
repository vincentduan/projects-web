/**
 * FileUploadController.java
 * Copyright (c) 2013 by efubao.com
 */
package com.efubao.core.common.fileupload;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerGroup;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 文件上传&下载
 * 
 * 
 */
public abstract class AbstractDownloadController {
	
	/** log */
	private Logger logger = LoggerFactory.getLogger(AbstractDownloadController.class);

	/**
	 * download from fastdfs
	 * 
	 * @param groupName
	 * @param fileName
	 * @param compress是否压缩
	 * @param quality图片质量
	 * @return
	 */
	public byte[] download(String groupName, String fileName, boolean compress, float quality, TrackerGroup trackerGroup) {
		
		String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		TrackerClient trackerClient = new TrackerClient(trackerGroup);
		TrackerServer trackerServer = null;
		try
		{
			trackerServer = trackerClient.getConnection();
			StorageClient1 storageClient = new StorageClient1(trackerServer, null);
			byte[] bytes = storageClient.download_file(groupName, fileName);
			if (!compress || (!fileExtName.equals("jpg") && !fileExtName.equals("jpeg")))
			{// 只压缩JPG图片
				return bytes;
			}
			
			if (quality <= 0 || quality >= 1)
			{// 设置图片质量经验值
				if (bytes.length > 2 * FileUtils.ONE_MB)
				{// 2M以上只保留18%的质量
					quality = 0.18F;
				}
				else if (bytes.length > FileUtils.ONE_MB)
				{// 1M以上只保留25%的质量
					quality = 0.25F;
				}
				else if (bytes.length >= 500 * FileUtils.ONE_KB)
				{// 500KB以上只保留35%的质量
					quality = 0.35F;
				}
				else if (bytes.length >= 200 * FileUtils.ONE_KB)
				{// 200KB以上只保留55%的质量
					quality = 0.55F;
				}
				else
				{// 200KB以下只保留85%的质量
					quality = 0.85F;
				}
			}
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Thumbnails.of(image).size(image.getWidth(), image.getHeight()).outputFormat("jpg").outputQuality(quality).toOutputStream(baos);
			return baos.toByteArray();
		}
		catch (Exception e)
		{
			logger.warn("download fail");
		}
		finally
		{
			if (trackerServer != null)
			{
				try
				{
					trackerServer.close();
				}
				catch (IOException e)
				{
					// ignore
				}
			}
		}
		return null;
	}

	public void getFileName(String[] filePath, TrackerGroup trackerGroup) {
		TrackerClient trackerClient = new TrackerClient(trackerGroup);
		TrackerServer trackerServer = null;
		try
		{
			trackerServer = trackerClient.getConnection();
			StorageClient1 storageClient = new StorageClient1(trackerServer, null);
			findName(filePath, storageClient);
		}
		catch (Exception e)
		{
			logger.warn("获取图片时发生错误");
		}
		finally
		{
			if (trackerServer != null)
			{
				try
				{
					trackerServer.close();
				}
				catch (IOException e)
				{
					logger.error("关闭fastfs时发生错误", e);
				}
			}
		}

	}

	private void findName(String[] filePath, StorageClient1 storageClient) throws IOException, MyException {
		for (int i = 0; i < filePath.length; i++)
		{
			NameValuePair[] nvp = storageClient.get_metadata1(filePath[i]);
			if (nvp != null && nvp.length > 0)
			{
				for (int j = 0; j < nvp.length; j++)
				{
					if (nvp[j] != null && ("fileName").equals(nvp[j].getName()))
					{
						filePath[i] = filePath[i] + "&" + nvp[j].getValue();
						break;
					}
				}
			}
		}
	}

}
