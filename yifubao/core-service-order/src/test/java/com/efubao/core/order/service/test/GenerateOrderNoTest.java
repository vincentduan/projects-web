package com.efubao.core.order.service.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.efubao.core.order.service.GenerateSerialNumberService;
import com.efubao.core.order.service.GenerateSerialNumberService.SerialNumberEnum;

//@Ignore

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:core-service-order-test.xml")
@TransactionConfiguration(transactionManager = "order_Txm", defaultRollback = false)
@Transactional
public class GenerateOrderNoTest {

	@Autowired
	private GenerateSerialNumberService generateSerialNumberService;
	@Before
	public void setUp() {

	}
	
	@Test
	public void test() {
		System.out.println(generateSerialNumberService.getSerialNumber(SerialNumberEnum.PAYMENT));
	}
	//
	// @After
	// public void tearDown() {
	//
	// }
}
