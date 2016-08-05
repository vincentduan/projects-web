package com.efubao.core.sp.service;

import java.util.List;

import com.efubao.common.util.Page;
import com.efubao.core.common.base.BaseService;
import com.efubao.core.sp.domain.SpCategoryRelation;
import com.efubao.core.sp.domain.SpContract;

public interface SpContractService extends BaseService<SpContract> {

	List<SpContract> queryByCondition(SpContract spContract);

	List<SpCategoryRelation> getSpCategoryRelationList(Long id);

	void queryAllByPage(Page<SpContract> page, SpContract spContract);

}
