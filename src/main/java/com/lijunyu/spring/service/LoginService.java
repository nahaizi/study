package com.lijunyu.spring.service;

import com.lijunyu.spring.entity.User;

public interface LoginService {
	User selectUserById(Integer userId);  
}
