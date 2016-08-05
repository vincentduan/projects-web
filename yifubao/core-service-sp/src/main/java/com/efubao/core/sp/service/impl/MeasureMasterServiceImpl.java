package com.efubao.core.sp.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.common.util.PersentLike;
import com.efubao.core.sp.domain.MeasureMaster;
import com.efubao.core.sp.domain.MeasureMasterExample;
import com.efubao.core.sp.mapper.MeasureMasterMapper;
import com.efubao.core.sp.service.MeasureMasterService;

@Service
public class MeasureMasterServiceImpl implements MeasureMasterService {

	@Autowired
	private MeasureMasterMapper measureMasterMapper;

	@Override
	public MeasureMaster findById(Long id) {
		if (id == null)
			return null;
		return measureMasterMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(MeasureMaster t) {
		if (t == null) {
			return 0;
		}
		return measureMasterMapper.insertSelective(t);
	}

	@Override
	public int update(MeasureMaster t) {
		if (t == null) {
			return 0;
		}
		return measureMasterMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return measureMasterMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<MeasureMaster> page, MeasureMaster t) {
		MeasureMasterExample example = new MeasureMasterExample();
		MeasureMasterExample.Criteria criteria = example.createCriteria();

		if (t != null) {
			if (StringUtils.isNotBlank(t.getName())) {
				criteria.andNameLike(PersentLike.makeUpPersentLike(t.getName()));
			}

		}
		page2Exam(page, example);
		int total = measureMasterMapper.countByExample(example);
		List<MeasureMaster> list = measureMasterMapper.selectByExample(example);
		page.setTotalCount(total);
		page.setResult(list);
	}

	/**
	 * 分页对象组装分页查询条件
	 * 
	 * @param p
	 *            分页对象
	 * @param c
	 *            查询条件
	 */
	private void page2Exam(Page<MeasureMaster> p, MeasureMasterExample c) {
		if (p != null && c != null) {
			c.setLimitEnd(p.getPageSize());
			c.setLimitStart(p.getPageSize() * (p.getPageNo() - 1));

			if (p.getOrderBy() != null && p.getOrderBy().length() < 20) {
				c.setOrderByClause(StringEscapeUtils.escapeSql(p.getOrderBy()));
			}
		}
	}

	@Override
	public List<MeasureMaster> queryByCondition(MeasureMaster measureMaster) {
		if (measureMaster == null) {
			return null;
		}
		MeasureMasterExample example = new MeasureMasterExample();
		MeasureMasterExample.Criteria criteria = example.createCriteria();

		if (measureMaster.getSpId() != null) {
			criteria.andSpIdEqualTo(measureMaster.getSpId());
		}
		if (measureMaster.getStatus() != null) {
			criteria.andStatusEqualTo(measureMaster.getStatus());
		}
		if (measureMaster.getIsDel() != null) {
			criteria.andIsDelEqualTo(measureMaster.getIsDel());
		}
		return measureMasterMapper.selectByExample(example);
	}

	@Override
	public MeasureMaster findByMobile(String mobile) {

		MeasureMasterExample example = new MeasureMasterExample();
		MeasureMasterExample.Criteria criteria = example.createCriteria();
		criteria.andMobileEqualTo(mobile.trim());

		List<MeasureMaster> list = measureMasterMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

}
