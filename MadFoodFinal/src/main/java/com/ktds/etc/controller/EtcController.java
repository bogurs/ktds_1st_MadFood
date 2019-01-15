package com.ktds.etc.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.etc.service.FoodService;
import com.ktds.etc.vo.JoinVO;

@Controller
public class EtcController {
	
	@Autowired
	private FoodService foodService;

	@RequestMapping("/card.etc")
	public ModelAndView card() {
		ModelAndView mav = new ModelAndView();
		mav = new ModelAndView();
		mav.setViewName("card");
		return mav;
	}

	@RequestMapping("/event.etc")
	public ModelAndView event() {
		ModelAndView mav = new ModelAndView();
		mav = new ModelAndView();
		mav.setViewName("event");
		return mav;
	}

	@RequestMapping("/list.etc")
	public ModelAndView list(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav = new ModelAndView();
		mav.setViewName("list");
		return mav;
	}

	@RequestMapping("/joinView.etc")
	public ModelAndView joinView(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav = new ModelAndView();
		mav.setViewName("joinForm");
		return mav;
	}

	@RequestMapping("/join.etc")
	public ModelAndView join(@ModelAttribute JoinVO article, HttpServletRequest req) throws SQLException {
		ModelAndView mav = new ModelAndView();
		article.setMileage(1000);
		foodService.join(article);
		mav.setViewName("thanks");
		return mav;
	}

	@RequestMapping("/searchId.etc")
	public ModelAndView searchId(String id) throws SQLException {
		ModelAndView mav = new ModelAndView();
		mav = new ModelAndView();
		mav.addObject("status", foodService.searchId(id));
		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/star.etc")
	public ModelAndView star() throws SQLException {
		ModelAndView mav = new ModelAndView();
		mav = new ModelAndView();
		mav.setViewName("star");
		return mav;
	}

	@RequestMapping("/searchBranch.etc")
	public ModelAndView searchBranch() {
		ModelAndView mav = new ModelAndView();
		mav = new ModelAndView();
		mav.setViewName("searchbranch");
		return mav;
	}

	@RequestMapping("/branchintroduce.etc")
	public ModelAndView branchintroduce(int selectedOptionNum) {
		ModelAndView mav = new ModelAndView();
		mav = new ModelAndView();
		if (selectedOptionNum == 0)
			return null;
		else if (selectedOptionNum == 1)
			mav.setViewName("1ho");
		else if (selectedOptionNum == 2)
			mav.setViewName("2ho");
		return mav;
	}

	@RequestMapping("/menu.etc")
	public ModelAndView menu() {
		ModelAndView mav = new ModelAndView();
		mav = new ModelAndView();
		mav.setViewName("menu");
		return mav;
	}

}
