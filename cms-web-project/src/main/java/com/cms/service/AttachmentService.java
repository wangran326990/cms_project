package com.cms.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cms.basic.model.Pager;
import com.cms.basic.model.SystemContext;
import com.cms.core.dao.IAttachmentDao;
import com.cms.core.model.Attachment;

@Service("attachmentService")
public class AttachmentService implements IAttachmentService {
	
	private IAttachmentDao attachmentDao;
	public final static String UPLOAD_PATH="/upload/";
	
	public IAttachmentDao getAttachmentDao() {
		return attachmentDao;
	}
	
	@Resource(name="attachmentDao")
	public void setAttachmentDao(IAttachmentDao attachmentDao) {
		this.attachmentDao = attachmentDao;
	}
	
	public static void deleteAttachFiles(Attachment a){
		
		String realPath = SystemContext.getRealPath();
		realPath +=UPLOAD_PATH;
		new File(realPath + a.getNewName()).delete();
		
	}
	
	@Override
	public void add(Attachment attachment) {
		attachmentDao.add(attachment);
	}

	@Override
	public void delete(int id) {
		Attachment a = attachmentDao.load(id);
		if(a==null) return;
		attachmentDao.delete(id);
		deleteAttachFiles(a);
		
	}

	@Override
	public Attachment load(int id) {
		return attachmentDao.load(id);
	}

	@Override
	public Pager<Attachment> findNoUsedAttachment() {
		return attachmentDao.findNoUsedAttachment();
	}

	@Override
	public void clearNoUsedAttachment() {
		attachmentDao.clearNoUsedAttachment();
	}

	@Override
	public List<Attachment> listByTopic(int tid) {
		return attachmentDao.listByTopic(tid);
	}

	@Override
	public List<Attachment> listIndexPic(int nums) {
		return attachmentDao.listIndexPic(nums);
	}

	@Override
	public Pager<Attachment> findChannelPic(int cid) {
		
		return attachmentDao.findChannelPic(cid);
	}

	@Override
	public List<Attachment> listAttachedByTopic(int tid) {
		return attachmentDao.listAttachedByTopic(tid);
	}
	

}
