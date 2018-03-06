package com.syy.demo.utils.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;

public class Test {
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		InvocationHandler invocationHandler = new UserInvocationHandler(userService);

		UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
				userService.getClass().getInterfaces(), invocationHandler);

		System.out.println(userServiceProxy.getName(1));
		System.out.println(userServiceProxy.getAge(1));

		CglibMethodInterceptor cglibProxy = new CglibMethodInterceptor();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserServiceImpl.class);
		enhancer.setCallback(cglibProxy);
		UserService o = (UserService) enhancer.create();
		o.getName(1);
		o.getAge(1);
	}
}
