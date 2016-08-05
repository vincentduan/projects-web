package com.efubao.core.auth.filter;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import com.efubao.core.pb.domain.AuthUser;
import com.efubao.core.pb.service.SecurityManageService;

/**
 * 权限鉴定
 * 
 */
public class BaseAccessDecisionManager implements AccessDecisionManager {
	/**  */
	private Logger logger = LoggerFactory.getLogger(BaseAccessDecisionManager.class);

    @Autowired
    private SecurityManageService securityManageService;

	/* 权限鉴定 当资源存在时，需要判断访问该资源的人是否有权限
	 */
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes) {
        String name = authentication.getName();
		if ("anonymousUser".equalsIgnoreCase(name)) {// 未登录用户
			throw new AccessDeniedException("未登录");
		}
		Assert.notEmpty(configAttributes, "未匹配到任何URL资源");
        // 超管直接跳过
        if(this.isSuperAdmin(name)){
            return;
        }
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		String needPermission = null;
		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			needPermission = configAttribute.getAttribute();
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (needPermission.equals(ga.getAuthority())) {
					return;
				}
			}
		}
		logger.warn("当前用户" + authentication.getName() + "没有访问"
				+ needPermission + "的权限 ");
		throw new AccessDeniedException("当前用户" + authentication.getName()
				+ "没有访问" + needPermission + "的权限");

	}

    /**
     * 是否超管
     * @param name
     * @return
     */
    private boolean isSuperAdmin(String name){
        AuthUser authUser = securityManageService.getUserById(Long.parseLong(name));
        if(authUser == null){
            throw new AccessDeniedException("未查询到用户名:" + name + "的用户");
        }
        Long[] roleIds = authUser.getRoleIds();
		if (roleIds!= null && roleIds.length>0) {
			for (Long rolesId : roleIds) {
				if (Long.valueOf("1").equals(rolesId)) {
					return true;
				}
			}
		}
        return false;
    }
	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
