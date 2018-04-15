package com.syygl.test.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syygl.test.mybatis.service.IUserService;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/getUserList", produces = "text/html;charset=UTF-8")
	@ResponseBody
	private String getUserList() {
		String json = userService.getUserList();
		return json;
	}
}
