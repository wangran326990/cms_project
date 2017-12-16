/**
 * 
 */
package com.cms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cms.basic.model.Pager;
import com.cms.core.dao.IChannelDao;
import com.cms.core.dao.IGroupDao;
import com.cms.core.dao.IUserDao;
import com.cms.core.errors.CmsException;
import com.cms.core.model.Channel;
import com.cms.core.model.ChannelTree;
import com.cms.core.model.Group;
import com.cms.core.model.GroupChannel;
import com.cms.core.model.User;

/**
 * @author wr
 *
 */
@Service("groupService")
public class GroupService implements IGroupService {
	
	private IGroupDao groupDao;
	private IUserDao userDao;
	private IChannelDao channelDao;
	
	public IChannelDao getChannelDao() {
		return channelDao;
	}

	@Resource(name="channelDao")
	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
	}
	
	public IGroupDao getGroupDao() {
		return groupDao;
	}
	
	@Resource(name="groupDao")
	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource(name="userDao")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/* (non-Javadoc)
	 * @see com.cms.service.IGroupService#add(com.cms.core.model.Group)
	 */
	@Override
	public void add(Group group) {
		groupDao.add(group);
	}

	/* (non-Javadoc)
	 * @see com.cms.service.IGroupService#delete(int)
	 */
	@Override
	public void delete(int gid) {
		//check if group has users
		List<User> users = userDao.listUsersByGroup(gid);
		if(users!=null && users.size() >0) throw new CmsException("group contains users, cannot deleted");
		groupDao.delete(gid);
	}

	/* (non-Javadoc)
	 * @see com.cms.service.IGroupService#load(int)
	 */
	@Override
	public Group load(int gid) {
		return groupDao.load(gid);
	}

	/* (non-Javadoc)
	 * @see com.cms.service.IGroupService#update(com.cms.core.model.Group)
	 */
	@Override
	public void update(Group group) {
		groupDao.update(group);
	}

	/* (non-Javadoc)
	 * @see com.cms.service.IGroupService#listGroup()
	 */
	@Override
	public List<Group> listGroup() {
		return groupDao.listGroups();
	}

	/* (non-Javadoc)
	 * @see com.cms.service.IGroupService#findGroup()
	 */
	@Override
	public Pager<Group> findGroup() {
		return groupDao.findGroups();
	}

	@Override
	public void deleteGroupUsers(int gid) {
		groupDao.deleteUsersFromGroup(gid);
	}

	@Override
	public List<User> listGroupUsers(int gid) {
		List<User> users =userDao.listUsersByGroup(gid);
		return users;
	}

	@Override
	public void addGroupChannel(int gid, int cid) {
		Group group = groupDao.load(gid);
		Channel channel = channelDao.load(cid);
		if(group!=null && channel!=null)
			groupDao.addGroupChannel(group, channel);
		else 
			throw new CmsException("group or channel not exists "); 
	}

	@Override
	public GroupChannel loadGroupChannel(int gid, int cid) {
		
		return groupDao.loadGroupChannel(gid, cid);
	}

	@Override
	public List<Integer> listGroupChannelIds(int gid) {
		Group group  = groupDao.load(gid);
		if(group == null) throw new CmsException("group not exist");
		return groupDao.listGroupChannelIds(gid);
	}

	@Override
	public List<ChannelTree> generateGroupChannelTree(int gid) {
		Group group  = groupDao.load(gid);
		if(group == null) throw new CmsException("group not exist");
		return groupDao.generateGroupChannelTree(gid);
	}

	@Override
	public List<ChannelTree> generateUserChannelTree(int uid) {
		User user  = userDao.load(uid);
		if(user == null) throw new CmsException("user not exist");	
		return groupDao.generateUserChannelTree(uid);
	}

	@Override
	public void deleteGroupChannel(int gid, int cid) {
		groupDao.deleteGroupChannel(gid, cid);
	}

	@Override
	public void clearGroupChannels(int gid) {
		groupDao.clearGroupChannels(gid);
		
	}

	

}
