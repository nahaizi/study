package com.lijunyu.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijunyu.spring.dao.LoginDao;
import com.lijunyu.spring.dao.impl.LoginDaoImpl;
import com.lijunyu.spring.entity.User;
import com.lijunyu.spring.service.LoginService;

@Service
public class LoginServiceImpl  implements LoginService {
	@Autowired  
	private LoginDao userDao;  
	@Override
	public User selectUserById(Integer userId) {  
		return userDao.selectUserById(userId);  
		
	}  
}
