package Pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article {

	// Fields

	private Integer id;
	private String title;
	private String author;
	private String content;
	private Long time;
	private String summary;  //摘要
	private Integer star;
	private Integer visit;
	private String image_url;
	private Set articleTags = new HashSet(0);
	private Set articleSorts = new HashSet(0);
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(String title, String author) {
		this.title = title;
		this.author = author;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

		

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public Integer getStar() {
		return this.star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public Integer getVisit() {
		return this.visit;
	}

	public void setVisit(Integer visit) {
		this.visit = visit;
	}

	public Set getArticleTags() {
		return this.articleTags;
	}

	public void setArticleTags(Set articleTags) {
		this.articleTags = articleTags;
	}

	public Set getArticleSorts() {
		return this.articleSorts;
	}

	public void setArticleSorts(Set articleSorts) {
		this.articleSorts = articleSorts;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}