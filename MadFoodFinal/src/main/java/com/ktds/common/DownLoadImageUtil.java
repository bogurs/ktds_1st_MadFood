package com.ktds.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class DownLoadImageUtil extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String realFolder = req.getSession().getServletContext().getRealPath("/menuitem/");
		File file = (File) model.get("filename");
		OutputStream out = res.getOutputStream();
		FileInputStream fis = null;
		try {
			int temp;
			fis = new FileInputStream(realFolder + file.getName());
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

				}
			}
		}
	}
}
