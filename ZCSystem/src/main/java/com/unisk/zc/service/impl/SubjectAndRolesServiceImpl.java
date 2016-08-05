package com.unisk.zc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.unisk.zc.entitys.UserAndUserGroup;
import com.unisk.zc.service.SubjectAndRolesService;

@Service
public class SubjectAndRolesServiceImpl extends
		BaseServiceImpl<UserAndUserGroup> implements SubjectAndRolesService {
	private static final Logger logger = LoggerFactory
			.getLogger(SubjectAndRolesServiceImpl.class);

}
