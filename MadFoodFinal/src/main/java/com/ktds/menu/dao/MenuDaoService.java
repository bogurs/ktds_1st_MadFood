package com.ktds.menu.dao;

import java.util.List;

import com.ktds.menu.vo.CommentVO;
import com.ktds.menu.vo.MenuVO;

public interface MenuDaoService {

	public void registerMenu(MenuVO article);

	public List<MenuVO> getMenu();

	public MenuVO GetInform(int dish_num);

	public List<CommentVO> getAllComment(int dish_num);

	public List<CommentVO> insertComment(int dish_num, String comment_content, String id);

	// delete_menu
	public void deleteMenu(int dish_num);
}
