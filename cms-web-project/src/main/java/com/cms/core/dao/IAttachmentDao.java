package com.cms.core.dao;

import java.util.List;

import com.cms.basic.dao.IBaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.Attachment;

public interface IAttachmentDao extends IBaseDao<Attachment> {
	
	public Pager<Attachment> findNoUsedAttachment();
	
	public void clearNoUsedAttachment();
	
	public void deleteByTopic(int tid);
	
	public List<Attachment> listByTopic(int tid);
	
	public List<Attachment> listIndexPic(int nums);
	
	public Pager<Attachment> findChannelPic(int cid);
	
	public List<Attachment> listAttachedByTopic(int tid);
	
	public Pager<Attachment> listAllPic();
}
