package com.cms.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cms.basic.dao.BaseDao;
import com.cms.basic.model.Pager;
import com.cms.core.model.IndexPic;

@Repository(value="indexPicDao")
public class IndexPicDao extends BaseDao<IndexPic> implements IIndexPicDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<IndexPic> listIndexPicByNum(int num) {
		String hql = "from IndexPic order by createDate desc";
		return this.getSession().createQuery(hql).setFirstResult(0).setMaxResults(num).list();
	}

	@Override
	public Pager<IndexPic> findIndexPic() {
		// TODO Auto-generated method stub
		return this.find("from IndexPic");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> listAllIndexPicName() {
		String hql = "select ip.newName from IndexPic ip";
		return this.getSession().createQuery(hql).list();
	}

	@Override
	public Map<String, Integer> getMinAdnMaxPos() {

			String hql = "select max(pos),min(pos) from IndexPic";
			Object[] obj = (Object[])this.getSession().createQuery(hql).uniqueResult();
			Map<String,Integer> mm = new HashMap<String,Integer>();
			mm.put("max", (Integer)obj[0]);
			mm.put("min", (Integer)obj[1]);
			return mm;
	}
	
	@Override
	public IndexPic add(IndexPic ip) {
		//让其他的元素的序号先增加1
		String hql = "update IndexPic ip set ip.pos=ip.pos+1 where pos>=?";
		this.getSession().createQuery(hql).setParameter(0, 1).executeUpdate();
		ip.setPos(1);
		super.add(ip);
		return ip;
	}
	
	@Override
	public void delete(int id) {
		IndexPic ip = this.load(id);
		int pos = ip.getPos();
		String hql = "update IndexPic ip set ip.pos=ip.pos-1 where pos>?";
		this.getSession().createQuery(hql).setParameter(0, pos).executeUpdate();
		super.delete(id);
	}
	
	@Override
	public void updatePos(int id, int oldPos, int newPos) {
		IndexPic ip = this.load(id);
		if(oldPos==newPos) {
			return;
		}
		String hql = "";
		if(oldPos<newPos) {
			hql = "update IndexPic set pos=pos-1 where pos>? and pos<=?";
		} else {
			hql = "update IndexPic set pos=pos+1 where pos<? and pos>=?";
		}
		this.getSession().createQuery(hql)
			.setParameter(0, oldPos)
			.setParameter(1, newPos).executeUpdate();
		ip.setPos(newPos);
		this.update(ip);
	}

	@Override
	public void updateStatus(int id) {
		IndexPic ip = this.load(id);
		int status = ip.getStatus();
		if(status==0){
			ip.setStatus(1);
		}else{
			ip.setStatus(0);
		}
	}
	
}
