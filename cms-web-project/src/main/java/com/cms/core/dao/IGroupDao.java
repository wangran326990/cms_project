package com.cms.core.dao;

import java.util.List;

import com.cms.basic.dao.IBaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.Channel;
import com.cms.core.model.ChannelTree;
import com.cms.core.model.Group;
import com.cms.core.model.GroupChannel;

public interface IGroupDao extends IBaseDao<Group> {
		public List<Group> listGroups();
		public Pager<Group> findGroups();
		public void deleteUsersFromGroup(int gid);
		
		public 	void addGroupChannel(Group group, Channel channel);
		
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
