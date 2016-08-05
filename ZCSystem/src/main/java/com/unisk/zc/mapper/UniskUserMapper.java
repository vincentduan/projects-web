package com.unisk.zc.mapper;

import java.util.List;

import com.unisk.zc.entitys.UniskUser;

public interface UniskUserMapper extends BaseMapper<UniskUser> {

	List<UniskUser> selectSelective(UniskUser record);

	List<UniskUser> selectListForDeptidByPage(UniskUser record);

	// 根据用户组关系表得到用户
	List<UniskUser> selectUserUGListPage(UniskUser record);

	// 用户组添加用户列表
	List<UniskUser> selectRemoveSomeUserListPage(UniskUser record);

	// 角色-用户列表
	List<UniskUser> selectSubjectRolesUserListPage(UniskUser record);

	List<String> selectUserIdsByTagIds(List<String> tagIds);

	List<String> selectUserIdsByDeptIds(List<String> deptIds);

	List<String> selectAllUserIds();
}