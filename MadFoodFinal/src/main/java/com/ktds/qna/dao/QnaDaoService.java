package com.ktds.qna.dao;

import java.util.List;

import com.ktds.qna.vo.QnaCommentVO;
import com.ktds.qna.vo.QnaVO;

public interface QnaDaoService {

	// list
	public List<QnaVO> getArticles(int startRow, int endRow);

	public int getArticleCount();

	// write
	public void insertArticle(QnaVO article);

	// login
	public String login_check(String id);

	// content
	public QnaVO getArticle(int article_num);

	public int getCommentNum(int article_num);

	// update
	public QnaVO getUpdateArticle(int article_num);

	public void UpdateArticle(int article_num, String title, String content);

	// delete
	public void deleteArticle(int article_num);

	// reply
	public void reply(QnaVO article);

	// add Hit
	public void addHit(int article_num);

	// comment
	public List<QnaCommentVO> insertComment(int article_num, String comment_content, String id);

	public List<QnaCommentVO> getAllComment(int article_num);
}
