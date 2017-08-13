package com.sun.sb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@RequestMapping("/")
public class SampleController {
	@RequestMapping("/")
	String home(@Autowired HttpServletRequest request) {
		String user = "yuaner";
		request.setAttribute("user", user);
		return "index.html";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
	
	@RequestMapping("/todo")
	String todo() {
		return "Hello World2!";
	}

}
