package com.syy.demo.aopTest;

import net.sf.cglib.proxy.Enhancer;

public class Test2 {
	public static void main(String[] args) {
		DaoProxy daoProxy = new DaoProxy();

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(DaoImpl.class);
		enhancer.setCallback(daoProxy);

		Dao dao = (DaoImpl) enhancer.create();
		dao.insert();
		System.out.println("----------分割线----------");
		dao.delete();
		System.out.println("----------分割线----------");
		dao.update();

	}
}
