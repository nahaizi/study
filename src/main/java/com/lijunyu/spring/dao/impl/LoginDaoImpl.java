package com.lijunyu.spring.dao.impl;

import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
@Repository("LoginDaoImpl") 
public class LoginDaoImpl implements LoginDao {
	/**
	 * ��־��¼��
	 */
	private Log LOG = LogFactory.getLog(getClass());
	
	@Autowired  
	private SqlSessionTemplate sqlSession; 
	/**
	 * 
	 */
	@Override
	public User selectUserById(Integer userId) {
		LOG.info("--------------开始查询-------------");
		InputStream in;
		User user = new User();
//		try {
//			in = Resources.getResourceAsStream("com/lijunyu/spring/mapper/UserMapper.xml");
//			
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//			//��ȡsession
//			SqlSession session = sqlSessionFactory.openSession();
//			//����mapper�ӿ�ʵ��
//			LoginDao userMapper = session.getMapper(LoginDao.class);
//			user = userMapper.selectUserById(10);
			
			
			user = sqlSession.selectOne("com.lijunyu.spring.dao.LoginDao.selectUserById", 10);  
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return user;
	}

}
