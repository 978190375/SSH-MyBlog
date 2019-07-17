package DAO;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import Pojo.Tag;

public class TagDao extends HibernateDaoSupport implements TagDaoInterface {

	@Override
	public List getTagByInput(String input_value) {
		// TODO Auto-generated method stub
		List tags=this.getHibernateTemplate().find("from Tag as t where t.tag like '%"+input_value+"%'");
		
		return tags;
	}
	

	@Override
	public void saveTag(Tag t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(t);
		
	}
	
	@Override
	public void updateTag(Tag t) {
		this.getHibernateTemplate().update(t);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tag getTagById(int id) {
		Tag t=null;
		List ts=this.getHibernateTemplate().find("from Tag as t where t.id ='"+id+"'");
		
		if(ts.size()>0)
			t=(Tag)ts.get(0);
		// TODO Auto-generated method stub
		return t;
	}

	@Override
	public Tag getTagByTag(String input_value) {
		// TODO Auto-generated method stub
		Tag t=null;
		List ts=this.getHibernateTemplate().find("from Tag as t where t.tag ='"+input_value+"'");
		if(ts.size()>0)
			t=(Tag)ts.get(0);
		return t;
	}


	@Override
	public List getAllTag() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Tag");
	}


	@Override
	public void deleteTag(Tag t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(t);
		
	}


	@Override
	public boolean getTagByTagKey(String tag_key) {
		// TODO Auto-generated method stub
		
		return this.getHibernateTemplate().find("from Tag as t where t.tag='"+tag_key+"'").size()>0;
	}


}
