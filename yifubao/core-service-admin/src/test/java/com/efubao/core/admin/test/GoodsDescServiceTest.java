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
import com.efubao.core.admin.domain.GoodsDesc;
import com.efubao.core.admin.service.GoodsDescService;

//@Ignore

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:core-service-admin-test.xml")
@TransactionConfiguration(transactionManager = "admin_Txm", defaultRollback = false)
@Transactional
public class GoodsDescServiceTest {

	@Autowired
	private GoodsDescService goodsDescService;

	@Before
	public void setUp() {

	}

	@Test
	public void testFindById() {
		try {
			GoodsDesc goodsDesc = goodsDescService.findById(2L);

			System.out.println("--------" + goodsDesc.getId() + "--------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testinsert() {
		try {
			GoodsDesc goodDesc = new GoodsDesc();
			goodDesc.setGoodsId(3L);
			goodDesc.setDescription("descccc");
			int temp = goodsDescService.save(goodDesc);
			System.out.println("--------" + temp + "--------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testupdate() {
		try {
			GoodsDesc goodsDesc = goodsDescService.findById(1L);
			goodsDesc.setDescription("aaaaaaa");
			int temp = goodsDescService.update(goodsDesc);
			System.out.println("--------" + temp + "--------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testdelete() {
		try {
			int temp = goodsDescService.deleteById(1L);
			System.out.println("--------" + temp + "--------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
