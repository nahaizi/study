package com.lijunyu.spring.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.lijunyu.spring.dao.LoginDao;
import com.lijunyu.spring.entity.User;
/**
 * 
 * @Description: ��¼ҳ��dao��
 * @version 1.0.2
 * @author lijunyu
 * @date 2017��8��22������6:04:23
 */
@Repository  
public class LoginDaoImpl implements LoginDao {
	/**
	 * ��־��¼��
	 */
	private Logger LOG = Logger.getLogger(LoginDaoImpl.class);
	
	/**
	 * 
	 */
	@Override
	public User selectUserById(Integer userId) {
		LOG.info("--------------��ʼ��ѯ-------------");
		// TODO Auto-generated method stub
//		this.;
		return null;
	}

}
