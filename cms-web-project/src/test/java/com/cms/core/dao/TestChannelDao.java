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
import com.cms.core.model.Channel;
import com.cms.core.model.ChannelTree;
import com.cms.core.model.ChannelType;
import com.cms.core.test.util.AbstractDbUnitTestCase;
import com.cms.core.test.util.EntitiesHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans-core.xml")
public class TestChannelDao extends AbstractDbUnitTestCase{
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Resource(name="channelDao")
	private IChannelDao channelDao;	
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException{
		this.backupAllTable();
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
		IDataSet ds = createDateSet("t_channel");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
	
	}

	@Test
	public void testListByParent() {
		int pid = 1;
		List<Channel> expected = channelDao.listByParent(pid);
		List<Channel> actuals = Arrays.asList(new Channel(2,"USER MANAGEMENT 1",0,"#",ChannelType.TOPIC_LIST,0,0,0,1,1,new Channel()),
											 new Channel(3,"USER MANAGEMENT 2",0,"#",ChannelType.TOPIC_CONTENT,0,0,0,1,2,new Channel()),
											 new Channel(4,"USER MANAGEMENT 3",0,"#",ChannelType.TOPIC_LIST,0,0,0,0,3,new Channel()),
											 new Channel(5,"USER MANAGEMENT 4",0,"#",ChannelType.TOPIC_CONTENT,0,0,0,1,4,new Channel()));
		EntitiesHelper.assertChannels(expected, actuals);
		
	}
	
	@Test
	public void testGetMaxOrderByParent(){
		Integer pid =1;
		Integer max = channelDao.getMaxOrderByParent(pid);
		assertEquals(max, new Integer(4));
		max = channelDao.getMaxOrderByParent(2);
		assertEquals(max, new Integer(0));
	}
	
	@Test
	public void testgenerateTree(){
		List<ChannelTree> tree = channelDao.generateTree();
		System.out.println(tree);
		
	}
	
	@Test
	public void testgenerateTreeByParentId(){
		List<ChannelTree> tree = channelDao.generateTreeByParent(1);
		System.out.println(tree);
	}
	
	@Test
	public void testUpdateSort(){
		Integer[] ids ={3,4,2,5};
		Integer[] orders={1,2,3,4};
		channelDao.updateSort(ids);
		for(int i=0; i<ids.length; i++){
			assertEquals(channelDao.load(ids[i]).getOrders(), orders[i].intValue());
		}
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
