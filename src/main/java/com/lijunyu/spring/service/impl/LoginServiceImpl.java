package com.lijunyu.spring.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijunyu.spring.dao.LoginDao;
import com.lijunyu.spring.entity.User;
import com.lijunyu.spring.service.LoginService;

/**
 * 
 * @Description: ��¼ҳ���߼�
 * @version 1.0.2
 * @author lijunyu
 * @date 2017��8��22������6:03:42
 */
@Service
public class LoginServiceImpl implements LoginService {
	/**
	 * ��־��¼��
	 */
	private Logger LOG = Logger.getLogger(LoginServiceImpl.class);
	@Autowired  
	private LoginDao userDao;  
	@Override
	public User selectUserById(Integer userId) {  
		LOG.info("--------------ҵ���߼���-------------");
		return userDao.selectUserById(userId);  
	}  
}
