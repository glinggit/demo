package com.syy.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syy.demo.entity.User;
import com.syy.demo.service.inter.IDemoService;
import com.syy.demo.service.inter.IUserService;

@Controller
@RequestMapping("/demo")
public class DemoController extends ApplicationObjectSupport {

	@Autowired
	private IDemoService demoService;
	
	@Autowired
	private IUserService userService;

	
	
	

	@RequestMapping(params = "method=index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		String demoValue = demoService.getDemoValue();
		System.out.println(demoValue);
		logger.info(demoValue + new Date());
		logger.debug(demoValue + new Date());
		logger.error(demoValue + new Date());
		
		
		return "index";
	}
	
	@RequestMapping(params = "method=getUser")
	public String getUser(HttpServletRequest request, HttpServletResponse response) {
		List<User> listUser = userService.findAll();
		
		System.out.println(listUser.size());
		
		return "index";
	}
}
