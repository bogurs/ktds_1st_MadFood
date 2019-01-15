package com.ktds.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.qna.dao.QnaDaoService;
import com.ktds.qna.vo.QnaCommentVO;
import com.ktds.qna.vo.QnaVO;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaDaoService qnaDaoService;

	@Override
	public List<QnaVO> getArticles(int startRow, int endRow) {
		return qnaDaoService.getArticles(startRow, endRow);
	}

	@Override
	public int getArticleCount() {
		return qnaDaoService.getArticleCount();
	}

	@Override
	public void insertArticle(QnaVO article) {
		qnaDaoService.insertArticle(article);
	}

	@Override
	public int login_check(String id, String pass) {
		int status = 0;
		if (qnaDaoService.login_check(id) != null) {
			if (pass.equals(qnaDaoService.login_check(id))) {
				status = 1;
			} else {
				status = 2;
			}
		} else {
			status = 3;
		}
		return status;
	}

	@Override
	public QnaVO getArticle(int article_num) {
		return qnaDaoService.getArticle(article_num);
	}

	@Override
	public int getCommentNum(int article_num) {
		return qnaDaoService.getCommentNum(article_num);
	}

	@Override
	public QnaVO getUpdateArticle(int article_num) {
		return qnaDaoService.getUpdateArticle(article_num);
	}

	@Override
	public void UpdateArticle(int article_num, String title, String content) {
		qnaDaoService.UpdateArticle(article_num, title, content);
	}

	@Override
	public void deleteArticle(int article_num) {
		qnaDaoService.deleteArticle(article_num);
	}

	@Override
	public void reply(QnaVO article) {
		qnaDaoService.reply(article);
	}

	@Override
	public void addHit(int article_num) {
		qnaDaoService.addHit(article_num);
	}
	
	@Override
	public List<QnaCommentVO> insertComment(int article_num, String comment_content, String id) {
		return qnaDaoService.insertComment(article_num, comment_content, id);
	}

	@Override
	public List<QnaCommentVO> getAllComment(int article_num) {
		return qnaDaoService.getAllComment(article_num);
	}

}
