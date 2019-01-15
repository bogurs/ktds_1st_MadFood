package com.ktds.order.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.order.dao.OrderDaoService;
import com.ktds.order.vo.OrderVO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDaoService orderDaoService;

	@Override
	public void insertOrder(HttpServletRequest req) {
		String[] dish_num = req.getParameterValues("dish_num");
		String[] count = req.getParameterValues("count");
		String id = (String) req.getSession().getAttribute("id");

		int order_num = orderDaoService.incrementOrder();

		for (int i = 0; i < dish_num.length; i++) {
			orderDaoService.insertOrder(order_num, Integer.parseInt(dish_num[i]), Integer.parseInt(count[i]), id);
		}

	}

	@Override
	public List<OrderVO> getOrderList(String id) {
		return orderDaoService.getOrderList(id);
	}

}
