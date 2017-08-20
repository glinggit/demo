package com.syy.demo.test.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.syy.demo.entity.User;
import com.syy.demo.service.inter.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath*:config/springconf/db/demo-context-core.xml" }) 
public class TestUserService {
	private static final Logger LOGGER = Logger.getLogger(TestUserService.class);  
	@Autowired
	private IUserService userService;  
  
//    @Test  
//    public void testGetById() {  
//        //测试查询对应的用户  
//        User User = userService.getById(1);  
//        LOGGER.info(JSON.toJSONStringWithDateFormat(User,  
//                "yyyy-MM-dd HH:mm:ss"));  
//    }  
  
    @Test  
    public void testFindAll() {  
        //测试查询全部用户  
        List<User> Users = userService.findAll();  
        for (User User : Users) {  
            LOGGER.info(JSON.toJSONStringWithDateFormat(User,  
                    "yyyy-MM-dd HH:mm:ss"));  
        }  
    }  
  
//    @Test  
//    public void testSave() {  
//        //测试保存用户数据  
//        User User = new User();  
//        User.setUserName("xiaohonghong");  
//        int result = userService.save(User);  
//        LOGGER.info("result = " + result);  
//    }  
}
