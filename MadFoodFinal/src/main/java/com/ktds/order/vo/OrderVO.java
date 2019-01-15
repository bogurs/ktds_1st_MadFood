package com.ktds.order.vo;

import java.sql.Timestamp;

public class OrderVO {
	private int dish_num;
	private String id;
	private String title;
	private int price;
	private String menu_content;
	private String menu_kind;
	private String pic_name;
	private int order_num;
	private Timestamp order_date;
	private int count;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMenu_content() {
		return menu_content;
	}

	public void setMenu_content(String menu_content) {
		this.menu_content = menu_content;
	}

	public String getMenu_kind() {
		return menu_kind;
	}

	public void setMenu_kind(String menu_kind) {
		this.menu_kind = menu_kind;
	}

	public String getPic_name() {
		return pic_name;
	}

	public void setPic_name(String pic_name) {
		this.pic_name = pic_name;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public Timestamp getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + dish_num;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((menu_content == null) ? 0 : menu_content.hashCode());
		result = prime * result + ((menu_kind == null) ? 0 : menu_kind.hashCode());
		result = prime * result + ((order_date == null) ? 0 : order_date.hashCode());
		result = prime * result + order_num;
		result = prime * result + ((pic_name == null) ? 0 : pic_name.hashCode());
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderVO other = (OrderVO) obj;
		if (count != other.count)
			return false;
		if (dish_num != other.dish_num)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (menu_content == null) {
			if (other.menu_content != null)
				return false;
		} else if (!menu_content.equals(other.menu_content))
			return false;
		if (menu_kind == null) {
			if (other.menu_kind != null)
				return false;
		} else if (!menu_kind.equals(other.menu_kind))
			return false;
		if (order_date == null) {
			if (other.order_date != null)
				return false;
		} else if (!order_date.equals(other.order_date))
			return false;
		if (order_num != other.order_num)
			return false;
		if (pic_name == null) {
			if (other.pic_name != null)
				return false;
		} else if (!pic_name.equals(other.pic_name))
			return false;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderVO [dish_num=" + dish_num + ", id=" + id + ", title=" + title + ", price=" + price
				+ ", menu_content=" + menu_content + ", menu_kind=" + menu_kind + ", pic_name=" + pic_name
				+ ", order_num=" + order_num + ", order_date=" + order_date + ", count=" + count + "]";
	}

}
