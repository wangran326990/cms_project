package com.cms.service;

import java.util.List;

import com.cms.basic.model.Pager;
import com.cms.core.model.Keyword;

public interface IKeywordService {
	
	//public void saveOrUpdate(String name);
	
	//public List<Keyword> listPrimaryKeyword(int nums);
	
	public Pager<Keyword> findNoUseKeywords();
	
	public List<Keyword> listNoUseKeywords();
	
	public void clearNoUseKeywords();
	
	public List<Keyword> findUsedKeywords();
	
	
	public void addOrUpdate(String name);
	
	/**
	 * get keyword cute times larger than nums
	 * @param nums
	 * @return
	 */
	
	public List<Keyword> getKeywordByTimes(int nums);
	/**
	 * get top nums cute times keywords
	 * @param nums
	 * @return
	 */
	
	public List<Keyword> getMaxTimesKeyword(int nums);
	
	public List<String> listKeywordByCon(String name);
}
