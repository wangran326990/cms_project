package com.cms.core.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.cms.basic.dao.BaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.Channel;
import com.cms.core.model.ChannelTree;
import com.cms.core.model.Group;
import com.cms.core.model.GroupChannel;

@Repository("groupDao")
public class GroupDao extends BaseDao<Group> implements IGroupDao {

	@Override
	public List<Group> listGroups() {
		return this.list("from Group");
	}

	@Override
	public Pager<Group> findGroups() {
		return this.find("from Group");
	}

	@Override
	public void deleteUsersFromGroup(int gid) {
		this.updateByHql("delete UserGroup ug where ug.group.id=?", gid);
	}

	@Override
	public void addGroupChannel(Group group, Channel channel) {
		GroupChannel gc = this.loadGroupChannel(group.getId(), channel.getId());
		if(gc!=null) return;
		gc = new GroupChannel();
		gc.setGroup(group);
		gc.setChannel(channel);
		this.getSession().save(gc);
		
	}

	@Override
	public GroupChannel loadGroupChannel(int gid, int cid) {
		// TODO Auto-generated method stub
		String hql = "from GroupChannel gc where gc.group.id=? and gc.channel.id=?";
		Object[] args = {gid,cid};
		return (GroupChannel) this.queryObject(hql, args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> listGroupChannelIds(int gid) {
		String hql = "select gc.channel.id from GroupChannel gc where gc.group.id=?";
		return this.getSession().createQuery(hql).setParameter(0, gid).list();
	}

	@Override
	public List<ChannelTree> generateGroupChannelTree(int gid) {
		String sql = "select c.id as id , c.name as name, c.pid as pid from t_channel c"
					+ " join t_group_channel gc on gc.c_id = c.id"
					+ " where gc.g_id = ?";
		
		List<ChannelTree> cts = this.listBySql(sql,gid, ChannelTree.class, false);
		ChannelDao.initTreeNode(cts);
		return cts;
	}

	@Override
	public List<ChannelTree> generateUserChannelTree(int uid) {
		String sql = "select distinct c.id as id , c.name as name, c.pid as pid from t_channel c"
					+ " left join t_group_channel gc on gc.c_id = c.id"
					+ " left join t_user_group ug on ug.g_id = gc.g_id"
					+ " where ug.u_id = ?";
		Object arg = uid;
		
		List<ChannelTree> cts = this.listBySql(sql,arg, ChannelTree.class, false);
		ChannelDao.initTreeNode(cts);
		return cts;
	}

	@Override
	public void deleteGroupChannel(int gid, int cid) {
		Object[] args ={gid, cid};
		this.updateByHql("delete GroupChannel gc where gc.group.id=? and gc.channel.id=?",args);
	}

	@Override
	public void clearGroupChannels(int gid) {
		Object arg =gid;
		this.updateByHql("delete GroupChannel gc where gc.group.id=?", arg);
		
	}
	
	

}
