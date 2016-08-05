package com.efubao.core.sp.service;

import java.util.List;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.sp.domain.SpCertificatePicture;

public interface SpCertificatePictureService extends BaseService<SpCertificatePicture> {

	List<SpCertificatePicture> queryByCondition(SpCertificatePicture spCertificatePicture);

}
