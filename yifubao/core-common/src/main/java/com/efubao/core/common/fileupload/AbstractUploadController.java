package com.efubao.core.common.fileupload;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.efubao.common.util.FileUtil;

public abstract class AbstractUploadController {

	/** log */
	private Logger logger = LoggerFactory
			.getLogger(AbstractUploadController.class);
	/** 单次上传图片不能超过50张 */
	public static final int MAX_COUNT = 50;
	/** 允许上传的文件类型 */
	private static final String IMG_ACCETP_TYPES = "png,jpg,jpeg";
	// private static final String CRM_ACCETP_TYPES =
	// "png,gif,jpg,jpeg,rar,zip,7z,doc,docx";
	// private static final String CRM_ACCETP_TYPES_1 =
	// "png,gif,jpg,jpeg,doc,docx";
	private static final String RECORECE_ACCETP_TYPES = "png,gif,jpg,jpeg,rar,zip,7z,doc,docx,xls,xlsx";
	/** 图片加水印后的质量设置 */
	private static final float COMPRESSED_QUALITY = 0.85F;

	/**
	 * local上传单资源
	 * 
	 * @param mf文件
	 * @param trackerCrmGroup
	 * @return
	 */
	public String uploadSingleToLocal(MultipartFile mf, Boolean isImg,
			Boolean watermark, String rootPath) {

		String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
		if (!isImg && watermark) {
			return String.format(msg, false, null, "非" + IMG_ACCETP_TYPES
					+ "禁止加水印");
		}
		String filename = mf.getOriginalFilename();
		String fileExtName = getFileExtName(mf);
		try {
			String type = isImg ? IMG_ACCETP_TYPES : RECORECE_ACCETP_TYPES;
			if (!validateFileExtName(mf, type, true, fileExtName)) {
				return String.format(msg, false, null, "文件格式错误，只支持" + type);
			}
			String file = saveFile(mf, watermark, rootPath);
			if (StringUtils.isNotBlank(file)) {
				return String.format(msg, true, file, "上传成功");
			} else {
				return String.format(msg, false, null, "文件上传失败，请重试或与管理员联系");
			}
		} catch (IOException e) {
			logger.error("Fail to upload file, filename is " + filename, e);
			return String.format(msg, false, null, "文件上传失败，请重试或与管理员联系");
		}
	}

	private String getFileExtName(MultipartFile mf) {
		String filename = mf.getOriginalFilename();
		if (StringUtils.isNotBlank(filename) && filename.contains(".")
				&& !filename.endsWith(".")) {
			return filename.substring(filename.lastIndexOf(".") + 1)
					.toLowerCase();
		}
		return null;
	}

	/**
	 * 验证文件扩展文件名
	 * 
	 * @param mf文件
	 * @param type扩展文件名类型
	 * @return
	 * @throws IOException
	 */
	private boolean validateFileExtName(MultipartFile mf, String type,
			boolean isImage, String fileExtName) throws IOException {
		if (StringUtils.isBlank(fileExtName)
				|| !StringUtils.contains(type, fileExtName)) {
			return false;
		}
		if (isImage) {
			ImageInputStream imageStream = ImageIO.createImageInputStream(mf
					.getInputStream());
			Iterator<ImageReader> readers = ImageIO
					.getImageReaders(imageStream);
			if (readers.hasNext()) {
				String formatName = readers.next().getFormatName();
				if (StringUtils.isBlank(formatName)
						|| !StringUtils.containsIgnoreCase(type, formatName)) {
					return false;
				}
			}
		}
		return true;
	}

