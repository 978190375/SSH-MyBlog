package Action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Service.ArticleService;
import Service.SortService;

public class IndexAction extends ActionSupport {
	private int articleCount;
	private int sortCount;
	private List articles;
	private ArticleService as;
	private SortService ss;
	public String GetIndex() {
		articleCount=as.getArticleCount();
		sortCount=ss.getSortCount();
		articles=as.getArticle(5);
		return SUCCESS;
	}
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	public int getSortCount() {
		return sortCount;
	}
	public void setSortCount(int sortCount) {
		this.sortCount = sortCount;
	}
	public List getArticles() {
		return articles;
	}
	public void setArticles(List articles) {
		this.articles = articles;
	}
	public ArticleService getAs() {
		return as;
	}
	public void setAs(ArticleService as) {
		this.as = as;
	}
	public SortService getSs() {
		return ss;
	}
	public void setSs(SortService ss) {
		this.ss = ss;
	}
	
}
