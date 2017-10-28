package com.syy.demo.thread;

import com.syy.demo.service.inter.IUserService;

public class TestThread implements Runnable{
	
	private IUserService userService;
	private int taskNum;
	
	public TestThread(IUserService userService, int taskNum){
		this.userService = userService;
		this.taskNum = taskNum;
	}
	

	public void run() {
		userService.update(taskNum);
	}

}
