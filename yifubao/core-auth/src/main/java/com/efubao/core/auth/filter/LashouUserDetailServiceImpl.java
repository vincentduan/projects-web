package com.efubao.core.auth.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.efubao.core.pb.domain.AuthResource;
import com.efubao.core.pb.domain.AuthRole;
import com.efubao.core.pb.domain.AuthUser;
import com.efubao.core.pb.service.SecurityManageService;

/**
 * 该类主要实现了对UserDetail的赋值
 * 包括将用户的权限赋值给UserDetail的GrantedAuthority
 * 
 */
public class LashouUserDetailServiceImpl implements UserDetailsService {
	/**  */
    @Autowired
    private SecurityManageService securityManageService;


    @Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(userName);
		boolean enables = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		User userdetail = new User(userName, "[PROTECTED]",
				enables, accountNonExpired, credentialsNonExpired,
				accountNonLocked, grantedAuths);
		return userdetail;
	}

	/**
	 * 根据传入的用户信息(可以是用户Id，用户名)查询用户权限
	 * 此处需要判断两件事：
	 * 1.如果用户没有被禁用，则付给默认权限。(此处有争议)
	 * 2.如果用户被禁用，则直接跳到403。也就是查询不到用户权限。
	 * @param userId 用户Id
	 * @return Set<GrantedAuthority> 权限信息
	 */
    private Set<GrantedAuthority> obtionGrantedAuthorities(String userId) {
	    Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
        AuthUser authUser = securityManageService.getUserById(Long.valueOf(userId));
        if(authUser == null){
            return authSet;
        }
        Long[] roleIds = authUser.getRoleIds();
        List<AuthResource> resourceList = new ArrayList<AuthResource>();
        if (roleIds != null && roleIds.length > 0){
            List<AuthRole> roleList = securityManageService.findRoleListByIds(Arrays.asList(roleIds), Boolean.TRUE);
            if (roleList != null && roleList.size()>0){
                for (AuthRole role : roleList){
                    if (role.getId().equals(1)){
                        resourceList = securityManageService.findResourceAll();
                        break;
                    }else{
                        resourceList.addAll(
                                securityManageService.findResourceListByIds(Arrays.asList(role.getResourceIds()),
                                        Boolean.TRUE));
                    }
                }
            }
        }
        if (resourceList == null || resourceList.size() == 0){
            AuthRole role = securityManageService.findroleById(0L);
            resourceList = securityManageService.findResourceListByIds(Arrays.asList(role.getResourceIds()),Boolean.TRUE);
        }
        if (resourceList != null && resourceList.size()>0) {
            for (AuthResource resource : resourceList) {
                authSet.add(new SimpleGrantedAuthority(resource.getCname()));
            }
        }
		return authSet;
	}

}
