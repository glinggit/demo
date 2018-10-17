package com.syy.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syy.demo.dao.UserDao;
import com.syy.demo.entity.User;
import com.syy.demo.service.inter.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired  
    private UserDao userDao; 

	public User getById(Integer id) {
		return userDao.getById(id);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public Integer save(User user) {
		return userDao.save(user);
	}

	@Transactional
	public void update(int taskNum) {
		User user = userDao.getById(1);
		System.out.println(taskNum + ">>>>>>>" + user.getUserName());
		
		String name = (Integer.parseInt(user.getUserName()) - 1) + "";
		System.out.println(taskNum + "<<<<<<<<" + name);
		
		userDao.update(name);
		
	}

	@Override
	public String getRandomNum4User(String userId) {
		//给userId分配一个随机的红包ID
		
		return null;
	}


}
