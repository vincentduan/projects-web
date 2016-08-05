package com.efubao.core.common.mq;

import com.efubao.core.common.config.Config;
import com.efubao.core.common.mq.pojo.SMSInfo;
import com.efubao.core.common.mq.rabbit.RabbitPublisherService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 后台系统发送邮件、短信、数据推送等消息队列服务
 * 
 * 
 */
@Service
public class MessagePublishService {

	/** 短信和邮件的队列总数各10个: email0~email9, sms0~sms9 */
	private static final int QUEUE_NUM = 10;
	/** log */
	private Logger logger = LoggerFactory
			.getLogger("SMS");

	/** SMS routing key prefix */
	private static final String SMS_PREFIX = "sms";
	/** 企信通mq */
	private static final String SMS_QIXINTONG = "sms_qixintong";

	static final String LIVE = "live";

	/**  */
	@Resource(name = "messageRabbitPublisherService")
	private RabbitPublisherService messageMq;

	@Autowired
	private Config config;


	/**
	 * send sms to mq
	 * 
	 * @param t
	 */
	public void sendSms(SMSInfo t) {
		if (t != null) {
			String cont = EscapeChar(t.getContent());
			if (!LIVE.equals(config.getEnv())) {
				t.setMobile(config.getTestMbobile());
			}
			String msg = "insert into sm_queue set content='" + cont
					+ "',mobile='" + t.getMobile() + "';";
			msg = "user:" + config.user + "###" + config.ip + "###" + msg;
			try {
				if (LIVE.equals(config.getEnv())) {
					messageMq.send(SMS_PREFIX + System.nanoTime() % QUEUE_NUM, msg);
				}
				logger.info(
						"send msg to sms mq======>receiver is:{},contents is:{}",
						t.getMobile(), msg);
			} catch (Exception ex) {
				logger.error(ex.getMessage());
				logger.error(
						"send msg to mq failed======>receiver is:{},content is :{}",
						t.getMobile(), msg);
			}
		}
	}

	/**
	 * 发送sms消息到MQ,由SmsSubscriberHandler监听并调用企信通平台发送
	 * 
	 * @param t
	 */
	public void sendSmsByObj(SMSInfo t) {
		if (t != null) {
			try {
				if (LIVE.equals(config.getEnv())) {
					messageMq.send(SMS_QIXINTONG, t);
				}
				logger.info("send qixintong sms======>sms is:{}", t.toString());
			} catch (Exception ex) {
				logger.error(ex.getMessage());
				logger.info("send qixintong sms======>sms is:{}", t.toString());
			}
		}
	}

	private String EscapeChar(String str) {
		String r = str;
		if (str != null) {
			if (str.contains("'")) {
				r = str.replaceAll("'", "\\\\'");
			}
		}
		return r;
	}
}
