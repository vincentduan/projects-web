package com.efubao.core.sp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.sp.domain.SpServiceRange;
import com.efubao.core.sp.domain.SpServiceRangeExample;
import com.efubao.core.sp.mapper.SpServiceRangeMapper;
import com.efubao.core.sp.service.SpServiceRangeService;

@Service
public class SpServiceRangeServiceImpl implements SpServiceRangeService {

	@Autowired
	private SpServiceRangeMapper spServiceRangeMapper;

	@Override
	public SpServiceRange findById(Long id) {
		// TODO Auto-generated method stub
		return spServiceRangeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(SpServiceRange t) {
		if (t == null) {
			return 0;
		}
		return spServiceRangeMapper.insertSelective(t);
	}

	@Override
	public int update(SpServiceRange t) {
		// TODO Auto-generated method stub
		if (t == null) {
			return 0;
		}
		return spServiceRangeMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return spServiceRangeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SpServiceRange> queryByCondition(SpServiceRange spServiceRange) {
		if (spServiceRange == null) {
			return null;
		}
		SpServiceRangeExample example = new SpServiceRangeExample();
		SpServiceRangeExample.Criteria criteria = example.createCriteria();

		if (spServiceRange.getSpId() != null) {
			criteria.andSpIdEqualTo(spServiceRange.getSpId());
		}
		if (spServiceRange.getIsDel() != null) {
			criteria.andIsDelEqualTo(spServiceRange.getIsDel());
		}
		return spServiceRangeMapper.selectByExample(example);
	}

	@Override
	public void queryByPage(Page<SpServiceRange> page, SpServiceRange t) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String querySpRangeBySpId(Long spId) {
		String spRange = "";
		if (null != spId) {
			SpServiceRange spServiceRange = new SpServiceRange();
			spServiceRange.setSpId(spId);
			spServiceRange.setIsDel(false);
			List<SpServiceRange> spRs = this.queryByCondition(spServiceRange);
			if (!spRs.isEmpty()) {
				spRange = spRs.get(0).getCityNames();
			}
		}
		return spRange;
	}

}
