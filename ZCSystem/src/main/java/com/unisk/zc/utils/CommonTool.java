package com.unisk.zc.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.math.RandomUtils;

import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.utils.springs.UniskPropertyPlaceHolder;

public class CommonTool {

	public static final String PATH = "http://123.125.99.118";

	public static String createOrderNO() {
		String ret = DateUtils.getALLFormat().format(new Date(System.currentTimeMillis()));
		int ram = RandomUtils.nextInt(new Random(System.currentTimeMillis()), 999);
		int len = String.valueOf(ram).length();
		String zero = "";
		for (int i = 0; i < 3-len; i++) {
			zero += "0";
		}
		return ret + zero + ram;
	}
	
	public static String createRandomPWD(int n) {
		String ret = new String( System.currentTimeMillis() + "");
		ret = ret.substring( ret.length() + 1 - n );
		return ret ;
	}
	
	public static Map parserToMap(String s) {
		Map map = new HashMap();
		JSONObject json = JSONObject.fromObject(s);
		Iterator keys = json.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String value = json.get(key).toString();
			if (value.startsWith("{") && value.endsWith("}")) {
				map.put(key, parserToMap(value));
			} else {
				map.put(key, value);
			}

		}
		return map;
	}

	public static boolean isEmail(String email) {
		if (null == email || "".equals(email))
			return false;
		Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");// 复杂匹配
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static String parseRequestParam(String param) throws UniskException {
		try {
			param = new String(param.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new UniskException(e);
		}
		return getDecode(param);
	}

	public static void tempPictureCopy(String desPath, String fileName) throws UniskException {
		String tempImagePath = UniskPropertyPlaceHolder.getProperty("tempFileSavePath", "");
		fileMkdir(desPath);
		try {
			FileUtils.copyFile(new File(tempImagePath + "/" + fileName), new File(desPath + "/" + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new UniskException(e);
		}
	}

	public static void fileMkdir(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	public static String getDecode(String str) throws UniskException {
		try {
			String placeName = java.net.URLDecoder.decode(str, "UTF-8");
			return placeName;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new UniskException(e);
		}
	}

	public static String createPicture(String savePath, String visitPath, String getImageVisit) throws UniskException {
		try {
			String tempImageSavePath = UniskPropertyPlaceHolder.getProperty("tempFileSavePath", "");
			CommonTool.fileMkdir(savePath);

			int d = getImageVisit.lastIndexOf("/");

			System.out.println(tempImageSavePath + getImageVisit.substring(d + 1));
			System.out.println(savePath + getImageVisit.substring(d + 1));
			FileUtils.copyFile(new File(tempImageSavePath + getImageVisit.substring(d + 1)),
					new File(savePath + getImageVisit.substring(d + 1)));
			return visitPath + getImageVisit.substring(d + 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new UniskException(e);

		}
	}

	public static Boolean deletePicture(String savePath, String getImageVisit) throws UniskException {
		try {
			File deleteOwnFile = new File(savePath + getImageVisit.substring(getImageVisit.lastIndexOf("/") + 1));
			deleteOwnFile.delete();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UniskException(e);

		}
	}

	public static void main(String args[]) {
		//
		try {
			System.out.println(getDecode("%E6%B7%B1%E7%81%B0%2F%E6%A9%99%E8%89%B2"));
			System.out.println(createOrderNO());
		} catch (UniskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
