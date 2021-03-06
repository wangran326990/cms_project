package com.cms.core.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

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
import com.cms.core.model.Keyword;
import com.cms.core.test.util.AbstractDbUnitTestCase;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans-core.xml")
public class TestKeywordDao extends AbstractDbUnitTestCase{
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Resource(name="keywordDao")
	private IKeywordDao keywordDao;
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException{
		this.backupAllTable();
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
		IDataSet ds = createDateSet("topic");
		DatabaseOperation.TRUNCATE_TABLE.execute(dbunitCon, ds);
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
	
	}
	@Test
	public void testListPrimaryKeyword() {
		List<Keyword> list =keywordDao.listPrimaryKeyword(8);
		assertEquals(list.size(), 3);
	}

	@Test
	public void testFindNoUseKeywords() {
		Pager<Keyword> keywords = keywordDao.findNoUseKeywords();
		assertEquals(keywords.getTotal(),3);
	}

	@Test
	public void testClearNoUseKeywords() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFindUsedKeywords() {
		List<Keyword> keywords = keywordDao.findUsedKeywords();
		//assertEquals(keywords.getTotal(),10);
		System.out.println(keywords);
	}
	
	@Test
	public void testAddOrUpdate_Update(){
		String name = "ab";
		keywordDao.addOrUpdate(name);
		Keyword kw = keywordDao.load(1);
		assertEquals(2, kw.getTimes());
	}
	
	@Test
	public void testAddOrUpdate_Add(){
		String name = "fjiwoejfiow";
		keywordDao.addOrUpdate(name);
		Keyword kw = keywordDao.load(11);
		assertNotNull(kw);
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
