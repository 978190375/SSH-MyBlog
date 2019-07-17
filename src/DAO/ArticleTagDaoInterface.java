package DAO;

import java.util.List;

import Pojo.ArticleTag;

public interface ArticleTagDaoInterface {
	/**
	 * 保存ArticleTag对象
	 * @param article_tag
	 */
	void saveArticleTag(ArticleTag article_tag);
	/**
	 * 更新ArticleTag对象
	 * @param article_tag
	 */
	void updateArticleTag(ArticleTag article_tag);
	/**
	 * 通过tag_id获取所有包含该标签的文章
	 * @param tag_id
	 * @return
	 */
	List getArticleTagByTagId(int tag_id);
	
	/**
	 * 删除articleTag对象
	 * @param article_tag
	 */
	void deleteArticleTag(ArticleTag article_tag);
}
