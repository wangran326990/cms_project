package com.cms.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cms.basic.dao.BaseDao;
import com.cms.core.model.Role;
@Repository("roleDao")
public class RoleDao extends BaseDao<Role> implements IRoleDao {

	@Override
	public List<Role> listRoles() {
		return this.list("from Role");
	}
	
}
