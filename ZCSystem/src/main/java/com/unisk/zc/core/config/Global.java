package com.unisk.zc.core.config;

import com.google.common.collect.Maps;
import com.unisk.zc.utils.springs.UniskPropertyPlaceHolder;

import java.util.Map;

import org.springframework.util.Assert;

public class Global
{

	private static Map map = Maps.newHashMap();

	public Global()
	{
	}

	public static String getConfig(String key)
	{
		String value = (String)map.get(key);
		if (value == null)
		{
			value = UniskPropertyPlaceHolder.getProperty(key, "");
			map.put(key, value);
		}
		return value;
	}

	public static String getAdminPath()
	{
		return getConfig("adminPath");
	}

	public static String getFrontPath()
	{
		return getConfig("frontPath");
	}

	public static String getUrlSuffix()
	{
		return getConfig("urlSuffix");
	}

	public static Boolean isDemoMode()
	{
		String dm = getConfig("demoMode");
		if (!"true".equals(dm) && !"1".equals(dm))
			return Boolean.valueOf(false);
		else
			return Boolean.valueOf(true);
	}

	public static Boolean isEnableWorkFlow()
	{
		String dm = getConfig("enableWorkFlow");
		if (!"true".equals(dm) && !"1".equals(dm))
			return Boolean.valueOf(false);
		else
			return Boolean.valueOf(true);
	}

	public static String getCkBaseDir()
	{
		String dir = getConfig("userfiles.basedir");
		Assert.hasText(dir, "配置文件里没有配置userfiles.basedir属性");
		if (!dir.endsWith("/"))
			dir = (new StringBuilder(String.valueOf(dir))).append("/").toString();
		return dir;
	}

	public static String getThemeDefault()
	{
		return getConfig("theme.default");
	}

}