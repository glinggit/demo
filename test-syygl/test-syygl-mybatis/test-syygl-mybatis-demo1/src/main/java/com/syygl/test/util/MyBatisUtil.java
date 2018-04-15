package com.syygl.test.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.syygl.test.Test1;

public class MyBatisUtil {

//	public static SqlSession getSqlSession() {
//		String resource = "conf.xml";
//		// ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
//		InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
//		// ����sqlSession�Ĺ���
//		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
//		SqlSession session = sessionFactory.openSession();
//		return session;
//	}
//
//	public static SqlSession getSqlSession(boolean b) {
//		String resource = "conf.xml";
//		// ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
//		InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
//		// ����sqlSession�Ĺ���
//		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
//		SqlSession session = sessionFactory.openSession();
//		return session;
//	}
	
	 /**
     * ��ȡSqlSessionFactory
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        String resource = "conf.xml";
        InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        return factory;
    }
    
    /**
     * ��ȡSqlSession
     * @return SqlSession
     */
    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession();
    }
    
    /**
     * ��ȡSqlSession
     * @param isAutoCommit 
     *         true ��ʾ������SqlSession������ִ����SQL֮����Զ��ύ����
     *         false ��ʾ������SqlSession������ִ����SQL֮�󲻻��Զ��ύ������ʱ����Ҫ�����ֶ�����sqlSession.commit()�ύ����
     * @return SqlSession
     */
    public static SqlSession getSqlSession(boolean isAutoCommit) {
        return getSqlSessionFactory().openSession(isAutoCommit);
    }

}
