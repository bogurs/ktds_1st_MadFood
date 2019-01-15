package com.ktds.notice.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ktds.notice.dao.NoticeDaoService;
import com.ktds.notice.vo.NoticeCommentVO;
import com.ktds.notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDaoService noticeDaoService;

	@Override
	public List<NoticeVO> getArticles(int startRow, int endRow) {
		return noticeDaoService.getArticles(startRow, endRow);
	}

	@Override
	public int getArticleCount() {
		return noticeDaoService.getArticleCount();
	}

	@Override
	public NoticeVO getArticle(int article_num) {
		return noticeDaoService.getArticle(article_num);
	}

	@Override
	public int getCommentNum(int article_num) {
		return noticeDaoService.getCommentNum(article_num);
	}

	@Override
	public void insertArticle(NoticeVO article, HttpServletRequest req) {
		MultipartFile mtf = article.getIbatisfname();
		try {
			if (!mtf.getOriginalFilename().equals("")) {
				String realFolder = req.getSession().getServletContext().getRealPath("/menuitem/");
				mtf.transferTo(new File(realFolder + mtf.getOriginalFilename()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		noticeDaoService.insertArticle(article);
	}

	@Override
	public NoticeVO getUpdateArticle(int article_num) {
		return noticeDaoService.getUpdateArticle(article_num);
	}

	@Override
	public void UpdateArticle(int article_num, String title, String content) {
		noticeDaoService.UpdateArticle(article_num, title, content);
	}

	@Override
	public void deleteArticle(int article_num) {
		noticeDaoService.deleteArticle(article_num);
	}

	@Override
	public void reply(NoticeVO article, HttpServletRequest req) {
		MultipartFile mtf = article.getIbatisfname();
		try {
			if (!mtf.getOriginalFilename().equals("")) {
				String realFolder = req.getSession().getServletContext().getRealPath("/menuitem/");
				mtf.transferTo(new File(realFolder + mtf.getOriginalFilename()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		noticeDaoService.reply(article);
	}

	@Override
	public void addHit(int article_num) {
		noticeDaoService.addHit(article_num);
	}
	
	@Override
	public List<NoticeCommentVO> insertComment(int article_num, String comment_content, String id) {
		return noticeDaoService.insertComment(article_num, comment_content, id);
	}

	@Override
	public List<NoticeCommentVO> getAllComment(int article_num) {
		return noticeDaoService.getAllComment(article_num);
	}
}
