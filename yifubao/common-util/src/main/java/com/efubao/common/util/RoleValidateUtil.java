/**
 
 * RoleValidateUtil.java
 
 * Copyright (c) 2013 by efubao.com
 
 */
package com.efubao.common.util;

import org.apache.commons.lang.StringUtils;

/**
 
 
 * 用户-角色验证用Util
 
 
 */
public class RoleValidateUtil {
	/**
	 * 用户是否拥有某角色
	 * @param userRoles 用户的角色
	 * @param roleId 要验证的角色
	 * @return
	 */
	public static boolean hasRole(String userRoles, Integer roleId){
		if(StringUtils.isNotBlank(userRoles) && roleId!=null){
			StringBuilder roles = new StringBuilder(","+userRoles+",");
			StringBuilder roleIdToVali = new StringBuilder(","+roleId+",");
			if(roles.toString().contains(roleIdToVali)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 用户是否拥有value大于验证角色的角色
	 * @param userRoles 用户的角色
	 * @param roleId 要验证的角色
	 * @return
	 */
	public static boolean hasUpperRoles(String userRoles, Integer roleId){
		if(StringUtils.isNotBlank(userRoles) && roleId!=null){
			String[] roles = userRoles.split(",");
			if(roles!=null && roles.length>0){
				for(String role:roles){
					Integer userRoleId = new Integer(role);
					if(userRoleId >= roleId){
						return true;
					}
				}
			}
		}
		return false;
	}
}
