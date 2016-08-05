package com.unisk.zc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.unisk.wechat.api.support.request.TagManageRequest;
import com.unisk.wechat.api.support.request.UserManageRequest;
import com.unisk.zc.core.config.Global;
import com.unisk.zc.core.support.MyBatisBaseDao;
import com.unisk.zc.core.support.Page;
import com.unisk.zc.core.utils.UserUtils;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.mapper.UniskUserMapper;
import com.unisk.zc.service.UniskUserService;

@Service
public class UniskUserServiceImpl extends BaseServiceImpl<UniskUser> implements UniskUserService {

	@Autowired
	UniskUserMapper userMapper;

	@Autowired
	MyBatisBaseDao baseDao;
	
	@Override
	public Map<String, Object> getUserByLoginName(String username) throws UniskException {
		UniskUser user = new UniskUser();
		user.setUsername(username);
		user.setIslock(0);
		try {
			List<Map<String, Object>> userMaps =  baseDao.selectList("com.unisk.zc.mapper.UniskUserMapper.selectList", user);
			Map<String, Object> userMap = null;
			if( userMaps!=null && !userMaps.isEmpty() ) userMap = userMaps.get(0);
			return userMap;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);// 错误原因要向上传播，不然controller获取到异常都不知道异常原因是什么
		}
	}

	@Override
	public Page<Map<String, Object>> selectMapPage(UniskUser user) throws UniskException {
		Page<Map<String, Object>> page = null;
		try {
			page = baseDao.selectListMapPage("com.unisk.zc.mapper.UniskUserMapper.selectListByPage", user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return page;
	}

	@Override
	public int insert(UniskUser user) throws UniskException {
		int ret = 0;
		try {
			user.setPassword(entryptPassword(user.getPassword()));
			// 增加修改时间 默认为当前时间。
			user.setModifytime(new Date());
			ret = userMapper.insertSelective(user);
			if (ret > 0) {
				JSONObject json = new JSONObject();
				json.put("userid", String.valueOf(user.getUsername()));
				json.put("name", user.getRealname());
				JSONArray deptArray = new JSONArray();
				deptArray.put(String.valueOf(user.getDeptid()));
				json.put("department", deptArray.toString());
				json.put("position", user.getTitle());
				json.put("mobile", user.getPhone());
				json.put("gender", user.getSex() == 0 ? "2" : "1");
				json.put("email", user.getEmail());
				String retJsonStr = UserManageRequest.userCreateRequest(json.toString());
				if(JSONObject.fromString(retJsonStr).getInt("errcode") == 0){
					user.setWechatstatus(1);
				}else{
					user.setWechatstatus(0);
				}
				user.setModifytime(new Date());
				updateNoSync(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return ret;
	}

	@Override
	public int delete(Integer id) throws UniskException {
		int ret = 0;
		try {
			ret = userMapper.deleteByPrimaryKey(id);

			/******************** 删除微信端数据，同步删除标签成员，删除成员 *************************/
			if (ret > 0) {
				UniskUser user = new UniskUser();
				user.setId(id);
				Page<UniskUser> page = new Page<UniskUser>();
				page.setCurrentPage(1);
				page.setMaxNum(Integer.MAX_VALUE);
				user.setPage(page);
				Page<Map<String, Object>> page2 = baseDao.selectListMapPage("com.unisk.zc.mapper.UniskUserMapper.selectUserUGListPage", user);
				List<Map<String, Object>> userMaps = page2.getData();
				JSONObject json = null;
				JSONArray jsonArray = null;
				if (userMaps != null && !userMaps.isEmpty()) {
					for (Map<String, Object> map : userMaps) {
						json = new JSONObject();
						json.put("tagid", map.get("USERGROUPID"));
						jsonArray = new JSONArray();
						jsonArray.put(map.get("USERNAME"));
						json.put("userlist", jsonArray.toArray());
						TagManageRequest.tagDeleteUserRequest(json.toString());
					}
				}
				UserManageRequest.userDeleteRequest(String.valueOf(id));
			}
		} catch (Exception e) {
			throw new UniskException(e);
		}
		return ret;
	}

	@Override
	public UniskUser findById(Integer id) throws UniskException {
		try {

			return userMapper.selectByPrimaryKey(id);

		} catch (Exception e) {
			throw new UniskException(e);
		}
	}

	@Override
	public int updateNoSync(UniskUser user) throws UniskException {
		int ret;
		try {
			ret = userMapper.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return ret;
	}

	@Override
	public int update(UniskUser user) throws UniskException {
		int ret = 0;
		try {
			user.setModifytime(new Date());
			UniskUser loginUser = UserUtils.getUser();
			if( loginUser!=null && loginUser.getId() != null ) user.setModifyuserid(loginUser.getId());
			ret = updateNoSync(user);
			if (ret > 0) {
				user = findById(user.getId());
				JSONObject json = new JSONObject();
				json.put("userid", String.valueOf(user.getUsername()));
				json.put("name", user.getRealname());
				JSONArray deptArray = new JSONArray();
				deptArray.put(String.valueOf(user.getDeptid()));
				json.put("department", deptArray.toString());
				json.put("position", user.getTitle());
				json.put("mobile", user.getPhone());
				json.put("gender", user.getSex() == 0 ? "2" : "1");
				json.put("email", user.getEmail());
				String retJsonStr = UserManageRequest.userUpdateRequest(json.toString());
				if(JSONObject.fromString(retJsonStr).getInt("errcode") == 0){
					user.setWechatstatus(3);
				}else{
					user.setWechatstatus(2);
				}
				user.setModifytime(new Date());
				updateNoSync(user);
			}
		} catch (Exception e) {
			throw new UniskException(e);
		}
		return ret;
	}

	public String entryptPassword(String password) {
		ByteSource salt = ByteSource.Util.bytes(password.toCharArray());
		Hash hash = new SimpleHash(Global.getConfig("hashAlgorithm"), password, salt, Integer.valueOf(Global.getConfig("hashInterations")));
		return hash.toHex();
	}

	@Override
	public Page<UniskUser> selectRemoveHasChooseUser(UniskUser user) throws UniskException {

		try {
			userMapper.selectRemoveSomeUserListPage(user);
			return user.getPage();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
	}

	@Override
	public Page<UniskUser> selectSubjectRolesUserListPage(UniskUser user) throws UniskException {
		try {
			userMapper.selectSubjectRolesUserListPage(user);
			return user.getPage();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
	}

	@Override
	public List<String> selectUserIdsByDeptIds(List<String> deptIds) throws UniskException {
		return userMapper.selectUserIdsByDeptIds(deptIds);
	}

	@Override
	public List<String> selectUserIdsByTagIds(List<String> tagIds) throws UniskException {
		return userMapper.selectUserIdsByTagIds(tagIds);
	}

	@Override
	public boolean checkUsernameIsOnly(UniskUser user) throws UniskException {
		boolean ret = false;
		List<UniskUser> users = null;
		try {
			if( user.getId() != null ){
				Map queryMap = Maps.newHashMap();
				queryMap.put("notinids", "not in (" + user.getId() + ")");
				user.setQueryMap(queryMap);
			}
			users = userMapper.selectList(user);
			if (users != null && !users.isEmpty())
				ret = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return ret;
	}
	
	@Override
	public List<String> selectAllUserIds() throws UniskException {
		return userMapper.selectAllUserIds();
	}
}
