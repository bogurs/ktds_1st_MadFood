package com.ktds.notice.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.common.PagingUtil;
import com.ktds.notice.service.NoticeService;
import com.ktds.notice.vo.NoticeVO;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("/notice_list.notice")
	public ModelAndView list(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		PagingUtil pagingUtil = new PagingUtil();
		String pageCode;
		int count = 0;
		List<NoticeVO> articleList;

		String pageNum = req.getParameter("pageNum");// 페이지 번호O
		if (pageNum == null) {
			pageNum = "1";
		}

		count = noticeService.getArticleCount();// 전체 글의 수

		int pageSize = 10;// 한 페이지의 글의 갯수
		int pageBlock = 10; // 한블럭에 보여줄 페이지 갯수

		pagingUtil.paging(Integer.parseInt(pageNum), count, pageSize, pageBlock);
		pageCode = pagingUtil.getSb().toString();

		if (count > 0) {
			articleList = noticeService.getArticles(pagingUtil.getStartRow(), pagingUtil.getEndRow());// 현재 페이지에 해당하는 글 목록
		} else {
			articleList = null;
		}

		mav = new ModelAndView();
		// 해당 뷰에서 사용할 속성 //request 객체에 심는 과정 //심지 않고는 class에서 jsp로 값을 넘겨줄 수 없다.
		mav.addObject("count", count); // 총 글의 개수
		mav.addObject("pageNum", pageNum);
		mav.addObject("pageCode", pageCode);
		mav.addObject("articleList", articleList); // arraylist내부에 들어있는 값을 출력해야
													// 하는데 for문을 쓰지 않고 jstl을 이용해
													// 쉽게 출력한다.
		mav.setViewName("notice_list");

		return mav;
	}

	@RequestMapping("/notice_content.notice")
	public ModelAndView content(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		NoticeVO article = new NoticeVO();
		int commentNum = 0;

		try {
			article = noticeService.getArticle(Integer.parseInt(req.getParameter("article_num")));
			// 글 내용에 보여줄 값들(제목, 내용, 파일)을 가져온다

			if ((String) req.getSession().getAttribute("id") != article.getId()) {
				noticeService.addHit(Integer.parseInt(req.getParameter("article_num")));
			}

			commentNum = noticeService.getCommentNum(Integer.parseInt(req.getParameter("article_num")));
			// 글 내용 아래 댓글의 수를 표시하기 위한 메서드
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("article", article);
		mav.addObject("pageNum", req.getParameter("pageNum"));
		mav.addObject("commentNum", commentNum);
		// request객체에 article객체(컨텐트 정보를 담고 있다), 페이지숫자(항상 달고다닌다), 댓글의 수를 심는다.
		mav.setViewName("notice_content");
		return mav;
	}

	@RequestMapping("/notice_writeForm.notice")
	public ModelAndView writeForm(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		String pageNum = req.getParameter("pageNum");// 페이지 번호O
		if (pageNum == null) {
			pageNum = "1";
		}

		HttpSession hs = req.getSession();
		// getSession으로 세션에 할당된 id값을 가져올 때 사용
		if (hs.getAttribute("id") != null) {
			// 세션에 id값이 있는 경우
			mav.addObject("pageNum", pageNum);
			mav.setViewName("notice_write");
			return mav;
			// 바로 글쓰기 양식으로 간다
		} else {
			hs.setAttribute("logined", "ok");
			mav.setViewName("login");
			return mav;
			// 세션에 id가 없는 경우 logined문자열을 세션에 할당하고 login jsp에 넘긴다
		}
	}

	@RequestMapping("/notice_write.notice")
	// @ModelAttribute는 생략이 가능하다.
	public ModelAndView write(NoticeVO article, HttpServletRequest req, @RequestParam String pageNum) {
		ModelAndView mav = new ModelAndView();

		article.setId((String) req.getSession().getAttribute("id"));// 세션에서 id값
																	// 얻음
		try {
			if (article.getTitle().equals("") || article.getContent().equals("")) {
				mav.addObject("pageNum", pageNum);
				mav.addObject("write_error", 1);
				mav.setViewName("notice_writeForm");
				return mav;
			} else {
				noticeService.insertArticle(article, req); // 할당한 값들을 boardVO 객체를 이용해 넘겨줌
				mav.setViewName("redirect:/notice_list.notice");
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping("/notice_download.notice")
	// @ModelAttribute는 생략이 가능하다.
	public ModelAndView download(@RequestParam String fname, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String realFolder = req.getSession().getServletContext().getRealPath("/menuitem/");
		mav.addObject("filename", new File(realFolder + fname));
		mav.setViewName("downloadview");
		return mav;
	}

	@RequestMapping("/notice_updateForm.notice")
	public ModelAndView updateForm(@RequestParam int article_num, @RequestParam String pageNum) {
		ModelAndView mav = new ModelAndView();
		NoticeVO article = new NoticeVO();

		try {// 제목과 본문내용만 가져올 것(전부 가져오지 말고)
			article = noticeService.getUpdateArticle(article_num);
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("article", article);
		mav.addObject("article_num", article_num);
		mav.addObject("pageNum", pageNum);

		mav.setViewName("notice_update");
		return mav;

	}

	@RequestMapping("/notice_update.notice")
	public String update(@RequestParam int article_num, @RequestParam String pageNum, @RequestParam String title,
			@RequestParam String content, HttpServletRequest req) throws IOException {
		NoticeVO article = new NoticeVO();
		article.setId((String) req.getSession().getAttribute("id"));
		try {
			noticeService.UpdateArticle(article_num, title, content);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/notice_content.notice?pageNum=" + pageNum + "&article_num=" + article_num;
	}

	@RequestMapping("/notice_delete.notice")
	public String delete(HttpServletRequest req) throws SQLException, IOException {
		int article_num = Integer.parseInt(req.getParameter("article_num"));
		String pageNum = req.getParameter("pageNum");

		noticeService.deleteArticle(article_num);
		return "redirect:/notice_list.notice?pageNum=" + pageNum;
	}

	@RequestMapping("/notice_replyForm.notice")
	public ModelAndView replyForm(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("depth", req.getParameter("depth"));
		mav.addObject("pos", req.getParameter("pos"));
		mav.addObject("pageNum", req.getParameter("pageNum"));
		mav.addObject("group_id", req.getParameter("group_id"));

		mav.setViewName("notice_replyForm");
		return mav;
	}

	@RequestMapping("/notice_reply.notice")
	public String reply(NoticeVO article, HttpServletRequest req) throws IOException {
		article.setId((String) req.getSession().getAttribute("id"));
		try {
			noticeService.reply(article, req); // 답글을 입력하기 위한 메서드 호출
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/notice_list.notice?pageNum=" + req.getParameter("pageNum");

	}

	@RequestMapping("/list.notice")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		return mav;
	}
	
	@RequestMapping("/commentRead.notice")
	public ModelAndView commentRead(@RequestParam int article_num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("commentList", noticeService.getAllComment(article_num));
		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/commentWrite.notice")
	public ModelAndView commentWrite(@RequestParam int article_num, @RequestParam String comment_content,
			HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("commentWrite",
				noticeService.insertComment(article_num, comment_content, (String) req.getSession().getAttribute("id")));
		mav.setViewName("JSON");
		return mav;
	}

}
