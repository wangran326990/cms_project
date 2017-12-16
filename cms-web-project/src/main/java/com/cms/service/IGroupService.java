package com.cms.service;

import java.util.List;

import com.cms.basic.model.Pager;
import com.cms.core.model.Channel;
import com.cms.core.model.ChannelTree;
import com.cms.core.model.Group;
import com.cms.core.model.GroupChannel;
import com.cms.core.model.User;

public interface IGroupService {
	
	public void add(Group group);
	 
	public void delete(int id);
	
	public Group load(int id);
	
	public void update(Group group);
	
	public List<Group> listGroup();
	
	public Pager<Group> findGroup();
	
	public void deleteGroupUsers(int gid);
	
	public List<User> listGroupUsers(int gid);
	
	
	public 	void addGroupChannel(int gid, int cid);
	
	public GroupChannel loadGroupChannel(int gid, int cid);
	
	/**
	 * get a group's channel id
	 * @param gid
	 * @return
	 */
	public List<Integer> listGroupChannelIds(int gid);
	
	/**
	 * get a group's channel tree
	 * @param gid
	 * @return
	 */
	public List<ChannelTree> generateGroupChannelTree(int gid);
	
	/**
	 * get a user's channel tree
	 * @param uid
	 * @return
	 */
	
	public List<ChannelTree> generateUserChannelTree(int uid);
	
	
	/**
	 * delete user channel
	 * @param gid
	 * @param cid
	 */
	public void deleteGroupChannel(int gid, int cid);
	
	/**
	 * delete all channels in a group
	 * @param gid
	 */
	public void clearGroupChannels(int gid);
}
