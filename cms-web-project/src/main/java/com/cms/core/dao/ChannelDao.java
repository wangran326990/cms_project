package com.cms.core.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.stereotype.Repository;

import com.cms.basic.dao.BaseDao;
import com.cms.core.model.Channel;
import com.cms.core.model.ChannelTree;
import com.cms.core.model.ChannelType;

@Repository("channelDao")
public class ChannelDao extends BaseDao<Channel> implements IChannelDao {


	public static void initTreeNode(List<ChannelTree> cts){
		cts.add(0, new ChannelTree(Channel.ROOT_ID, Channel.ROOT_NAME,-1));
		for(ChannelTree node : cts){
			if(node.getPid() == null){
				node.setPid(0);
			}
		}
		
	}
	
	@Override
	public List<Channel> listByParent(Integer pid) {
		String hql = "select c from Channel c left join fetch c.parentChannel cp "
				   + "where cp.id=" +pid+" order by c.orders";
		if(pid == null || pid==0){
				hql = "select c from Channel c "
					+ "where c.parentChannel is null"+" order by c.orders";
		}
		return this.list(hql);
	}

	@Override
	public int getMaxOrderByParent(Integer pid) {
		String hql = "select max(c.orders) from Channel c "
					+ "where c.parentChannel.id =" +pid;
		if(pid == null || pid==0){
			hql = "select max(c.orders) from Channel c "
					+ "where c.parentChannel is null";
		}
		Object obj = this.queryObject(hql);
		if(obj ==null )return 0;
		return (Integer)obj;
	}

	@Override
	public List<ChannelTree> generateTree() {
		String sql = "select id, name, pid from t_channel order by orders";
		List<ChannelTree> cts = this.listBySql(sql, ChannelTree.class, false);
		cts.add(0, new ChannelTree(Channel.ROOT_ID, Channel.ROOT_NAME,-1));
		for(ChannelTree node : cts){
			if(node.getPid() == null){
				node.setPid(0);
			}
		}
		return cts;
	}

	@Override
	public List<ChannelTree> generateTreeByParent(Integer pid) {
		if(pid==null || pid==0){
			String sql = "select id, name, pid from t_channel "
					+ "where pid is null order by orders";
			List<ChannelTree> cts = this.listBySql(sql, ChannelTree.class, false);
			return cts;
		}else{
			String sql = "select id, name, pid from t_channel "
					+ "where pid=? order by orders";
			List<ChannelTree> cts = this.listBySql(sql, pid, ChannelTree.class, false);
			return cts;
		}
		
	}

	@Override
	public void updateSort(Integer[] ids) {
		for(int i=0; i<ids.length;i++){
			this.load(ids[i]).setOrders(i+1);	
		}
	}

	@Override
	public List<Channel> listChannelsByStatus(int status) {
		String hql = "select new Channel(c.id, c.name) from Channel c where c.status = ? and c.type!=" +ChannelType.NAV_CHANNEL.ordinal();
		if(status==-1){
			hql ="select new Channel(c.id, c.name) from Channel c where c.type!=" +ChannelType.NAV_CHANNEL.ordinal();
		}
		return (status==-1)?this.list(hql):this.list(hql, status);
	}

	@Override
	public List<ChannelTree> generatePublishedChannelTree() {
		String sql = "select id, name, pid from t_channel where status=1 order by orders";
		List<ChannelTree> cts = this.listBySql(sql, ChannelTree.class, false);
		cts.add(0, new ChannelTree(Channel.ROOT_ID, Channel.ROOT_NAME,-1));
		for(ChannelTree node : cts){
			if(node.getPid() == null){
				node.setPid(0);
			}
		}
		Collections.sort(cts);
		List<ChannelTree> results =this.treeLevelOrderTraveral(cts);
		
		return results;
	}
	
	private List<ChannelTree> treeLevelOrderTraveral(List<ChannelTree> cts){
					Queue<ChannelTree> queue = new LinkedList<>();
					queue.add(cts.get(0));
					List<ChannelTree> results = new ArrayList<>();
					ChannelTree current =null;
					while(!queue.isEmpty()){
						int levelNumber = queue.size();
						for(int i=0; i<levelNumber; i++){
							results.add(queue.peek());
							current = queue.poll();
							for(ChannelTree ct : cts){
								if(ct.getPid()==current.getId()){
									queue.add(ct);
								}
							}
							
						}
					}
					
					return results;
	}
	
	

	
}
