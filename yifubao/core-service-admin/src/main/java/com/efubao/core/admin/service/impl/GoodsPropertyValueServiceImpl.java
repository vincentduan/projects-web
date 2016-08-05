package com.efubao.core.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.GoodsPropertyValue;
import com.efubao.core.admin.domain.GoodsPropertyValueExample;
import com.efubao.core.admin.domain.GoodsPropertyValueExample.Criteria;
import com.efubao.core.admin.mapper.GoodsPropertyValueMapper;
import com.efubao.core.admin.service.GoodsPropertyValueService;

@Service
public class GoodsPropertyValueServiceImpl implements GoodsPropertyValueService {

	@Autowired
	private GoodsPropertyValueMapper goodsPropertyValueMapper;

	@Override
	public GoodsPropertyValue findById(Long id) {
		return goodsPropertyValueMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(GoodsPropertyValue t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GoodsPropertyValue t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		return goodsPropertyValueMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<GoodsPropertyValue> page, GoodsPropertyValue t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GoodsPropertyValue> selectByExample(GoodsPropertyValueExample goodsPropertyValueExample) {
		// TODO Auto-generated method stub
		return goodsPropertyValueMapper.selectByExample(goodsPropertyValueExample);
	}

	@Override
	public List<GoodsPropertyValue> getGoodsPropertyValueListByGoodsPropertyId(List<Long> ids) {
		GoodsPropertyValueExample goodsPropertyValueExample = new GoodsPropertyValueExample();
		Criteria criteria = goodsPropertyValueExample.createCriteria();
		criteria.andGoodsPropertyIdIn(ids);
		goodsPropertyValueExample.setOrderByClause("goods_property_id asc");
		return goodsPropertyValueMapper.selectByExample(goodsPropertyValueExample);
	}
}
