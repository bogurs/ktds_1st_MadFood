package com.ktds.qna.controller;

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
import com.ktds.qna.service.QnaService;
import com.ktds.qna.vo.QnaVO;

@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@RequestMapping("/go_login.ktds")
	public ModelAndView go_login(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");

		return mav;
	}

	@RequestMapping("/login.ktds")
	public ModelAndView login(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		if (req.getParameter("id").equals("")) {
			mav.addObject("login_error", 1);
			mav.setViewName("login_error");
			return mav;
		} else if (req.getParameter("pass").equals("")) {
			mav.addObject("login_error", 2);
			mav.setViewName("login_error");
			return mav;
		} else {
			String id = req.getParameter("id"); // ktds(id)값이 넘어옴
			String pass = req.getParameter("pass"); // 1234(pass)값이 넘어옴
			int status = qnaService.login_check(id, pass);
			// id와 pass를 넘겨서 BqsOracleDao에서 메소드로 처리한다
			if (status == 1) {// 그냥 세션을 부르면 불러오지 못한다(jsp내에서만 불러낼 수 있다)
				// servlet context(application내장객체의 타입)
				HttpSession hs = req.getSession();
				hs.setAttribute("id", id);
				mav.setViewName("loginok");
				return mav;
			} else if (status == 2) {
				mav.addObject("login_error", 3);
				mav.setViewName("login_error");
				return mav;
			} else {
				mav.addObject("login_error", 4);
				mav.setViewName("login_error");
				return mav;
			}
		}
	}

	@RequestMapping("/logout.ktds")
	public String logout(HttpServletRequest req) {

		try {
			HttpSession hs = req.getSession();
			// 세션의 값을 받아온다(로그인이 되어 있으므로 이 경우에는 id가 할당되어 있다)
			hs.invalidate();// 세션 비활성화
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/main.ktds";
	}

	@RequestMapping("/main.ktds")
	public ModelAndView main(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");

		return mav;
	}

	@RequestMapping("/qna_list.ktds")
	public ModelAndView qna_list(HttpServletRequest req) {
		int count = 0;
		String pageCode;
		List<QnaVO> articleList;
		PagingUtil pagingUtil = new PagingUtil();

		String pageNum = req.getParameter("pageNum");// 페이지 번호O
		if (pageNum == null) {
			pageNum = "1";
		}

		try {
			count = qnaService.getArticleCount();// 전체 글의 수
		} catch (Exception e) {

		}

		int pageSize = 10;// 한 페이지의 글의 갯수
		int pageBlock = 10; // 한블럭에 보여줄 페이지 갯수

		pagingUtil.paging(Integer.parseInt(pageNum), count, pageSize, pageBlock);
		pageCode = pagingUtil.getSb().toString();

		if (count > 0) {
			articleList = qnaService.getArticles(pagingUtil.getStartRow(), pagingUtil.getEndRow());// 현재 페이지에 해당하는 글 목록
		} else {
			articleList = null;
		}
		ModelAndView mav = new ModelAndView();
		// 해당 뷰에서 사용할 속성 //request 객체에 심는 과정 //심지 않고는 class에서 jsp로 값을 넘겨줄 수 없다.
		mav.addObject("count", count); // 총 글의 개수
		mav.addObject("pageNum", pageNum);
		mav.addObject("pageCode", pageCode);
		mav.addObject("articleList", articleList);
		mav.setViewName("qna_list");

		return mav;
	}

	@RequestMapping("/qna_writeForm.ktds")
	public ModelAndView writeForm(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		HttpSession hs = req.getSession();
		// getSession으로 세션에 할당된 id값을 가져올 때 사용
		if (hs.getAttribute("id") != null) {
			// 세션에 id값이 있는 경우
			mav.addObject("pageNum", req.getParameter("pageNum"));
			mav.setViewName("qna_write");
			return mav;
			// 바로 글쓰기 양식으로 간다
		} else {
			hs.setAttribute("logined", "ok");
			mav.setViewName("login");
			return mav;
			// 세션에 id가 없는 경우 logined문자열을 세션에 할당하고 login jsp에 넘긴다
		}
	}

	@RequestMapping("/qna_writeOk.ktds") // @ModelAttribute는 생략이 가능하다.
	public ModelAndView qna_writeOk(QnaVO article, HttpServletRequest req, @RequestParam String pageNum) {
		ModelAndView mav = new ModelAndView();
		article.setId((String) req.getSession().getAttribute("id"));// 세션에서 id값 얻음

		try {
			if (article.getTitle().equals("") || article.getContent().equals("")) {
				mav.addObject("pageNum", pageNum);
				mav.addObject("write_error", 1);
				mav.setViewName("qna_write");
				return mav;
			} else {
				qnaService.insertArticle(article); // 할당한 값들을 boardVO 객체를 이용해 넘겨줌
				mav.setViewName("redirect:/qna_list.ktds");
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping("/qna_content.ktds")
	public ModelAndView qna_content(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		QnaVO qnaBoardVO = new QnaVO();
		int commentNum = 0;

		try {
			qnaBoardVO = qnaService.getArticle(Integer.parseInt(req.getParameter("article_num")));
			// 글 내용에 보여줄 값들(제목, 내용, 파일)을 가져온다

			if ((String) req.getSession().getAttribute("id") != qnaBoardVO.getId()) {
				qnaService.addHit(Integer.parseInt(req.getParameter("article_num")));
			}
			// 조회수를 늘려주는 메서드

			commentNum = qnaService.getCommentNum(Integer.parseInt(req.getParameter("article_num")));
			// 글 내용 아래 댓글의 수를 표시하기 위한 메서드
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("article", qnaBoardVO);
		mav.addObject("pageNum", req.getParameter("pageNum"));
		mav.addObject("commentNum", commentNum);
		// request객체에 article객체(컨텐트 정보를 담고 있다), 페이지숫자(항상 달고다닌다), 댓글의 수를 심는다.
		mav.setViewName("qna_content");
		return mav;
	}

	@RequestMapping("/qna_updateForm.ktds")
	public ModelAndView qna_updateForm(@RequestParam int article_num, @RequestParam String pageNum) {
		ModelAndView mav = new ModelAndView();
		QnaVO qnaBoardVO = new QnaVO();

		try {// 제목과 본문내용만 가져올 것(전부 가져오지 말고)
			qnaBoardVO = qnaService.getUpdateArticle(article_num);
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("article", qnaBoardVO);
		mav.addObject("article_num", article_num);
		mav.addObject("pageNum", pageNum);

		mav.setViewName("qna_update");
		return mav;

	}

	@RequestMapping("/qna_update.ktds")
	public ModelAndView qna_update(@RequestParam int article_num, @RequestParam String pageNum,
			@RequestParam String title, @RequestParam String content, HttpServletRequest req) throws IOException {
		ModelAndView mav = new ModelAndView();
		QnaVO qnaBoardVO = new QnaVO();

		qnaBoardVO.setId((String) req.getSession().getAttribute("id"));
		try {
			if (title.equals("") || content.equals("")) {
				mav.addObject("pageNum", pageNum);
				mav.addObject("update_error", 1);
				mav.setViewName("qna_update");
				return mav;
			} else {
				qnaService.UpdateArticle(article_num, title, content);
				mav.setViewName("redirect:/qna_content.ktds?pageNum=" + pageNum + "&article_num=" + article_num);
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping("/qna_delete.ktds")
	public String qna_delete(HttpServletRequest req) throws SQLException, IOException {
		int article_num = Integer.parseInt(req.getParameter("article_num"));
		String pageNum = req.getParameter("pageNum");

		qnaService.deleteArticle(article_num);
		return "redirect:/qna_list.ktds?pageNum=" + pageNum;
	}

	@RequestMapping("/qna_replyForm.ktds")
	public ModelAndView qna_replyForm(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("depth", req.getParameter("depth"));
		mav.addObject("pos", req.getParameter("pos"));
		mav.addObject("pageNum", req.getParameter("pageNum"));
		mav.addObject("group_id", req.getParameter("group_id"));

		mav.setViewName("qna_replyForm");
		return mav;
	}

	@RequestMapping("/qna_reply.ktds")
	public ModelAndView qna_reply(QnaVO article, HttpServletRequest req) throws IOException {
		ModelAndView mav = new ModelAndView();

		article.setId((String) req.getSession().getAttribute("id"));
		try {
			if (article.getTitle().equals("") || article.getContent().equals("")) {
				mav.addObject("pageNum", req.getParameter("pageNum"));
				mav.addObject("reply_error", 1);
				mav.setViewName("qna_replyForm");
				return mav;
			} else {
				qnaService.reply(article); // 답글을 입력하기 위한 메서드 호출
				mav.setViewName("redirect:/qna_list.ktds?pageNum=" + req.getParameter("pageNum"));
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping("/commentRead.qna")
	public ModelAndView commentRead(@RequestParam int article_num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("commentList", qnaService.getAllComment(article_num));
		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/commentWrite.qna")
	public ModelAndView commentWrite(@RequestParam int article_num, @RequestParam String comment_content,
			HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("commentWrite",
				qnaService.insertComment(article_num, comment_content, (String) req.getSession().getAttribute("id")));
		mav.setViewName("JSON");
		return mav;
	}
	
}
