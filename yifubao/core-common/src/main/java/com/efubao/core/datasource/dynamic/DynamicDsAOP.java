package com.efubao.core.datasource.dynamic;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.efubao.common.util.Page;

/**
 * 数据源切换拦截器
 * 
 * 
 */
@Component
@Aspect
@Order(Integer.MAX_VALUE - 1)
public class DynamicDsAOP {

	private Logger logger = LoggerFactory.getLogger(DynamicDsAOP.class);

	/**
	 * 切换数据源,目标对象的方法执行前执行
	 * 
	 * @param jp
	 */
	@Before("execution(* com.efubao.t.admin.service..*.*(..)) || execution(* com.efubao.t.pb.service..*.*(..))")
	public void beforeInvoke(JoinPoint jp) {
		String beanName = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		// check pageSize
		Object[] args = jp.getArgs();
		if (args != null) {
			for (Object obj : args) {
				if (obj != null && obj instanceof Page) {
					Page p = (Page) obj;
					if (p != null && p.getPageSize() > 100) {
						p.setPageSize(100);
					}
				}
			}
		}
		if (StringUtils.isNotBlank(methodName)) {
			String n = methodName.toLowerCase();
			if (n.startsWith("save") || n.startsWith("update")
					|| n.startsWith("del") || n.startsWith("remove")) {
				JdbcContextHolder.setCustomerType(JdbcContextHolder.master);
			} else {
				JdbcContextHolder.setCustomerType(JdbcContextHolder.slave);
			}
		}
		logger.debug("datasource aop 拦截 ，前置通知:class={},method={},ds={}",
				beanName, methodName, JdbcContextHolder.getCustomerType());
	}
}
