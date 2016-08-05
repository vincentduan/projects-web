package com.efubao.core.admin.controller.newfileupload;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.efubao.core.common.newfileupload.service.ResourceService;

public abstract class AbstractResourceController
{
	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractResourceController.class);

	@Autowired
	private ResourceService resourceService;

	// 文件扩展名
	private static final String FILE_EXT_NAME = "fileExtName";

	// 文件名
	private static final String FILE_NAME = "fileName";

	// 文件大小
	private static final String FILE_LENGTH = "fileLength";

	// 图片加水印后的质量设置
	protected static final float COMPRESSED_QUALITY = 0.85F;

	// 单次上传图片不能超过50张
	protected static final int MAX_COUNT = 50;
	
	//单个文件的最大10MB
	protected static final long MAX_SIZE = 1024 * 1024 * 10;

	// 允许上传文件类型
	protected static final String[] RESOURCE_ACCETP_TYPES = {"png","gif","jpg","jpeg","rar", "zip","7z","doc","docx","xls","xlsx"};

	// 允许上传图片类型
	protected static final String[] IMG_ACCETP_TYPES = {"png","gif","jpg","jpeg"};

	
	protected String validateFile(MultipartFile multipartFile,String[] acceptType)
	{
		//错误消息
		String msg =  null;
		
		// 文件名
		String fileName = multipartFile.getOriginalFilename();
		
		// 扩展名
		String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		
		// 文件大小
		long fileSize = multipartFile.getSize();
		
		
		// 验证文件为空
		if (StringUtils.isEmpty(extension) || StringUtils.isEmpty(fileName) || fileSize <= 0)
		{
			msg = "上传文件为空";
			return msg;
		}
		
		// 验证文件大小
		if ( fileSize > MAX_SIZE)
		{
			msg = "文件超过10MB";
			return msg;
		}
		
		boolean flag = ArrayUtils.contains(acceptType, extension.toLowerCase());
		if(!flag)
		{
			msg = "文件格式不允许上传";
			return msg;
		}
		
		return msg;
	}

	/**
	 * 文件上传
	 * 
	 * @param multipartFile
	 * @param hasWaterMark
	 * @return
	 */
	protected String fileUpload(MultipartFile multipartFile)
	{
		byte[] datas = null;

		try
		{
			datas = multipartFile.getBytes();
		}
		catch (IOException e)
		{
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		
		// 文件名
		String fileName = multipartFile.getOriginalFilename();
		// 扩展名
		String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		// 文件大小
		String length = String.valueOf(datas.length);

		// 元数据
		Map<String, String> metadata = new HashMap<String, String>();
		metadata.put(FILE_EXT_NAME, extension);
		metadata.put(FILE_NAME, fileName);
		metadata.put(FILE_LENGTH, length);

		return path(extension, datas, metadata);
	}
	
	/**
	 * 
	 * @param extension扩展名
	 * @param datas字节数据
	 * @param metadata元数据
	 * @return
	 */
	private String path(String extension, byte[] datas, Map<String, String> metadata)
	{

		String resourcePath = null;

		try
		{
			resourcePath = resourceService.uploadResource(extension, datas, metadata);
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
			return resourcePath;
		}

		return resourcePath;
	}
	
	/**
	 * 文件下载
	 * @param path
	 * @return
	 */
	protected byte[] fileDownload(String path)
	{
		byte[] data  = null;
		
		try
		{
			data  = resourceService.downloadResource(path);
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
			return data;
		}
		return data;
	}

}
