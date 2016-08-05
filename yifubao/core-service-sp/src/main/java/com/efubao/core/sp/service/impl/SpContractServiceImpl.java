package com.efubao.core.sp.service.impl;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.common.util.PersentLike;
import com.efubao.core.sp.domain.SpCategoryRelation;
import com.efubao.core.sp.domain.SpCategoryRelationExample;
import com.efubao.core.sp.domain.SpCategoryRelationExample.Criteria;
import com.efubao.core.sp.domain.SpContract;
import com.efubao.core.sp.domain.SpContractExample;
import com.efubao.core.sp.mapper.SpCategoryRelationMapper;
import com.efubao.core.sp.mapper.SpContractMapper;
import com.efubao.core.sp.service.SpContractService;

@Service
public class SpContractServiceImpl implements SpContractService {

	@Autowired
	private SpContractMapper spContractMapper;
	@Autowired
	private SpCategoryRelationMapper spCategoryRelationMapper;

	@Override
	public SpContract findById(Long id) {
		SpContract s = null;
		try {
			if (id == null)
				return null;
			s = spContractMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}

	@Override
	public int save(SpContract t) {
		if (t == null) {
			return 0;
		}
		return spContractMapper.insertSelective(t);
	}

	@Override
	public int update(SpContract t) {
		if (t == null) {
			return 0;
		}
		return spContractMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return spContractMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<SpContract> page, SpContract t) {
		SpContractExample example = new SpContractExample();
		SpContractExample.Criteria criteria = example.createCriteria();

		if (t != null) {
			if (StringUtils.isNotBlank(t.getContractName())) {
				criteria.andContractNameLike(PersentLike.makeUpPersentLike(t.getContractName()));
			}

		}
		page2Exam(page, example);
		int total = spContractMapper.countByExample(example);
		List<SpContract> list = null;
		try {
			list = spContractMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		page.setTotalCount(total);
		page.setResult(list);
	}

	@Override
	public void queryAllByPage(Page<SpContract> page, SpContract spContract) {
		SpContractExample example = new SpContractExample();
		// SpContractExample.Criteria criteria = example.createCriteria();
		page2Exam(page, example);
		int total = spContractMapper.countByExample(example);
		List<SpContract> list = spContractMapper.selectByExample(example);
		page.setTotalCount(total);
		page.setResult(list);

	}

	/**
	 * 分页对象组装分页查询条件
	 * 
	 * @param p 分页对象
	 * @param c 查询条件
	 */
	private void page2Exam(Page<SpContract> p, SpContractExample c) {
		if (p != null && c != null) {
			c.setLimitEnd(p.getPageSize());
			c.setLimitStart(p.getPageSize() * (p.getPageNo() - 1));

			if (p.getOrderBy() != null && p.getOrderBy().length() < 20) {
				c.setOrderByClause(StringEscapeUtils.escapeSql(p.getOrderBy()));
			}
		}
	}

	@Override
	public List<SpContract> queryByCondition(SpContract spContract) {
		if (spContract == null) {
			return null;
		}
		SpContractExample example = new SpContractExample();
		SpContractExample.Criteria criteria = example.createCriteria();

		if (spContract.getStatus() != null) {
			criteria.andStatusEqualTo(spContract.getStatus());
		}
		if (spContract.getIsDel() != null) {
			criteria.andIsDelEqualTo(spContract.getIsDel());
		}
		return spContractMapper.selectByExample(example);
	}

	/**
	 * 根据合同id，获取类目id列表
	 */
	@Override
	public List<SpCategoryRelation> getSpCategoryRelationList(Long id) {
		SpCategoryRelationExample spCategoryRelationExample = new SpCategoryRelationExample();
		Criteria criteria = spCategoryRelationExample.createCriteria();
		criteria.andSpContractIdEqualTo(id);
		List<SpCategoryRelation> spCategoryRelation = this.selectByExample(spCategoryRelationExample);
		return spCategoryRelation;
	}

	private List<SpCategoryRelation> selectByExample(SpCategoryRelationExample spCategoryRelationExample) {
		return spCategoryRelationMapper.selectByExample(spCategoryRelationExample);
	}

}
