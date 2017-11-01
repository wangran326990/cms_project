package com.cms.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cms.basic.dao.BaseDao;
import com.cms.core.model.Channel;

@Repository("channelDao")
public class ChannelDao extends BaseDao<Channel> implements IChannelDao {



	@Override
	public List<Channel> listByParent(Integer pid) {
		String hql = "select c from Channel c "
				   + "where c.parentChannel.id=" +pid;
		if(pid == null){
				hql = "select c from Channel c "
					+ "where c.parentChannel is null";
		}
		return this.list(hql);
	}

	@Override
	public int getMaxOrderByParent(Integer pid) {
		String hql = "select max(c.orders) from Channel c "
					+ "where c.parentChannel.id =" +pid;
		if(pid == null){
			hql = "select max(c.orders) from Channel c "
					+ "where c.parentChannel is null";
		}
		return (Integer)this.queryObject(hql);
	}

	
}
