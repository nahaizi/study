package com.lijunyu.spring.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijunyu.spring.dao.LoginDao;
import com.lijunyu.spring.entity.User;
import com.lijunyu.spring.mapper.UserMapper;
import com.lijunyu.spring.service.LoginService;


/**
 * 
 * @Description: TODO
 * @version 1.0.2
 * @author lijunyu
 * @date 2018年3月1日下午7:34:06
 */
@Service
public class LoginServiceImpl implements LoginService {
	/**
	 * 
	 */
	private Logger LOG = Logger.getLogger(LoginServiceImpl.class);
	@Autowired  
	private LoginDao userDao; 
	@Autowired  
	private UserMapper usermapper;  
	
	@Override
	public User selectUserById(Integer userId) {  
		LOG.info("--------------查询用户苦苦-------------");
		return usermapper.selectUserById(userId);  
	}  
}
