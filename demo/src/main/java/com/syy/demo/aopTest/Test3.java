package com.syy.demo.aopTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
	//@Test
	@SuppressWarnings("resource")
	public void testAop() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/aop.xml");

		Dao dao = (Dao) ac.getBean("daoImpl");
		dao.insert();
		System.out.println("----------分割线----------");
		dao.delete();
		System.out.println("----------分割线----------");
		dao.update();
	}

}
