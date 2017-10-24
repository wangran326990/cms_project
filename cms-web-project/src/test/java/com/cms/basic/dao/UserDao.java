package com.cms.basic.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cms.basic.model.Pager;
import com.cms.basic.model.User;

@Repository(value="userDao")
public class UserDao extends BaseDao<User> implements IUserDao{


	@Override
	public List<User> listUserBySql(String sql, Object[] args, Class<User> clz, boolean hasEntity) {
		return super.listBySql(sql,args, clz, hasEntity);
	}

	@Override
	public Pager<User> findUserBySql(String sql, Object[] args, Class<User> clz, boolean hasEntity) {
		return super.findBySql(sql, args, clz, hasEntity);
	}

	@Override
	public Pager<User> findUserBySql(String sql, Object[] args, Map<String, Object> alias, Class<User> clz,
			boolean hasEntity) {
		return super.findBySql(sql, args, alias, clz, hasEntity);
	}

	@Override
	public List<User> listUserBySql(String sql, Object[] args, Map<String, Object> alias, Class<User> clz,
			boolean hasEntity) {
		return super.listBySql(sql, args, alias, clz, hasEntity);
	}


	


}