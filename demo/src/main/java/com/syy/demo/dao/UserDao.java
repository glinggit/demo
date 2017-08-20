package com.syy.demo.dao;

import java.util.List;

import com.syy.demo.entity.User;

public interface UserDao {

	public User getById(Integer id);

	public List<User> findAll();

	public Integer save(User entity); 
	
}
