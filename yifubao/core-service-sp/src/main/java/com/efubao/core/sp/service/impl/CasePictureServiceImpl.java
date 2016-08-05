package com.efubao.core.sp.service.impl;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.sp.domain.CasePicture;
import com.efubao.core.sp.domain.CasePictureExample;
import com.efubao.core.sp.mapper.CasePictureMapper;
import com.efubao.core.sp.service.CasePictureService;

@Service
public class CasePictureServiceImpl implements CasePictureService {

	@Autowired
	private CasePictureMapper casePictureMapper;

	@Override
	public CasePicture findById(Long id) {
		if (id == null) {
			return null;
		}
		return casePictureMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(CasePicture cp) {
		if (cp == null) {
			return 0;
		}
		return casePictureMapper.insertSelective(cp);
	}

	@Override
	public int update(CasePicture cp) {
		if (cp == null) {
			return 0;
		}
		return casePictureMapper.updateByPrimaryKeySelective(cp);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return casePictureMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<CasePicture> page, CasePicture cp) {
		CasePictureExample example = new CasePictureExample();
		CasePictureExample.Criteria criteria = example.createCriteria();

		if (cp != null) {
			if (cp.getCaseId() != null) {
				criteria.andCaseIdEqualTo(cp.getCaseId());
			}
			if (cp.getIsDel() != null) {
				criteria.andIsDelEqualTo(cp.getIsDel());
			}

		}
		page2Exam(page, example);
		int total = casePictureMapper.countByExample(example);
		List<CasePicture> list = casePictureMapper.selectByExample(example);
		page.setTotalCount(total);
		page.setResult(list);

	}

	/**
	 * 分页对象组装分页查询条件
	 * 
	 * @param p 分页对象
	 * @param cp 查询条件
	 */
	private void page2Exam(Page<CasePicture> p, CasePictureExample cp) {
		if (p != null && cp != null) {
			cp.setLimitEnd(p.getPageSize());
			cp.setLimitStart(p.getPageSize() * (p.getPageNo() - 1));

			if (p.getOrderBy() != null && p.getOrderBy().length() < 20) {
				cp.setOrderByClause(StringEscapeUtils.escapeSql(p.getOrderBy()));
			}
		}
	}

	@Override
	public List<CasePicture> queryByCondition(CasePicture cp) {
		if (cp == null) {
			return null;
		}
		CasePictureExample example = new CasePictureExample();
		CasePictureExample.Criteria criteria = example.createCriteria();
		if (cp.getCaseId() != null) {
			criteria.andCaseIdEqualTo(cp.getCaseId());
		}
		if (cp.getIsDel() != null) {
			criteria.andIsDelEqualTo(cp.getIsDel());
		}
		return casePictureMapper.selectByExample(example);
	}

}
