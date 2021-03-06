package com.cms.core.dao;

import java.util.List;

import com.cms.basic.dao.IBaseDao;
import com.cms.core.model.Channel;
import com.cms.core.model.ChannelTree;

public interface IChannelDao extends IBaseDao<Channel> {
	/**
	 * list child channel by parent id
	 * @param pid
	 * @return
	 */
	public List<Channel> listByParent(Integer pid);
	
	public int getMaxOrderByParent(Integer pid);
	
	/**
	 * generate tree by all the channel and artical
	 * 
	 * @return
	 */
	public List<ChannelTree> generateTree();
	
	public List<ChannelTree> generateTreeByParent(Integer pid);
	
	public void updateSort(Integer[] ids);
	
	public List<Channel> listChannelsByStatus(int status);
	
	public List<ChannelTree> generatePublishedChannelTree();
}
