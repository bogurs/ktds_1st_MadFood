package com.ktds.order.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.ktds.order.vo.OrderVO;

@Repository
public class OrderDaoServiceImpl implements OrderDaoService {
	
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	public void insertOrder(int order_num, int dish_num, int count, String id) {
		HashMap<String, Object> hm = new HashMap<>();

		hm.put("order_num", order_num);
		hm.put("dish_num", dish_num);
		hm.put("count", count);
		hm.put("id", id);

		System.out.println(hm.get("order_num"));
		System.out.println(hm.get("dish_num"));
		System.out.println(hm.get("count"));
		System.out.println(hm.get("id"));
		sqlMapClientTemplate.insert("insertOrder", hm);
	}

	@Override
	public int incrementOrder() {
		return (int) sqlMapClientTemplate.queryForObject("updateOrder");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderVO> getOrderList(String id) {
		return sqlMapClientTemplate.queryForList("getOrderList", id);
	}

}
