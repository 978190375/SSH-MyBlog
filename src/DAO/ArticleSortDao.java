package DAO;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import Pojo.Article;
import Pojo.ArticleSort;

public class ArticleSortDao extends HibernateDaoSupport implements ArticleSortDaoInterface {

	@Override
	public void saveArticleSort(ArticleSort as) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(as);
	}

	@Override
	public void updateArticleSort(ArticleSort as) {
		this.getHibernateTemplate().update(as);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getArticleSortBySortId(int sort_id) {
		// TODO Auto-generated method stub
		List ArticleSort=null;
		try {
			ArticleSort=this.getHibernateTemplate().find("from ArticleSort as a_s where a_s.sort.id="+sort_id);
		}catch(Exception e) {
			System.out.println(e);
		}
		return ArticleSort;
	}

	@Override
	public Article getArticleByArticleSort(ArticleSort as) {
		// TODO Auto-generated method stub
		Article a=as.getArticle();
		return a;
	}

	@Override
	public void deleteArticleSort(ArticleSort as) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(as);
	}


}
