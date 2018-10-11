package com.syy.demo.service.inter;

import com.syy.demo.entity.User;

public interface IDemoService {
	public String getDemoValue();
	
	public int save(User user);
}
