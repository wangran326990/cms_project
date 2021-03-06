package com.cms.core.dao;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.dbunit.DatabaseUnitException;
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

import com.cms.basic.model.SystemContext;
import com.cms.core.model.Role;
import com.cms.core.model.RoleType;
import com.cms.core.model.User;
import com.cms.core.test.util.AbstractDbUnitTestCase;
import com.cms.core.test.util.EntitiesHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans-core.xml")
public class TestRoleDao extends AbstractDbUnitTestCase{

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Resource(name="roleDao")
	private IRoleDao roleDao;
	
	@Resource(name="userDao")
	private IUserDao userDao;
	
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException{
		this.backupAllTable();
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
		IDataSet ds = createDateSet("t_core");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
	
	}
	
	@Test
	public void testListRoles() {
		List<Role> actuals = roleDao.listRoles();
		List<Role> expected = Arrays.asList(new Role(1, "admin", RoleType.ROLE_ADMIN),
											new Role(2, "artical_publisher", RoleType.ROLE_PUBLISHER),
											new Role(3, "artical_auditor", RoleType.ROLE_AUDIT));
		EntitiesHelper.assertRoles(expected, actuals);
	}

	@Test
	public void testDeleteRoleUsers() {
		int rid = 2;
		roleDao.deleteRoleUsers(rid);
		List<User> user = userDao.listUsersByRole(rid);
		assertEquals(user.size(), 0);
	}
	
	@After
	public void tearDown() throws DatabaseUnitException, SQLException, IOException {
		SystemContext.setOrder("asc");
		SystemContext.setSort("id");
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
		this.resumeTable();
	}
}
