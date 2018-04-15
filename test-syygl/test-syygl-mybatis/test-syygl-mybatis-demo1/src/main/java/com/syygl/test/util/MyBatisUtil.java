package com.syygl.test.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.syygl.test.Test1;

public class MyBatisUtil {

//	public static SqlSession getSqlSession() {
//		String resource = "conf.xml";
//		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
//		InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
//		// 构建sqlSession的工厂
//		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
//		SqlSession session = sessionFactory.openSession();
//		return session;
//	}
//
//	public static SqlSession getSqlSession(boolean b) {
//		String resource = "conf.xml";
//		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
//		InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
//		// 构建sqlSession的工厂
//		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
//		SqlSession session = sessionFactory.openSession();
//		return session;
//	}
	
	 /**
     * 获取SqlSessionFactory
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        String resource = "conf.xml";
        InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        return factory;
    }
    
    /**
     * 获取SqlSession
     * @return SqlSession
     */
    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession();
    }
    
    /**
     * 获取SqlSession
     * @param isAutoCommit 
     *         true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
     *         false 表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
     * @return SqlSession
     */
    public static SqlSession getSqlSession(boolean isAutoCommit) {
        return getSqlSessionFactory().openSession(isAutoCommit);
    }

}
