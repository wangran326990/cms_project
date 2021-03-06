package com.cms.service;

import java.util.List;

import com.cms.core.model.Role;
import com.cms.core.model.User;

public interface IRoleService {
	
	public void add(Role role);
	
	public void delete(int roleId);
	
	public void update(Role role);
	
	public Role load(int id);
	
	public List<Role> listRole();
	
	public void deleteRoleUsers(int id);
	
	public List<User> listRoleUsers(int rid);
	
}
