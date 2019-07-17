package DAO;

import java.util.List;

import Pojo.Article;
import Pojo.ArticleSort;

public interface ArticleSortDaoInterface {
	/**
	 * 保存ArticleSort对象
	 * @param as
	 */
	void saveArticleSort(ArticleSort as);
	/**
	 * 更新ArticleSort对象
	 * @param as
	 */
	void updateArticleSort(ArticleSort as);
	/**
	 * 删除ArticleSort
	 * @param as
	 */
	void deleteArticleSort(ArticleSort as);
	/**
	 * 通过sort_id获取有这个分类的文章分类
	 * @param sort_id
	 * @return
	 */
	List getArticleSortBySortId(int sort_id);
	/**
	 * 
	 * @param as
	 * @return
	 */
	Article getArticleByArticleSort(ArticleSort as);
}
