package com.cms.core.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.cms.core.model.CmsLink;
import com.cms.core.test.util.AbstractDbUnitTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans-core.xml")
public class TestCmsLinkDao extends AbstractDbUnitTestCase{

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Resource(name="cmsLinkDao")
	private ICmsLinkDao cmsLinkDao;
	
	
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException{
		this.backupAllTable();
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
		IDataSet ds = createDateSet("t_cms_link");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
	
	}
	
	@Test
	public void testDelete() {
		int id = 1;
		cmsLinkDao.delete(id);
		//List<CmsLink> cls = cmsLinkDao.listByType(null);
		//CmsLink cl =cmsLinkDao.get(id);
		//assertEquals(5, cls.size());
		List<CmsLink> cls = cmsLinkDao.list();
		//assertEquals(cls.size(), 5);
		
	}

	@Test
	public void testAddCmsLink() {
		CmsLink cl= new CmsLink();
		cl.setTitle("test link");
		cmsLinkDao.add(cl);
	//	CmsLink cl1 = cmsLinkDao.get(7);
		
	}

	@Test
	public void testFindByType() {
		Pager<CmsLink> cls = cmsLinkDao.findByType(null);
		assertEquals(cls.getTotal(), 6);
		Pager<CmsLink> cls1 = cmsLinkDao.findByType("type2");
		assertEquals(cls1.getTotal(), 2);
	}

	@Test
	public void testListByType() {
		String type ="type1";
		int[] ids={1,2,3};
		int[] result = new int[3];
		List<CmsLink> links = cmsLinkDao.listByType(type);
		List<Integer> results =links.stream().map(link->link.getId()).collect(Collectors.toList());
		for(int i=0; i<results.size(); i++){
			result[i] = results.get(i);
		}
		assertArrayEquals(result, ids);
		
	}

	@Test
	public void testListAllType() {
		
		System.out.println(cmsLinkDao.listAllType());
	}

	
	@Test
	public void testUpdatePos() {
		cmsLinkDao.updatePos(1, 1, 3);
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
