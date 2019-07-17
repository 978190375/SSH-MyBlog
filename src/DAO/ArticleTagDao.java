package DAO;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import Pojo.ArticleTag;

public class ArticleTagDao extends HibernateDaoSupport implements ArticleTagDaoInterface {

	@Override
	public void saveArticleTag(ArticleTag article_tag) {
		this.getHibernateTemplate().save(article_tag);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArticleTag(ArticleTag article_tag) {
		this.getHibernateTemplate().update(article_tag);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getArticleTagByTagId(int tag_id) {
		// TODO Auto-generated method stub
		List ArticleTag=null;
		try {
			ArticleTag=this.getHibernateTemplate().find("from ArticleTag as a_t where a_t.tag.id="+tag_id);
		}catch(Exception e) {
			System.out.println(e);
		}
		return ArticleTag;
	}

	@Override
	public void deleteArticleTag(ArticleTag article_tag) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(article_tag);
	}

}
