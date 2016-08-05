package com.efubao.core.sp.service.impl;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.common.util.PersentLike;
import com.efubao.core.sp.domain.Industry;
import com.efubao.core.sp.domain.IndustryExample;
import com.efubao.core.sp.mapper.IndustryMapper;
import com.efubao.core.sp.service.IndustryService;

@Service
public class IndustryServiceImpl implements IndustryService {

	@Autowired
	private IndustryMapper industryMapper;

	@Override
	public Industry findById(Long id) {
		if (id == null)
			return null;
		return industryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(Industry t) {
		if(t == null){
			return 0;
		}
		return industryMapper.insertSelective(t);
	}

	@Override
	public int update(Industry t) {
		if(t == null){
			return 0;
		}
		return industryMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if(id == null){
			return 0;
		}
		return industryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<Industry> page, Industry t) {
		IndustryExample example = new IndustryExample();
		IndustryExample.Criteria criteria = example.createCriteria();

	    if (t != null) {
	      if (StringUtils.isNotBlank(t.getName())){
	    	  criteria.andNameLike(PersentLike.makeUpPersentLike(t.getName()));
	      }
	     
	    }
	    page2Exam(page, example);
	    int total = industryMapper.countByExample(example);
	    List<Industry> list = industryMapper.selectByExample(example);
	    page.setTotalCount(total);
	    page.setResult(list);
	}
	
	/**
	   * 分页对象组装分页查询条件
	   * 
	   * @param p 分页对象
	   * @param c 查询条件
	   */
	  private void page2Exam(Page<Industry> p, IndustryExample c) {
	    if (p != null && c != null) {
	      c.setLimitEnd(p.getPageSize());
	      c.setLimitStart(p.getPageSize() * (p.getPageNo() - 1));

	      if (p.getOrderBy() != null && p.getOrderBy().length() < 20) {
	        c.setOrderByClause(StringEscapeUtils.escapeSql(p.getOrderBy()));
	      }
	    }
	  }
	  
	  /**
		 * 获得所有的有效的类别（isDel=false, status=1）
		 * 
		 * @return 实体对象列表
		 */
		@Override
		public List<Industry> queryAllActiveIndustry() {
			IndustryExample example = new IndustryExample();
			IndustryExample.Criteria criteria = example.createCriteria();
			criteria.andIsDelEqualTo(false);
			return industryMapper.selectByExample(example);
		}
	
}
