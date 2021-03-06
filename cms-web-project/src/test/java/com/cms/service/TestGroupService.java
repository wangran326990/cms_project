package com.cms.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cms.core.dao.IGroupDao;
import com.cms.core.dao.IUserDao;
import com.cms.core.model.Group;
import com.cms.core.model.User;

import static org.easymock.EasyMock.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-beans.xml")
public class TestGroupService {
	@Resource(name="groupDao")
	private IGroupDao groupDao;
	@Resource(name="userDao")
	private IUserDao userDao;
	
	@Resource(name="groupService")
	private IGroupService groupService;
	
	@Test
	public void testAdd() {
		//fail("Not yet implemented");
		Group group = new Group(4, "testGroup", "test Group Description"); 
		reset(groupDao);
		
		expect(groupDao.add(group)).andReturn(group);
		replay(groupDao);
		groupService.add(group);
		verify(groupDao);
	}

	@Test
	public void testDelete() {
		reset(groupDao, userDao);
		List<User> users = Arrays.asList();
		int gid =1;
		expect(userDao.listUsersByGroup(gid)).andReturn(users);
		groupDao.delete(gid);
		expectLastCall();
		replay(groupDao, userDao);
		groupService.delete(gid);
		verify(groupDao, userDao);
	}

	@Test
	public void testLoad() {
		
		int gid =1;
		Group group = new Group(4, "testGroup", "test Group Description");
		reset(groupDao);
		expect(groupDao.load(gid)).andReturn(group);
		replay(groupDao);
		groupService.load(gid);
		verify(groupDao);
		
	}

	@Test
	public void testUpdate() {
		
		Group group = new Group(4, "testGroup", "test Group Description");
		reset(groupDao);
		groupDao.update(group);
		expectLastCall();
		replay(groupDao);
		groupService.update(group);
		verify(groupDao);
	}

	@Test
	public void testListGroup() {
		List<Group> groups = Arrays.asList(new Group(), new Group());
		reset(groupDao);
		expect(groupDao.listGroups()).andReturn(groups);
		replay(groupDao);
		groupService.listGroup();
		verify(groupDao);
	}


	@Test
	public void testDeleteGroupUsers() {
		int gid =1;
		reset(groupDao);
		groupDao.deleteUsersFromGroup(gid);
		expectLastCall();
		replay(groupDao);
		groupService.deleteGroupUsers(gid);
		verify(groupDao);
	}

}
