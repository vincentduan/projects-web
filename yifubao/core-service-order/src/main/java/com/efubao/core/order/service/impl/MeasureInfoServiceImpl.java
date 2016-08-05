package com.efubao.core.order.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.MeasureInfo;
import com.efubao.core.order.domain.MeasureInfoExample;
import com.efubao.core.order.mapper.MeasureInfoMapper;
import com.efubao.core.order.service.MeasureInfoService;

@Service
public class MeasureInfoServiceImpl implements MeasureInfoService {

	@Autowired
	private MeasureInfoMapper measureInfoMapper;

	@Override
	public MeasureInfo findById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return null;
		}
		return measureInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(MeasureInfo t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return measureInfoMapper.insertSelective(t);
	}

	@Override
	public int update(MeasureInfo t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return measureInfoMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return 0;
		}
		return measureInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<MeasureInfo> page, MeasureInfo measureInfo) {
		// TODO Auto-generated method stub
		MeasureInfoExample example = new MeasureInfoExample();
		MeasureInfoExample.Criteria criteria = example.createCriteria();
		example.setDistinct(true);

		if (null != measureInfo) {
			if (null != measureInfo.getName()) {
				criteria.andNameEqualTo(measureInfo.getName());
			}
			if (null != measureInfo.getPhone()) {
				criteria.andPhoneEqualTo(measureInfo.getPhone());
			}
			if (null != measureInfo.getMeasureOrderNo()) {
				criteria.andMeasureOrderNoEqualTo(measureInfo.getMeasureOrderNo());
			}
		}

		page2Exam(page, example);
		if (page.isAutoCount()) {
			int total = measureInfoMapper.countByExample(example);
			page.setTotalCount(total);
		}

		List<MeasureInfo> list = measureInfoMapper.selectByExample(example);
		page.setResult(list);
	}

	@Override
	public void queryByCondition(Page<MeasureInfo> page, String measureOrderNo, String condition) {
		if (null == measureOrderNo) {
			return;
		}

		MeasureInfoExample example = new MeasureInfoExample();
		example.setDistinct(true);

		MeasureInfoExample.Criteria criteria = null;
		if (null != condition) {
			criteria = example.createCriteria();
			criteria.andMeasureOrderNoEqualTo(measureOrderNo);
			criteria.andNameLike("%" + condition + "%");

			criteria = example.or();
			criteria.andMeasureOrderNoEqualTo(measureOrderNo);
			criteria.andPhoneLike("%" + condition + "%");
		} else {
			example.createCriteria().andMeasureOrderNoEqualTo(measureOrderNo);
		}

		page2Exam(page, example);
		if (page.isAutoCount()) {
			int total = measureInfoMapper.countByExample(example);
			page.setTotalCount(total);
		}

		List<MeasureInfo> list = measureInfoMapper.selectByExample(example);
		page.setResult(list);
	}

	private void page2Exam(Page<MeasureInfo> page, MeasureInfoExample example) {
		if (null != page && null != example) {
			example.setLimitEnd(page.getPageSize());
			example.setLimitStart(page.getPageSize() * (page.getPageNo() - 1));
		}

		if (null != page.getOrderBy() && page.getOrderBy().length() < 20) {
			example.setOrderByClause(StringEscapeUtils.escapeSql(page.getOrderBy()));
		}
	}

	@Override
	public int countByParam(MeasureInfo measureInfo) {
		MeasureInfoExample example = new MeasureInfoExample();
		MeasureInfoExample.Criteria criteria = example.createCriteria();

		if (null != measureInfo) {
			if (null != measureInfo.getMeasureOrderNo())
				criteria.andMeasureOrderNoEqualTo(measureInfo.getMeasureOrderNo());
		}

		return measureInfoMapper.countByExample(example);
	}

	@Override
	public int countByUpdateTime(Timestamp beginTime, Timestamp endTime) {
		MeasureInfoExample example = new MeasureInfoExample();
		MeasureInfoExample.Criteria criteria = example.createCriteria();

		if (null != beginTime)
			criteria.andUpdateTimeGreaterThanOrEqualTo(beginTime);
		if (null != endTime)
			criteria.andUpdateTimeLessThanOrEqualTo(endTime);

		return measureInfoMapper.countByExample(example);
	}

}
