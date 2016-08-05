package com.efubao.core.common.mq;

/**
 * 订单事件枚举
 * @author zhangzhiyong
 *
 */
public enum OrderEventEnum {

	ORDER_PAY_SUCCESS("order_pay_success", "支付成功"), 
	ORDER_REFUND_APPLY("order_refund_apply", "退款申请"),
//	ORDER_REFUND_PROCESSING("order_refund_processing", "退款处理中"),
	ORDER_REFUND_SUCCESS("order_refund_success", "退款成功"),
	ORDER_REFUND_FORBID("order_refund_forbid", "拒绝退款");

	private String value;

	private String desc;

	private OrderEventEnum(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public static OrderEventEnum getEnum(String value) {
		if (value == null) {
			return null;
		}
		OrderEventEnum[] enumArray = OrderEventEnum.values();
		for (OrderEventEnum c : enumArray) {
			if (c.value.equals(value)) {
				return c;
			}
		}
		return null;
	}

	public String getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
}
