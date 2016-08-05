package com.efubao.core.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.GoodsSKU;
import com.efubao.core.admin.domain.GoodsSKUExample;
import com.efubao.core.admin.domain.GoodsSKUExample.Criteria;
import com.efubao.core.admin.mapper.GoodsSKUMapper;
import com.efubao.core.admin.service.GoodsSKUService;

@Service
public class GoodsSKUServiceImpl implements GoodsSKUService {
	
	

	@Autowired
	private GoodsSKUMapper goodsSKUMapper;

	@Override
	public GoodsSKU findById(Long id) {
		if(id == null){
			return null;
		}
		return goodsSKUMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(GoodsSKU t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GoodsSKU t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void queryByPage(Page<GoodsSKU> page, GoodsSKU t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<GoodsSKU> queryByCondition(GoodsSKU g) {
		if (g == null) {
			return null;
		}
		GoodsSKUExample example = new GoodsSKUExample();
		Criteria criteria = example.createCriteria();
		if (g.getGoodsId() != null) {
			criteria.andGoodsIdEqualTo(g.getGoodsId());
		}
		if (g.getIsDel() != null) {
			criteria.andIsDelEqualTo(g.getIsDel());
		}
		return goodsSKUMapper.selectByExample(example);
	}

	@Override
	public void searchGoodsSku(Page<GoodsSKU> page,String name, Integer id, Integer start, Integer end) {
		int total= goodsSKUMapper.selectByGoodsCounts(name, id);
		List<GoodsSKU> list = goodsSKUMapper.selectByGoods(name, id, start, end);
		page.setTotalCount(total);
		page.setResult(list);
	}

}
