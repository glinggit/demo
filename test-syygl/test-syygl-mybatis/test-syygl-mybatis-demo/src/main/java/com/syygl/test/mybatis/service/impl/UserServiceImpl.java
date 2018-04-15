package com.syygl.test.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.syygl.test.mybatis.dao.UserMapper;
import com.syygl.test.mybatis.model.User;
import com.syygl.test.mybatis.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired  
    private UserMapper userMapper;

	@Override
	public String getUserList() {
		User user = userMapper.selectByPrimaryKey(1);
		
		
		return JSON.toJSONString(user);
	}

}
