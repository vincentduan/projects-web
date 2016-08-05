package com.efubao.core.sp.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.efubao.core.sp.domain.Industry;
import com.efubao.core.sp.service.IndustryService;

//@Ignore

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:core-service-sp-test.xml")
@TransactionConfiguration(transactionManager = "sp_Txm", defaultRollback = true)
@Transactional
public class IndustryServiceTest {

	@Autowired
	private IndustryService industryService;

	@Before
	public void setUp() {

	}

	@Test
	public void testFindById() {
		try {
			Industry industry = industryService.findById(1L);
			System.out.println("--------" + industry + "--------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
