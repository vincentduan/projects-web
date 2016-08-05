package com.efubao.core.bigc.controller.common;

import java.util.HashMap;
import java.util.Map;

public class CommonVar {

	public static Map<Integer, String> orderStatusMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "发布需求");
		map.put(110, "管家受理");
		map.put(120, "选择服务商");
		map.put(125, "付订金");// 签单录合同，前端显示付订金
		map.put(130, "付订金");// 前端显示付订金
		map.put(140, "上门量体");
		map.put(150, "生产制作");
		map.put(160, "付尾款");
		map.put(170, "待发货");
		map.put(180, "待签收");
		map.put(190, "已签收");
		map.put(200, "交易完成");
		map.put(210, "取消订单");
		return map;
	}

}
