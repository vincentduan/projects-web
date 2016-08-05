package com.unisk.zc.core.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;

import com.google.common.collect.Maps;
import com.unisk.zc.core.shiro.SystemAuthorizingRealm;
import com.unisk.zc.core.support.MyBatisBaseDao;
import com.unisk.zc.entitys.Department;
import com.unisk.zc.entitys.Menu;
import com.unisk.zc.entitys.SubjectAndRoles;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.mapper.MenuMapper;
import com.unisk.zc.mapper.RolesMapper;
import com.unisk.zc.mapper.UniskUserMapper;
import com.unisk.zc.utils.springs.SpringContextHolder;

public class UserUtils {

	private static UniskUserMapper userDao = SpringContextHolder.getBean(UniskUserMapper.class);
	private static RolesMapper roleDao = SpringContextHolder.getBean(RolesMapper.class);
	private static MenuMapper menuDao = SpringContextHolder.getBean(MenuMapper.class);
	private static MyBatisBaseDao baseDao = SpringContextHolder.getBean(MyBatisBaseDao.class);

	public static final String CACHE_USER = "user";
	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_DEPARTMENT_LIST = "departmentList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	public static final String CACHE_OFFICE_MAP = "officeMap";

	public UserUtils() {
	}

	public static UniskUser getUser() {
		UniskUser user = (UniskUser) getCache("user");
		if (user == null)
			try {
				Subject subject = SecurityUtils.getSubject();
				SystemAuthorizingRealm.Principal principal = (SystemAuthorizingRealm.Principal) subject.getPrincipal();
				if (principal != null) {
					user = userDao.selectByPrimaryKey(Integer.valueOf(principal.getId()));
					if (user != null) {
						putCache("user", user);
					}
				}
			} catch (UnavailableSecurityManagerException unavailablesecuritymanagerexception) {
				unavailablesecuritymanagerexception.printStackTrace();
			} catch (InvalidSessionException invalidsessionexception) {
				invalidsessionexception.printStackTrace();
			}
		if (user == null) {
			user = new UniskUser();
			try {
				SecurityUtils.getSubject().logout();
			} catch (UnavailableSecurityManagerException unavailablesecuritymanagerexception1) {
				unavailablesecuritymanagerexception1.printStackTrace();
			} catch (InvalidSessionException invalidsessionexception1) {
				invalidsessionexception1.printStackTrace();
			}
		}
		return user;
	}

	public static UniskUser getUser(boolean isRefresh) {
		if (isRefresh)
			removeCache("user");
		return getUser();
	}

	public static List<SubjectAndRoles> getRoleList() {
		List list = (List) getCache("roleList");
		if (list == null || list.isEmpty()) {
			/*
			 * User user = getUser(); DetachedCriteria dc = roleDao.createDetachedCriteria(new Criterion[0]); dc.createAlias("office", "office"); dc.createAlias("userList", "userList",
			 * JoinType.LEFT_OUTER_JOIN); dc.add(dataScopeFilter(user, "office", "userList")); dc.add(Restrictions.eq("delFlag", "0")); dc.addOrder(Order.asc("office.code"
			 * )).addOrder(Order.asc("name")); list = roleDao.find(dc); putCache("roleList", list);
			 */
		}
		return list;
	}

	public static List getMenuList() {
		List menuList = (List) getCache(CACHE_MENU_LIST);
		if (menuList == null) {
			Menu menu = new Menu();
			menu.setIsshow(1);
			menuList = menuDao.selectSelective(menu);
			putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}

	public static List getDepartmentList(Integer parentid) {
		List departmentList = (List) getCache(CACHE_DEPARTMENT_LIST);
		if (departmentList == null) {
			Department department = new Department();
			UniskUser user = getUser();
			if (user != null && user.getId() != null)
				department.setCreateuserid(user.getId());
			if (parentid == null)
				department.setParentid(parentid);
			departmentList = baseDao.selectList("com.unisk.zc.mapper.DepartmentMapper.selectList", department);
			putCache(CACHE_DEPARTMENT_LIST, departmentList);
		}
		return departmentList;
	}

	public static UniskUser getUserById(String id) {
		if (StringUtils.isNotBlank(id))
			return null;
		else
			return null;
	}

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
		Object obj = getCacheMap().get(key);
		return obj != null ? obj : defaultValue;
	}

	public static void putCache(String key, Object value) {
		getCacheMap().put(key, value);
	}

	public static void removeCache(String key) {
		getCacheMap().remove(key);
	}

	public static Map getCacheMap() {
		Map map = Maps.newHashMap();
		SystemAuthorizingRealm.Principal principal = null;
		Subject subject = SecurityUtils.getSubject();
		principal = (SystemAuthorizingRealm.Principal) subject.getPrincipal();
		return principal == null ? map : principal.getCacheMap();

	}

	public static String getUserType() {
		String userType = "";
		// userType =UserUtils.getUser().getUserType();
		return userType;
	}

}
