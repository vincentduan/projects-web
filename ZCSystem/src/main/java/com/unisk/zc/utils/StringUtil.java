package com.unisk.zc.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

/**
 * 对字符串操作的静态类
 * 所有跟字符串有关的操作放到这里
 * @author xuhao
 *
 */
public class StringUtil {
	
	/**
	 * 创建的SecretKey的源
	 */
	private final static char[] KeyItem = new char[] { 'a', 'c', 'e', 'g', 'i',
			'k', 'm', 'o', 'q', 's', 'u', 'w', 'y', '0', '1', '2', '3', '4',
			'5', '6', '7', '8', '9', '*', '#', '^', '&', '$', '@' };
	
	/**
	 * 判断字符串是否为空
	 * 字符串为null 或者 str == '' 都视为空
	 * 都为空格也视为空
	 * 
	 * @param str
	 * @return 空为true，非空为false
	 */
	public static boolean isEmpty(String str){
		if (str == null) return true;    //字符为null
		if(str.trim().equals(""))	return true;   //字符为空串
		
		return false;
		
	}
	
	/**
	 * 判断对象是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(Object obj){
		if(obj == null)
			return true;
		
		if(obj instanceof String){
			String str = obj.toString();
			
			if("".equals(str.trim())){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 获取最终的值，空的对象则获取为空的字符串
	 * @param obj
	 * @return
	 */
	public static String getObjectValue(Object obj){
		String result = "";
		
		if(!isEmpty(obj)){
			result = obj.toString();
		}
		
		return result;
	}
	
	/**
	 * 创建密钥
	 * 
	 * @return
	 */
	public static String createSecretKey() {
		int number = KeyItem.length;
		String key = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			char c = KeyItem[new Random().nextInt(number)];
			sb.append(c);
		}
		key = sb.toString();
		return key;
	}
	
	/**
	 * 按字母升序排序组成待签名的字符串
	 * @param request  http请求
	 * @param list 不在签名里的参数
	 * @param isdecode 是否是解密，true ：URLDecoder ,false : URLEncoder
	 * @param code   编码类型 UTF-8 或 GBK
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unused")
	public static String createSignStr(HttpServletRequest request,List<String> list,boolean isdecode,String code) throws UnsupportedEncodingException {
		Map map = request.getParameterMap();
		Map<String,String> paraMap = new TreeMap<String, String>();
		for(Object object:map.keySet()){
			String key = object.toString();
			String value = request.getParameter(key);
			if(!list.contains(key)&&!"".equals(value)&&value!=null){
				if(isdecode){
					paraMap.put(key, URLDecoder.decode(value,code));
				}else{
					paraMap.put(key, URLEncoder.encode(value,code));
				}
			}
		}
		StringBuilder sbBuilder = new StringBuilder();
		for(String key:paraMap.keySet()){
			sbBuilder.append(key+"="+paraMap.get(key));
			sbBuilder.append("&");
		}
		return sbBuilder.toString().substring(0, sbBuilder.toString().lastIndexOf("&"));
	}
	
	/**
	 * 按字母升序排序组成待签名的字符串
	 * @param request  http请求
	 * @param list 不在签名里的参数
	 * @param isdecode 是否是解密，true ：URLDecoder ,false : URLEncoder
	 * @param 默认编码类型为UTF-8
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws UnsupportedEncodingException 
	 */
	public static String createSignStr(HttpServletRequest request,List<String> list,boolean isdecode) throws UnsupportedEncodingException{
		return createSignStr(request,list,isdecode,"UTF-8");
	}
	
}
