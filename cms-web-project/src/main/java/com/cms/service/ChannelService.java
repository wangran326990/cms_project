package com.cms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cms.basic.model.SystemContext;
import com.cms.core.dao.IChannelDao;
import com.cms.core.errors.CmsException;
import com.cms.core.model.Channel;
import com.cms.core.model.ChannelTree;

@Service("channelService")
public class ChannelService implements IChannelService {
	
	private IChannelDao channelDao;
	

	public IChannelDao getChannelDao() {
		return channelDao;
	}
	
	@Resource(name="channelDao")
	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
	}

	@Override
	public void add(Channel channel, Integer pid) {
		Integer orders = channelDao.getMaxOrderByParent(pid);
		if(pid !=null && pid>0){
			Channel pc = channelDao.load(pid);
			if(pc==null) throw new CmsException("parent channel cannot be load correctly !!");
			channel.setParentChannel(pc);
		}
		channel.setOrders(orders+1);
		channelDao.add(channel);
	}

	@Override
	public void update(Channel channel) {
		channelDao.update(channel);
	}

	@Override
	public void delete(int id) {
		//1. need to check if child channel exist
		
		List<Channel> cs = channelDao.listByParent(id);
		if(cs != null && cs.size()>0){
			throw new CmsException("Channel has child channel connot be deleted !!");
		}
		
		//2, need to check if artical exist
		//3, need to delete group channel relationship
		
		channelDao.delete(id);
	}

	@Override
	public void clearTopic(int id) {
		
	}

	@Override
	public Channel load(int id) {
		return channelDao.load(id);
	}

	@Override
	public List<Channel> listByParentId(Integer pid) {
		String sort = SystemContext.getSort();
		if(sort == null || "".equals(sort.trim())){
			//SystemContext.setSort("c.orders");
			SystemContext.setOrder("asc");
		}
		return channelDao.listByParent(pid);
	}

	@Override
	public List<ChannelTree> generateTree() {
		
		return channelDao.generateTree();
	}

	@Override
	public List<ChannelTree> generateTreeByParent(Integer pid) {
		return channelDao.generateTreeByParent(pid);
	}

	@Override
	public void updateSort(Integer[] ids) {
		channelDao.updateSort(ids);
	}

	@Override
	public List<Channel> listChannelsByStatus(int status) {
		return channelDao.listChannelsByStatus(status);
	}

	@Override
	public List<ChannelTree> generatePublishedChannelTree() {
		return channelDao.generatePublishedChannelTree();
	}

}
