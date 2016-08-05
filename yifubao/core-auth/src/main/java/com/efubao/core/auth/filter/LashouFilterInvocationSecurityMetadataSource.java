package com.efubao.core.auth.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.efubao.core.pb.domain.AuthResource;
import com.efubao.core.pb.service.SecurityManageService;

/**
 * 初始化Security时，需要加载所有权限信息
 */
public class LashouFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	/** log */
	private static final Logger logger = LoggerFactory.getLogger(LashouFilterInvocationSecurityMetadataSource.class);
	/** contractor injected */
    private SecurityManageService securityManageService;

	/**
	 * injected by contractor
	 * @param securityManageService
	 */
	public LashouFilterInvocationSecurityMetadataSource(final SecurityManageService securityManageService) {
	    this.securityManageService = securityManageService;
	}
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {

		return null;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
	
	/**
	 * 根据请求的URL获取ConfigAttribute
	 * 当访问进来后，首先判断访问的url是否在资源列表中
	 * @param object 从Filter传过来的对象
	 * @return Collection<ConfigAttribute>
	 * @throws IllegalArgumentException
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		requestUrl = requestUrl.toLowerCase();
		if (requestUrl.indexOf("?") >= 0) {
			requestUrl = requestUrl.split("\\?")[0];	
		}
		// 去除URL结尾处的'/'
		if (requestUrl.endsWith("/")) {
			requestUrl = requestUrl.substring(0, requestUrl.length() - 1);
		}
		logger.debug("requestUrl is " + requestUrl);
		List<ConfigAttribute> arr = new ArrayList<ConfigAttribute>();
		arr.add(this.getConfigAttributeByUrl(requestUrl));
        return arr;
        
	}
	
	/**
	 * @param requestUrl request URL
	 * @return
	 */
	private ConfigAttribute getConfigAttributeByUrl(String requestUrl){
		if (StringUtils.trimToNull(requestUrl) == null){
			AuthResource authResource = securityManageService.findResourceById(9999L);
			return new SecurityConfig(authResource.getCname());
		}
        List<AuthResource> resourceList = securityManageService.finaResourceListByStatus(Boolean.TRUE);
        for(AuthResource resource : resourceList){
            String resourceFullUrl = resource.getFullUrl();
            String resourceUrl = resource.getUrl();

            if (requestUrl.equals(resourceFullUrl) || requestUrl.equals(resourceUrl)) {
                return new SecurityConfig(resource.getCname());
            }
            if(resourceFullUrl.endsWith("*")){
                resourceFullUrl = resourceFullUrl.substring(0, resourceFullUrl.length() - 1);
            }
            if (resourceFullUrl.endsWith("/")){
                resourceFullUrl = resourceFullUrl.substring(0, resourceFullUrl.length() - 1);
            }
            if(StringUtils.isNotBlank(resourceUrl) && resourceUrl.endsWith("*")){
                resourceUrl = resourceUrl.substring(0, resourceUrl.length() - 1);
            }
            if (StringUtils.isNotBlank(resourceUrl) && resourceUrl.endsWith("/")){
                resourceUrl = resourceUrl.substring(0, resourceUrl.length() - 1);
            }
            if ((StringUtils.isNotBlank(resourceFullUrl) &&requestUrl.indexOf(resourceFullUrl) == 0) || 
            	(StringUtils.isNotBlank(resourceUrl) && requestUrl.indexOf(resourceUrl) == 0)) {
                return new SecurityConfig(resource.getCname());
            }

        }

		return new SecurityConfig("no resource fetched, request url=" + requestUrl);
	}

}
