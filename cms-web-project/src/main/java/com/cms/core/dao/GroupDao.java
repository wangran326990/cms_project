package com.cms.core.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.cms.basic.dao.BaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.Group;

@Repository("groupDao")
public class GroupDao extends BaseDao<Group> implements IGroupDao {

	@Override
	public List<Group> listGroups() {
		return this.list("from Group");
	}

	@Override
	public Pager<Group> findGroups() {
		return this.find("from Group");
	}

	@Override
	public void deleteUsersFromGroup(int gid) {
		this.updateByHql("delete UserGroup ug where ug.group.id=?", gid);
	}
	

}
