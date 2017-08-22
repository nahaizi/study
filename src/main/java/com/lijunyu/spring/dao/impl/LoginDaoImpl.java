package com.lijunyu.spring.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.lijunyu.spring.dao.LoginDao;
import com.lijunyu.spring.entity.User;
/**
 * 
 * @Description: 登录页面dao层
 * @version 1.0.2
 * @author lijunyu
 * @date 2017年8月22日下午6:04:23
 */
@Repository  
public class LoginDaoImpl implements LoginDao {
	/**
	 * 日志记录器
	 */
	private Logger LOG = Logger.getLogger(LoginDaoImpl.class);
	
	/**
	 * 
	 */
	@Override
	public User selectUserById(Integer userId) {
		LOG.info("--------------开始查询-------------");
		// TODO Auto-generated method stub
//		this.;
		return null;
	}

}
