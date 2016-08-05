//// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
//// Jad home page: http://kpdus.tripod.com/jad.html
//// Decompiler options: packimports(3) fieldsfirst ansi space 
//// Source File Name:   SpringContextHolder.java
//
package com.unisk.zc.utils.springs;

import java.io.IOException;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.DefaultResourceLoader;

//
//import java.io.IOException;
//
//import org.apache.commons.lang3.Validate;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.core.io.DefaultResourceLoader;
//
//public class SpringContextHolder
//	implements ApplicationContextAware, DisposableBean
//{
//
//	private static ApplicationContext applicationContext ;
//	private static Logger logger = LoggerFactory.getLogger(bjxask.emvc.core.utils.SpringContextHolder.class);
//
//	public SpringContextHolder()
//	{
//	}
//
//	public static ApplicationContext getApplicationContext()
//	{
//		assertContextInjected();
//		return applicationContext;
//	}
//
//	public static String getRootRealPath()
//	{
//		String rootRealPath = "";
//		try
//		{
//			rootRealPath = getApplicationContext().getResource("").getFile().getAbsolutePath();
//		}
//		catch (IOException e)
//		{
//			logger.warn("获取系统根目录失败");
//		}
//		return rootRealPath;
//	}
//
//	public static String getResourceRootRealPath()
//	{
//		String rootRealPath = "";
//		try
//		{
//			rootRealPath = (new DefaultResourceLoader()).getResource("").getFile().getAbsolutePath();
//		}
//		catch (IOException e)
//		{
//			logger.warn("获取资源根目录失败");
//		}
//		return rootRealPath;
//	}
//	 @SuppressWarnings("unchecked")
//	public static Object getBean(String name)
//	{
//		assertContextInjected();
//		return applicationContext.getBean(name);
//	}
//	 @SuppressWarnings("unchecked")
//	public static Object getBean(Class requiredType)
//	{
//		assertContextInjected();
//		return applicationContext.getBean(requiredType);
//	}
//
//	public static void clearHolder()
//	{
//		if (logger.isDebugEnabled())
//			logger.debug((new StringBuilder("清除SpringContextHolder中的ApplicationContext:")).append(applicationContext).toString());
//		applicationContext = null;
//	}
//
//	public  void setApplicationContext(ApplicationContext applicationContext)
//	{
//		 logger.debug("注入ApplicationContext到SpringContextHolder:{}", applicationContext);
//
//	        if (SpringContextHolder.applicationContext != null) {
//	            logger.warn("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:"
//	                    + SpringContextHolder.applicationContext);
//	        }
//               this.applicationContext = applicationContext;
//	}
//
//	public void destroy()
//		throws Exception
//	{
//		clearHolder();
//	}
//
//	private static void assertContextInjected()
//	{
//		   Validate.validState(applicationContext != null,
//	                "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
//	}
//
//	
//	
//
//}


/**

* 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候中取出ApplicaitonContext.

**/

public class SpringContextHolder implements ApplicationContextAware{

private static ApplicationContext applicationContext;
private static Logger logger = LoggerFactory.getLogger(com.unisk.zc.utils.springs.SpringContextHolder.class);

/**

* 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.

*/

public void setApplicationContext(ApplicationContext applicationContext) {

SpringContextHolder.applicationContext= applicationContext;

}

/**

* 取得存储在静态变量中的ApplicationContext.

*/

public static ApplicationContext getApplicationContext() {

checkApplicationContext();

return applicationContext;

}

/**

* 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.

*/

@SuppressWarnings("unchecked")

public static<T> T getBean(String name) {

checkApplicationContext();

return (T) applicationContext.getBean(name);

}

/**

* 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.

* 如果有多个Bean符合Class, 取出第一个.

*/

@SuppressWarnings("unchecked")

public static<T> T getBean(Class<T> clazz) {

checkApplicationContext();

Map beanMaps = applicationContext.getBeansOfType(clazz);

if (beanMaps!=null&& !beanMaps.isEmpty()) {

return(T) beanMaps.values().iterator().next();

} else{

return null;

}

}

private static void checkApplicationContext() {

if (applicationContext == null) {

throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");

}

}


public static String getRootRealPath()
{
	String rootRealPath = "";
	try
	{
		rootRealPath = getApplicationContext().getResource("").getFile().getAbsolutePath();
	}
	catch (IOException e)
	{
		logger.warn("获取系统根目录失败");
	}
	return rootRealPath;
}

public static String getResourceRootRealPath()
{
	String rootRealPath = "";
	try
	{
		rootRealPath = (new DefaultResourceLoader()).getResource("").getFile().getAbsolutePath();
	}
	catch (IOException e)
	{
		logger.warn("获取资源根目录失败");
	}
	return rootRealPath;
}

}