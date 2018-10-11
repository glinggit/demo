package com.syy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syy.demo.dao.UserDao;
import com.syy.demo.entity.User;
import com.syy.demo.service.inter.IDemoService;

@Service
public class DemoService implements IDemoService{
	@Autowired
	private UserDao userDao;

	public String getDemoValue() {
		User u = userDao.getById(1);
		System.out.println(u.getUserName());
		return u.getUserName();
	}

	@Override
	public int save(User user) {
		int num = userDao.save(user);
		return num;
	}

}
