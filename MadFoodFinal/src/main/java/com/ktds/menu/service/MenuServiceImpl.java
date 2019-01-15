package com.ktds.menu.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ktds.menu.dao.MenuDaoService;
import com.ktds.menu.vo.CommentVO;
import com.ktds.menu.vo.MenuVO;

@Service
public class MenuServiceImpl implements MenuService {
	
	private Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

	@Autowired
	MenuDaoService menuDaoService;

	@Override
	public void registerMenu(MenuVO article, HttpServletRequest req) throws IllegalStateException, IOException {

		MultipartFile multipartFile = article.getmpic_name();
		// if(mtf!=null)
		// 에러남...화일을 업로드 하거나 안하거나 전부 null은 아님
		// 따라서 화일 업로드를 하지 않으면... 업로드 경로의 폴더를 만들려고해서
		// 존재하는 디렉토리 이므로 에러가 남
		logger.debug("MenuVO writer: " + article.getId());
		logger.debug("MenuVO dish_num: " + article.getDish_num());
		logger.debug("MenuVO content: " + article.getMenu_content());
		logger.debug("MenuVO menu_kind: " + article.getMenu_kind());
		logger.debug("MenuVO price: " + article.getPrice());
		logger.debug("MenuVO title: " + article.getTitle());
		logger.debug("filename: " + multipartFile.getOriginalFilename());

		if (!multipartFile.getOriginalFilename().equals("")) {
			// if(mtf!=null){
			// 단순히 mtf가 널이냐 아니냐 물어봐도 되긴하다.
			String realFolder = req.getSession().getServletContext().getRealPath("/menuitem/");
			multipartFile.transferTo(new File(realFolder + multipartFile.getOriginalFilename()));
		}
		menuDaoService.registerMenu(article);
	}

	@Override
	public List<MenuVO> getMenu() {
		return menuDaoService.getMenu();
	}

	@Override
	public MenuVO GetInform(int dish_num) {
		return menuDaoService.GetInform(dish_num);

	}

	@Override
	public List<CommentVO> getAllComment(int dish_num) {
		return menuDaoService.getAllComment(dish_num);
	}

	@Override
	public List<CommentVO> insertComment(int dish_num, String comment_content, String id) {
		return menuDaoService.insertComment(dish_num, comment_content, id);
	}

	@Override
	public void deleteMenu(int dish_num) {
		menuDaoService.deleteMenu(dish_num);
	}

}
