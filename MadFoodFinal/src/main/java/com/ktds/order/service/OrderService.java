package com.ktds.order.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ktds.order.vo.OrderVO;

public interface OrderService {
	public void insertOrder(HttpServletRequest req);

	public List<OrderVO> getOrderList(String id);
}
