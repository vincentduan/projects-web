package com.unisk.zc.service;

import java.util.List;
import java.util.Map;

import com.unisk.zc.core.support.Page;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.exceptions.UniskException;

public interface UniskUserService extends BaseService<UniskUser> {
	
	int updateNoSync(UniskUser user) throws UniskException;

	/**
	 * 用户登录，按照用户名查询
	 * 
	 * @param username
	 * @return
	 * @throws UniskException
	 */
	Map<String, Object> getUserByLoginName(String username) throws UniskException;

	/**
	 * 
	 * @Description:得到用户列表，去除已经选中的用户
	 * @author 刘见明
	 * @time:2016年1月6日 下午1:29:46
	 * @return
	 * @throws UniskException
	 */
	public Page<UniskUser> selectRemoveHasChooseUser(UniskUser user) throws UniskException;

	/**
	 * 
	 * @Description:用户列表-根据用户角色
	 * @author 刘见明
	 * @time:2016年1月6日 下午5:44:16
	 * @param user
	 * @return
	 * @throws UniskException
	 */
	public Page<UniskUser> selectSubjectRolesUserListPage(UniskUser user) throws UniskException;

	/**
	 * 根据部门ID列表查询对应的用户ID列表
	 * 
	 * @param deptIds
	 * @return
	 * @throws UniskException
	 */
	public List<String> selectUserIdsByDeptIds(List<String> deptIds) throws UniskException;

	/**
	 * 根据用户组ID列表查询对应的用户ID列表
	 * 
	 * @param tagIds
	 * @return
	 * @throws UniskException
	 */
	public List<String> selectUserIdsByTagIds(List<String> tagIds) throws UniskException;

	/**
	 * 根据用户名查询当前用户名是否存在系统中,如果存在,返回true,否则false
	 * 
	 * @param user
	 * @return
	 */
	public boolean checkUsernameIsOnly(UniskUser user) throws UniskException;

	/**
	 * 查询所有用户名称集合列表
	 * 
	 * @return
	 * @throws UniskException
	 */
	public List<String> selectAllUserIds() throws UniskException;
}
