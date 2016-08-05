package com.unisk.zc.core.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.unisk.zc.utils.CommonTool;
import com.unisk.zc.utils.springs.UniskPropertyPlaceHolder;


@Controller

public class UploadController {
	private AtomicInteger number = new AtomicInteger();

	@ResponseBody
	@RequestMapping(value={"/upload"})
	public String upload(String fileTarget,Boolean isReturnSuccess, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("*****************start*******************uploadImage*******:");
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		String fileName = null;
		if( StringUtils.isEmpty(fileTarget) )
			fileTarget = "fileupload";
		if( isReturnSuccess == null )
			isReturnSuccess = true;
		// 创建请求解析器
		CommonsMultipartResolver commonsM = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 设置编码
		commonsM.setDefaultEncoding("UTF-8");
		if (commonsM.isMultipart(request)) {
			try {
				// 转换成多部分request
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				// 获取上传的文件
				MultipartFile fileupload = multipartRequest.getFile(fileTarget);
				
				CommonTool.fileMkdir(UniskPropertyPlaceHolder.getProperty("tempFileSavePath",""));
				SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); // 时间格式化的格式
				String nowTimeStr = sDateFormat.format(new Date()); // 当前时间
				fileName = nowTimeStr + "_" + number.getAndIncrement() + "." + (fileupload.getContentType().split("/")[1]);

				File fileSave = new File(UniskPropertyPlaceHolder.getProperty("tempFileSavePath","") + fileName);
				fos = new FileOutputStream(fileSave);
				bos = new BufferedOutputStream(fos);
				bos.write(fileupload.getBytes());
				bos.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (bos != null) {
					try {
						bos.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

		}
		System.out.println("*****************end*******************uploadImage*******:");
		if(isReturnSuccess)
			return UniskPropertyPlaceHolder.getProperty("tempFileVisitPath","") + fileName;
		else
			return "Success";
	}

}
