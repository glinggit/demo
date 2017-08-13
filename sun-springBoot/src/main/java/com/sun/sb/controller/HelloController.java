package com.sun.sb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
public class HelloController {
	private String user;

	@RequestMapping("/")
	public String helloworld() {
		HttpServletRequest req = (HttpServletRequest)RequestContextHolder.getRequestAttributes();
		this.user = "yuaner";
		req.setAttribute("user", user);
		return "index.html";
	}

	@RequestMapping("/hello/{name}")
	public String hellName(@PathVariable String name) {
		return "Hello " + name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	
}
