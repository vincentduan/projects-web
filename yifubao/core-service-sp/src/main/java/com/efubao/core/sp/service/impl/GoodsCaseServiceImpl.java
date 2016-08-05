package com.efubao.core.sp.service.impl;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.sp.domain.GoodsCase;
import com.efubao.core.sp.domain.GoodsCaseExample;
import com.efubao.core.sp.mapper.GoodsCaseMapper;
import com.efubao.core.sp.service.GoodsCaseService;

@Service
public class GoodsCaseServiceImpl implements GoodsCaseService {

	@Autowired
	private GoodsCaseMapper goodsCaseMapper;

	@Override
	public GoodsCase findById(Long id) {
		if (id == null) {
			return null;
		}
		return goodsCaseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(GoodsCase c) {
		if (c == null) {
			return 0;
		}
		return goodsCaseMapper.insertSelective(c);
	}

	@Override
	public int update(GoodsCase c) {
		if (c == null) {
			return 0;
		}
		return goodsCaseMapper.updateByPrimaryKeySelective(c);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return goodsCaseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<GoodsCase> page, GoodsCase c) {
		GoodsCaseExample example = new GoodsCaseExample();
		GoodsCaseExample.Criteria criteria = example.createCriteria();

		if (c != null) {
			if (c.getSpId() != null) {
				criteria.andSpIdEqualTo(c.getSpId());
			}
			if (c.getIsDel() != null) {
				criteria.andIsDelEqualTo(c.getIsDel());
			}

		}
		page2Exam(page, example);
		int total = goodsCaseMapper.countByExample(example);
		List<GoodsCase> list = goodsCaseMapper.selectByExample(example);
		page.setTotalCount(total);
		page.setResult(list);

	}

	/**
	 * 分页对象组装分页查询条件
	 * 
	 * @param p 分页对象
	 * @param c 查询条件
	 */
	private void page2Exam(Page<GoodsCase> p, GoodsCaseExample c) {
		if (p != null && c != null) {
			c.setLimitEnd(p.getPageSize());
			c.setLimitStart(p.getPageSize() * (p.getPageNo() - 1));

			if (p.getOrderBy() != null && p.getOrderBy().length() < 20) {
				c.setOrderByClause(StringEscapeUtils.escapeSql(p.getOrderBy()));
			}
		}
	}

	@Override
	public List<GoodsCase> queryByCondition(GoodsCase c) {
		if (c == null) {
			return null;
		}
		GoodsCaseExample example = new GoodsCaseExample();
		GoodsCaseExample.Criteria criteria = example.createCriteria();
		if (c.getSpId() != null) {
			criteria.andSpIdEqualTo(c.getSpId());
		}
		if (c.getIsDel() != null) {
			criteria.andIsDelEqualTo(c.getIsDel());
		}
		return goodsCaseMapper.selectByExample(example);
	}

}
