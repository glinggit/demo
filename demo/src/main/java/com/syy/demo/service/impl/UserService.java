package com.syy.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