	private static String generateFileName(){
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String timeStr = df.format(new Date());
		int radomInt = new Random().nextInt(899999)+100000;
		return timeStr+"_"+radomInt;
	}
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			
			System.out.println(generateFileName());
		}
	}
	/**
	 * 保存文件至local
	 * 
	 * @param mf文件
	 * @param watermark水印
	 * @return
	 * @throws IOException
	 */

	private String saveFile(MultipartFile mf, boolean watermark, String rootPath)
			throws IOException {
//		String fileName = mf.getOriginalFilename().replace(",", "_")
//				.replace("&", "_");
		String fileName = generateFileName()+"."+getFileExtName(mf);
		// 改名处理
		if (watermark) {
			// 添加水印
			byte[] bytes = null;
			BufferedImage image = ImageIO.read(mf.getInputStream());
			BufferedImage overlay = ImageIO.read(this.getClass()
					.getClassLoader().getResource("watermark.png"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Thumbnails.of(image).size(image.getWidth(), image.getHeight())
					.watermark(Positions.CENTER, overlay, 1f)
					.outputQuality(COMPRESSED_QUALITY)
					.outputFormat(getFileExtName(mf)).toOutputStream(baos);
			bytes = baos.toByteArray();
		} else {
			FileUtil.mkdir(rootPath);
			mf.transferTo(new File(rootPath + fileName));
		}
		return rootPath + fileName;
	}

	/**
	 * cms上传多张图片 图片格式限制为:CMS_ACCETP_TYPES 图片个数限制为:MAX_COUNT
	 * 
	 * @param mfs文件
	 * @param editorpic是否返回文件名
	 * @param isWater是否加水印
	 * @param size如果大小无限制
	 *            ，则传0
	 * @return
	 */
	// public String uploadMultiPicToCms(MultipartFile[] mfs, boolean editorpic,
	// boolean isWater, int size, TrackerGroup trackerCmsGroup) {
	//
	// String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
	// if (mfs == null || mfs.length == 0) {
	// return String.format(msg, false, null, "未接收到任何文件");
	// }
	//
	// if (mfs.length > MAX_COUNT) {
	// return String
	// .format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢 2.上传的单张图片不能大于10MB 3.上传多张图片数量不能超过50张");
	// }
	//
	// String[] files = new String[mfs.length];
	// int i = 0;
	// Pattern pattern = Pattern.compile("[,&]+");
	// for (MultipartFile mf : mfs) {
	// String filename = mf.getOriginalFilename();
	// String fileExtName = getFileExtName(mf);
	//
	// try {
	// if (!validateFileExtName(mf, CMS_ACCETP_TYPES, true,
	// fileExtName)) {
	// return String.format(msg, false, null, "文件格式错误，只支持"
	// + CMS_ACCETP_TYPES);
	// }
	// // 校验图片尺寸
	// if (!validateFileSize(mf, size)) {
	// return String
	// .format(msg,
	// false,
	// null,
	// "【上传失败：您上传的图片尺寸，有与标准详情图片尺寸640*N或913*N不符的情况，请检查后重新上传】",
	// null);
	// }
	// String file = uploadSinglePicToCms(mf, isWater, editorpic,
	// trackerCmsGroup, fileExtName);
	// if (StringUtils.isNotBlank(file)) {
	// //
	// group1/M00/00/35/CgwHElM-S1KALLY3AAAXDHhE9Eo44.jpeg&u=169233706,343847298.jpeg
	// // 过滤掉图片文件名里的特殊字符“，”“&”
	// String[] paths = file.split("&");
	// if (paths != null && paths.length > 0) {
	// Matcher matcher = pattern.matcher(paths[1]);
	// StringBuffer sbr = new StringBuffer();
	// while (matcher.find()) {
	// matcher.appendReplacement(sbr, "_");
	// }
	// matcher.appendTail(sbr);
	// file = paths[0] + "&" + String.valueOf(sbr);
	// }
	//
	// files[i] = file;
	// i++;
	// }
	// } catch (IOException e) {
	// logger.warn("Fail to upload file, filename is " + filename);
	// logger.error(e.getMessage());
	// return String.format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于10MB");
	// }
	//
	// }
	// return String.format(msg, true, StringUtils.join(files, ","), "上传成功");
	// }
	//
	// /**
	// * admin 上传多张图片
	// *
	// * @param mfs
	// * @param editorpic
	// * @param size
	// * @param trackerCmsGroup
	// * @return
	// */
	// public String uploadMultiPicToCmsByAdmin(MultipartFile[] mfs,
	// boolean editorpic, int size, TrackerGroup trackerCmsGroup) {
	// String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
	// if (mfs == null || mfs.length == 0) {
	// return String.format(msg, false, null, "未接收到任何文件");
	// }
	//
	// if (mfs.length > MAX_COUNT) {
	// return String
	// .format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢 2.上传的单张图片不能大于10MB 3.上传多张图片数量不能超过50张");
	// }
	// String[] files = new String[mfs.length];
	// int i = 0;
	// for (MultipartFile mf : mfs) {
	// String filename = mf.getOriginalFilename();
	// String fileExtName = getFileExtName(mf);
	//
	// try {
	// String file = uploadSinglePicToCms(mf, false, editorpic,
	// trackerCmsGroup, fileExtName);
	// if (StringUtils.isNotBlank(file)) {
	// files[i] = file;
	// i++;
	// }
	// } catch (IOException e) {
	// logger.warn("Fail to upload file, filename is " + filename);
	// logger.error(e.getMessage());
	// return String.format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于10MB");
	// }
	//
	// }
	// return String.format(msg, true, StringUtils.join(files, ","), "上传成功");
	// }
	//
	// /**
	// * admin 上传单张图片
	// *
	// * @param mfs
	// * @param editorpic
	// * @param size
	// * @param trackerCmsGroup
	// * @return
	// */
	// public String uploadSinglePicToCmsByAdmin(MultipartFile mf, boolean
	// water,
	// boolean withname, int size, TrackerGroup trackerCmsGroup) {
	// String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
	// if (mf == null) {
	// return String.format(msg, false, null, "未接收到任何文件");
	// }
	//
	// // 校验图片尺寸
	// if (!validateFileSize(mf, size)) {
	// PicSizeEnum picEnum = PicSizeEnum.valueOf(size);
	// int w = 0, h = 0;
	// String name = null;
	// if (picEnum != null) {
	// w = picEnum.getWidth();
	// h = picEnum.getHeight();
	// name = picEnum.getCname();
	// }
	// return String.format(msg, false, null, "上传失败：您上传的图片尺寸，与【" + name
	// + "】尺寸【" + w + "px*" + h + "px】不符，请检查后重新上传", null);
	// }
	//
	// String filename = mf.getOriginalFilename();
	// String fileExtName = getFileExtName(mf);
	// String file = null;
	// try {
	// file = uploadSinglePicToCms(mf, water, withname, trackerCmsGroup,
	// fileExtName);
	// } catch (IOException e) {
	// logger.warn("Fail to upload file, filename is " + filename);
	// logger.error(e.getMessage());
	// return String.format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于1MB");
	// }
	//
	// // file = "cms/M00/00/35/CgwHElM-S1KALLY3AAAXDHhE9Eo44.jpeg&test.png";
	//
	// if (StringUtils.isEmpty(file)) {
	// return String.format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于1MB");
	// }
	//
	// return String.format(msg, true, file, "上传成功");
	// }
	//
	// /**
	// * cms上传单张图片
	// *
	// * @param mf文件
	// * @param watermark是否加水印
	// * @return
	// */
	// public String uploadSinglePicToCms(MultipartFile mf, boolean watermark,
	// int size, TrackerGroup trackerCmsGroup) {
	//
	// String msg =
	// "{\"url\": \"%s\", \"fileType\":\"%s\", \"state\":\"%s\",\"original\":\"%s\"}";
	//
	// String filename = mf.getOriginalFilename();
	// String fileExtName = getFileExtName(mf);
	// try {
	// if (!validateFileExtName(mf, CMS_ACCETP_TYPES, true, fileExtName)) {
	// return String.format(msg, null, null, "文件格式错误，只支持"
	// + CMS_ACCETP_TYPES, null);
	// }
	// // 校验图片尺寸
	// if (!validateFileSize(mf, size)) {
	// return String.format(msg, false, null,
	// "上传失败：您上传的图片尺寸，与标准主图尺寸440*280不符，请检查后重新上传", null);
	// }
	// String file = uploadSinglePicToCms(mf, watermark, false,
	// trackerCmsGroup, fileExtName);
	// if (StringUtils.isNotBlank(file)) {
	// return String.format(msg, file, fileExtName, "SUCCESS",
	// filename);
	// } else {
	// // return String.format(msg, null, null,
	// // "文件上传失败，请重试或与管理员联系",null);
	// return String.format(msg, null, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于10MB",
	// null);
	// }
	// } catch (IOException e) {
	// logger.error("Fail to upload file, filename is " + filename, e);
	// // return String.format(msg, null, null, "文件上传失败，请重试或与管理员联系",null);
	// return String.format(msg, null, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于10MB",
	// null);
	// }
	// }
	//
	// /**
	// * crm上传单张图片
	// *
	// * @param mf文件
	// * @param trackerCrmGroup
	// * @return
	// */
	// public String uploadSinglePicToCrm(MultipartFile mf,
	// TrackerGroup trackerCrmGroup) {
	//
	// String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
	//
	// String filename = mf.getOriginalFilename();
	// String fileExtName = getFileExtName(mf);
	// try {
	// if (!validateFileExtName(mf, CRM_ACCETP_TYPES_1, true, fileExtName)) {
	// return String.format(msg, false, null, "文件格式错误，只支持"
	// + CRM_ACCETP_TYPES_1);
	// }
	// String file = uploadSinglePicToCms(mf, false, false,
	// trackerCrmGroup, fileExtName);
	// if (StringUtils.isNotBlank(file)) {
	// return String.format(msg, true, file, "上传成功");
	// } else {
	// // return String.format(msg, false, null, "文件上传失败，请重试或与管理员联系");
	// return String.format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于10MB");
	// }
	// } catch (IOException e) {
	// logger.error("Fail to upload file, filename is " + filename, e);
	// return String.format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于10MB");
	// }
	// }
	//
	//
	// /**
	// * 上传文件至fastdfs
	// *
	// * @param mf文件
	// * @param watermark水印
	// * @param withname是否显示文件名
	// * @return
	// * @throws IOException
	// */
	// private String uploadSinglePicToCms(MultipartFile mf, boolean watermark,
	// boolean withname, TrackerGroup trackerGroup, String fileExtName)
	// throws IOException {
	// String filename = mf.getOriginalFilename().replace(",", "_")
	// .replace("&", "_");
	// String[] results = uploadToFastdfs(filename, fileExtName, mf.getSize(),
	// mf.getInputStream(), watermark, trackerGroup);
	// if (results == null || results.length != 2) {
	// logger.warn("Fail to upload file, resutl is " + results);
	// return null;
	// }
	// return withFileName(withname, results, filename);
	// }
	//
	// /**
	// * crm上传多张图片 图片格式限制为:CRM_ACCETP_TYPES 图片个数限制为:MAX_COUNT
	// *
	// * @param mfs文件数组
	// * @param withname是否带上文件名返回
	// * @return
	// */
	// public String uploadMultiPicToCrm(@RequestParam final MultipartFile[]
	// mfs,
	// @RequestParam(value = "false", required = false) boolean withname,
	// TrackerGroup trackerCrmGroup) {
	// String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
	// if (mfs == null || mfs.length == 0) {
	// return String.format(msg, false, null, "未接收到任何文件");
	// }
	// if (mfs.length > MAX_COUNT) {
	// return String
	// .format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于10MB 3.上传多张图片数量不能超过50张");
	// }
	// String[] files = new String[mfs.length];
	// int i = 0;
	// for (MultipartFile mf : mfs) {
	// String filename = mf.getOriginalFilename().replace(",", "_")
	// .replace("&", "_");
	// String fileExtName = getFileExtName(mf);
	// try {
	// if (!this.validateFileExtName(mf, CRM_ACCETP_TYPES, false,
	// fileExtName)) {
	// return String.format(msg, false, null, "文件格式错误，只支持"
	// + CRM_ACCETP_TYPES);
	// }
	// String file = uploadSinglePicToCms(mf, false, withname,
	// trackerCrmGroup, fileExtName);
	// if (StringUtils.isNotBlank(file)) {
	// files[i] = file;
	// i++;
	// } else {
	// // return String.format(msg, false, null,
	// // "文件上传失败，请重试或与管理员联系");
	// return String
	// .format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于10MB");
	// }
	// } catch (IOException e) {
	// logger.warn("Fail to upload file, filename is " + filename, e);
	// // return String.format(msg, false, null, "文件上传失败，请重试或与管理员联系");
	// return String.format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于10MB");
	// }
	// }
	// return String.format(msg, true, StringUtils.join(files, ","), "上传成功");
	// }
	//
	// /**
	// * crm上传多张图片 图片格式限制为:CRM_ACCETP_TYPES 图片个数限制为:MAX_COUNT
	// *
	// * @param mfs文件数组
	// * @param withname是否带上文件名返回
	// * @return
	// */
	// public String uploadMultiNoticeToCrm(
	// @RequestParam final MultipartFile[] mfs,
	// @RequestParam(value = "false", required = false) boolean withname,
	// TrackerGroup trackerCrmGroup) {
	// String msg = "{\"success\":%b, \"filePath\":\"%s\", \"message\":\"%s\"}";
	// if (mfs == null || mfs.length == 0) {
	// return String.format(msg, false, null, "未接收到任何文件");
	// }
	// if (mfs.length > MAX_COUNT) {
	// // return String.format(msg, false, null, "上传图片不能超过50张");
	// return String.format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于10MB");
	// }
	// String[] files = new String[mfs.length];
	// int i = 0;
	// for (MultipartFile mf : mfs) {
	// String filename = mf.getOriginalFilename();
	// String fileExtName = getFileExtName(mf);
	// try {
	// if (!this.validateFileExtName(mf, CRM_ACCETP_TYPES_NOTICE,
	// false, fileExtName)) {
	// return String.format(msg, false, null, "文件格式错误，只支持"
	// + CRM_ACCETP_TYPES_NOTICE);
	// }
	// String file = uploadSinglePicToCms(mf, false, withname,
	// trackerCrmGroup, fileExtName);
	// if (StringUtils.isNotBlank(file)) {
	// files[i] = file;
	// i++;
	// } else {
	// // return String.format(msg, false, null,
	// // "文件上传失败，请重试或与管理员联系");
	// return String
	// .format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于10MB");
	// }
	// } catch (IOException e) {
	// logger.warn("Fail to upload file, filename is " + filename, e);
	// // return String.format(msg, false, null, "文件上传失败，请重试或与管理员联系");
	// return String.format(msg, false, null,
	// "上传图片失败的原因：1.请检查网络连接是否正常、网速是否太慢     2.上传的单张图片不能大于10MB");
	// }
	// }
	// return String.format(msg, true, StringUtils.join(files, ","), "上传成功");
	// }
	//
	// /**
	// * 带上文件名返回
	// *
	// * @param flag
	// * 是否带上文件名
	// * @param results
	// * 上传结果
	// * @param filename
	// * 上传得文件名
	// * @return
	// */
	// private String withFileName(Boolean flag, String[] results, String
	// filename) {
	// if (!flag) {
	// return StringUtils.join(results, "/");
	// } else {
	// return StringUtils.join(results, "/") + "&" + filename;
	// }
	// }
	//
	// /**
	// * upload file to fastdfs
	// *
	// * @param filename
	// * file name
	// * @param fileExtName
	// * file extensence
	// * @param fileLength
	// * file size
	// * @param in
	// * InputStream
	// * @param watermark
	// * 是否加水印
	// * @return file Id
	// */
	// private String[] uploadToFastdfs(final String filename,
	// final String fileExtName, final long fileLength,
	// final InputStream in, boolean watermark, TrackerGroup trackerGroup) {
	// TrackerClient trackerClient = new TrackerClient(trackerGroup);
	// // results[0]: groupName, results[1]: remoteFilename.
	// TrackerServer trackerServer = null;
	// try {
	//
	// byte[] bytes;
	// if (watermark) {// 添加水印
	// BufferedImage image = ImageIO.read(in);
	// BufferedImage overlay = ImageIO.read(this.getClass()
	// .getClassLoader().getResource("watermark.png"));
	// ByteArrayOutputStream baos = new ByteArrayOutputStream();
	// Thumbnails.of(image).size(image.getWidth(), image.getHeight())
	// .watermark(Positions.CENTER, overlay, 1f)
	// .outputQuality(COMPRESSED_QUALITY)
	// .outputFormat(fileExtName).toOutputStream(baos);
	// bytes = baos.toByteArray();
	// } else {
	// bytes = IOUtils.toByteArray(in);
	// }
	// trackerServer = trackerClient.getConnection();
	// StorageClient1 storageClient = new StorageClient1(trackerServer,
	// null);
	// NameValuePair[] metaList = new NameValuePair[] {
	// new NameValuePair("fileName", filename),
	// new NameValuePair("fileExtName", fileExtName),
	// new NameValuePair("fileLength", String.valueOf(fileLength)) };
	// return storageClient.upload_file(bytes, fileExtName, metaList);
	// } catch (Exception e) {
	// logger.warn("Fail to upload file, filename is " + filename, e);
	// } finally {
	// if (trackerServer != null) {
	// try {
	// trackerServer.close();
	// } catch (IOException e) {
	// // ignore
	// }
	// }
	// }
	// return null;
	// }
	//
	// /**
	// * 校验图片尺寸
	// *
	// * @param MultipartFile
	// * mf
	// * @param int size
	// */
	// public Boolean validateFileSize(MultipartFile mf, int size) {
	// Boolean flag = false;
	// try {
	// int w = Integer.MAX_VALUE;
	// int h = Integer.MAX_VALUE;
	// BufferedImage image = ImageIO.read(mf.getInputStream());
	// /*
	// * if (PicSizeEnum.MAIN_PIC.getId() == size) { w =
	// * PicSizeEnum.MAIN_PIC.getWidth(); h =
	// * PicSizeEnum.MAIN_PIC.getHeight(); } else if
	// * (PicSizeEnum.MIN_PIC.getId() == size) { w =
	// * PicSizeEnum.MIN_PIC.getWidth(); h =
	// * PicSizeEnum.MIN_PIC.getHeight(); } else { w =
	// * PicSizeEnum.OTHER_PIC.getWidth(); h =
	// * PicSizeEnum.OTHER_PIC.getHeight(); }
	// */
	// PicSizeEnum picEnum = PicSizeEnum.valueOf(size);
	// if (picEnum != null) {
	// w = picEnum.getWidth();
	// h = picEnum.getHeight();
	// }
	// if (PicSizeEnum.MIN_PIC.getId() == size) {
	// flag = isPicSize(w, h, image);
	// if (!flag) {
	// w = PicSizeEnum.MIN_PIC2.getWidth();
	// h = PicSizeEnum.MIN_PIC2.getHeight();
	// flag = isPicSize(w, h, image);
	// }
	// } else {
	// flag = isPicSize(w, h, image);
	// }
	// } catch (IOException e) {
	// logger.info("校验图片尺寸，图片格式错误Unsupported Image Type");
	// return flag;
	// }
	// return flag;
	// }
	//
	// public Boolean isPicSize(int w, int h, BufferedImage image) {
	// Boolean wf = (image.getWidth() == w);
	// Boolean hf = (image.getHeight() == h);
	// if (w == Integer.MAX_VALUE) {
	// wf = (image.getWidth() < w);
	// }
	// if (h == Integer.MAX_VALUE) {
	// hf = (image.getHeight() < h);
	// }
	// return (wf && hf);
	// }
}
