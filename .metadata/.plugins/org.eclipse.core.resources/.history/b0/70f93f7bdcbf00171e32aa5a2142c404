package com.cms.core.dao;

import java.util.List;

import com.cms.basic.dao.IBaseDao;
import com.cms.core.model.Channel;

public interface IChannelDao extends IBaseDao<Channel> {
	/**
	 * list child channel by parent id
	 * @param pid
	 * @return
	 */
	public List<Channel> listByParent(Integer pid);
	
	public int getMaxOrderByParent(Integer pid);
}
