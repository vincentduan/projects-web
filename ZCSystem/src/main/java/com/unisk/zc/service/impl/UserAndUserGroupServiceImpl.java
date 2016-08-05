package com.unisk.zc.service.impl;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.unisk.wechat.api.support.request.TagManageRequest;
import com.unisk.zc.core.support.MyBatisBaseDao;
import com.unisk.zc.core.utils.UserUtils;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.entitys.UserAndUserGroup;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.mapper.UserAndUserGroupMapper;
import com.unisk.zc.service.UserAndUserGroupService;

@Service
public class UserAndUserGroupServiceImpl extends BaseServiceImpl<UserAndUserGroup> implements UserAndUserGroupService {
	private static final Logger logger = LoggerFactory.getLogger(UserAndUserGroupServiceImpl.class);

	UserAndUserGroupMapper userAndUserGroupMapper;
	
	@Autowired
	MyBatisBaseDao baseDao;
	
	@Autowired
	public void setUserMapper(UserAndUserGroupMapper userAndUserGroupMapper) {
		this.userAndUserGroupMapper = userAndUserGroupMapper;
		super.setBaseMapper(userAndUserGroupMapper);// 将userAndUserGroupMapper对象注入到父类中
	}

	@Override
	public int delete(Integer id) throws UniskException {
		int ret = 0;
		try {
			UserAndUserGroup userAndUserGroup = userAndUserGroupMapper.selectByPrimaryKey(id);
			ret = userAndUserGroupMapper.deleteByPrimaryKey(id);
			if( ret > 0 ){
				/*************同步微信端接口 删除标签成员**************/
				JSONObject json = new JSONObject();
				json.put("tagid", userAndUserGroup.getUsergroupid());
				JSONArray userList = new JSONArray();
				UniskUser user = baseDao.selectOne("com.unisk.zc.mapper.UniskUserMapper.selectByPrimaryKey", userAndUserGroup.getUserid());
				userList.put(user.getUsername());
				json.put("userlist", userList);
				TagManageRequest.tagDeleteUserRequest(json.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return ret;
	}

	@Override
	public Integer delete(UserAndUserGroup userAndUserGroup) throws UniskException {
		int ret = 0;
		try {
			userAndUserGroup = baseDao.selectOne("com.unisk.zc.mapper.UserAndUserGroupMapper.selectByUniqueIndex", userAndUserGroup);
			if( userAndUserGroup != null && userAndUserGroup.getId() != null )  ret = delete(userAndUserGroup.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return ret;
	}

	// 添加用户组 -用户关系
	@Override
	public int insert(UserAndUserGroup userAndUserGroup) throws UniskException {
		int ret = 0;
		try {
			userAndUserGroup.setCreatetime(new Date());
			userAndUserGroup.setModifytime(new Date());
			UniskUser loginUser = UserUtils.getUser();
			if( loginUser!=null && loginUser.getId() != null  )userAndUserGroup.setCreateuserid(loginUser.getId());
			ret = userAndUserGroupMapper.insertSelective(userAndUserGroup);
			JSONObject json = new JSONObject();
			json.put("tagid", userAndUserGroup.getUsergroupid());
			JSONArray userList = new JSONArray();
			UniskUser user = baseDao.selectOne("com.unisk.zc.mapper.UniskUserMapper.selectByPrimaryKey", userAndUserGroup.getUserid());
			userList.put(user.getUsername());
			json.put("userlist", userList);
			String retJsonStr = TagManageRequest.tagAddUserRequest(json.toString());
			if( JSONObject.fromString(retJsonStr).getInt("errcode") == 0 ){
				userAndUserGroup.setWechatstatus(1);
			}else{
				userAndUserGroup.setWechatstatus(0);
			}
			userAndUserGroupMapper.updateByPrimaryKeySelective(userAndUserGroup);
		} catch (Exception e) {
			throw new UniskException();
		}
		return ret ;
	}

	@Override
	@Transactional(rollbackFor={RuntimeException.class,Exception.class})
	public Integer modifyUserAndUserGroup(UserAndUserGroup userAndUserGroup,String uids,String unames) throws UniskException {
		int ret = 0;
		try {
			String[] userids = null;
			if ( StringUtils.isEmpty(uids) ) return null;
			userids = uids.split(",");
			List<UserAndUserGroup> userAndUserGroups = Lists.newArrayList();
			UserAndUserGroup userAndUserGroupTemp = null;
			UniskUser loginUser = UserUtils.getUser();
			for (String id : userids) {
				userAndUserGroupTemp = new UserAndUserGroup();
				userAndUserGroupTemp.setUsergroupid(userAndUserGroup.getUsergroupid());
				userAndUserGroupTemp.setUserid( Integer.valueOf(id) );
				userAndUserGroupTemp.setModifytime( new Date() );
				userAndUserGroupTemp.setDelmark(0);
				if( loginUser!=null && loginUser.getId() != null  )userAndUserGroupTemp.setCreateuserid(loginUser.getId());
				userAndUserGroups.add(userAndUserGroupTemp);
			}
			baseDao.batchInsert("com.unisk.zc.mapper.UserAndUserGroupMapper.insert", userAndUserGroups);
			ret = userAndUserGroups.size();
			/*************同步微信端接口 增加标签成员**************/
			JSONObject json = new JSONObject();
			json.put("tagid", userAndUserGroup.getUsergroupid());
			json.put("userlist", JSONArray.fromArray(unames.split(",")));
			String retJsonStr = TagManageRequest.tagAddUserRequest(json.toString());
			List<UserAndUserGroup> tempList = Lists.newArrayList();
			if( JSONObject.fromString(retJsonStr).getInt("errcode") == 0 ){
				for (UserAndUserGroup temp : userAndUserGroups) {
					temp.setWechatstatus(1);
					tempList.add(temp);
				}
			}else {
				for (UserAndUserGroup temp : userAndUserGroups) {
					temp.setWechatstatus(0);
					tempList.add(temp);
				}
			}
			baseDao.batchUpdate("com.unisk.zc.mapper.UserAndUserGroupMapper.updateByPrimaryKeySelective", tempList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return ret;
	}
}
