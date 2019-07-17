package Pojo;

/**
 * ArticleSort entity. @author MyEclipse Persistence Tools
 */

public class ArticleSort  {

	// Fields

	private Integer id;
	private Sort sort;
	private Article article;

	// Constructors

	/** default constructor */
	public ArticleSort() {
	}

	/** full constructor */
	public ArticleSort(Sort sort, Article article) {
		this.sort = sort;
		this.article = article;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sort getSort() {
		return this.sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}