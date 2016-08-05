package com.efubao.core.sp.controller.common;

import java.util.HashMap;
import java.util.Map;

public class CommonVar {

	public static Map<Integer, String> orderStatusMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(120, "竞标");
		map.put(125, "中标录合同");// 签单录合同，前端显示付订金
		map.put(130, "客户支付订金");// 前端显示付订金
		map.put(140, "上门量体");
		map.put(150, "生产制作");
		map.put(160, "客户支付尾款");
		map.put(170, "待发货");
		map.put(180, "待签收");
		map.put(190, "已签收");
		map.put(200, "交易完成");
		map.put(210, "取消订单");
		return map;
	}

}
