package com.unisk.wechat.api.support;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.unisk.wechat.api.msg.Msg;
import com.unisk.wechat.api.util.SpringUtils;
import com.unisk.wechat.api.util.XmlUtil;

/**
 * 
 * @Description:处理微信消息、事件
 * @author shijingbang
 * @Date 2015年11月19日
 */
@Component
@DependsOn("springUtils")
public class WechatSession {

	private static final Logger logger = LoggerFactory.getLogger(WechatSession.class);
	private Map<String, MessageHandler> handlers = new HashMap<String, MessageHandler>();

	@PostConstruct
	public void initHandlers() {
		Map<String, MessageHandler> beans = SpringUtils.getBeansByType(MessageHandler.class);
		for (Entry<String, MessageHandler> entry : beans.entrySet()) {
			Assert.notNull(entry.getValue().getMsgType(), "微信消息处理MessageHandler：" + entry.getKey() + "实体bean的msgType属性不能为空！");
			String megType = entry.getValue().getMsgType();
			String event = entry.getValue().getEvent();
			String eventKey = entry.getValue().getEventKey();
			String key = StringUtils.isBlank(event) ? megType : megType + "_" + event;
			key = StringUtils.isBlank(eventKey) ? key : key + "_" + eventKey;
			handlers.put(key, entry.getValue());// 如果有多个同类型hanler,后面有个会覆盖前面的
			if (logger.isDebugEnabled() && handlers != null && !handlers.isEmpty()) {
				logger.debug("加载微信消息、事件处理器,key：{},handler：{}", key, entry.getValue());
			}
		}

	}

	/**
	 * 处理腾讯微信平台发送过来的各类消息、事件请求
	 * 
	 * @param is
	 *            request请求输入流
	 * @param pw
	 *            response输出流，返回响应消息
	 */
	public String processRequest(String decryptMsg) {
		String responseStr = "";// 响应消息
		try {
			Map<String, Object> map = XmlUtil.stringXmlToMap(decryptMsg);
			if (map != null && map.containsKey(Msg.MSG_TYPE)) {
				// 判断是消息类型还是事件类型
				String event = map.get(Msg.MSG_TYPE_EVENT) == null ? null : (String) map.get(Msg.MSG_TYPE_EVENT);
				String eventKey = map.get(Msg.MSG_TYPE_EVENT_KEY) == null ? null : (String) map.get(Msg.MSG_TYPE_EVENT_KEY);
				String msgType = (String) map.get(Msg.MSG_TYPE);

				// key的组成由：消息类型_事件类型_事件Key组成 唯一
				String key = msgType;
				if (StringUtils.isNotBlank(event)) {
					key = key + "_" + event;
				}
				if (StringUtils.isNotBlank(eventKey)) {
					key = key + "_" + eventKey;
				}
				if (logger.isDebugEnabled()) {
					logger.debug("消息类型对应的key为：{}", key);
				}

				// 根据消息类型 获取对应的MessageHandler对象处理
				MessageHandler handler = handlers.get(key);
				if (handler == null) {
					if (logger.isWarnEnabled()) {
						logger.warn("未找到消息key为：[{}]的Handler处理器,无法处理请求...", key);
					}
				} else {
					responseStr = handler.process(map);
				}
			}
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.debug("处理微信消息失败，失败原因：{}", e.getMessage());
			}
		}
		return responseStr;
	};

	public Map<String, MessageHandler> getHandlers() {
		return handlers;
	}

	public void setHandlers(Map<String, MessageHandler> handlers) {
		this.handlers = handlers;
	}

	public static void write(PrintWriter pw, String msg) {
		pw.write(msg);
		pw.flush();
		pw.close();
	}

}
