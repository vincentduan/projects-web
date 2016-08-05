package com.efubao.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.MeasureInfoProperty;
import com.efubao.core.order.domain.MeasureInfoPropertyExample;
import com.efubao.core.order.mapper.MeasureInfoPropertyMapper;
import com.efubao.core.order.service.MeasureInfoPropertyService;

@Service
public class MeasureInfoPropertyServiceImpl implements MeasureInfoPropertyService {

	@Autowired
	public MeasureInfoPropertyMapper measureInfoPropertyMapper;

	@Override
	public MeasureInfoProperty findById(Long id) {
		if (null == id) {
			return null;
		}
		return measureInfoPropertyMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(MeasureInfoProperty t) {
		if (null == t) {
			return 0;
		}
		return measureInfoPropertyMapper.insertSelective(t);
	}

	@Override
	public int update(MeasureInfoProperty t) {
		if (null == t) {
			return 0;
		}
		return measureInfoPropertyMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (null == id) {
			return 0;
		}
		return measureInfoPropertyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteByMeasureInfoId(Long measureInfoId) {
		if (null == measureInfoId) {
			return 0;
		}

		MeasureInfoPropertyExample example = new MeasureInfoPropertyExample();
		MeasureInfoPropertyExample.Criteria criteria = example.createCriteria();
		criteria.andMeasureInfoIdEqualTo(measureInfoId);

		return measureInfoPropertyMapper.deleteByExample(example);
	}

	@Override
	public void queryByPage(Page<MeasureInfoProperty> page, MeasureInfoProperty t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MeasureInfoProperty> queryByMeasureInfoId(Long measureInfoId) {
		// TODO Auto-generated method stub
		if (null == measureInfoId) {
			return null;
		}
		MeasureInfoPropertyExample example = new MeasureInfoPropertyExample();
		MeasureInfoPropertyExample.Criteria criteria = example.createCriteria();
		criteria.andMeasureInfoIdEqualTo(measureInfoId);

		return measureInfoPropertyMapper.selectByExample(example);
	}

}
