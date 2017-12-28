package com.cms.service;

import com.cms.basic.model.Pager;
import com.cms.core.model.Topic;

public interface ITopicService {
	/**
	 * add topic 
	 * @param topic object
	 * @param cid	channel id
	 * @param uid	user id
	 * @param aids	attachment ids
	 */
	public void add(Topic topic, int cid, int uid, Integer[] aids);
	
	public void add(Topic topic, int cid, int uid);
	
	public void delete(int tid);
	
	public void update(Topic topic, int cid, Integer[] aids);
	
	public void update(Topic topic, int cid);
	
	public Topic load(int tid);
	
	public Pager<Topic> findByChannelAndTitle(Integer cid, String title);
	
	public Pager<Topic> searchTopicByKeyword(String keyword);
	
	public Pager<Topic> searchTopic(String con);
	
	public Pager<Topic> find(Integer cid, String title, Integer status);
	
	public Pager<Topic> find(Integer uid, Integer cid, String title, Integer status);
	
	public Pager<Topic> findRecommandTopic(Integer cid);
	
	public void updateStatus(int tid);
}
