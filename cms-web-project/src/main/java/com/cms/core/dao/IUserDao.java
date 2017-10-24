package com.cms.core.dao;

import java.util.List;
import java.util.Map;

import com.cms.basic.dao.IBaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.Group;
import com.cms.core.model.Role;
import com.cms.core.model.RoleType;
import com.cms.core.model.User;
import com.cms.core.model.UserGroup;
import com.cms.core.model.UserRole;

public interface IUserDao extends IBaseDao<User> {
	
	
	
	List<User> list(String string, Object[] objects);

	Pager<User> find(String string, Object[] objects);

	List<User> listUserBySql(String string, Object[] objects, Class<User> class1, boolean b);

	Pager<User> findUserBySql(String string, Object[] objects, Class<User> class1, boolean b);

	Pager<User> findUserBySql(String string, Object[] objects, Map<String, Object> alias, Class<User> class1, boolean b);

	List<User> list(String string, Object[] objects, Map<String, Object> alias);

	Pager<User> find(String string, Object[] objects, Map<String, Object> alias);

	List<User> listUserBySql(String string, Object[] objects, Map<String, Object> alias, Class<User> class1, boolean b);
	
	
	/**
	 * get roles of an user
	 */
	
	public List<Role> listUserRoles(int userId);
	
	/**
	 * get roles' ids
	 * @param userId
	 * @return
	 */
	public List<Integer> listUserRoleIds(int userId);
	
	/**
	 * get group list of a user
	 * @param userId
	 * @return
	 */
	public List<Group> listUserGroups(int userId);
	
	/**
	 * get user groups' id
	 * @param userId
	 * @return
	 */
	
	public List<Integer> listUserGroupIds(int userId);
	
	/**
	 * get User Role information
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public UserRole loadUserRole(int userId, int roleId);
	
	/**
	 * get user group information
	 * @param userId
	 * @param groupId
	 * @return
	 */
	public UserGroup loadUserGroup(int userId, int groupId);
	
	/**
	 * get user by username
	 * @param username
	 * @return
	 */
	public User loadByUsername(String username);
	
	/**
	 * get list of user by role
	 * @param role
	 * @return
	 */
	public List<User> listUsersByRole(int roleId);
	
	/**
	 * 
	 * get users by user type
	 * @param roleType
	 * @return
	 */
	
	public List<User> listUsersByRole(RoleType roleType);
	
	/**
	 * get user by Group
	 * @param groupId
	 * @return
	 */
	public List<User> listUsersByGroup(int groupId);
	
	/**
	 * add user and role to DB
	 * 
	 * @param user
	 * @param role
	 */
	public void addUserRole(User user, Role role);
	
	public void addUserGroup(User user, Group group);
	
	/**
	 * delete user role relationship
	 * @param user
	 * @param role
	 */
	public void deleteUserRoles(int userId);

	/**
	 * delete user group relationship
	 * @param user
	 * @param group
	 */
	public void deleteUserGroups(int userId);
	
	public Pager<User> findUser();
	
	/**
	 * delete user role relationship by userId and roleId
	 * @param userId
	 * @param roleId
	 */
	public void deleteUserRole(int userId, int roleId);
	
	public void deleteUserGroup(int userId, int groupId);
}
