package com.efubao.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.MeasureOrderStatusStream;
import com.efubao.core.order.domain.MeasureOrderStatusStreamExample;
import com.efubao.core.order.mapper.MeasureOrderStatusStreamMapper;
import com.efubao.core.order.service.MeasureOrderStatusStreamService;

@Service
public class MeasureOrderStatusStreamServiceImpl implements MeasureOrderStatusStreamService {

	@Autowired
	private MeasureOrderStatusStreamMapper measureOrderStatusStreamMapper;

	@Override
	public MeasureOrderStatusStream findById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return null;
		}
		return measureOrderStatusStreamMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(MeasureOrderStatusStream t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return measureOrderStatusStreamMapper.insertSelective(t);
	}

	@Override
	public int update(MeasureOrderStatusStream t) {
		// TODO Auto-generated method stub
		if (null == t) {
			return 0;
		}
		return measureOrderStatusStreamMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		if (null == id) {
			return 0;
		}
		return measureOrderStatusStreamMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<MeasureOrderStatusStream> page, MeasureOrderStatusStream t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MeasureOrderStatusStream> findByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		if (null == orderNo) {
			return null;
		}
		MeasureOrderStatusStreamExample example = new MeasureOrderStatusStreamExample();
		MeasureOrderStatusStreamExample.Criteria criteria = example.createCriteria();
		criteria.andMeasureOrderNoEqualTo(orderNo);
		example.setOrderByClause("finish_time desc");
		
		return measureOrderStatusStreamMapper.selectByExample(example);
	}
}
