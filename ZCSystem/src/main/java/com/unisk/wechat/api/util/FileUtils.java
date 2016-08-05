package com.unisk.wechat.api.util;

import java.io.File;

import org.apache.commons.lang.StringUtils;

public class FileUtils extends org.apache.commons.io.FileUtils {
	/**
	 * 
	 * 微信企业号 上传永久素材限制<br/>
	 * 所有文件size必须大于5个字节<br/>
	 * 图片（image）:2MB，支持JPG,PNG格式<br/>
	 * 语音（voice）：2MB，播放长度不超过60s，支持AMR格式<br/>
	 * 视频（video）：10MB，支持MP4格式<br/>
	 * 普通文件（file）：20MB<br/>
	 * 整个企业图文消息素材和图片素材数目的上限为5000，其他类型为1000<br/>
	 * 超出素材数量限制返回错误码45028<br/>
	 * 
	 * @param file
	 * @return
	 * @author bang
	 */
	public static String getFileType(File file) {
		String filename = file.getName();
		String suffix = filename.substring(filename.lastIndexOf("."));
		String type = UploadType.file.name();
		if (StringUtils.equalsIgnoreCase(suffix, ".AMR")) {
			type = UploadType.voice.name();
		} else if (StringUtils.equalsIgnoreCase(suffix, ".JPG") || StringUtils.equalsIgnoreCase(suffix, ".PNG")) {
			type = UploadType.image.name();
		} else if (StringUtils.equalsIgnoreCase(suffix, ".MP4")) {
			type = UploadType.video.name();
		}
		return type;
	}

	public static void main(String[] args) {
		File file = new File("C:\\Users\\bang\\Desktop\\DEMO7.rar");
		System.out.println(getFileType(file));
	}
}
