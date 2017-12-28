package com.cms.service;

import java.util.List;

import com.cms.basic.model.Pager;
import com.cms.core.model.Attachment;

public interface IAttachmentService {
	
	public void add(Attachment attachment);
	
	public void delete(int id);
	
	public Attachment load(int id);
	
	public Pager<Attachment> findNoUsedAttachment();
	
	public void clearNoUsedAttachment();
	
	public List<Attachment> listByTopic(int tid);
	
	public List<Attachment> listIndexPic(int nums);
	
	public Pager<Attachment> findChannelPic(int cid);
	
	public List<Attachment> listAttachedByTopic(int tid);
}