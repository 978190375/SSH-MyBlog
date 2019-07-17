package DAO;

import java.util.List;

import Pojo.Comment;

public interface CommentDaoInterface {
	/**
	 * 保存评论
	 * @param c
	 */
	public void addComment(Comment c);
	/**
	 * 更新评论对象
	 * @param c
	 */
	public void updateComment(Comment c);
	
	/*
	 * 删除评论
	 */
	public void deleteComment(Comment c);
	/**
	 * 根据文章ID查找所有评论
	 * @param article_id
	 * @return
	 */
	public List getCommentByArticleId(int article_id);
	
	/**
	 * 根据评论ID查找对应评论
	 * @param comment_id
	 * @return
	 */
	public Comment getCommentByCommentId(int comment_id);
	
	/**
	 * 获取所有未审核的评论
	 * @return
	 */
	public List getAllCommentNoSure();
}
