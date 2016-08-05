package com.unisk.zc.service;

import com.unisk.zc.core.support.Page;
import com.unisk.zc.entitys.UserGroup;
import com.unisk.zc.exceptions.UniskException;

public interface UserGroupService extends BaseService<UserGroup> {
	/**
	 * 
	 * @Description:角色-用户组获取服务
	 * @author 刘见明
	 * @time:2016年1月7日 上午10:37:46
	 * @param userGroup
	 * @return
	 * @throws UniskException
	 */
	Page<UserGroup> selectUGSubjectRolesListPage(UserGroup userGroup)throws UniskException;
			

	Integer updateNoSync(UserGroup group)throws UniskException;

}
