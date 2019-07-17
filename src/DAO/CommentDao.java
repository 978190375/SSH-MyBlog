package DAO;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import Pojo.Comment;

public class CommentDao extends HibernateDaoSupport implements CommentDaoInterface{

	@Override
	public void addComment(Comment c) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(c);
		
	}

	@Override
	public void updateComment(Comment c) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(c);
		
	}
	@Override
	public List getCommentByArticleId(int article_id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Comment as c where c.sure=1 and c.article.id="+article_id);
		
	}


	@Override
	public Comment getCommentByCommentId(int comment_id) {
		System.out.println(comment_id);
		// TODO Auto-generated method stub
		List comments=this.getHibernateTemplate().find("from Comment as c where c.id="+comment_id);
		return (Comment)comments.get(0);
	}

	@Override
	public List getAllCommentNoSure() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Comment as c where c.sure=0");
	}

	@Override
	public void deleteComment(Comment c) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(c);
	}

}
