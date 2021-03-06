package com.cms.service;

import java.util.List;

import com.cms.basic.model.Pager;
import com.cms.core.model.Group;
import com.cms.core.model.Role;
import com.cms.core.model.User;

public interface IUserService {
	/**
	 * add user set roles and groups
	 * @param user
	 * @param rids
	 * @param groupIds
	 */
	public void add(User user, Integer[] rids, Integer[] groupIds);
	
	/**
	 *delete user and its groups and roles 
	 * if user has articles suspend the article but not delete the articals
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * user update, if rids exist, do not update the roles
	 * if rids not exist in the user, add a role, 
	 * if user's role not exist in the ids, delete the role.
	 * @param user
	 * @param rids
	 * @param groupIds
	 */
	
	public void update(User user, Integer[] rids, Integer[] groupIds);
	
	/**
	 * 
	 * 
	 * @param userId
	 */
	public void updateStatus(int userId);

	
	public Pager<User> findUser();
	
	/**
	 * get user information
	 */
	
	public User loadUser(int id);
	
	public List<Role> listUserRoles(int userId);
	
	public List<Group> listUserGroups(int userId);
	
	public Integer[] getUserRoleIds(int userId);
	
	public Integer[] getUserGroupIds(int userId);
	
	public List<Integer> listUserRoleIds(int userId);
	
	public List<Integer> listUserGroupIds(int userId);
	
	public boolean isAdmin(int userId);
	
	public User login(String username, String password);
	
	public void update(User user);
	
	public void updatePwd(int uid, String oldPassword, String newPassword);
}
