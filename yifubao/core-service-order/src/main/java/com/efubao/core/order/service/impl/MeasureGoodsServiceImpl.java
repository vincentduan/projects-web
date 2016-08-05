package com.efubao.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.MeasureGoods;
import com.efubao.core.order.domain.MeasureGoodsExample;
import com.efubao.core.order.mapper.MeasureGoodsMapper;
import com.efubao.core.order.service.MeasureGoodsService;

@Service
public class MeasureGoodsServiceImpl implements MeasureGoodsService {

	@Autowired
	public MeasureGoodsMapper measureGoodsMapper;

	@Override
	public MeasureGoods findById(Long id) {
		if (null == id) {
			return null;
		}
		return measureGoodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(MeasureGoods t) {
		if (null == t) {
			return 0;
		}
		return measureGoodsMapper.insertSelective(t);
	}

	@Override
	public int update(MeasureGoods t) {
		if (null == t) {
			return 0;
		}
		return measureGoodsMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (null == id) {
			return 0;
		}
		return measureGoodsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<MeasureGoods> page, MeasureGoods t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MeasureGoods> queryByMeasureOrderNo(String orderNo) {
		if (null == orderNo) {
			return null;
		}
		MeasureGoodsExample example = new MeasureGoodsExample();
		MeasureGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andMeasureOrderNoEqualTo(orderNo);
		return measureGoodsMapper.selectByExample(example);
	}
}
