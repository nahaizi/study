package com.lijunyu.spring.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
@RequestMapping("/logintest")
public class Login {
	private Log LOG = LogFactory.getLog(getClass());
	  //方式一  
    @RequestMapping("/login.do")  
    public String login(@RequestParam("username") String username,  
                        @RequestParam("password") String password,Model model){  
        if (username.equals(password))   
        {  
    		LOG.info("username: --------------------"+username+ "-------------------");
    		LOG.info("password: --------------------"+password+ "-------------------");
            model.addAttribute("username", username); 
            model.addAttribute("user", username);
            return "user/login";  
        } else {  
            return "NO";  
        }  
    }  
    //方式二
    @RequestMapping("/login2.do") 
    public String login2(String username,String password,Model model){  
		LOG.info("username: --------------------"+username+ "-------------------");
		LOG.info("password: --------------------"+password+ "-------------------");
        if (username.equals(password))   
        {  
            model.addAttribute("username", username);  
            return "jsp/OK.jsp";  
        } else {  
            return "jsp/NO.jsp";  
        }  
    }  
    
    
}
