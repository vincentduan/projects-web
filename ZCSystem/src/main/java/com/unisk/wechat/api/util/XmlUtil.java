package com.unisk.wechat.api.util;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unisk.wechat.api.msg.Msg;
import com.unisk.wechat.api.msg.xml.receive.RequestMsg;
import com.unisk.wechat.api.msg.xml.send.ReplyImageMsg;
import com.unisk.wechat.api.msg.xml.send.ReplyNewsMsg;
import com.unisk.wechat.api.msg.xml.send.ReplyTextMsg;

/**
 * 实体bean与xml相互转化工具类
 * jaxb处理CDATA解决方案参考：http://my.oschina.net/dailongyao/blog/338906?fromerr
 * 
 * @author bang
 * @Date 2015-11-18
 */
public class XmlUtil {
	private static final Logger logger = LoggerFactory.getLogger(XmlUtil.class);

	/**
	 * 将标注了jaxb注解的实体类转化为xml格式
	 * 
	 * @param obj
	 *            标注了jaxb注解的实体类
	 * @return xml格式字符串
	 */
	public static String toXml(Object obj) {
		StringWriter writer = new StringWriter();
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
			// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//
			// 是否格式化生成的xml串
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);// 是否省略xml头声明信息

			/*
			 * //因为CharacterEscapeHandler是jdk访问受限制类，故不再采用此方案处理CDATA
			 * marshaller.setProperty
			 * ("com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler",
			 * new CharacterEscapeHandler() {
			 * 
			 * @Override public void escape(char[] ch, int start, int length,
			 * boolean isAttVal, Writer writer) throws IOException {
			 * writer.write(ch, start, length); } });
			 */
			marshaller.marshal(obj, writer);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		/*
		 * if (logger.isDebugEnabled()) { logger.debug(writer.toString()); }
		 */
		return writer.toString();
	}

	/**
	 * xml转化为bean
	 * 
	 * @param xml
	 * @param c
	 * @return
	 */
	public static <T> T parseXml(String xml, Class<T> c) {
		T t = null;
		if (logger.isDebugEnabled()) {
			logger.debug("要解析的xml串为：{}", xml);
		}
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (JAXBException e) {
			if (logger.isDebugEnabled()) {
				logger.debug("jaxb转化字符串xml为{}实体类失败,失败原因:{}", c.getName(), e.getMessage());
			}
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * xml字符串转map对象 利用dom4j
	 * 
	 * @param xml
	 * @return
	 */
	public static Map<String, Object> xmlToMap(String xml) {
		Document document;
		try {
			document = DocumentHelper.parseText(xml);
			return xml2Map(document);
		} catch (DocumentException e) {
			if (logger.isDebugEnabled()) {
				logger.debug("解析字符串xml失败,失败原因:{}", e.getMessage());
			}
			e.printStackTrace();
		}
		return null;
	}

	public static Map<String, Object> xml2Map(Document document) {
		Map<String, Object> xmlMap = new HashMap<String, Object>();
		if (document == null)
			return null;
		Element root = document.getRootElement();
		for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
			Element e = (Element) iterator.next();
			List list = e.elements();
			if (list.size() > 0) {
				xmlMap.put(e.getName(), xml2Map(e));
			} else {
				xmlMap.put(e.getName(), e.getText());
			}
		}
		return xmlMap;
	}

	/**
	 * 输入流对象转map集合
	 * 
	 * @param in
	 * @return
	 */
	public static Map<String, Object> inputStreamToMap(InputStream in) {
		org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
		try {
			Document document = reader.read(in);
			Map<String, Object> map = xml2Map(document);
			if (logger.isDebugEnabled()) {
				logger.debug("解析请求输入流为map对象：{}", map);
			}
			return map;
		} catch (DocumentException e) {
			if (logger.isDebugEnabled()) {
				logger.debug("解析request请求输入流失败,失败原因:{}", e.getMessage());
			}
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * String格式字符串转map集合
	 */
	public static Map<String, Object> stringXmlToMap(String xml) {
		org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
		try {
			StringReader sr = new StringReader(xml);
			Document document = reader.read(sr);
			Map<String, Object> map = xml2Map(document);
			if (logger.isDebugEnabled()) {
				logger.debug("解析请求输入流为map对象：{}", map);
			}
			return map;
		} catch (DocumentException e) {
			if (logger.isDebugEnabled()) {
				logger.debug("解析request请求输入流失败,失败原因:{}", e.getMessage());
			}
			e.printStackTrace();
		}
		return null;
	}

	public static Map xml2Map(Element e) {
		Map map = new HashMap();
		List list = e.elements();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Element iter = (Element) list.get(i);
				List mapList = new ArrayList();

				if (iter.elements().size() > 0) {
					Map m = xml2Map(iter);
					if (map.get(iter.getName()) != null) {
						Object obj = map.get(iter.getName());
						if (!obj.getClass().getName().equals("java.util.ArrayList")) {
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(m);
						}
						if (obj.getClass().getName().equals("java.util.ArrayList")) {
							mapList = (List) obj;
							mapList.add(m);
						}
						map.put(iter.getName(), mapList);
					} else {
						map.put(iter.getName(), m);
					}
				} else {
					if (map.get(iter.getName()) != null) {
						Object obj = map.get(iter.getName());
						if (!obj.getClass().getName().equals("java.util.ArrayList")) {
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(iter.getText());
						}
						if (obj.getClass().getName().equals("java.util.ArrayList")) {
							mapList = (List) obj;
							mapList.add(iter.getText());
						}
						map.put(iter.getName(), mapList);
					} else
						map.put(iter.getName(), iter.getText());
				}
			}
		} else {
			map.put(e.getName(), e.getText());
		}
		return map;
	}

	public static void main(String[] args) {
		ReplyTextMsg msg = new ReplyTextMsg();
		msg.setFromUserName("bang");
		msg.setToUserName("张三");
		msg.setMsgType(Msg.MSG_TYPE_TEXT);
		msg.setContent("你好&我在测试");
		msg.setCreateTime(System.currentTimeMillis() + "");
		String result = toXml(msg);
		System.out.println(result);

		ReplyImageMsg image = new ReplyImageMsg();
		image.setFromUserName("bang");
		image.setToUserName("张三");
		image.setMsgType(Msg.MSG_TYPE_IMAGE);
		image.setMsgId("21213");
		image.setPicUrl("http://www.baidu.com");
		List<String> mediaIds = new ArrayList<String>();
		mediaIds.add("123213123");
		mediaIds.add("tret");
		image.setMediaId(mediaIds);
		result = toXml(image);
		System.out.println(result);

		ReplyNewsMsg newsMsg = new ReplyNewsMsg();
		newsMsg.setArticleCount(2);
		List<ReplyNewsMsg.InnerNewsMsg> news = new ArrayList<ReplyNewsMsg.InnerNewsMsg>();
		ReplyNewsMsg.InnerNewsMsg newmsg = new ReplyNewsMsg.InnerNewsMsg();
		newmsg.setDescription("都是分散的说法都是地方");
		newmsg.setPicUrl("http://www.baidu.com");
		newmsg.setTitle("施敬邦test");
		newmsg.setUrl("http://www.sina.com");
		news.add(newmsg);

		newmsg = new ReplyNewsMsg.InnerNewsMsg();
		newmsg.setDescription("dfdssdfsdf");
		newmsg.setPicUrl("http://www.qq.com");
		newmsg.setTitle("zhouejieluntest");
		newmsg.setUrl("http://www.taobao.com");
		news.add(newmsg);
		newsMsg.setNews(news);

		newsMsg.setCreateTime(System.currentTimeMillis() + "");
		newsMsg.setFromUserName("施敬邦");
		newsMsg.setMsgType("video");
		newsMsg.setToUserName("周杰伦");

		System.out.println(toXml(newsMsg));

		/*
		 * ImageMsg obj = parseXml(result, ImageMsg.class);
		 * System.out.println(obj.getFromUserName());
		 * 
		 * String xml =
		 * "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><xml>   <ToUserName><![CDATA[shijingbang]]></ToUserName>   <FromUserName><![CDATA[周杰伦]]></FromUserName>    <CreateTime>1348831860</CreateTime>   <MsgType><![CDATA[你好呀，哈哈]]></MsgType>   <Content><![CDATA[this is a test]]></Content>   <MsgId>1234567890123456</MsgId>   <AgentID>1</AgentID></xml>"
		 * ; ImageMsg obj1 = parseXml(xml, ImageMsg.class);
		 * System.out.println(obj1.getFromUserName());
		 * 
		 * String ss =
		 * "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><xml>    <AgentID>1</AgentID>    <FromUserName>bang</FromUserName>    <MsgType>image</MsgType>    <ToUserName>张三</ToUserName>    <PicUrl>http://www.baidu.com</PicUrl>    <MsgId>21213</MsgId>    <MediaId>123213123</MediaId></xml>"
		 * ; Map map = xmlToMap(ss);
		 * 
		 * System.out.println(map);
		 */

		String str = "<xml><ToUserName><![CDATA[wxfcb21d8e71642675]]></ToUserName><Encrypt><![CDATA[RxihboLMIOC7Kn+2F041jgePovx/tBqx/tGGy/FXl4eM86IAx5JzS83Z7fAldpX/O9YeOsnw3KOxBxVU9PJ7JrrHo2c+7Ii5CCM0gdQB5o0qp4J/GnpQTuOGRqPsfPjAROGEtIx93yRpXWrHdLT1cmvCCN+AuU1kje2KV4XTFJ2izrryB1x5Wq/cSxYSadHYLuGvI5jihUaPgRE9RAEn2aw24Zq3p9Eu4tfusCVjZXI+K8e5iPNPHNAwUL476EVT220yFgLU03BpJkVCZcG+lxWSWh+5076kThMbfa4z6gIuRLklYMZ77ozMrFyLON2puwuJgoRDbvNMuXNpszq6BD0tuxEs4IJSt9LL1fevEM+F+giNZZKuDpj6VwdsyxjUuoaR4GDJ5xEJlIEnj9kliDPTo98KSI/wxSB8UdfXFVP2KejL0LibCDR+3/7hHdeGgOu/BkiPIa76RPKrv7v1Xw==]]></Encrypt><AgentID><![CDATA[2]]></AgentID></xml>";

		RequestMsg requestMsg = parseXml(str, RequestMsg.class);
		System.out.println(requestMsg);

		String str1 = "<xml><ToUserName><![CDATA[%1$s]]></ToUserName><FromUserName><![CDATA[%2$s]]></FromUserName><CreateTime>%3$s</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[%4$s]]></Content></xml>";
		String result1 = String.format(str1, "施敬邦", "周杰伦", System.currentTimeMillis() + "", "你好，施敬邦欢迎关注沃众筹微信企业号！");
		System.out.println("响应结果：" + result1);

	}
}
