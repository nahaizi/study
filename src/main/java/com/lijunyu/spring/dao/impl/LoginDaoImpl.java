package com.lijunyu.spring.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.lijunyu.spring.dao.LoginDao;
import com.lijunyu.spring.entity.User;
@Repository  
public class LoginDaoImpl implements LoginDao {
	/**
	 * ÈÕÖ¾¼ÇÂ¼Æ÷
	 */
	private Logger logger = Logger.getLogger(LoginDaoImpl.class);
	@Override
	public User selectUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
