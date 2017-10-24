package com.cms.core.dao;

import java.util.List;

import com.cms.basic.dao.IBaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.Group;

public interface IGroupDao extends IBaseDao<Group> {
		public List<Group> listGroups();
		public Pager<Group> findGroups();
		
}
