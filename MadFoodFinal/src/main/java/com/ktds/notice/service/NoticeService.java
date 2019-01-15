package com.ktds.notice.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ktds.notice.vo.NoticeCommentVO;
import com.ktds.notice.vo.NoticeVO;

public interface NoticeService {

	// list
	public List<NoticeVO> getArticles(int startRow, int endRow);

	public int getArticleCount();

	// content
	public NoticeVO getArticle(int article_num);

	public int getCommentNum(int article_num);

	// write
	public void insertArticle(NoticeVO article, HttpServletRequest req);

	// update
	public NoticeVO getUpdateArticle(int article_num);

	public void UpdateArticle(int article_num, String title, String content);

	// delete
	public void deleteArticle(int article_num);

	// reply
	public void reply(NoticeVO article, HttpServletRequest req);

	// add Hit
	public void addHit(int article_num);

	// comment
	public List<NoticeCommentVO> insertComment(int article_num, String comment_content, String id);

	public List<NoticeCommentVO> getAllComment(int article_num);
}
