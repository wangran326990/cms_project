package com.cms.core.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.cms.core.model.User;
import com.cms.core.model.UserGroup;
import com.cms.core.model.UserRole;
import com.cms.basic.model.Pager;
import com.cms.basic.model.SystemContext;
import com.cms.core.model.Group;
import com.cms.core.model.Role;
import com.cms.core.model.RoleType;
import com.cms.core.test.util.AbstractDbUnitTestCase;
import com.cms.core.test.util.EntitiesHelper;

import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans-core.xml")
public class TestUserDao extends AbstractDbUnitTestCase{
	
	@Resource(name="roleDao")
	private IRoleDao roleDao;
	
	@Resource(name="userDao")
	private IUserDao userDao;
	
	@Resource(name="groupDao")
	private IGroupDao groupDao;
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Before
	public void setUp() throws DataSetException, SQLException, IOException{
		this.backupAllTable();
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));

		
	}
	
	@Test
	public void testListUserRole() throws DatabaseUnitException, SQLException {
		// TODO Auto-generated method stub
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		List<Role> actuals = Arrays.asList(new Role(2, "artical_publisher", RoleType.ROLE_PUBLISHER),
										   new Role(3, "artical_auditor", RoleType.ROLE_AUDIT));
		List<Role> roles = userDao.listUserRoles(2);
		EntitiesHelper.assertRoles(roles, actuals);
	
		
	}
	
	@Test
	public void testListRoleIds() throws DatabaseUnitException, SQLException{
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		List<Integer> actuals = Arrays.asList(2,3);
		List<Integer> expects = userDao.listUserRoleIds(2);
		EntitiesHelper.assertRoleIds(expects, actuals);
	}
	
	@Test
	public void testListUsersByRole() throws DatabaseUnitException, SQLException{
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		List<User> actuals = Arrays.asList(new User(2,"admin2","123","admin1","admin1@admin.com","110",1),
				   new User(3,"admin3","123","admin1","admin1@admin.com","110",1));
		List<User> expects = userDao.listUsersByRole(2);
		EntitiesHelper.assertUsers(expects, actuals);
	}

	@Test
	public void testListUserGroupIds() throws DatabaseUnitException, SQLException{
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		List<Integer> actuals = Arrays.asList(1,3);
		List<Integer> expected = userDao.listUserGroupIds(3);
		EntitiesHelper.assertObjects(expected, actuals);
	}
	
	@Test
	public void testListUserByGroup() throws DatabaseUnitException, SQLException{
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		List<User> actuals = Arrays.asList(new User(2,"admin2","123","admin1","admin1@admin.com","110",1),
				   new User(3,"admin3","123","admin1","admin1@admin.com","110",1)
				  );
		List<User>  expected = userDao.listUsersByGroup(3);
		EntitiesHelper.assertUsers(expected, actuals);
	}
	
	@Test
	public void testAddUserRole() throws DatabaseUnitException, SQLException{
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		Role role = roleDao.load(1);
		User user = userDao.load(1);
		userDao.addUserRole(user, role);
		UserRole ur = userDao.loadUserRole(user.getId(), role.getId());
		Assert.assertNotNull(ur);
		Assert.assertEquals(ur.getRole().getId(), 1);
		Assert.assertEquals(ur.getUser().getId(), 1);
	}
	
	@Test
	public void testAddUserGroup() throws DatabaseUnitException, SQLException{
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		Group group = groupDao.load(1);
		User user = userDao.load(1);
		userDao.addUserGroup(user, group);
		UserGroup ug = userDao.loadUserGroup(user.getId(), group.getId());
		Assert.assertNotNull(ug);
		Assert.assertEquals(ug.getGroup().getId(), 1);
		Assert.assertEquals(ug.getUser().getId(), 1);
	}
	
	@Test
	public void testLoadUserGroup() throws DatabaseUnitException, SQLException {
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		int uid =2;
		int gid=1;
		
		UserGroup ug = userDao.loadUserGroup(uid, gid);
		
		User au = new User(2,"admin2","123","admin1","admin1@admin.com","110",1);
		Group ag = new Group(1,"finance department","responsible for the finance parts of website");
		EntitiesHelper.assertUser(ug.getUser(), au);
		EntitiesHelper.assertGroup(ug.getGroup(), ag);
	}
	
	@Test 
	public void testLoadUserRole() throws DatabaseUnitException, SQLException{
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		int uid=2;
		int rid=3;
		
		UserRole ur = userDao.loadUserRole(uid, rid);
		User au = new User(2,"admin2","123","admin1","admin1@admin.com","110",1);
		Role ar = new Role(3, "artical_auditor", RoleType.ROLE_AUDIT);
		EntitiesHelper.assertUser(ur.getUser(), au);
		EntitiesHelper.assertRole(ur.getRole(), ar);
 		
	}
	
	@Test 
	public void testDeleteUserRoles() throws DatabaseUnitException, SQLException{
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		
		userDao.deleteUserRoles(2);
		List<Role> urs = userDao.listUserRoles(2);
		Assert.assertTrue(urs.size()<=0);
	}
	
	@Test 
	public void testDeleteUserGroups() throws DatabaseUnitException, SQLException{
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		
		userDao.deleteUserGroups(2);
		List<Group> ugs = userDao.listUserGroups(2);
		Assert.assertTrue(ugs.size()<=0);
	}
	
//	@Test
//	public void testFindUser() throws DatabaseUnitException, SQLException{
//		IDataSet ds = createDateSet("t_core");
//		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
//		SystemContext.setPageSize(3);
//		SystemContext.setPageOffset(0);
//		Pager<User> users =userDao.findUser();
//		List<User> expected = users.getDatas();
//		List<User> actual = Arrays.asList(new User(1,"admin1","123","admin1","admin1@admin.com","110",1), 
//				 						  new User(2,"admin2","123","admin1","admin1@admin.com","110",1),
//				 						  new User(3,"admin3","123","admin1","admin1@admin.com","110",1));
//		Assert.assertEquals(users.getOffset(), 0);
//		Assert.assertEquals(users.getSize(), 3);
//		Assert.assertEquals(users.getTotal(), 3);
//		EntitiesHelper.assertUsers(expected, actual);
//	}
	
	@Test
	public void testDeleteUserRole() throws DatabaseUnitException, SQLException{
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		userDao.deleteUserRole(1, 1);
		List<Role> urs = userDao.listUserRoles(1);
		Assert.assertTrue(urs.size()<=0);
		
	}
	
	@Test
	public void testDeleteUserGroup() throws DatabaseUnitException, SQLException{
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		userDao.deleteUserGroup(2, 1);
		List<Group> urs = userDao.listUserGroups(2);
		Assert.assertTrue(urs.size()==2);
		
	}
	@After
	public void tearDown() throws FileNotFoundException, DatabaseUnitException, SQLException {
		
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
		this.resumeTable();
	}
	
	
}
