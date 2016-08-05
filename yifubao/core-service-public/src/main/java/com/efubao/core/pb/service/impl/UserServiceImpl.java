package com.efubao.core.pb.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efubao.common.util.Page;
import com.efubao.core.pb.domain.User;
import com.efubao.core.pb.domain.UserExample;
import com.efubao.core.pb.mapper.UserMapper;
import com.efubao.core.pb.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserMapper userMapper;

	@Override
	public User findById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(User t) {
		if (t == null) {
			return 0;
		}
		return userMapper.insertSelective(t);
	}

	@Override
	public int update(User t) {
		if (t == null) {
			return 0;
		}
		return userMapper.updateByPrimaryKey(t);
	}

	@Override
	public int deleteById(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryByPage(Page<User> page, User t) {

	}

	@Override
	public User findByZbjId(Long zbjId) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andZbjUserIdEqualTo(zbjId);
		List<User> users = userMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(users))
			return users.get(0);
		return null;
	}

}
