package DAO;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import Pojo.Sort;

public class SortDao extends HibernateDaoSupport implements SortDaoInterface{

	@Override
	public List getAllSort() {
		return this.getHibernateTemplate().find("from Sort as s ");
	
	}
	@Override
	public void saveSort(Sort s) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(s);
		
	}

	@Override
	public void saveSortNoReturn(Sort s) {
		this.getHibernateTemplate().save(s);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateSort(Sort s) {
		this.getHibernateTemplate().update(s);		
		// TODO Auto-generated method stub
		
	}
	@Override
	public Sort getSortById(int id) {
		// TODO Auto-generated method stub
		Sort sort=null;
		List s=this.getHibernateTemplate().find("from Sort as s where s.id='"+id+"'");
		if(s.size()>0)
			sort=(Sort) s.get(0);
		
		return sort;
	}
	@Override
	public Sort findSortBySortValue(String value) {
		// TODO Auto-generated method stub
		Sort sort=null;
		List s=this.getHibernateTemplate().find("from Sort as s where s.sort='"+value+"'");
		if(s.size()>0)
			sort=(Sort) s.get(0);
		
		return sort;
	}
	@Override
	public int getSortCount() {
		// TODO Auto-generated method stub
		List s=this.getHibernateTemplate().find("from Sort");
		
		return s.size();
	}
	@Override
	public void deleteSort(Sort s) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(s);
	}

}
