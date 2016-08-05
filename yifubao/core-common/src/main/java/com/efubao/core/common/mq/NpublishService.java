package com.efubao.core.common.mq;


import com.efubao.core.common.mq.pojo.Message;
import com.efubao.core.common.mq.rabbit.RabbitPublisherService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 后台系统发送数据更新等消息队列服务
 * 
 * 
 */
@Service
public class NpublishService {
	/** log */
	private Logger logger = LoggerFactory.getLogger(NpublishService.class);

	/** 用户增加积分消息 routeKey */
	public static final String ORDER_ROUTE_KEY = "order";
	/** app消息推送 routeKey */

	/**商家结算routeKey*/
	public static final String SHOP_BALANCE_KEY = "balanceShop";
	/**  */
	@Resource(name = "nrabbitPublisherService")
	private RabbitPublisherService dataMq;


	/**
	 * 发送Map类型消息，便于消息体灵活扩展
	 * 
	 * @param t
	 */
	public void sendDataByMap(Message<Map<String, String>> t) {
		if (t != null) {
			String method = t.getMethod();
			if (method != null) {
				try {
					// send
					if (method.startsWith("order")) {
						dataMq.send(ORDER_ROUTE_KEY, t);
					} else if(method.equals(SHOP_BALANCE_KEY)){
						dataMq.send(SHOP_BALANCE_KEY, t);
					}
					logger.info("send data to mq======>msg is:{}", t.toString());
				} catch (Exception ex) {
					logger.error(ex.getMessage());
					logger.error("failed to send data to mq======>msg is:{}",
							t.toString());
				}
			}
		}
	}

	/**
	 * send积分to MQ
	 * @param godId
	 * @param mallId
	 * @param shopId
	 * @param orderNo
	 * @return
	 */
	public boolean sendMsgByOrderStatusToMQ(Long godId,Long mallId,Long shopId,String orderNo, OrderEventEnum orderEventEnum){
		Map<String,String> map = new HashMap<String,String>();
        map.put("godId", godId+"");
        map.put("mallId", mallId+"");
        map.put("shopId", shopId+"");
        map.put("orderNo", orderNo);
        Message<Map<String, String>> message = new Message<Map<String, String>>();
        message.setData(map);
        message.setCreate_time(System.currentTimeMillis());
        message.setMethod(orderEventEnum.getValue());
        message.setId(orderNo);
        this.sendDataByMap(message);
        return true;
	}
	
	/**
	 * 发送积分变更通知到MQ
	 * 
	 * @param mallId
	 * @param orderNo
	 * @param method
	 *            积分变更原因.(下单,付款,取消,退款).参照 CreditChangeTypeEnum.changeOccasion
	 * @return
	 */
	public boolean sendCreditChangeInfoToOrderMq(Long mallId,
			BigDecimal orderNo, String method) {
		if (mallId == null || orderNo == null || method == null) {
			logger.error(
					"sendCreditChangeInfoToOrderMq param null. mallId:%s,orderNo:%s,method:%s",
					mallId, orderNo, method);
			return false;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("mallId", mallId.toString());
		map.put("orderNo", orderNo.toString());

		Message<Map<String, String>> message = new Message<Map<String, String>>();
		message.setData(map);
		message.setCreate_time(System.currentTimeMillis());
		message.setMethod(method);
		message.setId(orderNo.toString());
		dataMq.send(ORDER_ROUTE_KEY, message);
		return true;
	}

	/**
	 * 商家结算同步数据
	 * @param batchNo 大批次号
	 */
	public void sendBatchNoToMQ(String batchNo) {
		Map<String,String> map = new HashMap<String,String>(1);
        map.put("batchNo", batchNo);
		Message<Map<String, String>> message = new Message<Map<String, String>>();
		long createTime = System.currentTimeMillis();
		message.setData(map);
		message.setId(createTime + "_" + batchNo);
		message.setCreate_time(createTime);
		message.setMethod(SHOP_BALANCE_KEY);
		this.sendDataByMap(message);
	}
}
