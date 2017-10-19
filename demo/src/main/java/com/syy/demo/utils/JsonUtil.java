package com.syy.demo.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class JsonUtil {

	public static void responseMessage(HttpServletResponse response, String message) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(message);
	}

}
