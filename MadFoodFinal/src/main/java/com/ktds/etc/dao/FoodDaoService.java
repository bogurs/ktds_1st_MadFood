package com.ktds.etc.dao;

import java.sql.SQLException;

import com.ktds.etc.vo.JoinVO;

public interface FoodDaoService {

	public void join(JoinVO article) throws SQLException;

	public int searchId(String id) throws SQLException;

}