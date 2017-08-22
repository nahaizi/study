package com.lijunyu.spring.dao;

import com.lijunyu.spring.entity.User;

public interface LoginDao {
	 public User selectUserById(Integer userId);  
}
