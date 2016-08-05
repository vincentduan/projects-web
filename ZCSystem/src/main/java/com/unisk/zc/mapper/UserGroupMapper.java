package com.unisk.zc.mapper;

import java.util.List;

import com.unisk.zc.entitys.UserGroup;

public interface UserGroupMapper extends BaseMapper<UserGroup> {
	//用户组角色列表
	List<UserGroup>selectUGSubjectRolesListPage(UserGroup userGroup);
	
}