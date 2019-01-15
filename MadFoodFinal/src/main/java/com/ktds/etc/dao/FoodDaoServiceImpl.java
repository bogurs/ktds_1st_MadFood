package com.ktds.etc.dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.ktds.etc.vo.JoinVO;

@Repository
public class FoodDaoServiceImpl implements FoodDaoService {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public void join(JoinVO article) throws SQLException {
		sqlMapClientTemplate.insert("join", article);
		System.out.println(article.getName());
	}

	public int searchId(String id) throws SQLException {
		String idcheck = "";
		int status = 0;

		idcheck = (String) sqlMapClientTemplate.queryForObject("searchId", id);
		System.out.println(idcheck + "1");
		if (idcheck != null) {
			status = 1; // 아이디가 있다는 소리임
		} else
			status = 0; // 아이디없다

		return status;
	}

}
