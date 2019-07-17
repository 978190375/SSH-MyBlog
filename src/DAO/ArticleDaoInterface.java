package DAO;

import java.util.List;

import Pojo.Article;
import Pojo.Sort;

public interface ArticleDaoInterface {
	void save(Article article);
	void deleteArticle(Article article);
	void updateArticle(Article article);
	/**
	 * 获取文章数量
	 * @return
	 */
	int getArticleCount();
	
	/**
	 * 获取count篇最新文章
	 * @param count
	 * @return
	 */
	List getArticle(int count);
	
	/**
	 * 获取全部文章
	 * @return
	 */
	List getArticle();
	
	/**
	 * 通过分类获取文章
	 * @param s
	 * @return
	 */
	List getArticleBySort(Sort s);
	
	/**
	 * 通过文章ID获取文章对象
	 * @param 文章ID
	 * @return 文章对象
	 */
	Article getArticleByArticleId(int id);
}
