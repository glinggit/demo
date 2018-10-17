package com.syy.demo.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syy.demo.entity.User;
import com.syy.demo.service.inter.IDemoService;
import com.syy.demo.service.inter.IUserService;
import com.syy.demo.thread.TestThread;
import com.syy.demo.utils.JsonUtil;
import com.syy.demo.utils.VerifyCodeUtils;

@Controller
@RequestMapping("/demo")
public class DemoController extends ApplicationObjectSupport {

	@Autowired
	private IDemoService demoService;

	@Autowired
	private IUserService userService;

	@RequestMapping(params = "method=index")
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		User user = new User();
		user.setUserName("syygl");
		
		demoService.save(user);
		
		String demoValue = demoService.getDemoValue();
		System.out.println(demoValue);
		logger.info(demoValue + new Date());
		logger.debug(demoValue + new Date());
		logger.error(demoValue + new Date());

		JsonUtil.responseMessage(response, JsonUtil.codeSYS("200", "成功", demoValue));
	}

	@RequestMapping(params = "method=getUser")
	public String getUser(HttpServletRequest request,
			HttpServletResponse response) {
		List<User> listUser = userService.findAll();

		System.out.println(listUser.size());
		
		

		return "index";
	}
	
	@RequestMapping(params = "method=testThread")
	public void testThread(HttpServletRequest request,
			HttpServletResponse response) {
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		
		for(int i=0; i<1000; i++){
			TestThread tt = new TestThread(userService, i);
			es.execute(tt);
		}
		
		
		
		
	}
	
	@RequestMapping("/getVerifyCode")
	public void getVerifyCode(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        //存入会话session  
        HttpSession session = request.getSession(true);  
        session.setAttribute("rand", verifyCode.toLowerCase());  
        //生成图片  
        int w = 200, h = 80;  
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);  
		
	}
	
}
