package com.efubao.core.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.GoodsPic;
import com.efubao.core.admin.domain.GoodsPicExample;
import com.efubao.core.admin.domain.GoodsPicExample.Criteria;
import com.efubao.core.admin.mapper.GoodsPicMapper;
import com.efubao.core.admin.service.GoodsPicService;

@Service
public class GoodsPicServiceImpl implements GoodsPicService {

	@Autowired
	private GoodsPicMapper goodsPicMapper;

	@Override
	public GoodsPic findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(GoodsPic t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GoodsPic t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void queryByPage(Page<GoodsPic> page, GoodsPic t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<GoodsPic> queryByCondition(GoodsPic g) {
		if (g == null) {
			return null;
		}
		GoodsPicExample example = new GoodsPicExample();
		Criteria criteria = example.createCriteria();
		if (g.getGoodsId() != null) {
			criteria.andGoodsIdEqualTo(g.getGoodsId());
		}
		if (g.getIsDel() != null) {
			criteria.andIsDelEqualTo(g.getIsDel());
		}
		return goodsPicMapper.selectByExample(example);
	}
	
}
