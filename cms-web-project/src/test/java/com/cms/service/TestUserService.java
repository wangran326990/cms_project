package com.cms.service;

import javax.annotation.Resource;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cms.basic.model.Pager;
import com.cms.core.dao.IGroupDao;
import com.cms.core.dao.IRoleDao;
import com.cms.core.dao.IUserDao;
import com.cms.core.model.Group;
import com.cms.core.model.Role;
import com.cms.core.model.RoleType;
import com.cms.core.model.User;

import junit.framework.Assert;

//easy mock

import static org.easymock.EasyMock.*;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans.xml")
public class TestUserService {
	
		@Resource(name="userService")
		private IUserService userService;
		
		@Resource(name="roleDao")
		private IRoleDao roleDao;
		
		@Resource(name="userDao")
		private IUserDao userDao;
		
		@Resource(name="groupDao")
		private IGroupDao groupDao;
		
		private User baseUser= new User(2, "admin2", "123", "admin1", "admin1@admin.com", "110", 0);
		
		@Test
		public void testDelete(){
			reset(userDao);
			int uid = 2;
			userDao.deleteUserGroups(uid);
			expectLastCall();
			userDao.deleteUserRoles(uid);
			expectLastCall();
			userDao.delete(uid);
			expectLastCall();
			replay(userDao);
			userService.delete(uid);
			verify(userDao);
		}
		
		@Test
		public void testUpdateStatus(){
			reset(userDao);
			int uid =2;
			User user = new User(2, "admin2", "123", "admin1", "admin1@admin.com", "110", 0);
			expect(userDao.load(uid)).andReturn(user);
			//userDao.update(user);
			user.setStatus(0);
			expectLastCall();
			replay(userDao);
			userService.updateStatus(uid);
			//Assert.assertEquals(user.getStatus(), 1);
			verify(userDao);
		}
		
		@Test(expected=com.cms.core.errors.CmsException.class)
		public void testUpdateStatusFail(){
			reset(userDao);
			int uid =2;
			User user = new User(2, "admin2", "123", "admin1", "admin1@admin.com", "110", 0);
			expect(userDao.load(uid)).andReturn(null);
			userDao.update(user);
			expectLastCall();
			replay(userDao);
			userService.updateStatus(uid);
			//Assert.assertEquals(user.getStatus(), 1);
			verify(userDao);
		}
		
		@Test
		public void testfindUser(){
			reset(userDao);
		
			expect(userDao.findUser()).andReturn(new Pager<User>());
			replay(userDao);
			userService.findUser();
			verify(userDao);
		}
		
		@Test(expected=com.cms.core.errors.CmsException.class)
		public void testAddUserExist(){
			reset(userDao, roleDao, groupDao);
			User eu = new User(2, "admin2", "123", "admin1", "admin1@admin.com", "110", 0);
			Integer[] rids = {1,2};
			Integer[] gids={2,3};
			expect(userDao.loadByUsername(baseUser.getUsername())).andReturn(eu);
			
			replay(userDao, roleDao, groupDao);
			userService.add(baseUser, rids, gids);
			verify(userDao, roleDao, groupDao);
		}
		
		@Test
		public void testAddUserSuccess(){
			reset(userDao, roleDao, groupDao);
			User eu = new User(2, "admin2", "123", "admin1", "admin1@admin.com", "110", 0);
			Role role = new Role(1,"admin",RoleType.ROLE_ADMIN);
			Group group = new Group(2,"responsible for the technical parts of website","technical department");
			Integer[] rids = {1,2};
			Integer[] gids={2,3};
			expect(userDao.loadByUsername(baseUser.getUsername())).andReturn(null);
			expect(userDao.add(baseUser)).andReturn(eu);
			//add first role;
			expect(roleDao.load(rids[0])).andReturn(role);
			userDao.addUserRole(baseUser, role);
			expectLastCall();
			
			//add second role;
			expect(roleDao.load(rids[1])).andReturn(role);
			userDao.addUserRole(baseUser, role);
			expectLastCall();
			
			//add first group 
			expect(groupDao.load(gids[0])).andReturn(group);
			userDao.addUserGroup(baseUser, group);
			expectLastCall();
			
			//add second group
			expect(groupDao.load(gids[1])).andReturn(group);
			userDao.addUserGroup(baseUser, group);
			expectLastCall();
			
			replay(userDao, roleDao, groupDao);
			userService.add(baseUser, rids, gids);
			verify(userDao, roleDao, groupDao);
		}
		
