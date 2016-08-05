package com.unisk.zc.service.impl;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisk.zc.core.support.MyBatisBaseDao;
import com.unisk.zc.core.support.Page;
import com.unisk.zc.core.utils.UserUtils;
import com.unisk.zc.entitys.Roles;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.mapper.RolesMapper;
import com.unisk.zc.service.RolesService;

@Service
public class RolesServiceImpl extends BaseServiceImpl<Roles> implements RolesService {
	private static final Logger logger = LoggerFactory.getLogger(RolesServiceImpl.class);
	@Autowired
	MyBatisBaseDao baseDao;

	RolesMapper roleMapper;

	public RolesMapper getRoleMapper() {
		return roleMapper;
	}

	@Autowired
	public void setRoleMapper(RolesMapper roleMapper) {
		if (logger.isDebugEnabled()) {
			logger.debug("roleMapper:{}注入到RolesServiceImpl中.", roleMapper);
		}
		this.roleMapper = roleMapper;
		super.setBaseMapper(roleMapper);// 将roleMapper注入到父类中
	}

	@Override
	public Page<Map<String, Object>> selectMapPage(Roles t) throws UniskException {
		// return baseDao.selectListMapPage("com.unisk.zc.mapper.RolesMapper.selectListMapPage", t);
		return super.selectMapPage(t);
	}

	@Override
	public Roles findById(Integer id) throws UniskException {
		Roles roles = baseDao.selectOne("com.unisk.zc.mapper.RolesMapper.selectByPrimaryKey", Integer.valueOf(id));
		return roles;
	}

	@Override
	public int delete(Integer id) throws UniskException {
		Roles roles = new Roles();
		roles.setId(id);
		roles.setDelmark(1);// 作废
		roles.setAllowdel(0);// 不允许删除
		roles.setAllowedit(0);// 不允许编辑
		roles.setModifytime(new Date(System.currentTimeMillis()));
		// 获取当前用户信息
		UniskUser user = UserUtils.getUser();
		if (user != null && user.getId() != null)
			roles.setModifyuserid(user.getId());
		int i = baseDao.update("com.unisk.zc.mapper.RolesMapper.updateByPrimaryKeySelective", roles);
		return i;
	}

	@Override
	public int insert(Roles roles) throws UniskException {
		roles.setDelmark(0);// 0在用 1：作废
		roles.setAllowdel(1);// 不允许删除
		roles.setAllowedit(1);// 不允许编辑
		// 获取当前用户信息
		UniskUser user = UserUtils.getUser();
		if (user != null && user.getId() != null)
			roles.setCreateuserid(user.getId());// 从session中获取当前登录用户，填充id进去
												// ，待权限认证功能完成时再填充
		return baseDao.insert("com.unisk.zc.mapper.RolesMapper.insert", roles);
	}

	@Override
	public int update(Roles roles) throws UniskException {
		// 获取当前用户信息
		UniskUser user = UserUtils.getUser();
		if (user != null && user.getId() != null)
			roles.setModifyuserid(user.getId());// 从session中获取当前登录用户，填充id进去
												// ，待权限认证功能完成时再填充
		return baseDao.update("com.unisk.zc.mapper.RolesMapper.updateByPrimaryKeySelective", roles);
	}

}
