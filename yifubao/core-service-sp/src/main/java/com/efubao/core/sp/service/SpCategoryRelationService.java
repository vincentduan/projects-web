package com.efubao.core.sp.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.sp.domain.SpCategoryRelation;

public interface SpCategoryRelationService extends BaseService<SpCategoryRelation> {

	List<SpCategoryRelation> queryByCondition(SpCategoryRelation spCategoryRelation);

}
