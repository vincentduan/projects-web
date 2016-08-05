package com.unisk.zc.service;

import com.unisk.zc.entitys.UserAndUserGroup;
import com.unisk.zc.exceptions.UniskException;

public interface UserAndUserGroupService extends BaseService<UserAndUserGroup> {

	Integer modifyUserAndUserGroup(UserAndUserGroup useAndUserGroup,String uids,String unames) throws UniskException;

	Integer delete(UserAndUserGroup userAndUserGroup) throws UniskException;

}
