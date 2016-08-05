package com.efubao.core.order.service;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.MeasureOrder;

public interface MeasureOrderService extends BaseService<MeasureOrder> {

	public MeasureOrder findByMeasureOrderNo(String measureOrderNo);

	public int deleteByMeasureOrderNo(String orderNo);

	public int countByParam(MeasureOrder measureOrder);

	public long sumMeasureNum();

	Integer sumMeasureNumByConditon(MeasureOrder measureOrder);

	public MeasureOrder findByOrderNo(String orderNo);
}
