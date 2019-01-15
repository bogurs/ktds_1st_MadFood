package com.ktds.common;

public class PagingUtil {
	private int totalPage, startPage, endPage;
	private int startRow, endRow;
	private StringBuffer sb;

	public void paging(int pageNum, int count, int pageSize, int pageBlock) {
		totalPage = (int) Math.ceil((double) count / pageSize);
		startRow = (pageNum - 1) * pageSize + 1;
		endRow = pageNum * pageSize;

		startPage = (int) ((pageNum - 1) / pageBlock) * pageBlock + 1;
		endPage = startPage + pageBlock - 1;

		if (endPage > totalPage) {
			endPage = totalPage;
		}

		sb = new StringBuffer();
		if (startPage < pageBlock) {
			sb.append("<img src='resources/beforePage.jpg' width='40' height='15'>");
		} else {
			sb.append("<img src='resources/beforePage.jpg' width='40' height='15'");
			sb.append(" onclick='location.href=\"notice_list.ktds?pageNum=");
			sb.append(startPage - pageBlock);
			sb.append("\"' style='cursor:pointer'> ");
		}

		sb.append("&nbsp;|");
		for (int i = startPage; i <= endPage; i++) {
			if (i == pageNum) {
				sb.append("&nbsp;&nbsp;<b><font color='#91B7EF'>");
				sb.append(i);
				sb.append("</font></b>");
			} else {
				sb.append("&nbsp;&nbsp;<a href='notice_list.ktds?pageNum=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}

		sb.append("&nbsp;|");
		if (endPage < totalPage) {
			sb.append("<img src='resources/afterPage.jpg'  width='40' height='15'");
			sb.append(" onclick='location.href=\"notice_list.ktds?pageNum=");
			sb.append(startPage + pageBlock);
			sb.append("\"' style='cursor:pointer'> ");
		} else {
			sb.append("<img src='resources/afterPage.jpg'  width='40' height='15'>");

		}
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public StringBuffer getSb() {
		return sb;
	}
}
