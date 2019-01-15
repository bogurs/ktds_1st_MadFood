package com.ktds.notice.vo;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

public class DownLoadImpl extends AbstractView {
	
	private Logger logger = LoggerFactory.getLogger(DownLoadImpl.class);

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String fileName = null;
		File file = (File) model.get("filename");

		res.setContentType("application/download");
		int length = (int) file.length();
		res.setContentLength(length);

		String userAgent = req.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("MSIE") > -1;

		if (ie) {// +는 파일이 저장될 때 공백이 생기는 경우 공백을 처리하기 위해 주어진 것으로 %20은 공백을 다시 생성하는 것이다
			fileName = URLEncoder.encode(file.getName(), "utf-8").replace("+", "%20");
			logger.debug("익스플로러");
		} else {
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1").replace("+", "%20");
			logger.debug("익스플로러 아닌 브라우저");
		}

		res.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		OutputStream out = res.getOutputStream();
		FileInputStream fis = null;

		try {
			int temp;
			fis = new FileInputStream(file);
			while ((temp = fis.read()) != -1) {
				out.write(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}
