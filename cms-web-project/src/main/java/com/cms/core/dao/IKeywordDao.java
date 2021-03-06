package com.cms.core.dao;

import java.util.List;

import com.cms.basic.dao.IBaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.Keyword;

public interface IKeywordDao extends IBaseDao<Keyword>{
	
	
	

	/**
	 * get numbers highest refer times keywords. 
	 * 
	 * @return
	 */
	public List<Keyword> listPrimaryKeyword(int nums);
	
	public Pager<Keyword> findNoUseKeywords();
	
	public List<Keyword> listNoUseKeywords();
	
	public void clearNoUseKeywords();
	
	public List<Keyword> findUsedKeywords();
	
	
	public void addOrUpdate(String name);
	
	public List<Keyword> listKeywordByCon(String content);
}
