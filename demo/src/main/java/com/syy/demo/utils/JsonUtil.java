package com.syy.demo.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class JsonUtil {

	public static void responseMessage(HttpServletResponse response,
			String message) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(message);
	}

	/**
	 * 返回数据拼接
	 * 
	 * @return
	 */
	public static String codeSYS(String code, String message, String data) {
		if (StringUtils.isEmpty(data)) {
			data = "{}";
		}
		return "{\"code\":\"" + code + "\",\"message\":\"" + message
				+ "\",\"data\":" + data + "}";
	}

	/**
	 * 业务请求正常返回数据
	 * 
	 * @param data
	 * @return
	 */
	public static String getDataStr(String data) {
		if (StringUtils.isEmpty(data)) {
			data = "{}";
		}
		return "{\"state\":\"200\",\"msg\":\"成功\",\"data\":" + data + "}";
	}

	/**
	 * 业务参数缺失报错
	 * 
	 * @param msg
	 * @return
	 */
	public static String code010(String msg) {
		return "{\"state\":\"010\",\"msg\":\"" + msg + "\",\"data\":{}}";
	}

	/**
	 * 与业务规则不符
	 */
	public static String code011(String msg) {
		return "{\"state\":\"011\",\"msg\":\"" + msg + "\",\"data\":{}}";
	}

	/**
	 * 系统流程异常
	 */
	public static String code012(String msg) {
		return "{\"state\":\"012\",\"msg\":\"" + msg + "\",\"data\":{}}";
	}

	/**
	 * 系统业务处理超时
	 */
	public static String code013(String msg) {
		return "{\"state\":\"013\",\"msg\":\"" + msg + "\",\"data\":{}}";
	}

}
