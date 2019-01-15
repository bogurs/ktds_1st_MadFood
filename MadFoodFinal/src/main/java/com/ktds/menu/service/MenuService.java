package com.ktds.menu.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ktds.menu.vo.CommentVO;
import com.ktds.menu.vo.MenuVO;

public interface MenuService {
	public void registerMenu(MenuVO article, HttpServletRequest req) throws IllegalStateException, IOException;

	public List<MenuVO> getMenu();

	public MenuVO GetInform(int dish_num);

	public List<CommentVO> getAllComment(int dish_num);

	public List<CommentVO> insertComment(int dish_num, String comment_content, String id);

	// delete_menu
	public void deleteMenu(int dish_num);
}
