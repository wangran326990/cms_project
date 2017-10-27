package com.cms.service;

import java.util.List;

import com.cms.basic.model.Pager;
import com.cms.core.model.Group;
import com.cms.core.model.User;

public interface IGroupService {
	
	public void add(Group group);
	 
	public void delete(int id);
	
	public Group load(int id);
	
	public void update(Group group);
	
	public List<Group> listGroup();
	
	public Pager<Group> findGroup();
	
	public void deleteGroupUsers(int gid);
	
	public List<User> listGroupUsers(int gid);
}
