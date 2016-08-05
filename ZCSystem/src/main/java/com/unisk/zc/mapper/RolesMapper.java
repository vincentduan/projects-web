package com.unisk.zc.mapper;

import com.unisk.zc.entitys.Roles;

public interface RolesMapper extends BaseMapper<Roles> {

	public int logicalDeleteById(Roles roles);
}