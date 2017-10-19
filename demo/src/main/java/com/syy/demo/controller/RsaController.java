package com.syy.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syy.demo.utils.JsonUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/rsa")
public class RsaController extends ApplicationObjectSupport {


	@RequestMapping(params = "method=getRsa")
	public void getRsa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("result", "1");
		maps.put("rsa", "桂玲我爱你");
		JSONObject json = JSONObject.fromObject(maps);
		JsonUtil.responseMessage(response, json.toString());

	}
	
}
