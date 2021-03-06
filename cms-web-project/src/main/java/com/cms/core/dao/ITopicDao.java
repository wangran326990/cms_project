package com.cms.core.dao;

import java.util.List;

import com.cms.basic.dao.IBaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.Keyword;
import com.cms.core.model.Topic;

public interface ITopicDao extends IBaseDao<Topic>{
	
	public Pager<Topic> findByChannelAndTitle(Integer cid, String title);
	
	public Pager<Topic> searchTopicByKeyword(String keyword);
	
	public Pager<Topic> searchTopic(String con);
	
	public Pager<Topic> find(Integer cid, String title, Integer status);
	
	public Pager<Topic> find(Integer uid, Integer cid, String title, Integer status);
	
	public Pager<Topic> findRecommandTopic(Integer cid);
	
	public void deleteTopic(int tid);
	
}