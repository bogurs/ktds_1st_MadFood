package com.ktds.menu.vo;

import java.sql.Timestamp;

public class CommentVO {
	private int menucomment_num;
	private String id;
	private String comment_content;
	private Timestamp comment_date;
	private int dish_num;

	public int getMenucomment_num() {
		return menucomment_num;
	}

	public void setMenucomment_num(int menucomment_num) {
		this.menucomment_num = menucomment_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public Timestamp getComment_date() {
		return comment_date;
	}

	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}

	public int getDish_num() {
		return dish_num;
	}

	public void setDish_num(int dish_num) {
		this.dish_num = dish_num;
	}

	@Override
	public String toString() {
		return "CommentVO [menucomment_num=" + menucomment_num + ", id=" + id + ", comment_content=" + comment_content
				+ ", comment_date=" + comment_date + ", dish_num=" + dish_num + "]";
	}

}
