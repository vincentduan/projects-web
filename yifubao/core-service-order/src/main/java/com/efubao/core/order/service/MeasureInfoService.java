package com.efubao.core.order.service;

import java.sql.Timestamp;

import com.efubao.common.util.Page;
import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.MeasureInfo;

public interface MeasureInfoService extends BaseService<MeasureInfo> {

	public void queryByCondition(Page<MeasureInfo> page, String measureOrderNo, String condition);

	public int countByParam(MeasureInfo measureInfo);
	
	public int countByUpdateTime(Timestamp beginTime, Timestamp endTime);
}
