package com.cms.core.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
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

import com.cms.basic.model.Pager;
import com.cms.basic.model.SystemContext;
import com.cms.core.model.Attachment;
import com.cms.core.test.util.AbstractDbUnitTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans-core.xml")
public class TestAttachment extends AbstractDbUnitTestCase{
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	@Resource(name="attachmentDao")
	private AttachmentDao attachmentDao;
	
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException{
		this.backupAllTable();
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
		IDataSet ds = createDateSet("topic");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
	
	}
	
	@Test
	public void testFindNoUsedAttachment() {
		Pager<Attachment> page = attachmentDao.findNoUsedAttachment();
		assertEquals(page.getTotal(), 2);

	}

	@Test
	public void testClearNoUsedAttachment() {
		attachmentDao.clearNoUsedAttachment();
		Pager<Attachment> page = attachmentDao.findNoUsedAttachment();
		assertEquals(page.getTotal(), 0);
	}

	@Test
	public void testDeleteByTopic() {
		attachmentDao.deleteByTopic(1);
		List<Attachment> attachments =attachmentDao.listByTopic(1);
		assertEquals(attachments.size(), 0);
	}

	@Test
	public void testListByTopic() {
		List<Attachment> attachments =attachmentDao.listByTopic(1);
		assertEquals(attachments.size(), 3);
	}

	@Test
	public void testListIndexPic() {
		int nums = 3;
		List<Attachment> attachments = attachmentDao.listIndexPic(nums);
		assertEquals(3, attachments.size());
	}

	@Test
	public void testFindChannelPic() {
		int cid =7;
		Pager<Attachment> attachments = attachmentDao.findChannelPic(cid);
		assertEquals(2, attachments.getTotal());
	}

	@Test
	public void testListAttachedByTopic() {
		int tid=1;
		List<Attachment> attachments = attachmentDao.listAttachedByTopic(tid);
		assertEquals(2, attachments.size());
	}
	
	@After
	public void tearDown() throws Exception {
		SystemContext.setOrder("asc");
		SystemContext.setSort("id");
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
		this.resumeTable();
	}

}
