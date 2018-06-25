package com.lijunyu.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lijunyu.spring.entity.User;
import com.lijunyu.spring.mapper.UserMapper;
import com.lijunyu.spring.service.UserService;


@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User login(User user)
	{
		return userMapper.findByIdAndPsw(user);
	}

	@Override
	public int register(User user)
	{
		return userMapper.register(user);
	}


}
