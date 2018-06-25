package com.lijunyu.spring.mapper;

import com.lijunyu.spring.entity.User;

public interface UserMapper
{
	User findById(String id);
	User findByIdAndPsw(User user);
	int register(User user);
	User selectUserById(Integer userId);  
}
