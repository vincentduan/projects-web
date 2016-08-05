package com.efubao.core.sp.service.impl;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.sp.domain.SpCategoryRelation;
import com.efubao.core.sp.domain.SpCategoryRelationExample;
import com.efubao.core.sp.mapper.SpCategoryRelationMapper;
import com.efubao.core.sp.service.SpCategoryRelationService;

@Service
public class SpCategoryRelationServiceImpl implements SpCategoryRelationService {

	@Autowired
	private SpCategoryRelationMapper spCategoryRelationMapper;

	@Override
	public SpCategoryRelation findById(Long id) {
		// TODO Auto-generated method stub
		return spCategoryRelationMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(SpCategoryRelation t) {
		if (t == null) {
			return 0;
		}
		return spCategoryRelationMapper.insertSelective(t);
	}

	@Override
	public int update(SpCategoryRelation t) {
		// TODO Auto-generated method stub
		if (t == null) {
			return 0;
		}
		return spCategoryRelationMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return spCategoryRelationMapper.deleteByPrimaryKey(id);
	}


	@Override
	public List<SpCategoryRelation> queryByCondition(SpCategoryRelation spCategoryRelation) {
		if (spCategoryRelation == null) {
			return null;
		}
		SpCategoryRelationExample example = new SpCategoryRelationExample();
		SpCategoryRelationExample.Criteria criteria = example.createCriteria();

		if (spCategoryRelation.getSpContractId() != null) {
			criteria.andSpContractIdEqualTo(spCategoryRelation.getSpContractId());
		}
		if (spCategoryRelation.getIsDel() != null) {
			criteria.andIsDelEqualTo(spCategoryRelation.getIsDel());
		}
		return spCategoryRelationMapper.selectByExample(example);
	}

	@Override
	public void queryByPage(Page<SpCategoryRelation> page, SpCategoryRelation t) {
		// TODO Auto-generated method stub
		
	}

}
