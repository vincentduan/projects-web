package com.efubao.core.sp.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.sp.domain.MeasureMaster;


public interface MeasureMasterService extends BaseService<MeasureMaster>{

	MeasureMaster findByMobile(String mobile);

	List<MeasureMaster> queryByCondition(MeasureMaster measureMaster);
	
}
