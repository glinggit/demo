package com.syy.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syy.demo.service.inter.IDemoService;

@Controller
@RequestMapping("/demo")
public class DemoController extends ApplicationObjectSupport {

	@Autowired
	private IDemoService demoService;


	@RequestMapping(params = "method=index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		String demoValue = demoService.getDemoValue();
		System.out.println(demoValue);
		logger.info(demoValue + new Date());
		logger.debug(demoValue + new Date());
		logger.error(demoValue + new Date());
		
		
		return "index";
	}
}
