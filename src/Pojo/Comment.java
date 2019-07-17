package Pojo;

import java.sql.Timestamp;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment  {

	// Fields

	private Integer id;
	private Article article;
	private String nickname;
	private String content;
	private Long time;
	private Integer star;
	private Integer diss;
	private Integer sure;
	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(Article article, String nickname, String content, Long time, Integer star, Integer diss) {
		this.article = article;
		this.nickname = nickname;
		this.content = content;
		this.time = time;
		this.star = star;
		this.diss = diss;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public Integer getStar() {
		return this.star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public Integer getDiss() {
		return this.diss;
	}

	public void setDiss(Integer diss) {
		this.diss = diss;
	}

	public Integer getSure() {
		return sure;
	}

	public void setSure(Integer sure) {
		this.sure = sure;
	}

}