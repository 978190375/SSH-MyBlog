package Pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Sort entity. @author MyEclipse Persistence Tools
 */

public class Sort {

	// Fields

	private Integer id;
	private String sort;
	private Set articleSorts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sort() {
	}

	/** full constructor */
	public Sort(String sort, Set articleSorts) {
		this.sort = sort;
		this.articleSorts = articleSorts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Set getArticleSorts() {
		return this.articleSorts;
	}

	public void setArticleSorts(Set articleSorts) {
		this.articleSorts = articleSorts;
	}

}