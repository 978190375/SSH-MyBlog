package Pojo;

/**
 * ArticleTag entity. @author MyEclipse Persistence Tools
 */

public class ArticleTag {

	// Fields

	private Integer id;
	private Tag tag;
	private Article article;

	// Constructors

	/** default constructor */
	public ArticleTag() {
	}

	/** full constructor */
	public ArticleTag(Tag tag, Article article) {
		this.tag = tag;
		this.article = article;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}