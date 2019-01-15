package com.ktds.etc.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.etc.dao.FoodDaoService;
import com.ktds.etc.vo.JoinVO;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	FoodDaoService food;

	@Override
	public void join(JoinVO article) throws SQLException {
		food.join(article);
	}

	@Override
	public int searchId(String id) throws SQLException {
		int status = 0;
		status = food.searchId(id);
		return status;
	}

}
