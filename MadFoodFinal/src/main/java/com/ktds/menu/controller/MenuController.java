package com.ktds.menu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.menu.service.MenuService;
import com.ktds.menu.vo.MenuVO;

@Controller
public class MenuController {

	private Logger logger = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;

	@RequestMapping("/menu1.menu")
	public ModelAndView FoodRegisterForm1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("menu_write");
		return mav;
	}

	@RequestMapping("/menu_write.menu")
	public ModelAndView registerMenu(MenuVO menuVO, HttpServletRequest req) throws IllegalStateException, IOException {
		HttpSession httpSession = req.getSession();
		String sessionId = (String) httpSession.getAttribute("id");
		logger.debug("sessionId: " + sessionId);

		menuVO.setId(sessionId);
		menuService.registerMenu(menuVO, req);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/menu_list.menu");
		return mav;
	}

	@RequestMapping("/menu_list.menu")
	public ModelAndView getMenu() {
		List<MenuVO> articleList = menuService.getMenu();

		ModelAndView mav = new ModelAndView();
		mav.addObject("articleList", articleList);
		mav.setViewName("menu_list");
		return mav;
	}

	@RequestMapping("/download.menu")
	public ModelAndView download(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("filename", new File(req.getParameter("fname")));
		mav.setViewName("downloadview");
		return mav;
	}

	@RequestMapping("/getInform.menu")
	public ModelAndView GetInform(@RequestParam int dish_num) {
		logger.debug("dish_num: " + dish_num);
		MenuVO article = menuService.GetInform(dish_num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", article);
		mav.setViewName("popupmenu");
		return mav;
	}

	@RequestMapping("/menudetail.menu")
	public ModelAndView showmenu(@ModelAttribute MenuVO article) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", article);
		mav.setViewName("menu_detail");
		return mav;
	}

	@RequestMapping("/menu_aside.menu")
	public ModelAndView menu_aside(@RequestParam int dish_num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("commentList", menuService.getAllComment(dish_num));
		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/getComment.menu")
	public ModelAndView getAllComment(@RequestParam int dish_num) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("commentList", menuService.getAllComment(dish_num));
		mav.setViewName("JSON");

		return mav;
	}

	@RequestMapping("/writeComment.menu")
	public ModelAndView insertComment(@RequestParam int dish_num, @RequestParam String comment_content,
			HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String id = (String) req.getSession().getAttribute("id");

		mav.addObject("commentList", menuService.insertComment(dish_num, comment_content, id));
		mav.setViewName("JSON");

		return mav;
	}

	@RequestMapping("/deleteMenu.menu")
	public ModelAndView deleteMenu(@RequestParam int dish_num) {
		ModelAndView mav = new ModelAndView();
		logger.debug("dish_num: " + dish_num);

		menuService.deleteMenu(dish_num);
		mav.setViewName("redirect:/menu_list.menu");
		return mav;
	}

}
