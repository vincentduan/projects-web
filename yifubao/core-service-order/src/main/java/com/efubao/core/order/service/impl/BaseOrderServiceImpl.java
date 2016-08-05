package com.efubao.core.order.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.order.domain.BaseOrder;
import com.efubao.core.order.domain.BaseOrderExample;
import com.efubao.core.order.domain.BaseOrderExample.Criteria;
import com.efubao.core.order.mapper.BaseOrderMapper;
import com.efubao.core.order.service.BaseOrderService;

@Service
public class BaseOrderServiceImpl implements BaseOrderService {
	@Autowired
	public BaseOrderMapper baseOrderMapper;

	@Override
	public BaseOrder findById(Long id) {
		if (id == null)
			return null;
		return baseOrderMapper.selectByPrimaryKey(id.toString());
	}

	@Override
	public BaseOrder findByOrderNo(String orderNo) {
		if (orderNo == null) {
			return null;
		}
		return baseOrderMapper.selectByPrimaryKey(orderNo);
	}

	@Override
	public int save(BaseOrder t) {
		if (t == null) {
			return 0;
		}
		return baseOrderMapper.insertSelective(t);
	}

	@Override
	public int update(BaseOrder t) {
		if (t == null) {
			return 0;
		}
		return baseOrderMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		return 0;
	}

	@Override
	public int deleteByOrderNo(String orderNo) {
		if (orderNo == null) {
			return 0;
		}
		return baseOrderMapper.deleteByPrimaryKey(orderNo);
	}

	@Override
	public void queryByPage(Page<BaseOrder> page, BaseOrder t) {
		BaseOrderExample baseOrderExample = new BaseOrderExample();
		Criteria criteria = baseOrderExample.createCriteria();
		if (t != null) {
			if (t.getSpId() != null) {
				criteria.andSpIdEqualTo(t.getSpId());
			}
			if (t.getStatus() != null) {
				if (t.getStatus() != 2) {
					criteria.andStatusEqualTo(t.getStatus());
				} else {
					// 状态为0 表示订金和尾款
					List<Integer> s = new LinkedList<>();
					s.add(125);
					s.add(130);
					s.add(160);
					criteria.andStatusIn(s);
				}
			}

		}
		page2Exam(page, baseOrderExample);
		int total = baseOrderMapper.countByExample(baseOrderExample);
		List<BaseOrder> list = baseOrderMapper.selectByExample(baseOrderExample);
		page.setTotalCount(total);
		page.setResult(list);
	}

	private void page2Exam(Page<BaseOrder> p, BaseOrderExample c) {
		if (p != null && c != null) {
			c.setLimitEnd(p.getPageSize());
			c.setLimitStart(p.getPageSize() * (p.getPageNo() - 1));

			if (p.getOrderBy() != null && p.getOrderBy().length() < 20) {
				c.setOrderByClause(StringEscapeUtils.escapeSql(p.getOrderBy()));
			}
		}
	}

	@Override
	public List<BaseOrder> queryByCondition(BaseOrder baseOrder) {
		if (baseOrder == null) {
			return null;
		}
		BaseOrderExample example = new BaseOrderExample();
		Criteria criteria = example.createCriteria();
		if (baseOrder.getOrderNo() != null) {
			criteria.andOrderNoEqualTo(baseOrder.getOrderNo());
		}

		return baseOrderMapper.selectByExample(example);
	}

}
