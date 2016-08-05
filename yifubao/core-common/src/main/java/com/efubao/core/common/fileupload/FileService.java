package com.efubao.core.common.fileupload;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerGroup;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	private Logger logger = LoggerFactory.getLogger(FileService.class);

	/** 单次上传图片不能超过50张 */
	public static final int MAX_COUNT = 50;
	/** 允许上传的文件类型 */
	private static final String CMS_ACCETP_TYPES = "jpg,jpeg";
	private static final String CRM_ACCETP_TYPES = "png,gif,jpg,jpeg,rar,zip,7z,doc,docx";
	private static final String CRM_ACCETP_TYPES_1 = "png,gif,jpg,jpeg,doc,docx";
	private static final String CRM_ACCETP_TYPES_NOTICE = "png,gif,jpg,jpeg,rar,zip,7z,doc,docx,xls,xlsx";
	/** 图片加水印后的质量设置 */
	private static final float COMPRESSED_QUALITY = 0.85F;

	private TrackerGroup trackerGroup;

	public TrackerGroup getTrackerGroup( ) {
		return trackerGroup;
	}

	public void setTrackerGroup(TrackerGroup trackerGroup) {
		this.trackerGroup = trackerGroup;
	}

	/**
	 * download from fastdfs
	 * 
	 * @param groupName
	 * @param fileName
	 * @param compress是否压缩
	 * @param quality图片质量
	 * @return
	 */
	public byte[] download(String groupName, String fileName, boolean compress, float quality) {
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
					quality = 0.15F;
				}
				else if (bytes.length > FileUtils.ONE_MB)
				{// 1M以上只保留25%的质量
					quality = 0.20F;
				}
				else if (bytes.length >= 500 * FileUtils.ONE_KB)
				{// 500KB以上只保留35%的质量
					quality = 0.30F;
				}
				else if (bytes.length >= 100 * FileUtils.ONE_KB)
				{// 200KB以上只保留55%的质量
					quality = 0.40F;
				}
				else
				{// 100KB以下只保留55%的质量
					quality = 0.55F;
				}
			}
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Thumbnails.of(image).size(image.getWidth(), image.getHeight()).outputFormat("jpg").outputQuality(quality).toOutputStream(baos);
			return baos.toByteArray();
		}
		catch (Exception e)
		{
			logger.warn("download file failed  ");
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

	public String[] getFileName(String[] filePath) {
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
			logger.error("获取图片时发生错误：", e);
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
					logger.error("关闭fastfs时发生错误", e);
				}
			}
		}
		return filePath;
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

	/**
	 * cms上传多张图片 图片格式限制为:CMS_ACCETP_TYPES 图片个数限制为:MAX_COUNT
	 * 
	 * @param mfs
	 *            文件
	 * @param editorpic
	 *            是否返回文件名
	 * @param isWater
	 *            是否加水印
	 * @return
	 */
	public String uploadMultiPicToCms(MultipartFile[] mfs, boolean editorpic, boolean isWater) {
		String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
		if (mfs == null || mfs.length == 0)
		{
			return String.format(msg, false, null, "未接收到任何文件");
		}
		if (mfs.length > MAX_COUNT)
		{
			return String.format(msg, false, null, "上传图片不能超过50张");
		}
		String[] files = new String[mfs.length];
		int i = 0;
		for (MultipartFile mf : mfs)
		{
			String filename = mf.getOriginalFilename().replace(",", "_").replace("&", "_");
			String fileExtName = getFileExtName(mf);
			try
			{
				if (!validateFileExtName(mf, CMS_ACCETP_TYPES, true, fileExtName))
				{
					return String.format(msg, false, null, "文件格式错误，只支持" + CMS_ACCETP_TYPES);
				}
				String file = uploadSinglePicToCms(mf, isWater, editorpic, trackerGroup, fileExtName);
				if (StringUtils.isNotBlank(file))
				{
					files[i] = file;
					i++;
				}
			}
			catch (IOException e)
			{
				logger.warn("Fail to upload file, filename is " + filename, e);
				return String.format(msg, false, null, "文件上传失败，请重试或与管理员联系");
			}
		}
		return String.format(msg, true, StringUtils.join(files, ","), "上传成功");
	}

	/**
	 * cms上传单张图片
	 * 
	 * @param mf
	 *            文件
	 * @param watermark
	 *            是否加水印
	 * @return
	 */
	public String uploadSinglePicToCms(MultipartFile mf, boolean watermark) {
		String msg = "{\"url\": \"%s\", \"fileType\":\"%s\", \"state\":\"%s\",\"original\":\"%s\"}";
		String filename = mf.getOriginalFilename().replace(",", "_").replace("&", "_");
		String fileExtName = getFileExtName(mf);
		try
		{
			if (!validateFileExtName(mf, CMS_ACCETP_TYPES, true, fileExtName))
			{
				return String.format(msg, null, null, "文件格式错误，只支持" + CMS_ACCETP_TYPES, null);
			}
			String file = uploadSinglePicToCms(mf, watermark, false, trackerGroup, fileExtName);
			if (StringUtils.isNotBlank(file))
			{
				return String.format(msg, file, fileExtName, "SUCCESS", filename);
			}
			else
			{
				return String.format(msg, null, null, "文件上传失败，请重试或与管理员联系", null);
			}
		}
		catch (IOException e)
		{
			logger.warn("Fail to upload file, filename is " + filename);
			return String.format(msg, null, null, "文件上传失败，请重试或与管理员联系", null);
		}
	}

	/**
	 * crm上传单张图片
	 * 
	 * @param mf
	 *            文件
	 * @param watermark
	 *            是否加水印
	 * @return
	 */
	public String uploadSinglePicToCrm(MultipartFile mf) {
		String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
		String filename = mf.getOriginalFilename().replace(",", "_").replace("&", "_");
		String fileExtName = getFileExtName(mf);
		try
		{
			if (!validateFileExtName(mf, CRM_ACCETP_TYPES_1, true, fileExtName))
			{
				return String.format(msg, false, null, "文件格式错误，只支持" + CRM_ACCETP_TYPES_1);
			}
			String file = uploadSinglePicToCms(mf, false, false, trackerGroup, fileExtName);
			if (StringUtils.isNotBlank(file))
			{
				return String.format(msg, true, file, "上传成功");
			}
			else
			{
				return String.format(msg, false, null, "文件上传失败，请重试或与管理员联系");
			}
		}
		catch (IOException e)
		{
			logger.error("Fail to upload file, filename is " + filename);
			return String.format(msg, false, null, "文件上传失败，请重试或与管理员联系");
		}
	}

	private String getFileExtName(MultipartFile mf) {
		String filename = mf.getOriginalFilename().replace(",", "_").replace("&", "_");
		if (StringUtils.isNotBlank(filename) && filename.contains(".") && !filename.endsWith("."))
		{
			return filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
		}
		return null;
	}

	/**
	 * 验证文件扩展文件名
	 * 
	 * @param mf
	 *            文件
	 * @param type
	 *            扩展文件名类型
	 * @return
	 * @throws IOException
	 */
	private boolean validateFileExtName(MultipartFile mf, String type, boolean isImage, String fileExtName) throws IOException {
		if (StringUtils.isBlank(fileExtName) || !StringUtils.contains(type, fileExtName))
		{
			return false;
		}
		if (isImage)
		{
			ImageInputStream imageStream = ImageIO.createImageInputStream(mf.getInputStream());
			Iterator<ImageReader> readers = ImageIO.getImageReaders(imageStream);
			if (readers.hasNext())
			{
				String formatName = readers.next().getFormatName();
				if (StringUtils.isBlank(formatName) || !StringUtils.containsIgnoreCase(type, formatName))
				{
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 上传文件至fastdfs
	 * 
	 * @param mf文件
	 * @param watermark水印
	 * @param withname是否显示文件名
	 * @return
	 * @throws IOException
	 */
	private String uploadSinglePicToCms(MultipartFile mf, boolean watermark, boolean withname, TrackerGroup trackerGroup, String fileExtName) throws IOException {
		String filename = mf.getOriginalFilename().replace(",", "_").replace("&", "_");
		String[] results = uploadToFastdfs(filename, fileExtName, mf.getSize(), mf.getInputStream(), watermark, trackerGroup);
		if (results == null || results.length != 2)
		{
			logger.warn("Fail to upload file, resutl is " + results);
			return null;
		}
		return withFileName(withname, results, filename);
	}

	/**
	 * crm上传多张图片 图片格式限制为:CRM_ACCETP_TYPES 图片个数限制为:MAX_COUNT
	 * 
	 * @param mfs文件数组
	 * @param withname是否带上文件名返回
	 * @return
	 */
	public String uploadMultiPicToCrm(@RequestParam final MultipartFile[] mfs, @RequestParam(value = "false", required = false) boolean withname) {
		
		String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
		
		if (mfs == null || mfs.length == 0)
		{
			return String.format(msg, false, null, "未接收到任何文件");
		}
		if (mfs.length > MAX_COUNT)
		{
			return String.format(msg, false, null, "上传图片不能超过50张");
		}
		String[] files = new String[mfs.length];
		int i = 0;
		for (MultipartFile mf : mfs)
		{
			String filename = mf.getOriginalFilename().replace(",", "_").replace("&", "_");
			String fileExtName = getFileExtName(mf);
			try
			{
				if (!this.validateFileExtName(mf, CRM_ACCETP_TYPES, false, fileExtName))
				{
					return String.format(msg, false, null, "文件格式错误，只支持" + CRM_ACCETP_TYPES);
				}
				String file = uploadSinglePicToCms(mf, false, withname, trackerGroup, fileExtName);
				if (StringUtils.isNotBlank(file))
				{
					files[i] = file;
					i++;
				}
				else
				{
					return String.format(msg, false, null, "文件上传失败，请重试或与管理员联系");
				}
			}
			catch (IOException e)
			{
				logger.warn("Fail to upload file, filename is " + filename);
				return String.format(msg, false, null, "文件上传失败，请重试或与管理员联系");
			}
		}
		return String.format(msg, true, StringUtils.join(files, ","), "上传成功");
	}

	/**
	 * crm上传多张图片 图片格式限制为:CRM_ACCETP_TYPES 图片个数限制为:MAX_COUNT
	 * 
	 * @param mfs文件数组
	 * @param withname是否带上文件名返回
	 * @return
	 */
	public String uploadMultiNoticeToCrm(@RequestParam final MultipartFile[] mfs, @RequestParam(value = "false", required = false) boolean withname) {
		
		String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
		
		if (mfs == null || mfs.length == 0)
		{
			return String.format(msg, false, null, "未接收到任何文件");
		}
		if (mfs.length > MAX_COUNT)
		{
			return String.format(msg, false, null, "上传图片不能超过50张");
		}
		String[] files = new String[mfs.length];
		int i = 0;
		for (MultipartFile mf : mfs)
		{
			String filename = mf.getOriginalFilename().replace(",", "_").replace("&", "_");
			String fileExtName = getFileExtName(mf);
			try
			{
				if (!this.validateFileExtName(mf, CRM_ACCETP_TYPES_NOTICE, false, fileExtName))
				{
					return String.format(msg, false, null, "文件格式错误，只支持" + CRM_ACCETP_TYPES_NOTICE);
				}
				String file = uploadSinglePicToCms(mf, false, withname, trackerGroup, fileExtName);
				if (StringUtils.isNotBlank(file))
				{
					files[i] = file;
					i++;
				}
				else
				{
					return String.format(msg, false, null, "文件上传失败，请重试或与管理员联系");
				}
			}
			catch (IOException e)
			{
				logger.warn("Fail to upload file, filename is " + filename);
				return String.format(msg, false, null, "文件上传失败，请重试或与管理员联系");
			}
		}
		return String.format(msg, true, StringUtils.join(files, ","), "上传成功");
	}

	/**
	 * 带上文件名返回
	 * 
	 * @param flag是否带上文件名
	 * @param results上传结果
	 * @param filename上传得文件名
	 * @return
	 */
	private String withFileName(Boolean flag, String[] results, String filename) {
		if (!flag)
		{
			return StringUtils.join(results, "/");
		}
		else
		{
			return StringUtils.join(results, "/") + "&" + filename;
		}
	}

	/**
	 * upload file to fastdfs
	 * 
	 * @param filename file name
	 * @param fileExtName
	 *            file extensence
	 * @param fileLength
	 *            file size
	 * @param in
	 *            InputStream
	 * @param watermark
	 *            是否加水印
	 * @return file Id
	 */
	private String[] uploadToFastdfs(final String filename, final String fileExtName, final long fileLength, final InputStream in, boolean watermark, TrackerGroup trackerGroup) {
		TrackerClient trackerClient = new TrackerClient(trackerGroup);
		// results[0]: groupName, results[1]: remoteFilename.
		TrackerServer trackerServer = null;
		try
		{
			byte[] bytes;
			if (watermark)
			{// 添加水印
				BufferedImage image = ImageIO.read(in);
				BufferedImage overlay = ImageIO.read(this.getClass().getClassLoader().getResource("watermark.png"));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				Thumbnails.of(image).size(image.getWidth(), image.getHeight()).watermark(Positions.CENTER, overlay, 1f).outputQuality(COMPRESSED_QUALITY).outputFormat(fileExtName).toOutputStream(baos);
				bytes = baos.toByteArray();
			}
			else
			{
				bytes = IOUtils.toByteArray(in);
			}
			trackerServer = trackerClient.getConnection();
			StorageClient1 storageClient = new StorageClient1(trackerServer, null);
			NameValuePair[] metaList = new NameValuePair[] { new NameValuePair("fileName", filename), new NameValuePair("fileExtName", fileExtName), new NameValuePair("fileLength", String.valueOf(fileLength)) };
			return storageClient.upload_file(bytes, fileExtName, metaList);
		}
		catch (Exception e)
		{
			logger.warn("uploadToFastdfs 图片格式错误");
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

}
