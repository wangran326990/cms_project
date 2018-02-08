package com.cms.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cms.basic.model.Pager;
import com.cms.basic.model.SystemContext;
import com.cms.core.dao.IndexPicDao;
import com.cms.core.model.IndexPic;

@Service(value="indexPicService")
public class IndexPicService implements IIndexPicService{
	
	private IndexPicDao indexPicDao;
	
	
	@Override
	public void add(IndexPic indexPic) {
		indexPicDao.add(indexPic);
	}

	@Override
	public void update(IndexPic indexPic) {
		indexPicDao.update(indexPic);
	}

	@Override
	public void delete(int id) {
		IndexPic pic = indexPicDao.load(id);
		String rp = SystemContext.getRealPath();
		String tp = rp+"/resources/indexPic/thumbnail/"+pic.getNewName();
		String pp = rp+"/resources/indexPic/"+pic.getNewName();
		new File(tp).delete();
		new File(pp).delete();
		indexPicDao.delete(id);
	}

	@Override
	public void updateStatus(int id) {
		indexPicDao.updateStatus(id);
	}

	@Override
	public IndexPic load(int id) {
		return indexPicDao.load(id);
	}

	@Override
	public List<IndexPic> listIndexPicByNum(int num) {
		
		return indexPicDao.listIndexPicByNum(num);
	}

	@Override
	public Pager<IndexPic> findIndexPic() {
		return indexPicDao.findIndexPic();
	}

	@Override
	public List<String> listAllIndexPicName() {
		return indexPicDao.listAllIndexPicName();
	}

	@Override
	public void cleanNoUseIndexPic(List<String> pics) throws IOException {
		
	}

	@Override
	public Map<String, Integer> getMinAdnMaxPos() {
		return indexPicDao.getMinAdnMaxPos();
	}

	@Override
	public void updatePos(int id, int oldPos, int newPos) {
		indexPicDao.updatePos(id, oldPos, newPos);
		
	}

	public IndexPicDao getIndexPicDao() {
		return indexPicDao;
	}
	
	@Resource(name="indexPicDao")
	public void setIndexPicDao(IndexPicDao indexPicDao) {
		this.indexPicDao = indexPicDao;
	}

}
