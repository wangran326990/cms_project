package com.cms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cms.core.dao.IRoleDao;
import com.cms.core.dao.IUserDao;
import com.cms.core.errors.CmsException;
import com.cms.core.model.Role;
import com.cms.core.model.User;

@Service("roleService")
public class RoleService implements IRoleService {

	private IUserDao userDao;
	private IRoleDao roleDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}
	@Resource(name="userDao")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IRoleDao getRoleDao() {
		return roleDao;
	}
	
	@Resource(name="roleDao")
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	
	
	@Override
	public void add(Role role) {
		roleDao.add(role);
	}

	@Override
	public void delete(int roleId) {
		List<User> users = userDao.listUsersByRole(roleId);
		if(users!=null && users.size() >0) throw new CmsException("this role contains users");
		roleDao.delete(roleId);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
	}

	@Override
	public Role load(int rid) {
		// TODO Auto-generated method stub
		return roleDao.load(rid);
	}

	@Override
	public List<Role> listRole() {
		// TODO Auto-generated method stub
		return roleDao.listRoles();
	}

	@Override
	public void deleteRoleUsers(int rid) {
		roleDao.deleteRoleUsers(rid);
	}

}
