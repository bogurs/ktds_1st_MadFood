package com.ktds.menu.dao;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.ktds.menu.vo.CommentVO;
import com.ktds.menu.vo.MenuVO;

@Repository
public class MenuDaoServiceImpl implements MenuDaoService {
	
	private Logger logger = LoggerFactory.getLogger(MenuDaoServiceImpl.class);
	
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	public void registerMenu(MenuVO article) {
		sqlMapClientTemplate.insert("registerMenu", article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuVO> getMenu() {
		return sqlMapClientTemplate.queryForList("getMenu");
	}

	@Override
	public MenuVO GetInform(int dish_num) {
		return (MenuVO) sqlMapClientTemplate.queryForObject("GetInform", dish_num);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentVO> getAllComment(int dish_num) {
		return sqlMapClientTemplate.queryForList("getAllFoodComment", dish_num);
	}

	@Override
	public List<CommentVO> insertComment(int dish_num, String comment_content, String id) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("dish_num", dish_num);
		hm.put("comment_content", comment_content);
		hm.put("id", id);

		logger.debug("id: " + id);
		sqlMapClientTemplate.insert("insertFoodComment", hm);
		return getAllComment(dish_num);
	}

	@Override
	public void deleteMenu(int dish_num) {
		// 글 삭제를 위한 메서드(게시판 테이블과 게시판을 위한 댓글 테이블에 해당 글번호를 갖는 모든 레코드를 삭제한다)
		sqlMapClientTemplate.delete("deleteMenu", dish_num);
		sqlMapClientTemplate.delete("deleteMenuComment", dish_num);
	}

}
