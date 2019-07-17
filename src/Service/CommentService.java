package Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import DAO.CommentDaoInterface;
import Pojo.Article;
import Pojo.Comment;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CommentService {	
	public CommentDaoInterface cd;
	public Comment c;
	public ArticleService as;
	public Article a;
	
	/**
	 * 添加评论
	 * @param article_id 文章ID
	 * @param comment 评论内容
	 * @param nickname 评论者昵称
	 * @return
	 */
	public String addComment(int article_id,String comment,String nickname) {
		a=as.GetArticleByArticleId(article_id);
		c.setArticle(a);
		c.setContent(comment);
		c.setDiss(0);
		c.setNickname(nickname);
		c.setSure(0);
		c.setStar(0);
		c.setTime((new Date()).getTime());
		addComment(c);
		a.getComments().add(c);
		as.update(a);
		return "[{\"result\":\"success\"}]";
		
	}
	
	/**
	 * 根据文章ID获取所有评论
	 * @param article_id
	 * @return
	 */
	public List getCommentByArticleId(int article_id) {
		List comments=cd.getCommentByArticleId(article_id);
		return comments;
	}
	
	/**
	 * 保存评论
	 * @param c 评论对象
	 */
	public void addComment(Comment c) {
		cd.addComment(c);
		
	}
	
	public void addStar(int comment_id) {
		c=cd.getCommentByCommentId(comment_id);
		c.setStar(c.getStar()+1);
		cd.updateComment(c);
	}
	public void deStar(int comment_id) {

		c=cd.getCommentByCommentId(comment_id);
		if(c.getStar()>0) {
			c.setStar(c.getStar()-1);
			cd.updateComment(c);
		}
	}
	public void addDiss(int comment_id) {
		c=cd.getCommentByCommentId(comment_id);
		c.setDiss(c.getDiss()+1);
		cd.updateComment(c);
		
	}
	public void deDiss(int comment_id) {
		c=cd.getCommentByCommentId(comment_id);
		if(c.getDiss()>0) {
			c.setDiss(c.getDiss()-1);
			cd.updateComment(c);
		}
	}
	
	public String getAllComment() {
		List comments=cd.getAllCommentNoSure();
		JSONArray outa=new JSONArray();
		JSONObject result=new JSONObject();
		if(comments!=null)
		{	
			result.put("result", "success");
			outa.add(result);
			Iterator commentsIt=comments.iterator();
			while(commentsIt.hasNext()) {
				JSONObject outj=new JSONObject();
				c=(Comment)commentsIt.next();
				outj.put("article_id", c.getArticle().getId());
				outj.put("article_title", c.getArticle().getTitle());
				outj.put("comment_id", c.getId());
				outj.put("comment_nickname", c.getNickname());
				outj.put("comment_content", c.getContent());
				outj.put("comment_time", c.getTime());
				outa.add(outj);
			}
		}
		else {
			result.put("result", "error");
			outa.add(result);
		}
		System.out.println(outa.toString());
		return outa.toString();
		
	}
	public String updateComment(int comment_id) {
		c=cd.getCommentByCommentId(comment_id);
		c.setSure(1);
		cd.updateComment(c);
		return "[{\"result\":\"success\"}]";
	}
	public String deleteComment(int comment_id) {
		c=cd.getCommentByCommentId(comment_id);
		cd.deleteComment(c);
		return "[{\"result\":\"success\"}]";
		
	}
	public CommentDaoInterface getCd() {
		return cd;
	}
	public void setCd(CommentDaoInterface cd) {
		this.cd = cd;
	}
	public Comment getC() {
		return c;
	}
	public void setC(Comment c) {
		this.c = c;
	}
	public ArticleService getAs() {
		return as;
	}
	public void setAs(ArticleService as) {
		this.as = as;
	}
	public Article getA() {
		return a;
	}
	public void setA(Article a) {
		this.a = a;
	}
	
}
