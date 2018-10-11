package com.syy.demo.aopTest;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		// ServiceImpl sImpl = new ServiceImpl();
		// sImpl.delete();
		// sImpl.insert();
		// sImpl.update();

		Dao dao = new DaoImpl();

		Dao proxyDao = (Dao) Proxy.newProxyInstance(LogInvocationHandler.class.getClassLoader(),
				new Class<?>[] { Dao.class }, new LogInvocationHandler(dao));

		proxyDao.insert();
		System.out.println("----------分割线----------");
		proxyDao.delete();
		System.out.println("----------分割线----------");
		proxyDao.update();

	}
}
