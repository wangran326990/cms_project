package com.cms.service;

import java.util.List;

import com.cms.core.model.Channel;
import com.cms.core.model.ChannelTree;

public interface IChannelService {
	/**
	 * add a channel
	 * @param channel
	 * @param pid
	 */
	
	public void add(Channel channel, Integer pid);
	
	public void update(Channel channel);
	
	public void delete(int id);
	
	public void clearTopic(int id);
	
	public Channel load(int id);
	
	/**
	 * Load Channel by parent id
	 * @param pid
	 * @return
	 */
	public List<Channel> listByParentId (Integer pid);
	
	public List<ChannelTree> generateTree();
	
	public List<ChannelTree> generateTreeByParent(Integer pid);
}
