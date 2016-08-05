package com.efubao.core.sp.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.sp.domain.CasePicture;

public interface CasePictureService extends BaseService<CasePicture> {

	List<CasePicture> queryByCondition(CasePicture cp);

}
