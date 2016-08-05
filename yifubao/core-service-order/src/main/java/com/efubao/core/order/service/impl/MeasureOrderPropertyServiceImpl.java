package com.efubao.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.MeasureOrderProperty;
import com.efubao.core.order.domain.MeasureOrderPropertyExample;
import com.efubao.core.order.mapper.MeasureOrderPropertyMapper;
import com.efubao.core.order.service.MeasureOrderPropertyService;

@Service
public class MeasureOrderPropertyServiceImpl implements MeasureOrderPropertyService {

	@Autowired
	private MeasureOrderPropertyMapper mapper;

	@Override
	public MeasureOrderProperty findById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return null;
		}
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(MeasureOrderProperty t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return mapper.insertSelective(t);
	}

	@Override
	public int update(MeasureOrderProperty t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return mapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return 0;
		}
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<MeasureOrderProperty> page, MeasureOrderProperty t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MeasureOrderProperty> queryByMeasureOrderNo(String orderNo) {
		if (null == orderNo) {
			return null;
		}
		MeasureOrderPropertyExample example = new MeasureOrderPropertyExample();
		MeasureOrderPropertyExample.Criteria criteria = example.createCriteria();
		criteria.andMeasureOrderNoEqualTo(orderNo);
		return mapper.selectByExample(example);
	}
}