		@Test(expected=com.cms.core.errors.CmsException.class)
		public void testAddUserNoRole(){
			reset(userDao, roleDao, groupDao);
			Role role = new Role(1,"admin",RoleType.ROLE_ADMIN);
			Group group = new Group(2,"responsible for the technical parts of website","technical department");
			Integer[] rids = {1,2,5,6};
			Integer[] gids = {2,3,4};
			expect(userDao.loadByUsername("admin2")).andReturn(null);
			//add role
			expect(userDao.add(baseUser)).andReturn(baseUser);
			
			//dynamic add roles
			expect(roleDao.load(EasyMock.gt(0))).andReturn(null).times(4);
			userDao.addUserRole(baseUser, role);
			expectLastCall().times(4);
			
			//dynamic add groups
			expect(groupDao.load(EasyMock.gt(0))).andReturn(group).times(3);
			userDao.addUserGroup(baseUser, group);
			expectLastCall().times(3);
			
			replay(userDao, roleDao, groupDao);
			userService.add(baseUser, rids, gids);
			verify(userDao,roleDao,groupDao);
		}
		
		@Test(expected=com.cms.core.errors.CmsException.class)
		public void testAddUserNoGroup(){
			reset(userDao, roleDao, groupDao);
			Role role = new Role(1,"admin",RoleType.ROLE_ADMIN);
			Group group = new Group(2,"responsible for the technical parts of website","technical department");
			Integer[] rids = {1,2,5,6};
			Integer[] gids = {2,3,4};
			expect(userDao.loadByUsername("admin2")).andReturn(null);
			//add role
			expect(userDao.add(baseUser)).andReturn(baseUser);
			
			//dynamic add roles
			expect(roleDao.load(EasyMock.gt(0))).andReturn(role).times(4);
			userDao.addUserRole(baseUser, role);
			expectLastCall().times(4);
			
			//dynamic add groups
			expect(groupDao.load(EasyMock.gt(0))).andReturn(null).times(3);
			userDao.addUserGroup(baseUser, group);
			expectLastCall().times(3);
			
			replay(userDao, roleDao, groupDao);
			userService.add(baseUser, rids, gids);
			verify(userDao,roleDao,groupDao);
		}
		
		@Test
		public void testUpdateUserDelete(){
			reset(userDao, roleDao, groupDao);
			List<Integer> erids = Arrays.asList(new Integer(1),new Integer(2),new Integer(3));
			List<Integer> egids = Arrays.asList(new Integer(1),new Integer(2),new Integer(3));
			
			Integer[] nids = {1,2};
			
			// dummy role and group data
			Role role = new Role(1,"admin",RoleType.ROLE_ADMIN);
			Group group = new Group(2,"responsible for the technical parts of website","technical department");
			expect(userDao.listUserRoleIds(baseUser.getId())).andReturn(erids);
			expect(userDao.listUserGroupIds(baseUser.getId())).andReturn(egids);
			
			//load roles and add User Role relationships
//			expect(roleDao.)).andReturn(role).times(3);
//			userDao.addUserRole(baseUser, role);
//			expectLastCall().times(3);
			
			//load groups and add User Group relationships
//			expect(groupDao.load(EasyMock.gt(0))).andReturn(group).times(3);
			

			//delete User Role relationships
			userDao.deleteUserRole(baseUser.getId(), 3);
			expectLastCall();
			
			
			//delete role user relationship
			userDao.deleteUserGroup(baseUser.getId(), 3);
			expectLastCall();
			
			replay(userDao, roleDao, groupDao);
			userService.update(baseUser, nids, nids);
			verify(userDao,roleDao,groupDao);
		}
		
		@Test
		public void testUpdateUserAdd(){
			reset(userDao, roleDao, groupDao);
			List<Integer> erids = Arrays.asList(new Integer(1),new Integer(2));
			List<Integer> egids = Arrays.asList(new Integer(1),new Integer(2));
			
			Integer[] nids = {1,2,3};
			
			// dummy role and group data
			Role role = new Role(1,"admin",RoleType.ROLE_ADMIN);
			Group group = new Group(2,"responsible for the technical parts of website","technical department");
			expect(userDao.listUserRoleIds(baseUser.getId())).andReturn(erids);
			expect(userDao.listUserGroupIds(baseUser.getId())).andReturn(egids);
			
			//load roles and add User Role relationships
			expect(roleDao.load(3)).andReturn(role);
			userDao.addUserRole(baseUser, role);
			expectLastCall();
			
			//load groups and add User Group relationships
			expect(groupDao.load(3)).andReturn(group);
			userDao.addUserGroup(baseUser, group);
			expectLastCall();
			

			//delete User Role relationships
//			userDao.deleteUserRole(baseUser.getId(), 3);
//			expectLastCall();
			
			
			//delete role user relationship
//			userDao.deleteUserGroup(baseUser.getId(), 3);
//			expectLastCall();
			
			replay(userDao, roleDao, groupDao);
			userService.update(baseUser, nids, nids);
			verify(userDao,roleDao,groupDao);
		}
		
}
