package com.efubao.core.admin.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.efubao.core.admin.domain.Property;
import com.efubao.core.admin.domain.PropertyExample;
import com.efubao.core.admin.domain.PropertyExample.Criteria;
import com.efubao.core.admin.domain.PropertyValue;
import com.efubao.core.admin.domain.PropertyValueExample;
import com.efubao.core.admin.service.PropertyService;
import com.efubao.core.admin.service.PropertyValueService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:core-service-admin-test.xml")
@TransactionConfiguration(transactionManager = "admin_Txm", defaultRollback = false)
@Transactional
public class PropertyServiceTest {

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private PropertyValueService propertyValueService;

	@Before
	public void setUp() {

	}

	@Test
	public void add() {
		try {
			Property record = new Property();
			record.setName("颜色");
			record.setIsSale(true);
			record.setSort(1);
			record.setStatus(1);
			int returnCode = propertyService.save(record);
			System.out.println("returnCode : " + returnCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
//	public void findAll() {
//		try {
//			List<Property> lists = propertyService.selectAll();
//			for (Property property : lists) {
//				System.out.println("属性ID : " + property.getId());
//				System.out.println("属性名称 : " + property.getName());
//				System.out.println("是否销售属性 : " + property.getIsSale());
//				System.out.println("排序 : " + property.getSort());
//				System.out.println("状态 : " + property.getStatus());
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
//			PropertyExample example = new PropertyExample();
//			Criteria criteria = example.createCriteria();
//			criteria.andNameLike("%口");
//			criteria.andStatusEqualTo(1);
//			List<Property> lists = propertyService.selectByExample(example);
//			for (Property property : lists) {
//				System.out.println("属性ID : " + property.getId());
//				System.out.println("属性名称 : " + property.getName());
//				System.out.println("是否销售属性 : " + property.getIsSale());
//				System.out.println("排序 : " + property.getSort());
//				System.out.println("状态 : " + property.getStatus());
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
			Property record = new Property();
			record.setId((long) 10);
			record.setStatus(1);
			int returnCode = propertyService.update(record);
			System.out.println("returnCode : " + returnCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteByPrimaryKey() {
		try {
			int returnCode = propertyService.deleteById((long) 18);
			System.out.println("returnCode : " + returnCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addValue() {
		try {
			PropertyValue value = new PropertyValue();
			value.setName("绿色");
			value.setPropertyId((long) 6);
			value.setSort(2);
			value.setStatus(1);
			int returnCode = propertyValueService.save(value);
			System.out.println("returnCode : " + returnCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//
//	@Test
//	public void findAllValue() {
//		try{
//			PropertyValueExample example = new PropertyValueExample();
//			com.efubao.core.admin.domain.PropertyValueExample.Criteria criteria = example.createCriteria();
//			criteria.andPropertyIdEqualTo((long)6);
//			List<PropertyValue> lists = propertyValueService.selectByExample(example);
//			for (PropertyValue propertyValue : lists) {
//				System.out.println("属性值ID : "+propertyValue.getId());
//				System.out.println("属性值 : "+propertyValue.getName());
//				System.out.println("属性ID : "+propertyValue.getPropertyId());
//				System.out.println("排序 : "+propertyValue.getSort());
//				System.out.println("状态 : "+propertyValue.getStatus());
//				System.out.println("---------------------------");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void updateValueByPrimaryKey() {
		try {
			PropertyValue record = new PropertyValue();
			record.setId((long) 7);
			record.setStatus(2);
			int returnCode = propertyValueService.update(record);
			System.out.println("returnCode : " + returnCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteValueByPrimaryKey() {
		try {
			int returnCode = propertyValueService.deleteById((long) 10);
			System.out.println("returnCode : " + returnCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
