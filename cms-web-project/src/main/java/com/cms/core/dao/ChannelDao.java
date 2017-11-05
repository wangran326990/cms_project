package com.cms.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cms.basic.dao.BaseDao;
import com.cms.core.model.Channel;
import com.cms.core.model.ChannelTree;

@Repository("channelDao")
public class ChannelDao extends BaseDao<Channel> implements IChannelDao {



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

	
}
