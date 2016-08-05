package com.efubao.core.admin.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.domain.CategoryExample;
import com.efubao.core.admin.domain.GoodsProperty;
import com.efubao.core.admin.domain.GoodsPropertyExample;
import com.efubao.core.admin.domain.GoodsPropertyExample.Criteria;
import com.efubao.core.admin.mapper.GoodsPropertyMapper;
import com.efubao.core.admin.service.GoodsPropertyService;
import com.efubao.core.common.util.PersentLike;

@Service
public class GoodsPropertyServiceImpl implements GoodsPropertyService {

	@Autowired
	private GoodsPropertyMapper goodsPropertyMapper;

	@Override
	public GoodsProperty findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(GoodsProperty t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GoodsProperty t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void queryByPage(Page<GoodsProperty> page, GoodsProperty t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GoodsProperty> selectByExample(GoodsPropertyExample example) {
		// TODO Auto-generated method stub
		return goodsPropertyMapper.selectByExample(example);
	}

	@Override
	public List<GoodsProperty> queryByCondition(GoodsProperty g) {
		if (g == null) {
			return null;
		}
		GoodsPropertyExample example = new GoodsPropertyExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(g.getPropertyName())) {
			criteria.andPropertyNameLike(PersentLike.makeUpPersentLike(g
					.getPropertyName()));
		}
		if (g.getGoodsId() != null) {
			criteria.andGoodsIdEqualTo(g.getGoodsId());
		}
		if (g.getIsDel() != null) {
			criteria.andIsDelEqualTo(g.getIsDel());
		}
		return goodsPropertyMapper.selectByExample(example);
	}

	/**
	 * 根据商品id，获得商品属性列表
	 */
	@Override
	public List<GoodsProperty> getGoodsPropertyListByGoodsId(Long id) {
		GoodsPropertyExample goodsPropertyExample = new GoodsPropertyExample();
		Criteria criteria = goodsPropertyExample.createCriteria();
		criteria.andGoodsIdEqualTo(id);
		return goodsPropertyMapper.selectByExample(goodsPropertyExample);
	}

}
