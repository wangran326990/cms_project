package com.cms.core.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.cms.basic.dao.BaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.Attachment;
import com.cms.core.model.Keyword;
@Repository(value="keywordDao")
public class KeywordDao extends BaseDao<Keyword> implements IKeywordDao {

	@SuppressWarnings("unchecked")
	private Map<String,Integer> getExistKeyword2Map() {
		String hql = "select t.keyword from Topic t";
		List<String> allKeys = this.getSession().createQuery(hql).list();
		Map<String,Integer> keys = new HashMap<String,Integer>();
		for(String ak:allKeys) {
			String[] ks = ak.split("\\|");
			for(String k:ks) {
				if("".equals(k.trim())) continue;
				if(keys.containsKey(k)) {
					keys.put(k, keys.get(k)+1);
				} else {
					keys.put(k, 1);
				}
			}
		}
		return keys;
	}
	
	private Set<String> getExistKeywords() {
		return getExistKeyword2Map().keySet();
	}


	@Override
	public List<Keyword> listPrimaryKeyword(int nums) {
		
		String hql = "select k from Keyword k "
				+ "where k.times >=?"; 
		
		return this.list(hql, nums);
	}

	@Override
	public Pager<Keyword> findNoUseKeywords() {
		String hql ="from Keyword where name not in (:ks)";
		//get a set of used keyword names
		Set<String> ks = getExistKeywords();
		Map<String, Object> alias = new HashMap<>();
		alias.put("ks", ks);
			
		return this.findByAlias(hql, alias);
	}

	@Override
	public void clearNoUseKeywords() {
//		String hql ="delete k from Keyword k "
//				+ "where k.times =?";
//		this.updateByHql(hql,0);
		List<Keyword> keywords = this.listNoUseKeywords();
		for(Keyword keyword : keywords){
			this.delete(keyword.getId());
		}
	}

	@Override
	public List<Keyword> findUsedKeywords() {
		Map<String,Integer> allKeys = getExistKeyword2Map();
		Set<String> keys = allKeys.keySet();
		List<Keyword> ks = new ArrayList<Keyword>();
		for(String k:keys) {
			ks.add(new Keyword(k,allKeys.get(k)));
		}
		Collections.sort(ks);
		return ks;
	}

	@Override
	public void addOrUpdate(String name) {
		String hql = "from Keyword where name=?";
		Keyword kw = (Keyword)this.queryObject(hql, name);
		if(kw == null) {
			Keyword keyword = new Keyword();
			keyword.setName(name);
			keyword.setNameFullPy(name);
			keyword.setNameShortPy(name);
			keyword.setTimes(1);
			this.add(keyword);
		}else{
			kw.setTimes(kw.getTimes()+1);
		}
	}

	@Override
	public List<Keyword> listNoUseKeywords() {
		String hql ="from Keyword where name not in (:ks)";
		//get a set of used keyword names
		Set<String> ks = getExistKeywords();
		Map<String, Object> alias = new HashMap<>();
		alias.put("ks", ks);
			
		return this.listByAlias(hql, alias);
	}

	@Override
	public List<Keyword> listKeywordByCon(String content) {
		String hql="from Keyword where name like '%"+content+"%'";
		
		return this.list(hql);
	}

	
}
