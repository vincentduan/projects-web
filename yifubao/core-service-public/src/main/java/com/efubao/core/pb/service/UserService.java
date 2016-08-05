package com.efubao.core.pb.service;

import com.efubao.core.common.base.BaseService;
import com.efubao.core.pb.domain.User;

public interface UserService extends BaseService<User> {

	public User findByZbjId(Long zbjId);
}
