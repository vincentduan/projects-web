package com.efubao.core.admin.controller.newfileupload;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/open/imgupload")
public class ImgUploadController extends AbstractResourceController {

	/**
	 * 单文件上传
	 * @param mfs
	 * @return
	 */
	@RequestMapping(value="/single",method = RequestMethod.POST)
	@ResponseBody
	public String singleUpload(@RequestParam MultipartFile mfs)
	{
		String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
		
		String check =  super.validateFile(mfs, IMG_ACCETP_TYPES);
		
		if(StringUtils.isNotEmpty(check))
		{
			return String.format(msg, false, null, check);
		}
		
		String path = super.fileUpload(mfs);
		
		if(StringUtils.isEmpty(path))
		{
			return String.format(msg, false, null, "上传失败");
		}
		
		return String.format(msg, true, path, "上传成功");
	}
	
	/**
	 * 多文件上传
	 * @param mfs
	 * @return
	 */
	@RequestMapping(value="/multi",method = RequestMethod.POST)
	@ResponseBody
	public String multiUpload(@RequestParam MultipartFile[] mfs)
	{
		String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
		
		if(mfs.length > MAX_COUNT)
		{
			return String.format(msg, false, null, "每次最多上传"+MAX_COUNT+"个文件");
		}
		
		String[] paths = new String[mfs.length];

		int i = 0;
		for (MultipartFile multipartFile : mfs)
		{
			String check =  super.validateFile(multipartFile, IMG_ACCETP_TYPES);
			
			if(StringUtils.isNotEmpty(check))
			{
				continue;
			}
			
			String path = super.fileUpload(multipartFile);
			
			if (StringUtils.isNotBlank(path))
			{
				paths[i] = path;
				i++;
			}
		}
		
		if(paths.length==0)
		{
			return String.format(msg, false, null, "上传失败");
		}
		
		return String.format(msg, true, StringUtils.join(paths, ","), "上传成功");
	}
	
	
	/**
	 * 添加水印
	 * @param mf
	 * @return
	 * @throws Exception
	 */
	private byte[] makeWaterMark(MultipartFile mf) throws Exception
	{

		BufferedImage image = ImageIO.read(mf.getInputStream());

		BufferedImage overlay = ImageIO.read(this.getClass().getClassLoader().getResource("watermark.png"));

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		Thumbnails.of(image).size(image.getWidth(), image.getHeight()).watermark(Positions.CENTER, overlay, 1f).outputQuality(COMPRESSED_QUALITY).outputFormat(FilenameUtils.getExtension(mf.getOriginalFilename())).toOutputStream(baos);

		return baos.toByteArray();
	}
	
}
