package com.unisk.zc.service;

import com.unisk.zc.entitys.Department;
import com.unisk.zc.exceptions.UniskException;

public interface DepartmentService extends BaseService<Department> {

	int updateNoSync(Department dept) throws UniskException;

}
