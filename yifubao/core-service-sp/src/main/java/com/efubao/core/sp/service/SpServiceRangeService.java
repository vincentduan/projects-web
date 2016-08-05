package com.efubao.core.sp.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.sp.domain.SpServiceRange;

public interface SpServiceRangeService extends BaseService<SpServiceRange> {

	List<SpServiceRange> queryByCondition(SpServiceRange spServiceRange);

	String querySpRangeBySpId(Long spId);

}
