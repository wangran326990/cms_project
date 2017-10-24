package com.cms.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import com.cms.basic.model.Pager;
import com.cms.core.dao.IGroupDao;
import com.cms.core.dao.IRoleDao;
import com.cms.core.dao.IUserDao;
import com.cms.core.errors.CmsException;
import com.cms.core.model.Group;
import com.cms.core.model.Role;
import com.cms.core.model.User;

@Service("userService")
public class UserService implements IUserService {

	private IUserDao userDao;
	private IRoleDao roleDao;
	private IGroupDao groupDao;
	
	@Override
	public void add(User user, Integer[] rids, Integer[] groupIds) {
		// TODO Auto-generated method stub
		User tu = userDao.loadByUsername(user.getUsername());
		if(tu!=null){
			throw new CmsException("user already exist !!");
		}
		userDao.add(user);
		for(Integer rid : rids ){
			//1.check role object exist?
			
			Role role = roleDao.load(rid);
			if(role==null){
				throw new CmsException("role not exist");
			}
			userDao.addUserRole(user, role);
			//2. check user and role object exist?
		}
		for(Integer groupId : groupIds){
			Group group = groupDao.load(groupId);
			if(group==null){
				throw new CmsException("group not exist");
			}
			userDao.addUserGroup(user, group);
		}
	}

	@Override
	public void delete(int id) {
		
//		User user = userDao.load(id);
//		if(user==null) return;
		
		//1 delete user group relationship
				userDao.deleteUserGroups(id);
		//2 delete user role relationship
		
				userDao.deleteUserRoles(id);
		
		
		
		userDao.delete(id);
	}

	@Override
	public void update(User user, Integer[] rids, Integer[] groupIds) {
		//1. get user group and role ids;
		List<Integer> erids = userDao.listUserRoleIds(user.getId());
		List<Integer> egids = userDao.listUserGroupIds(user.getId());
		//2. if rids not exist in eids, we should add new relationship in UserRole table;
		for(Integer rid : rids){
			if(!erids.contains(rid)){
				Role role = roleDao.load(rid);
				userDao.addUserRole(user, role);
			}
		}
		
		for(Integer gid : groupIds){
			if(!egids.contains(gid)){
				Group group = groupDao.load(gid);
				userDao.addUserGroup(user, group);
			}
		}
		//3. delete relationship in UserRole table if eids not exist in rids;
		for(Integer rid: erids){
			if(!ArrayUtils.contains(rids, rid)){
				userDao.deleteUserRole(user.getId(), rid);
			}
		}
		
		for(Integer gid : egids){
			if(!ArrayUtils.contains(groupIds, gid)){
				userDao.deleteUserGroup(user.getId(), gid);
			}
		}
	}

	@Override
	public void updateStatus(int userId) {
		User user = userDao.load(userId);
		if(user==null) throw new CmsException("user not exist !");
		if(user.getStatus()==0) user.setStatus(1);
		else
			user.setStatus(0);
			userDao.update(user);
	}

	@Override
	public Pager<User> findUser() {
		return userDao.findUser();
	}

	@Override
	public User loadUser(int id) {
		// TODO Auto-generated method stub
		return userDao.load(id);
	}

	@Override
	public List<Role> listUserRoles(int userId) {
		// TODO Auto-generated method stub
		return userDao.listUserRoles(userId);
	}

	@Override
	public List<Group> listUserGroups(int userId) {
		// TODO Auto-generated method stub
		return userDao.listUserGroups(userId);
	}

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

	public IGroupDao getGroupDao() {
		return groupDao;
	}

	@Resource(name="groupDao")
	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}
	
	
}
