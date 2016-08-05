package com.efubao.core.order.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.order.domain.MeasureInfoProperty;

public interface MeasureInfoPropertyService extends BaseService<MeasureInfoProperty>{

	public List<MeasureInfoProperty> queryByMeasureInfoId(Long measureInfoId);
	
	public int deleteByMeasureInfoId(Long measureInfoId);
}
