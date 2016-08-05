package com.unisk.zc.core.support;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.unisk.zc.entitys.BaseQuery;

/**
 * mybatis分页拦截器，用于填充返回值
 * 
 * @Description:
 * @author shijingbang
 * @Date 2015年12月23日
 */
@Aspect
@Component
public class PageIntecepter {

	private static final Logger logger = LoggerFactory.getLogger(PageIntecepter.class);

	@Pointcut("execution(* com.unisk..service..*.*Page(..))")
	public void pageAroundPointCut() {
	};

	@Around(value = "pageAroundPointCut()")
	public Object around(ProceedingJoinPoint pjp) {
		try {
			Object[] params = pjp.getArgs();// 获取目标方法的入参集合
			Object retVal = pjp.proceed();// 执行目标方法

			// 注意：目标对象的第一个入参必须是BaseQuery的子类
			if (params != null && params.length > 0 && params[0] instanceof BaseQuery) {
				// 目标对象的目标方法返回值如果是Page类型，则返回page对象，否则原样返回
				if (MethodSignature.class.isAssignableFrom(pjp.getSignature().getClass())) {
					BaseQuery<?> param = (BaseQuery<?>) params[0];
					Page<?> page = param.getPage();
					MethodSignature ms = (MethodSignature) pjp.getSignature();
					if (Page.class.isAssignableFrom(ms.getReturnType())) {
						return page;
					}
				}
			}
			return retVal;
		} catch (Throwable e) {
			e.printStackTrace();
			logger.error("执行目标对象{}的方法{}环绕增强出错，错误原因{}", pjp.getTarget().getClass(), pjp.getSignature().getName(), e.getClass().getName() + ":" + e.getMessage());
		}
		return null;
	}
}
