package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Pojo.Article;
import Pojo.Comment;
import Service.ArticleService;
import Service.CommentService;

public class ArticleAction extends ActionSupport  {
	public ArticleService as;
	public CommentService cs;
	public Article a;
	private String title;   //标题
	private String content; //内容
	private String sort; //分类
	private String tag;//标签
	private String image_url; //特色图片
	private String summary;//摘要
	private String author; //作者
	private Long time; //时间戳
	private int visit; //访问
	private int star; //点赞
	private int article_id;
	private int page;
	private int sort_id;
	private int tag_id;
	private List<Comment> comments;
	public void saveArticle() {
		System.out.println(title+"-"+content+"-"+sort+"-"+tag+"-"+image_url+"-"+summary);
		as.saveArticle(title, content, sort, tag, image_url, summary);
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("[{\"result\":\"success\"}]");
	}
	public void updateArticle() {
		System.out.println(image_url);
		as.updateArticle(article_id,title, content, sort, tag, image_url, summary);
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("[{\"result\":\"success\"}]");
	}
	public void deleteArticle() {
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(as.deleteArticle(article_id));
	}
	/**
	 * 通过json提取文章
	 */
	public void GetArticleByJson() {
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(as.GetArticleByPageJ(page));
	}
	/**
	 * 首页获取文章
	 */
	public void GetArticleByJsonPage() {
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(as.GetArticleByPageIndex(page,sort_id,tag_id));
	}
	
	/**
	 * 通过文章ID获取文章所有信息
	 * 用于首页显示文章
	 */
	public String getArticleDetail() {
		a=as.GetArticleByArticleId(article_id);
		a.setVisit(a.getVisit()+1);
		as.update(a);
		comments=cs.getCommentByArticleId(article_id);
		System.out.println(comments.size());
		return SUCCESS;
	}
	
	/**
	 * 通过文章ID获取文章JSON格式
	 */
	public void getArticleDetailJSON() {
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(as.GetArticleJSONByArticleId(article_id));
	}
	/*文章点赞*/
	public void addStar() {
		as.addStar(article_id);
	}
	/*文章消除赞*/
	public void deStar() {
		as.deStar(article_id);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public ArticleService getAs() {
		return as;
	}
	public void setAs(ArticleService as) {
		this.as = as;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSort_id() {
		return sort_id;
	}
	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public Article getA() {
		return a;
	}
	public void setA(Article a) {
		this.a = a;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public int getVisit() {
		return visit;
	}
	public void setVisit(int visit) {
		this.visit = visit;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public CommentService getCs() {
		return cs;
	}
	public void setCs(CommentService cs) {
		this.cs = cs;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
