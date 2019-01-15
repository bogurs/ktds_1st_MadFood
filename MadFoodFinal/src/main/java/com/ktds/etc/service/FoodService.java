package com.ktds.etc.service;

import java.sql.SQLException;

import com.ktds.etc.vo.JoinVO;

public interface FoodService {

	public void join(JoinVO article) throws SQLException;

	public int searchId(String id) throws SQLException;

}
