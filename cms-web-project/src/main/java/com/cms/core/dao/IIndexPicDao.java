package com.cms.core.dao;

import java.util.List;
import java.util.Map;

import com.cms.basic.dao.IBaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.IndexPic;

public interface IIndexPicDao extends IBaseDao<IndexPic>{
	
	public List<IndexPic> listIndexPicByNum(int num);
	
	public Pager<IndexPic> findIndexPic();
	
	public List<String> listAllIndexPicName();
	
	public Map<String, Integer> getMinAdnMaxPos();
	
	public void updatePos(int id, int oldPos, int newPos);
	
	public void updateStatus(int id);
	
}
