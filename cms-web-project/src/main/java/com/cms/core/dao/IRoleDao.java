package com.cms.core.dao;

import java.util.List;

import com.cms.basic.dao.IBaseDao;
import com.cms.core.model.Role;
import com.cms.core.model.UserRole;

public interface IRoleDao extends IBaseDao<Role>{
	
	public List<Role> listRoles();	
	
	public void deleteRoleUsers(int rid);
}