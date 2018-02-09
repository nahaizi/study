package com.lijunyu.spring.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	private Log LOG = LogFactory.getLog(getClass());
	@Resource
	LoginService loginservice;
	
	/**
	 * 
	 * @Description: ��½����
	 * @param session
	 * @param data
	 * @return
	 * @return String
	 * @throws
	 * @author lijunyu
	 * @date 2018��2��9������5:40:14
	 *===========================================
	 * �޸��ˣ�lijunyu��    �޸�ʱ�䣺2018��2��9������5:40:14��    �޸İ汾��
	 * �޸ı�ע��TODO
	 *===========================================
	 */
	@RequestMapping(value="login", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody  
	public String login(HttpSession session,@RequestBody Map<String, Object> data){
//		SysAdmin admin = (SysAdmin) session.getAttribute(Constant.LOGIN_SESSION);  
//	          
//	        JSONObject json=new JSONObject(data);  
//	        User user=new User();  
//	      
//	        user.setPageNum(0);  
//	        user.setInsert_Date(json.getString("year"));  
	        //user.setInsert_Date(json.getString("year"));  
		LOG.info("-----------�_ʼ ��ԃ----------");
		User user = loginservice.selectUserById(10);
//		model.addAttribute("user",user);
		return "../jsp/Login.jsp";
	}
	
	
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
	public String find(HttpSession session,@RequestBody Map<String, Object> data){
		LOG.info("-----------�_ʼ ��ԃ----------");
		User user = loginservice.selectUserById(10);
//		model.addAttribute("user",user);
		return "../jsp/Login.jsp";
	}
}
