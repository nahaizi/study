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
 * @Description: ��¼ҳ��
 * @version 1.0.2
 * @author lijunyu
 * @date 2017��8��22������5:58:36
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	//��־
	private Logger LOG = Logger.getLogger(LoginController.class);
	@Resource
	LoginService loginservice;
	
	
	/**
	 * 
	 * @Description: ��ѯ����
	 * @param model
	 * @return
	 * @return String
	 * @throws
	 * @author lijunyu
	 * @date 2017��8��22������6:00:26
	 *===========================================
	 * �޸��ˣ�lijunyu��    �޸�ʱ�䣺2017��8��22������6:00:26��    �޸İ汾��
	 * �޸ı�ע��
	 *===========================================
	 */
	@RequestMapping("/find.do")
	public String find(Model model){
		LOG.info("-----------�_ʼ ��ԃ----------");
		User user = loginservice.selectUserById(10);
		model.addAttribute("user",user);
		return "../jsp/Login.jsp";
	}
}
