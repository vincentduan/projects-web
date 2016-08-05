package com.efubao.core.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.GoodsDesc;
import com.efubao.core.admin.domain.GoodsDescExample;
import com.efubao.core.admin.domain.GoodsDescExample.Criteria;
import com.efubao.core.admin.mapper.GoodsDescMapper;
import com.efubao.core.admin.service.GoodsDescService;

@Service
public class GoodsDescServiceImpl implements GoodsDescService {

	@Autowired
	private GoodsDescMapper goodsDescMapper;

	@Override
	public GoodsDesc findById(Long id) {
		if (id == null)
			return null;
		return goodsDescMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(GoodsDesc t) {
		if (t == null) {
			return 0;
		}
		return goodsDescMapper.insertSelective(t);
	}

	@Override
	public int update(GoodsDesc t) {
		if (t == null) {
			return 0;
		}
		return goodsDescMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return goodsDescMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<GoodsDesc> page, GoodsDesc t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GoodsDesc> queryByCondition(GoodsDesc g) {
		if (g == null) {
			return null;
		}
		GoodsDescExample example = new GoodsDescExample();
		Criteria criteria = example.createCriteria();
		if (g.getGoodsId() != null) {
			criteria.andGoodsIdEqualTo(g.getGoodsId());
		}
		if (g.getIsDel() != null) {
			criteria.andIsDelEqualTo(g.getIsDel());
		}
		return goodsDescMapper.selectByExample(example);
	}

}
