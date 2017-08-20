package com.syy.demo.service.inter;

import java.util.List;

import com.syy.demo.entity.User;

public interface IUserService {
	// 通过Id查询UserInfo  
    User getById(Integer id);  
  
    // 查询全部的UserInfo  
    List<User> findAll();  
  
    // 添加UserInfo  
    Integer save(User user);
}
