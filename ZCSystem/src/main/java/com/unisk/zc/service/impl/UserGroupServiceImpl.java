package com.unisk.zc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.unisk.wechat.api.support.request.TagManageRequest;
import com.unisk.wechat.api.support.request.UserManageRequest;
import com.unisk.zc.core.support.MyBatisBaseDao;
import com.unisk.zc.core.support.Page;
import com.unisk.zc.core.utils.UserUtils;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.entitys.UserGroup;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.mapper.UniskUserMapper;
import com.unisk.zc.mapper.UserGroupMapper;
import com.unisk.zc.service.UserGroupService;

@Service
public class UserGroupServiceImpl extends BaseServiceImpl<UserGroup> implements UserGroupService {

	@Autowired
	UserGroupMapper ugMapper;

	@Autowired
	UniskUserMapper userMapper;
	@Autowired
	MyBatisBaseDao baseDao;
	
	@Override
	public Page<Map<String, Object>> selectMapPage(UserGroup group)
			throws UniskException {
		Page<Map<String, Object>> page = null;
		try {
			page = baseDao.selectListMapPage("com.unisk.zc.mapper.UserGroupMapper.selectListByPage", group);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return page;
	}

	@Override
	public Page<UserGroup> selectByPage(UserGroup up) throws UniskException {
		try {
			ugMapper.selectListByPage(up);
			return up.getPage();
		} catch (Exception e) {
			throw new UniskException();
		}
	}

	// 用户组删除 只做id删除
	@Override
	public int delete(Integer id) throws UniskException {
		int ret = 0;
		try {
			ret = ugMapper.deleteByPrimaryKey(id);
			if( ret > 0 ){
				/**************系统的组对应微信的标签，同步删除微信标签***************/
				TagManageRequest.tagDeleteRequest(String.valueOf(id));
				UniskUser user = new UniskUser();
				Map queryMap = Maps.newHashMap();
				queryMap.put("usergroupid", id);
				user.setQueryMap(queryMap);
				userMapper.selectUserUGListPage(user);
			}
		} catch (Exception e) {
			throw new UniskException();
		}
		return ret;
	}

	// 插入单个记录
	@Override
	public int insert(UserGroup group) throws UniskException {
		int ret = 0;
		try {
			// 操作时间必须添加
			group.setModifytime(new Date());
			group.setDelmark(0);
			UniskUser loginUser = UserUtils.getUser();
			if( loginUser!=null && loginUser.getId() != null ) group.setModifyuserid(loginUser.getId());
			ret = ugMapper.insertSelective(group);
			if( ret > 0 ){
				/**************系统的组对应微信的标签，同步插入微信标签***************/
				JSONObject json = new JSONObject();
				json.put("tagname", group.getGroupname());
				json.put("tagid", group.getId());
				String retJsonStr = TagManageRequest.tagCreateRequest(json.toString());
				if( JSONObject.fromString(retJsonStr).getInt("errcode") == 0 ){
					group.setWechatstatus(1);
				}else{
					group.setWechatstatus(0);
				}
				updateNoSync(group);
			}
		} catch (Exception e) {
			throw new UniskException();
		}
		return ret;
	}

	@Override
	public Integer updateNoSync(UserGroup group) throws UniskException {
		int ret = 0;
		try {
			ret = ugMapper.updateByPrimaryKeySelective(group);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return ret;
	}

	@Override
	public int update(UserGroup group) throws UniskException {
		int ret = 0;
		try {
			group.setModifytime(new Date());
			UniskUser loginUser = UserUtils.getUser();
			if( loginUser!=null && loginUser.getId() != null ) group.setModifyuserid(loginUser.getId());
			ret = updateNoSync(group);
			if( ret > 0 ){
				/**************系统的组对应微信的标签，同步更新微信标签***************/
				JSONObject json = new JSONObject();
				json.put("tagname", group.getGroupname());
				json.put("tagid", group.getId());
				String retJsonStr = TagManageRequest.tagUpdateRequest(json.toString());
				if( JSONObject.fromString(retJsonStr).getInt("errcode") == 0 ){
					group.setWechatstatus(3);
				}else{
					group.setWechatstatus(2);
				}
				updateNoSync(group);
			}
		} catch (Exception e) {
			throw new UniskException();
		}
		return ret;
	}

	@Override
	public UserGroup findById(Integer id) throws UniskException {
		try {
			return ugMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new UniskException();
		}
	}

	@Override
	public Page<UserGroup> selectUGSubjectRolesListPage(UserGroup userGroup)
			throws UniskException {
		try {
			ugMapper.selectUGSubjectRolesListPage(userGroup);
			return userGroup.getPage();
		} catch (Exception e) {
			throw new UniskException();
		}
	}
	
}
