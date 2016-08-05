package com.efubao.core.admin.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.efubao.common.util.Page;
import com.efubao.core.admin.domain.Goods;
import com.efubao.core.admin.service.GoodsService;

//@Ignore

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:core-service-admin-test.xml")
@TransactionConfiguration(transactionManager = "admin_Txm", defaultRollback = false)
@Transactional
public class GoodsServiceTest {

	@Autowired
	private GoodsService goodsService;

	@Before
	public void setUp() {

	}

	//
	// @Test
	// @Ignore
	// public void testSave() {
	// try{
	// Product p = new Product() ;
	// p.setBrand("Apple");
	// p.setColor("金色");
	// p.setModel("A1586");
	// p.setSize("4.7英寸");
	//
	// p.setProductTypeId(1);
	// p.setIsValid(1);
	//
	// p.setcTime(new Date());
	// p.setmTime(new Date());
	// int val = productService.save(p) ;
	// System.out.println(val);
	// }catch(Exception e){
	// e.printStackTrace();
	// }
	// }
	//
	@Test
	public void testFindById() {
		try {
			Goods goods = goodsService.findById(1L);

			System.out.println("--------" + goods + "--------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testinsert() {
		try {
			Goods good = new Goods();
			good.setName("goods4");
			good.setCategoryId(2L);
			int temp = goodsService.save(good);
			System.out.println("--------" + temp + "--------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testupdate() {
		try {
			Goods good = goodsService.findById(4L);
			good.setName("goods41");
			good.setCategoryId(4L);
			int temp = goodsService.update(good);
			System.out.println("--------" + temp + "--------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testdelete() {
		try {
			int temp = goodsService.deleteById(4L);
			System.out.println("--------" + temp + "--------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectByPage() {
		try {
			Page<Goods> page = new Page<>();
			page.setPageNo(1);
			page.setPageSize(3);
			Goods goods = new Goods();
			goodsService.queryByPage(page, goods);
			System.out.println("--------" + page.getResult().size() + "--------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//
	// @Test
	// public void testFindByPage() {
	// try{
	// Page<Consumer> page = new Page<Consumer>() ;
	// // page.setPageNo(1);
	// // page.setPageSize(10);
	// consumerService.findByPage(page, null,null);
	//
	// System.out.println(page.getResult().size());
	// }catch(Exception e){
	// e.printStackTrace();
	// }
	// }
	//
	// @After
	// public void tearDown() {
	//
	// }
}
