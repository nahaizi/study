package com.lijunyu.spring.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lijunyu.spring.entity.User;
import com.lijunyu.spring.service.LoginService;  
  

//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner  
@RunWith(SpringJUnit4ClassRunner.class)  
//指定bean注入的配置文件  
@ContextConfiguration(locations = { "classpath:/config/spring-servlet.xml" })  
public class Springtest {
    @Autowired  
    private LoginService userService;  
//    org.slf4j.Logger logger = LoggerFactory.getLogger(Springtest.class);  
    private static Logger logger = LogManager.getLogger(Springtest.class.getName());
    @Test  
    public void selectUserByIdTest(){  
    	logger.debug("开始.........");
        User user = userService.selectUserById(10);  
        logger.debug("查找结果" + user);  
    }  
}
