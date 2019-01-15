package com.ktds.order.dao;

import java.util.List;

import com.ktds.order.vo.OrderVO;

public interface OrderDaoService {
	public void insertOrder(int order_num, int dish_num, int count, String id);

	public int incrementOrder();

	public List<OrderVO> getOrderList(String id);
}
