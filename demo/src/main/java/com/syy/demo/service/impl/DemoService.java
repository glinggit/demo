package com.syy.demo.service.impl;

import org.springframework.stereotype.Service;

import com.syy.demo.service.inter.IDemoService;

@Service
public class DemoService implements IDemoService{

	public String getDemoValue() {
		return "你好呀";
	}

}
