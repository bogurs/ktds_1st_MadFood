package com.ktds.menu.vo;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class MenuVO {
	private int dish_num;
	private String id;
	private String title;
	private String price;
	private String menu_content;
	private Timestamp menu_date;
	private MultipartFile mpic_name;
	private String menu_kind;
	private String pic_name;

	public int getDish_num() {
		return dish_num;
	}

	public void setDish_num(int dish_num) {
		this.dish_num = dish_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMenu_content() {
		return menu_content;
	}

	public void setMenu_content(String menu_content) {
		this.menu_content = menu_content;
	}

	public Timestamp getMenu_date() {
		return menu_date;
	}

	public void setMenu_date(Timestamp menu_date) {
		this.menu_date = menu_date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public MultipartFile getmpic_name() {
		return mpic_name;
	}

	public void setmpic_name(MultipartFile mpic_name) {
		this.mpic_name = mpic_name;
	}

	public String getMenu_kind() {
		return menu_kind;
	}

	public void setMenu_kind(String menu_kind) {
		this.menu_kind = menu_kind;
	}

	public String getpic_name() {
		return pic_name;
	}

	public void setpic_name(String pic_name) {
		this.pic_name = pic_name;
	}

	@Override
	public String toString() {
		return "MenuVO [dish_num=" + dish_num + ", id=" + id + ", title=" + title + ", price=" + price
				+ ", menu_content=" + menu_content + ", menu_date=" + menu_date + ", mpic_name=" + mpic_name
				+ ", menu_kind=" + menu_kind + ", pic_name=" + pic_name + "]";
	}

}
