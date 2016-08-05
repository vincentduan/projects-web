package com.efubao.core.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.domain.CategoryExample;
import com.efubao.core.admin.domain.CategoryExample.Criteria;
import com.efubao.core.admin.mapper.CategoryMapper;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.common.util.PersentLike;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public Category findById(Long id) {
		if (id == null) {
			return null;
		}
		return categoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(Category t) {
		if (t == null) {
			return 0;
		}
		return categoryMapper.insertSelective(t);
	}

	@Override
	public int update(Category t) {
		if (t == null) {
			return 0;
		}
		return categoryMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return 0;
		}
		return categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<Category> page, Category t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Category> queryByCondition(Category category) {
		if (category == null) {
			return null;
		}
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		if (category.getName() != null) {
			criteria.andNameLike(PersentLike.makeUpPersentLike(category
					.getName()));
		}
		if (category.getParentId() != null) {
			criteria.andParentIdEqualTo(category.getParentId());
		}
		if (category.getStatus() != null) {
			criteria.andStatusEqualTo(category.getStatus());
		}
		if (category.getIsDel() != null) {
			criteria.andIsDelEqualTo(category.getIsDel());
		}
		example.setOrderByClause("sort");
		return categoryMapper.selectByExample(example);
	}

	/**
	 * 根据主键获得所有父类别及自身，由高级至低级
	 * 
	 * @param id
	 *            主键
	 * @return 实体对象列表
	 */
	@Override
	public List<Category> queryParentCategory(Long cid) {
		if (cid == null) {
			return null;
		}
		Category currentCategory = findById(cid);
		List<Category> parentCategorys = new ArrayList<Category>();
		String levelPath = currentCategory.getLevelPath();
		if (StringUtils.isNotBlank(levelPath)) {
			for (String s : levelPath.split(",")) {
				parentCategorys.add(findById(Long.parseLong(s)));
			}
		}
		parentCategorys.add(currentCategory);
		return parentCategorys;
	}

	/**
	 * 获得所有的有效的类别（isDel=false, status=1）
	 * 
	 * @return 实体对象列表
	 */
	@Override
	public List<Category> queryAllActiveCategory() {
		Category categoryTmp = new Category();
		categoryTmp.setIsDel(false);
		categoryTmp.setStatus(1);
		return queryByCondition(categoryTmp);
	}

}
