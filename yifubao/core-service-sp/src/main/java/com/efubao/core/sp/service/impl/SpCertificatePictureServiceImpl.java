package com.efubao.core.sp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.sp.domain.SpCertificatePicture;
import com.efubao.core.sp.domain.SpCertificatePictureExample;
import com.efubao.core.sp.domain.SpServiceRange;
import com.efubao.core.sp.mapper.SpCertificatePictureMapper;
import com.efubao.core.sp.service.SpCertificatePictureService;

@Service
public class SpCertificatePictureServiceImpl implements SpCertificatePictureService {

	@Autowired
	private SpCertificatePictureMapper spCertificatePictureMapper;

	@Override
	public SpCertificatePicture findById(Long id) {
		// TODO Auto-generated method stub
		return spCertificatePictureMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(SpCertificatePicture t) {
		if (t == null) {
			return 0;
		}
		return spCertificatePictureMapper.insertSelective(t);
	}

	@Override
	public int update(SpCertificatePicture t) {
		// TODO Auto-generated method stub
		if (t == null) {
			return 0;
		}
		return spCertificatePictureMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return spCertificatePictureMapper.deleteByPrimaryKey(id);
	}


	@Override
	public List<SpCertificatePicture> queryByCondition(SpCertificatePicture spCertificatePicture) {
		if (spCertificatePicture == null) {
			return null;
		}
		SpCertificatePictureExample example = new SpCertificatePictureExample();
		SpCertificatePictureExample.Criteria criteria = example.createCriteria();

		if (spCertificatePicture.getSpId() != null) {
			criteria.andSpIdEqualTo(spCertificatePicture.getSpId());
		}
		if (spCertificatePicture.getIsDel() != null) {
			criteria.andIsDelEqualTo(spCertificatePicture.getIsDel());
		}
		return spCertificatePictureMapper.selectByExample(example);
	}

	@Override
	public void queryByPage(Page<SpCertificatePicture> page,
			SpCertificatePicture t) {
		// TODO Auto-generated method stub
		
	}

}
