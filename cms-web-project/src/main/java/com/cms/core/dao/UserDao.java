package com.cms.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cms.basic.dao.BaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.Group;
import com.cms.core.model.Role;
import com.cms.core.model.RoleType;
import com.cms.core.model.User;
import com.cms.core.model.UserGroup;
import com.cms.core.model.UserRole;
@SuppressWarnings("unchecked")
@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

	
	@Override
	public List<Role> listUserRoles(int userId) {
		String hql = "select ur.role from UserRole ur "
					+ "where ur.user.id=?";
		
		return this.getSession().createQuery(hql).setParameter(0,userId).list();
	}

	@Override
	public List<Integer> listUserRoleIds(int userId) {
		String hql = "select ur.role.id from UserRole ur "
					+ "where ur.user.id=?";
		return this.getSession().createQuery(hql).setParameter(0, userId).list();
	}

	@Override
	public List<Group> listUserGroups(int userId) {
		// TODO Auto-generated method stub
		String hql ="select ug.group from UserGroup ug "
					+ "where ug.user.id=?";
		return this.getSession().createQuery(hql).setParameter(0, userId).list();
	}

	@Override
	public List<Integer> listUserGroupIds(int userId) {
		// TODO Auto-generated method stub
		String hql = "select ug.group.id from UserGroup ug "
					+ "where ug.user.id=?";
		return this.getSession().createQuery(hql).setParameter(0, userId).list();
	}

	@Override
	public UserRole loadUserRole(int userId, int roleId) {
		// TODO Auto-generated method stub
		String hql="from UserRole ur "
				+ "left join fetch ur.user u left join fetch ur.role r "
				+ "where ur.user.id=? and ur.role.id=?";
		return (UserRole) this.getSession().createQuery(hql)
				.setParameter(0, userId)
				.setParameter(1, roleId)
				.uniqueResult();
	}

	@Override
	public UserGroup loadUserGroup(int userId, int groupId) {
		/*
		 * one hql only get UserGroup not get User and Group.
		 */
		//String hql="from UserGroup ug "
		//		+ "where ug.user.id=? and ug.group.id=?";
		
		/*
		 * one hql get UserGroup User and Group.
		 */
		
		String hql="from UserGroup ug "
				+ "left join fetch ug.user u left join fetch ug.group g "
				+ "where u.id=? and g.id=?";
		return (UserGroup) this.getSession().createQuery(hql)
				.setParameter(0, userId)
				.setParameter(1, groupId)
				.uniqueResult();
	}

	@Override
	public User loadByUsername(String username) {
		// TODO Auto-generated method stub
		String hql = "from User u "
					+ "where u.username=?";
		
		return (User) this.getSession().createQuery(hql)
				.setParameter(0, username).uniqueResult();
	}

	@Override
	public List<User> listUsersByRole(int roleId) {
		// TODO Auto-generated method stub
		String hql = "select ur.user from UserRole ur "
					+ "where ur.role.id = ?";
		
		return this.getSession().createQuery(hql)
			   .setParameter(0, roleId).list();
	}

	@Override
	public List<User> listUsersByRole(RoleType roleType) {
		String hql = "select ur.user from UserRole ur "
					+ "where ur.role.roleSn = ?";
	
	return this.getSession().createQuery(hql)
		   .setParameter(0, roleType).list();
	}

	@Override
	public List<User> listUsersByGroup(int groupId) {
		String hql="select ug.user from UserGroup ug "
				+ "where ug.group.id=?";
		return  this.getSession().createQuery(hql)
				.setParameter(0, groupId).list();
	}

	@Override
	public List<User> listUserBySql(String sql, Object[] args, Class<User> clz, boolean hasEntity) {
		// TODO Auto-generated method stub
		return super.listBySql(sql,args, clz, hasEntity);
	}

	@Override
	public Pager<User> findUserBySql(String sql, Object[] args, Class<User> clz, boolean hasEntity) {
		// TODO Auto-generated method stub
		return super.findBySql(sql, args, clz, hasEntity);
	}

	@Override
	public Pager<User> findUserBySql(String sql, Object[] args, Map<String, Object> alias, Class<User> clz,
			boolean hasEntity) {
		// TODO Auto-generated method stub
		return super.findBySql(sql, args, alias, clz, hasEntity);
	}

	@Override
	public List<User> listUserBySql(String sql, Object[] args, Map<String, Object> alias, Class<User> clz,
			boolean hasEntity) {
		// TODO Auto-generated method stub
		return super.listBySql(sql, args, alias, clz, hasEntity);
	}

	@Override
	public void addUserRole(User user, Role role) {
	
		UserRole ur = this.loadUserRole(user.getId(), role.getId());
		if(ur !=null){
			return;
		}
		ur = new UserRole();
		ur.setRole(role);
		ur.setUser(user);
		this.getSession().save(ur);
	}

	@Override
	public void addUserGroup(User user, Group group) {
		UserGroup ug = this.loadUserGroup(user.getId(), group.getId());
		if(ug !=null){
			return;
		}
		ug = new UserGroup();
		ug.setUser(user);
		ug.setGroup(group);
		this.getSession().save(ug);
	}

	@Override
	public void deleteUserRoles(int userId) {
		// TODO Auto-generated method stub
		String hql="delete UserRole ur where ur.user.id=?";
		this.updateByHql(hql, userId);
	}

	@Override
	public void deleteUserGroups(int userId) {
		// TODO Auto-generated method stub
		String hql="delete UserGroup ug where ug.user.id=?";
		this.updateByHql(hql, userId);
	}

	@Override
	public Pager<User> findUser() {
		// TODO Auto-generated method stub
		return this.find("from User");
	}

	@Override
	public void deleteUserRole(int userId, int roleId) {
		// TODO Auto-generated method stub
		String hql = "delete UserRole ur where ur.user.id=? and ur.role.id=?";
		this.updateByHql(hql, new Object[]{userId,roleId});
	}

	@Override
	public void deleteUserGroup(int userId, int groupId) {
		String hql="delete UserGroup ug where ug.user.id=? and ug.group.id=?";
		this.updateByHql(hql, new Object[]{userId, groupId});
	}

	/*
	@Override
	public void deleteUserRole(User user, Role role) {
		// TODO Auto-generated method stub
		UserRole ur = this.loadUserRole(user.getId(), role.getId());
		if(ur==null) return;
		
		this.getSession().delete(ur);
	}

	@Override
	public void deleteUserGroup(User user, Group group) {
		
		UserGroup ug = this.loadUserGroup(user.getId(), group.getId());
		if(ug==null) return;
		this.getSession().delete(ug);
	}
	*/ 
	

}
