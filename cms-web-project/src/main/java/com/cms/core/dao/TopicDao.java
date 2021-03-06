package com.cms.core.dao;

import org.springframework.stereotype.Repository;

import com.cms.basic.dao.BaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.Topic;

@Repository(value="topicDao")
public class TopicDao extends BaseDao<Topic> implements ITopicDao {

	

	private String getTopicSelect() {
		return "select new Topic(t.id, t.title, t.keyword, t.status, t.recommend, t.publishDate, t.author, t.cname,t.summary)";
	}
	
	@Override
	public Pager<Topic> findByChannelAndTitle(Integer cid, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<Topic> searchTopicByKeyword(String keyword) {
		String hql = getTopicSelect()+" from Topic t where t.status=1 and keyword like '%"+keyword+"%'";
		return this.find(hql);
	}

	@Override
	public Pager<Topic> searchTopic(String con) {
		String hql = getTopicSelect()+" from Topic t where t.status=1 and"
					+ " (title like '%"+con+"%' or content like '%"+con+"%' or summary like '%"+con+"%')" ;
		return this.find(hql);
	}

	@Override
	public Pager<Topic> find(Integer cid, String title, Integer status) {
		
		return this.find(null, cid, title, status);
	}

	@Override
	public Pager<Topic> find(Integer uid, Integer cid, String title, Integer status) {
		String hql = "select new Topic(t.id, t.title, t.keyword, t.status, t.recommend, t.publishDate, t.author, t.cname,t.summary) from Topic t where 1=1";
		hql = this.hqlBuilder(hql, uid, cid, title, status);		
		return this.find(hql);
	}

	@Override
	public Pager<Topic> findRecommandTopic(Integer cid) {
		String hql = getTopicSelect()+" from Topic t where t.status=1 and t.recommend=1 and t.channel.id=?";
		return this.find(hql,cid);
	}
	
	private String hqlBuilder(String hql, Integer uid, Integer cid, String title, Integer status){
		if(uid!=null && uid>0){
			hql += " and t.user.id ="+uid;
		}
		
		if(cid!=null && cid>0){
			hql +=" and t.channel.id ="+cid;
		}
		
		if(title!=null && !title.trim().equals("")){
			hql +=" and t.title like '%"+title+"%'";
		}
		
		if(status!=null){
			hql +=" and t.status ="+status;
		}
		return hql;
	}

	@Override
	public void deleteTopic(int tid) {
		this.delete(tid);
	}



}
