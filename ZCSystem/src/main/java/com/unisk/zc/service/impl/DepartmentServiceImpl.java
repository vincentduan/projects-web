package com.unisk.zc.service.impl;

import java.util.Date;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisk.wechat.api.support.request.DeptManageRequest;
import com.unisk.zc.core.support.MyBatisBaseDao;
import com.unisk.zc.core.support.Page;
import com.unisk.zc.core.utils.UserUtils;
import com.unisk.zc.entitys.Department;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.service.DepartmentService;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements
		DepartmentService {

	@Autowired
	MyBatisBaseDao baseDao;
	
	@Override
	public Department findById(Integer id) throws UniskException {
		if( id == null ) return null;
		Department dept = null;
		try {
			dept = baseDao.selectOne("com.unisk.zc.mapper.DepartmentMapper.selectByPrimaryKey", id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return dept;
	}

	@Override
	public Page<Map<String, Object>> selectMapPage(Department dept)
			throws UniskException {
		
		UniskUser users = UserUtils.getUser();
		if( users != null && users.getId() != null ) dept.setCreateuserid(users.getId());
		Page<Map<String, Object>> page = null;
		try {
			page = baseDao.selectListMapPage("com.unisk.zc.mapper.DepartmentMapper.selectListMapPage", dept);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return page;
	}

	@Override
	public int insert(Department dept) throws UniskException {
		int ret = 0;
		try {
			UniskUser users = UserUtils.getUser();
			if( users != null && users.getId() != null ) dept.setCreateuserid(users.getId());
			dept.setDelmark(0);
			dept.setModifytime(new Date());
			ret = baseDao.insert("com.unisk.zc.mapper.DepartmentMapper.insert", dept);
			/********************* 同步插入微信端部门 ************************/
			if( ret > 0 ){
				JSONObject json = new JSONObject();
				json.put("name", dept.getDeptname());
				json.put("parentid", dept.getParentid());
				json.put("order", dept.getSortcode());
				json.put("id", dept.getId());
				String retjsonStr = DeptManageRequest.deptCreateRequest(json.toString());
				if( JSONObject.fromString(retjsonStr).getInt("errcode") == 0 ){
					dept.setModifytime(new Date());
					dept.setWechatstatus(1);
					updateNoSync(dept);
				}else{
					dept.setModifytime(new Date());
					dept.setWechatstatus(0);
					updateNoSync(dept);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return ret;
	}

	@Override
	public int updateNoSync(Department dept) throws UniskException {
		int ret = 0;
		try {
			ret = baseDao.update("com.unisk.zc.mapper.DepartmentMapper.updateByPrimaryKeySelective", dept);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return ret;
	}

	@Override
	public int update(Department dept) throws UniskException {
		int ret = 0;
		try {
			UniskUser users = UserUtils.getUser();
			if( users != null && users.getId() != null ) dept.setModifyuserid(users.getId());
			dept.setModifytime(new Date());
			ret =updateNoSync( dept);
			/********************* 同步更新微信端部门 ************************/
			if( ret > 0 ){
				JSONObject json = new JSONObject();
				json.put("name", dept.getDeptname());
				json.put("parentid", dept.getParentid());
				json.put("order", dept.getSortcode());
				json.put("id", dept.getId());
				String retjsonStr = DeptManageRequest.deptUpdateRequest(json.toString());
				if( JSONObject.fromString(retjsonStr).getInt("errcode") == 0 ){
					dept.setModifytime(new Date());
					dept.setWechatstatus(3);
					updateNoSync( dept);
				}else{
					dept.setModifytime(new Date());
					dept.setWechatstatus(2);
					updateNoSync( dept);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return ret;
	}
}
