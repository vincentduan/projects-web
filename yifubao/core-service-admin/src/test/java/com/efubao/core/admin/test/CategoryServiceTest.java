package com.efubao.core.admin.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.efubao.core.admin.domain.Category;
import com.efubao.core.admin.domain.CategoryExample;
import com.efubao.core.admin.domain.Property;
import com.efubao.core.admin.domain.PropertyExample;
import com.efubao.core.admin.domain.PropertyExample.Criteria;
import com.efubao.core.admin.domain.PropertyValue;
import com.efubao.core.admin.domain.PropertyValueExample;
import com.efubao.core.admin.service.CategoryService;
import com.efubao.core.admin.service.PropertyService;
import com.efubao.core.admin.service.PropertyValueService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:core-service-admin-test.xml")
@TransactionConfiguration(transactionManager = "admin_Txm", defaultRollback = false)
@Transactional
public class CategoryServiceTest {

	@Autowired
	private CategoryService categoryService;

	@Before
	public void setUp() {

	}

	@Test
	public void add() {
		try {
			ArrayList<String> categoryNames = new ArrayList<String>();
			categoryNames.add("工程服");
			categoryNames.add("休闲服");
			categoryNames.add("西服正装");
			categoryNames.add("防寒服");
			categoryNames.add("大衣外套");
			categoryNames.add("羽绒服");
			for (String name : categoryNames) {
				Category category = new Category();
				category.setName(name);
				category.setSort(1);
				category.setStatus(1);
				category.setLevelPath("");
				int returnCode = categoryService.save(category);
				System.out.println("returnCode : " + returnCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addSub() {
		try {
			Long id = new Long(8);
			String name = "长袖衬衫";
			Category parentCategory = categoryService.findById(id);
			Category category = new Category();
			category.setName(name);
			category.setParentId(id);
			category.setSort(1);
			category.setStatus(1);
			category.setLevelPath(parentCategory.getLevelPath() + "," + id);
			int returnCode = categoryService.save(category);
			System.out.println("returnCode : " + returnCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
//	public void findAll() {
//		try {
//			List<Category> lists = categoryService.selectAll();
//			for (Category category : lists) {
//				System.out.println("分类ID : " + category.getId());
//				System.out.println("分类名称 : " + category.getName());
//				System.out.println("父类ID : " + category.getParentId());
//				System.out.println("排序 : " + category.getSort());
//				System.out.println("状态 : " + category.getStatus());
//				System.out.println("路径 : " + category.getLevelPath());
//				System.out.println("---------------------------");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	@Test
//	public void findByNameAndStatus() {
//		try {
//			CategoryExample example = new CategoryExample();
//			com.efubao.core.admin.domain.CategoryExample.Criteria criteria = example.createCriteria();
//			criteria.andNameLike("%衬衫");
//			criteria.andStatusEqualTo(1);
//			List<Category> lists = categoryService.selectByExample(example);
//			for (Category category : lists) {
//				System.out.println("分类ID : " + category.getId());
//				System.out.println("分类名称 : " + category.getName());
//				System.out.println("父类ID : " + category.getParentId());
//				System.out.println("排序 : " + category.getSort());
//				System.out.println("状态 : " + category.getStatus());
//				System.out.println("路径 : " + category.getLevelPath());
//				System.out.println("---------------------------");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	@Test
	public void updateByPrimaryKey() {
		try {
			Category category = new Category();
			category.setId((long) 5);
			category.setStatus(2);
			int returnCode = categoryService.update(category);
			System.out.println("returnCode : " + returnCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
//	public void deleteByPrimaryKey() {
//		try {
//			Long id = new Long(7);
//			CategoryExample example = new CategoryExample();
//			com.efubao.core.admin.domain.CategoryExample.Criteria criteria = example.createCriteria();
//			criteria.andParentIdEqualTo(id);
//			List<Category> subCategorys = categoryService.selectByExample(example);
//			int returnCode;
//			if (subCategorys.isEmpty()){
//				returnCode = categoryService.deleteById(id);
//			}else{
//				returnCode = 2;
//			}
//			System.out.println("returnCode : " + returnCode);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
