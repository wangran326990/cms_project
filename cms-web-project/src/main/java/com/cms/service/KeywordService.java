package com.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cms.basic.model.Pager;
import com.cms.core.dao.IKeywordDao;
import com.cms.core.model.Keyword;

@Service(value="keywordService")
public class KeywordService implements IKeywordService {

	private IKeywordDao keywordDao;
	

	public IKeywordDao getKeywordDao() {
		return keywordDao;
	}

	@Resource(name="keywordDao")
	public void setKeywordDao(IKeywordDao keywordDao) {
		this.keywordDao = keywordDao;
	}


	@Override
	public Pager<Keyword> findNoUseKeywords() {
		return this.keywordDao.findNoUseKeywords();
	}

	@Override
	public List<Keyword> listNoUseKeywords() {
		return this.listNoUseKeywords();
	}

	@Override
	public void clearNoUseKeywords() {
		this.clearNoUseKeywords();
	}

	@Override
	public List<Keyword> findUsedKeywords() {
		return this.findUsedKeywords();
	}

	@Override
	public void addOrUpdate(String name) {
		keywordDao.addOrUpdate(name);
	}

	@Override
	public List<Keyword> getKeywordByTimes(int nums) {
		List<Keyword> ks = keywordDao.findUsedKeywords();
		List<Keyword> kks = new ArrayList<Keyword>();
		for(Keyword keyword : ks){
			if(keyword.getTimes() >=nums)
				kks.add(keyword);
		}
		return kks;
	}

	@Override
	public List<Keyword> getMaxTimesKeyword(int nums) {
		List<Keyword> ks = keywordDao.findUsedKeywords();
		List<Keyword> kks = new ArrayList<Keyword>();
		if(ks.size()<=nums) return ks;
		for(int i=0;i<=nums;i++) {
			kks.add(ks.get(i));
		}
		return kks;
	}

	@Override
	public List<String> listKeywordByCon(String name) {
		 List<Keyword> keywords = keywordDao.listKeywordByCon(name);
		 return keywords.stream().map(keyword->keyword.getName()).collect(Collectors.toList());
	}
	

}
