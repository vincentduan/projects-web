package com.unisk.zc.mapper;

import java.util.List;

import com.unisk.zc.entitys.Menu;

public interface MenuMapper extends BaseMapper<Menu>{
 
	List<Menu> selectSelective(Menu record);
}