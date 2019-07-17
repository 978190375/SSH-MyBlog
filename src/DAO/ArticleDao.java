package DAO;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import Pojo.Article;
import Pojo.Sort;

public class ArticleDao extends HibernateDaoSupport implements ArticleDaoInterface {

	@Override
	public void save(Article article) {
		this.getHibernateTemplate().save(article);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArticle(Article article) {
		this.getHibernateTemplate().update(article);
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getArticleCount() {
		// TODO Auto-generated method stub
		List articles=GetArticleList();
		return articles.size();
	}

	@Override
	public List getArticle(int count) {
		// TODO Auto-generated method stub
		List articles=GetArticleList();
		if(articles.size()<=count)
			return articles;
		else
			return articles.subList(0, count+1);
	}

	@Override
	public List getArticle() {
		// TODO Auto-generated method stub
		return GetArticleList();
	}

	public List GetArticleList() {
		return this.getHibernateTemplate().find("from Article ");
	}

	@Override
	public List getArticleBySort(Sort s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article getArticleByArticleId(int id) {
		// TODO Auto-generated method stub
		List articles=this.getHibernateTemplate().find("from Article as a where a.id="+id);
		
		return (Article) articles.get(0);
	}

	@Override
	public void deleteArticle(Article article) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(article);
	}
}
