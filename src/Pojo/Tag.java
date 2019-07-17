package Pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Tag entity. @author MyEclipse Persistence Tools
 */

public class Tag  {

	// Fields

	private Integer id;
	private String tag;
	private Set articleTags = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tag() {
	}

	/** full constructor */
	public Tag(String tag, Set articleTags) {
		this.tag = tag;
		this.articleTags = articleTags;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Set getArticleTags() {
		return this.articleTags;
	}

	public void setArticleTags(Set articleTags) {
		this.articleTags = articleTags;
	}

}