package com.cms.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cms.basic.model.Pager;
import com.cms.basic.model.SystemContext;
import com.cms.core.dao.IAttachmentDao;
import com.cms.core.dao.IChannelDao;
import com.cms.core.dao.ITopicDao;
import com.cms.core.dao.IUserDao;
import com.cms.core.errors.CmsException;
import com.cms.core.model.Attachment;
import com.cms.core.model.Channel;
import com.cms.core.model.Topic;
import com.cms.core.model.User;

@Service(value="topicService")
public class TopicService implements ITopicService {

	private ITopicDao topicDao;
	private IAttachmentDao attachmentDao;
	private IUserDao userDao;
	private IChannelDao channelDao;

	

	
	public ITopicDao getTopicDao() {
		return topicDao;
	}
	
	@Resource(name="topicDao")
	public void setTopicDao(ITopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public IAttachmentDao getAttachmentDao() {
		return attachmentDao;
	}
	
	@Resource(name="attachmentDao")
	public void setAttachmentDao(IAttachmentDao attachmentDao) {
		this.attachmentDao = attachmentDao;
	}

	
	public IUserDao getUserDao() {
		return userDao;
	}
	
	@Resource(name="userDao")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IChannelDao getChannelDao() {
		return channelDao;
	}
	
	@Resource(name="channelDao")
	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
	}
	
	private void addTopicAtts(Topic topic, Integer [] aids){
		if(aids!=null)
			for(Integer aid : aids){
				Attachment a = attachmentDao.load(aid);
				if(a==null) continue;
				a.setTopic(topic);
			}
	}
	
	@Override
	public void add(Topic topic, int cid, int uid, Integer[] aids) {
		Channel c = channelDao.load(cid);
		User u = userDao.load(uid);
		if(c==null || u==null){
			throw new CmsException("channel or user not exist");
		}
		topic.setAuthor(u.getNickname());
		topic.setCname(c.getName());
		topic.setCreateDate(new Date());
		topic.setChannel(c);
		topic.setUser(u);
		topicDao.add(topic);
//		if(aids!=null)
//		for(Integer aid : aids){
//			Attachment a = attachmentDao.load(aid);
//			if(a==null) continue;
//			a.setTopic(topic);
//		}
		this.addTopicAtts(topic, aids);
	}

	@Override
	public void add(Topic topic, int cid, int uid) {
		this.add(topic, cid, uid, null);
	}

	@Override
	public void delete(int tid) {
		//1 check topic exist or not?
//		Topic topic = topicDao.load(tid);
//		if(topic ==null) throw new CmsException("topic not exist");
//		
//		List<Attachment> attachments = attachmentDao.listByTopic(tid);
//		if(!attachments.isEmpty())
//			for(Attachment attachment : attachments){
//				attachment.setTopic(null);
//				attachmentDao.update(attachment);
//			}
//		topicDao.deleteTopic(tid);
		
		List<Attachment> attachments = attachmentDao.listByTopic(tid);
		if(!attachments.isEmpty())
		attachmentDao.deleteByTopic(tid);
		topicDao.delete(tid);
		//delete from disk
		for(Attachment a : attachments){
			AttachmentService.deleteAttachFiles(a);
		}
		
	}

	@Override
	public void update(Topic topic, int cid, Integer[] aids) {
		// TODO Auto-generated method stub
		Channel c = channelDao.load(cid);
		if(c==null) throw new CmsException("channel not exist");
		topic.setCname(c.getName());
		topic.setChannel(c);
		topicDao.update(topic);
		addTopicAtts(topic, aids);
	}

	@Override
	public void update(Topic topic, int cid) {
		update(topic, cid, null);
	}

	@Override
	public Topic load(int tid) {
		return topicDao.load(tid);
	}

	@Override
	public Pager<Topic> findByChannelAndTitle(Integer cid, String title) {
		return topicDao.findByChannelAndTitle(cid, title);
	}

	@Override
	public Pager<Topic> searchTopicByKeyword(String keyword) {
		return topicDao.searchTopicByKeyword(keyword);
	}

	@Override
	public Pager<Topic> searchTopic(String con) {
		return topicDao.searchTopic(con);
	}

	@Override
	public Pager<Topic> find(Integer cid, String title, Integer status) {
		return topicDao.find(cid, title, status);
	}

	@Override
	public Pager<Topic> find(Integer uid, Integer cid, String title, Integer status) {
		return topicDao.find(uid, cid, title, status);
	}

	@Override
	public Pager<Topic> findRecommandTopic(Integer cid) {
		return topicDao.findRecommandTopic(cid);
	}

	@Override
	public void updateStatus(int tid) {
		Topic t = topicDao.load(tid);
		if(t.getStatus()==0) t.setStatus(1);
		else t.setStatus(0);
	}

	

}
