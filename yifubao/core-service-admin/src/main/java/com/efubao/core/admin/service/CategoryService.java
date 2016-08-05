package com.efubao.core.admin.service;

import java.util.List;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.domain.CategoryExample;
import com.efubao.core.common.base.BaseService;


public interface CategoryService extends BaseService<Category>{

	List<Category> queryByCondition(Category category);

	List<Category> queryParentCategory(Long cid);

	List<Category> queryAllActiveCategory();
	
}
