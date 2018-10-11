package com.syy.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.syy.demo.dao.UserDao;
import com.syy.demo.entity.User;

@Repository("userDao")  
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;


	public User getById(Integer id) {

		String sql = "SELECT * FROM user WHERE id = ? for update";

		User user = jdbcTemplate.queryForObject(sql, new User(), new Object[] { id });

		return user;
	}

	public List<User> findAll() {
		String sql = " SELECT * FROM user ";
		List<User> userInfos = null;
		System.out.println(jdbcTemplate);
		jdbcTemplate.execute(sql);
		return userInfos;
	}

	public Integer save(User entity) {

		String sql = "INSERT INTO user(userName) VALUES(100),(200),(300)";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("uname", entity.getUserName());
		int result = jdbcTemplate.update(sql);

		return result;
	}

	public void update(String name) {
		String sql = "update user set userName = " + name + " where id = 1";
		jdbcTemplate.execute(sql);
		
	}
}
