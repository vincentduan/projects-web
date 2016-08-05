package com.efubao.core.admin.controller.newfileupload;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.efubao.core.common.fileupload.AbstractUploadController;

@Controller
@RequestMapping("/fileUpload")
public class ResourceUploadController extends AbstractUploadController{
	
	/**
	 * 单图片上传
	 * @param mfs
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/singlePic",method = RequestMethod.POST )
	public String singlePicUpload(@RequestParam MultipartFile mfs)
	{
		String rootPath = "/Users/cJack1913/workspace/fileUploadSpace/";
		return super.uploadSingleToLocal(mfs, true, false, rootPath);
	}
	
	/**
	 * 多图片上传
	 * @param mfs
	 * @return
	 */
//	@ResponseBody
//	@RequestMapping(value="/multiPic",method = RequestMethod.POST )
//	public String multiPicUpload(@RequestParam MultipartFile[] mfs)
//	{
//		String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
//		
//		if(mfs.length > MAX_COUNT)
//		{
//			return String.format(msg, false, null, "每次最多上传"+MAX_COUNT+"个文件");
//		}
//		
//		String[] paths = new String[mfs.length];
//
//		int i = 0;
//		for (MultipartFile multipartFile : mfs)
//		{
//			String check =  super.validateFile(multipartFile, RESOURCE_ACCETP_TYPES);
//			
//			if(StringUtils.isNotEmpty(check))
//			{
//				continue;
//			}
//			
//			String path = super.fileUpload(multipartFile);
//			
//			if (StringUtils.isNotBlank(path))
//			{
//				paths[i] = path;
//				i++;
//			}
//		}
//		
//		if(paths.length==0)
//		{
//			return String.format(msg, false, null, "上传失败");
//		}
//		
//		return String.format(msg, true, StringUtils.join(paths, ","), "上传成功");
//	}
	
}
