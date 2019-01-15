package com.ktds.notice.dao;

import java.util.List;

import com.ktds.notice.vo.NoticeCommentVO;
import com.ktds.notice.vo.NoticeVO;

public interface NoticeDaoService {

	// list
	public List<NoticeVO> getArticles(int startRow, int endRow);

	public int getArticleCount();

	// content
	public NoticeVO getArticle(int article_num);

	public int getCommentNum(int article_num);

	// write
	public void insertArticle(NoticeVO article);

	// update
	public NoticeVO getUpdateArticle(int article_num);

	public void UpdateArticle(int article_num, String title, String content);

	// delete
	public void deleteArticle(int article_num);

	// reply
	public void reply(NoticeVO article);

	// add Hit
	public void addHit(int article_num);

	// comment
	public List<NoticeCommentVO> insertComment(int article_num, String comment_content, String id);

	public List<NoticeCommentVO> getAllComment(int article_num);
}
