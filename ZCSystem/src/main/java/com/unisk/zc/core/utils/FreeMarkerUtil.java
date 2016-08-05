package com.unisk.zc.core.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoader;

import com.unisk.wechat.api.support.SystemConfig;
import com.unisk.zc.utils.DateUtils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

/**
 * FreeMarker解析工具类
 * 
 * @author shijingbang
 * 
 */
public class FreeMarkerUtil {
	private static Logger logger = LoggerFactory.getLogger(FreeMarkerUtil.class);
	private static Configuration config = new Configuration();
	// 模板目录，相对于classpath的
	public static final String templateFolder = SystemConfig.getValue("wzc.freemarker.template_folder", "template");
	public static final String DEFAULT_GENERATE_FOLDER = "statics/upload/notice/{0}/";
	public static final String generateFolder = SystemConfig.getValue("wzc.freemarker.upload_folder");

	static {
		config.setEncoding(Locale.CHINA, "UTF-8");
		config.setDefaultEncoding("UTF-8");
		config.setIncompatibleImprovements(new Version(2, 3, 20));
		config.setObjectWrapper(new DefaultObjectWrapper());
		config.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		try {
			String path = FreeMarkerUtil.class.getClassLoader().getResource(templateFolder).getPath();
			logger.info("freemarker模板存放路径为:" + path);
			config.setDirectoryForTemplateLoading(new File(path));
		} catch (IOException e) {
			logger.info("加载freemarker配置出错！" + e.getMessage());
		}
	}

	/**
	 * 
	 * @param templateName
	 *            模板名称
	 * @param fileName
	 *            要生成的文件名称
	 * @param root
	 *            生成文件所需的数据
	 */
	public static String analysisTemplate(String templateName, String fileName, Map<?, ?> root, boolean isGeneFile) {
		Writer writer = null;
		String result = "";
		try {
			Template template = config.getTemplate(templateName);
			if (isGeneFile) {

				File file = new File(getUploadFilePath() + fileName);
				if (!file.exists()) {
					file.getParentFile().mkdirs();
				}
				FileOutputStream fos = new FileOutputStream(file);
				writer = new OutputStreamWriter(fos, "UTF-8");
				template.process(root, writer);
				writer.flush();
				writer.close();
				logger.info("生成{}文件成功,文件路径:{}", fileName, file.getAbsolutePath());
				return result;
			}
			writer = new StringWriter();
			template.process(root, writer);
			result = writer.toString();
			writer.close();
			logger.info("处理模板{}成功", templateName);
		} catch (Exception e) {
			logger.error("处理模板出错!错误原因：{}", e.getMessage());
		}
		return result;
	}

	public static Configuration getConfig() {
		return config;
	}

	public static void setConfig(Configuration config) {
		FreeMarkerUtil.config = config;
	}

	public static void main(String[] args) {
		File file = new File(templateFolder);
		System.out.println(FreeMarkerUtil.class.getClassLoader().getResource("").getPath());
		file = new File(generateFolder);
		System.out.println(System.getProperty("user.dir"));
		System.out.println(file.getAbsolutePath());
		ClassPathResource res = new ClassPathResource(templateFolder);
		try {
			File file1 = res.getFile();
			System.out.println(res.getFile().getAbsolutePath());
		} catch (IOException e) {
			throw new RuntimeException("ClasspathUtil:getAbsolutePathOfClasspathResouce|get resource wrong!", e);
		}
	}

	public static String getUploadFilePath() {
		// 没有配置wzc.freemarker.upload_folder则上传至默认路径：tomcat服务的webapp/statics/upload/notice目录下
		if (StringUtils.isBlank(generateFolder)) {
			return ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/") + generateUploadFilePath(DEFAULT_GENERATE_FOLDER);
		}
		return generateUploadFilePath(generateFolder);
	}

	public static String generateUploadFilePath(String path) {
		return MessageFormat.format(path, DateUtils.getNowTime(DateUtils.DATE_SMALL_STR));
	}
}
