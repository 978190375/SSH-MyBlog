package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Pojo.Article;
import Pojo.Comment;
import Service.ArticleService;
import Service.CommentService;

public class CommentAction extends ActionSupport   {
	public CommentService cs;
	private String nickname;
	private String comment;
	private int article_id;
	private int comment_id;
	public void addComment() {
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
		out.print(cs.addComment(article_id, comment, nickname));
	}
	
	/*评论点赞*/
	public void addStar() {
		cs.addStar(comment_id);
	}
	/*评论消除赞*/
	public void deStar() {
		cs.deStar(comment_id);
	}
	/*评论点踩*/
	public void addDiss() {
		cs.addDiss(comment_id);
	}
	/*评论消除踩*/
	public void deDiss() {
		cs.deDiss(comment_id);
	}
	
	/**
	 * 审核通过评论
	 */
	public void acceptComment() {
		outJson(cs.updateComment(comment_id));
	}
	/**
	 * 审核失败，删除评论
	 */
	public void refuseComment() {
		outJson(cs.deleteComment(comment_id));
	}
	/**
	 * 获取所有评论
	 */
	public void getAllComment() {
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
		out.print(cs.getAllComment());
	}
	public void outJson(String str) {
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
		out.print(str);
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public CommentService getCs() {
		return cs;
	}
	public void setCs(CommentService cs) {
		this.cs = cs;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	
	
}
