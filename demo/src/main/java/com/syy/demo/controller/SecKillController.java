package com.syy.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syy.demo.service.inter.IUserService;


@Controller
@RequestMapping("/seckill")
public class SecKillController {
	@Autowired
	private IUserService userService;
	
	
	
	
	
	
	public String getRandomNum4User() {
		//模拟不同的用户
		String userId = UUID.randomUUID().toString().replace("-", "");
		
		String num = userService.getRandomNum4User(userId);
		
		return "";
	}
}
