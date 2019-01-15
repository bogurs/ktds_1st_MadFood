package com.ktds.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.order.service.OrderService;
import com.ktds.order.vo.OrderVO;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/menu_order.order")
	public ModelAndView insertOrder(HttpServletRequest req) {
		orderService.insertOrder(req);
		ModelAndView mav = new ModelAndView();
		mav.addObject("orderOK", 1);
		mav.setViewName("redirect:/menu_list.menu");
		return mav;
	}

	@RequestMapping("/order_list.order")
	public ModelAndView order_list(HttpServletRequest req) {
		String id = (String) req.getSession().getAttribute("id");
		List<OrderVO> articleList = orderService.getOrderList(id);

		int sum = 0;
		for (int i = 0; i < articleList.size(); i++) {
			sum += articleList.get(i).getPrice() * articleList.get(i).getCount();
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("articleList", articleList);
		mav.addObject("sum", sum);
		mav.setViewName("order_list");
		return mav;
	}

}
