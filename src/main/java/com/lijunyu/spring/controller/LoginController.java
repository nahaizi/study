package com.lijunyu.spring.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lijunyu.spring.entity.User;
import com.lijunyu.spring.service.LoginService;

/**
 * 
 * @Description: 登录页面
 * @version 1.0.2
 * @author lijunyu
 * @date 2017年8月22日下午5:58:36
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	//日志
	private Logger LOG = Logger.getLogger(LoginController.class);
	@Resource
	LoginService loginservice;
	
	
	/**
	 * 
	 * @Description: 查询方法
	 * @param model
	 * @return
	 * @return String
	 * @throws
	 * @author lijunyu
	 * @date 2017年8月22日下午6:00:26
	 *===========================================
	 * 修改人：lijunyu，    修改时间：2017年8月22日下午6:00:26，    修改版本：
	 * 修改备注：
	 *===========================================
	 */
	@RequestMapping("/find.do")
	public String find(Model model){
		LOG.info("-----------開始 查詢----------");
		User user = loginservice.selectUserById(10);
		model.addAttribute("user",user);
		return "../jsp/Login.jsp";
	}
}
