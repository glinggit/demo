package com.sun.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController2 {
	@RequestMapping(value = {"sc2","/todo"},method = RequestMethod.GET)
	String todo() {
		return "Hello World2!";
	}


}
