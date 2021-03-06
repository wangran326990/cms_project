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
import com.cms.basic.model.SystemContext;
import com.cms.core.model.Channel;
import com.cms.core.model.ChannelTree;
import com.cms.core.model.ChannelType;
import com.cms.core.model.Group;
import com.cms.core.model.GroupChannel;
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
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(15);
		List<Group> datas = Arrays.asList(new Group(1, "finance department", "responsible for the finance parts of website"),
				   new Group(2, "technical department", "responsible for the technical parts of website"),
				   new Group(3, "publicity department", "responsible for the publicity parts of website"));
		Pager<Group> actuals = groupDao.findGroups();
		assertNotNull(actuals);
		assertEquals(actuals.getTotal(), 3);
		EntitiesHelper.assertGroups(datas, actuals.getDatas());
	}

	@Test
	public void testDeleteUsersFromGroup() {
		int gid = 3;
		int actualUserSize =0;
		groupDao.deleteUsersFromGroup(gid);
		List<User> eu= userDao.listUsersByGroup(gid);
		assertEquals(eu.size(), actualUserSize);
		
	}
	
	@Test
	public void testloadGroupChannel(){
		int gid =1;
		int cid =1;
		Group group = new Group(1, "finance department", "responsible for the finance parts of website");
		Channel channel = new Channel(1, "user management module", 0, "#", ChannelType.NAV_CHANNEL, 0, 0, 0, 0, 1, new Channel());
		GroupChannel expectGC = new GroupChannel(1,group,channel);
		
		GroupChannel actualsGC = groupDao.loadGroupChannel(gid, cid);
		
		EntitiesHelper.assertGroupChannel(expectGC, actualsGC);
	}
	
	@Test
	public void testlistGroupChannelIds(){
		int gid =3;
		List<Integer> ecids = Arrays.asList(new Integer(7), new Integer(6));
		List<Integer> acids = groupDao.listGroupChannelIds(gid);
		for(int i=0; i<ecids.size();i++){
			assertEquals(ecids.get(i).intValue(), acids.get(i).intValue());
		}
	}
	
	@Test
	public void testgenerateGroupChannelTree(){
		int gid = 3;
		List<ChannelTree> tree = groupDao.generateGroupChannelTree(gid);
		System.out.println(tree);
	}
	
	@Test
	public void testgenerateUserChannelTree(){
		int uid =2;
		List<ChannelTree> tree = groupDao.generateUserChannelTree(uid);
		System.out.println(tree);
		System.out.println(tree.size());
	}
	
//	@Test
//	public void testdeleteGroupChannel(){
//		int gid = 1;
//		int cid =1;
//		groupDao.deleteGroupChannel(gid, cid);
//		GroupChannel gcactuals = groupDao.loadGroupChannel(gid, cid);
//		assertNull(gcactuals);
//	}
//	
//	@Test 
//	public void testclearGroupChannels(){
//		int gid =3;
//		groupDao.clearGroupChannels(gid);
//		List<Integer> ids = groupDao.listGroupChannelIds(gid);
//		assertEquals(ids.size(), 0);
//	}
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
