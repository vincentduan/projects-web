package com.efubao.core.admin.service.impl;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.Goods;
import com.efubao.core.admin.domain.GoodsExample;
import com.efubao.core.admin.mapper.GoodsMapper;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.admin.service.GoodsPropertyService;
import com.efubao.core.admin.service.GoodsPropertyValueService;
import com.efubao.core.admin.service.GoodsService;
import com.efubao.core.common.util.PersentLike;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private CategoryService categoryServcie;
	@Autowired
	private GoodsPropertyService goodsPropertyService;
	@Autowired
	private GoodsPropertyValueService goodsPropertyValueService;

	@Override
	public Goods findById(Long id) {
		if (id == null)
			return null;
		return goodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(Goods t) {
		if (t == null) {
			return 0;
		}
		return goodsMapper.insertSelective(t);
	}

	@Override
	public int update(Goods t) {
		if (t == null) {
			return 0;
		}
		return goodsMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return goodsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<Goods> page, Goods t) {
		GoodsExample example = new GoodsExample();
		GoodsExample.Criteria criteria = example.createCriteria();

		if (t != null) {
			if (StringUtils.isNotEmpty(t.getName())) {
				criteria.andNameLike(PersentLike.makeUpPersentLike(t.getName()));
			}
			if (t.getCategoryId() != null) {
				criteria.andCategoryIdEqualTo(t.getCategoryId());
			}
			if (t.getStatus() != null) {
				criteria.andStatusEqualTo(t.getStatus());
			}
			example.setOrderByClause("sort");
		}
		page2Exam(page, example);
		int total = goodsMapper.countByExample(example);
		List<Goods> list = goodsMapper.selectByExample(example);
		page.setTotalCount(total);
		page.setResult(list);
	}

	@Override
	public void queryByPageExample(Page<Goods> page, GoodsExample example) {
		page2Exam(page, example);
		int total = goodsMapper.countByExample(example);
		List<Goods> list = goodsMapper.selectByExample(example);
		page.setTotalCount(total);
		page.setResult(list);
	}

	/**
	 * 分页对象组装分页查询条件
	 * 
	 * @param p 分页对象
	 * @param c 查询条件
	 * @param p 分页对象
	 * @param c 查询条件
	 */
	private void page2Exam(Page<Goods> p, GoodsExample c) {
		if (p != null && c != null) {
			c.setLimitEnd(p.getPageSize());
			c.setLimitStart(p.getPageSize() * (p.getPageNo() - 1));

			if (p.getOrderBy() != null && p.getOrderBy().length() < 20) {
				c.setOrderByClause(StringEscapeUtils.escapeSql(p.getOrderBy()));
			}
		}
	}

}
