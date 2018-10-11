package com.syy.demo.aopTest;

/**
 * 最原始的添加日志
 * @author pp
 *
 */
public class ServiceImpl {

	//private Dao dao = new DaoImpl();
	private Dao dao = new LogDao(new DaoImpl());

	public void insert() {
		//System.out.println("insert()方法开始时间：" + System.currentTimeMillis());
		dao.insert();
		//System.out.println("insert()方法结束时间：" + System.currentTimeMillis());
	}

	public void delete() {
		dao.delete();
	}

	public void update() {
		//System.out.println("update()方法开始时间：" + System.currentTimeMillis());
		dao.update();
		//System.out.println("update()方法结束时间：" + System.currentTimeMillis());
	}

}
