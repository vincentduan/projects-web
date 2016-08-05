/**
 * Copyright &copy; 2012-2013 EMVC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.unisk.zc.core.shiro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisk.zc.core.servlet.ValidateCodeServlet;
import com.unisk.zc.core.utils.LoginCookieUtils;
import com.unisk.zc.core.utils.UserUtils;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.exceptions.CaptchaException;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.service.UniskUserService;

/**
 * 系统安全认证实现类
 * 
 * @author xuhao
 * @version 2015-12-08
 */
@Service
// @DependsOn({"userDao","roleDao","menuDao"})
public class SystemAuthorizingRealm extends AuthorizingRealm {

	@Autowired
	UniskUserService userService;

	/**
	 * 认证回调函数, 登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Session session = SecurityUtils.getSubject().getSession();
		/*
		 * String phonecode = (String) session.getAttribute(ValidatePhoneCodeServlet.VALIDATE_PHONE_CODE); if (token.getPhoneCode() == null || !token.getPhoneCode().equals(phonecode)) {
		 * throw new CaptchaException("手机验证码错误."); }
		 */
		if (LoginCookieUtils.isValidateCodeLogin(token.getUsername(), false, false)) {
			// 判断验证码
			String code = (String) session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
			if (token.getCaptcha() == null || !token.getCaptcha().toUpperCase().equals(code)) {
				throw new CaptchaException("图形验证码错误.");
			}
		}

		try {
			Map<String, Object> userMap = userService.getUserByLoginName(token.getUsername());
			ByteSource salt = null;
			if (userMap != null) {
				// 此处有bug，将decodeHex方法是将16进制字符串转为字节数组，十六进制包含(1-9,a-f)如果字符串中超出此范围，将报错
				// byte[] salt = Encodes.decodeHex(user.getUSERPWD());
				// if ( StringUtils.isNotBlank ( user.getPassword() ) ) {
				// salt = ByteSource.Util.bytes( token.getPassword() );
				// }
				// salt 为从token中取得的密码做参数
				salt = ByteSource.Util.bytes(token.getPassword());

				// 用户自定义realm已经覆盖默认的SimpleCredentialsMatcher，改用HashedCredentialsMatcher(采用的SHA_1算法，迭代次数1024次)
				// 备注：因为数据库目前password存的是明文，所以此处第二个参数hashedCredentials需要经过HASH计算后才行，不能直接user.getUSERPWD()
				// 后续在用户管理模块保存用户入库的逻辑中应该保存经过HASH之后的密文，这样此处才不需要再HASH计算，直接user.getUSERPWD()即可
				return new SimpleAuthenticationInfo(new Principal(userMap), userMap.get("password"), salt, getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Principal principal = (Principal) getAvailablePrincipal(principals);
		try {
			UniskUser user = userService.findById(Integer.valueOf(principal.getId()));
			UserUtils.putCache("user", user);
		} catch (UniskException e) {
			e.printStackTrace();
		}

		// SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// List<Menu> list = UserUtils.getMenuList();
		// for (Menu menu : list){
		// if (StringUtils.isNotBlank(menu.getPermission())){
		// // 添加基于Permission的权限信息
		// for (String permission :
		// StringUtils.split(menu.getPermission(),",")){
		// info.addStringPermission(permission);
		// }
		// }
		// }
		// // 更新登录IP和时间
		// getSystemService().updateUserLoginInfo(user.getId());
		// return info;
		// } else {
		return null;
		// }
	}

	/**
	 * 设定密码校验的Hash算法与迭代次数
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("SHA-1");
		matcher.setHashIterations(1024);
		setCredentialsMatcher(matcher);
	}

	/**
	 * 清空用户关联权限认证，待下次使用时重新加载
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清空所有关联认证
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

	/**
	 * 授权用户信息
	 */
	public static class Principal implements Serializable {

		private static final long serialVersionUID = 1L;

		private final String id;
		/**
		 * 用户名
		 */
		private final String loginName;
		/**
		 * 姓名
		 */
		private final String name;
		/**
		 * 所在组织机构名
		 */
		private String orgName;
		private Map<String, Object> cacheMap;

		public Principal(UniskUser user) {
			this.id = user.getId() + "";
			this.loginName = user.getUsername();
			this.name = user.getRealname();
			this.orgName = user.getDeptid() + "";
		}

		public Principal(Map<String, Object> userMap) {
			this.id = String.valueOf(userMap.get("id"));
			this.loginName = (String) userMap.get("username");
			this.name = (String) userMap.get("realname");
			this.orgName = (String) userMap.get("DEPTIDLABEL");
		}

		public String getId() {
			return id;
		}

		public String getLoginName() {
			return loginName;
		}

		public String getName() {
			return name;
		}

		public String getOrgName() {
			return orgName;
		}

		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}

		public Map<String, Object> getCacheMap() {
			if (cacheMap == null) {
				cacheMap = new HashMap<String, Object>();
			}
			return cacheMap;
		}

		@Override
		public String toString() {
			return "Principal [id=" + id + ", loginName=" + loginName + ", name=" + name + ", orgName=" + orgName + ", cacheMap=" + cacheMap + "]";
		}

	}
}
