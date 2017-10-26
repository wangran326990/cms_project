package com.cms.core.dao;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

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

import com.cms.core.test.util.EntitiesHelper;
import com.cms.basic.model.Pager;
import com.cms.core.model.Group;
import com.cms.core.model.User;
import com.cms.core.test.util.AbstractDbUnitTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans-core.xml")
public class TestGroupDao extends AbstractDbUnitTestCase{

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Resource(name="groupDao")
	private IGroupDao groupDao;
	
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
	public void testListGroups() {
		List<Group> actuals = groupDao.listGroups();
		List<Group> expected = Arrays.asList(new Group(1, "finance department", "responsible for the finance parts of website"),
										   new Group(2, "technical department", "responsible for the technical parts of website"),
										   new Group(3, "publicity department", "responsible for the publicity parts of website"));
		EntitiesHelper.assertGroups(expected, actuals);
	}

	@Test
	public void testFindGroups() {
		Pager<Group> actuals = groupDao.findGroups();
		Pager<Group> expected = new Pager<>();
		List<Group> datas = Arrays.asList(new Group(1, "finance department", "responsible for the finance parts of website"),
				   new Group(2, "technical department", "responsible for the technical parts of website"),
				   new Group(3, "publicity department", "responsible for the publicity parts of website"));
		expected.setDatas(datas);
		expected.setOffset(0);
		expected.setSize(15);
		expected.setTotal(3);
		assertEquals(expected.getOffset(), actuals.getOffset());
		assertEquals(expected.getSize(), actuals.getSize());
		assertEquals(expected.getTotal(), actuals.getTotal());
		EntitiesHelper.assertGroups(expected.getDatas(), actuals.getDatas());
	}

	@Test
	public void testDeleteUsersFromGroup() {
		int gid = 3;
		int actualUserSize =0;
		groupDao.deleteUsersFromGroup(gid);
		List<User> eu= userDao.listUsersByGroup(gid);
		assertEquals(eu.size(), actualUserSize);
		
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
