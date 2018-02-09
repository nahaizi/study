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
 * @Description: 登录页面
 * @version 1.0.2
 * @author lijunyu
 * @date 2017年8月22日下午5:58:36
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	//日志
	private Log LOG = LogFactory.getLog(getClass());
	@Resource
	LoginService loginservice;
	
	/**
	 * 
	 * @Description: 登陆方法
	 * @param session
	 * @param data
	 * @return
	 * @return String
	 * @throws
	 * @author lijunyu
	 * @date 2018年2月9日下午5:40:14
	 *===========================================
	 * 修改人：lijunyu，    修改时间：2018年2月9日下午5:40:14，    修改版本：
	 * 修改备注：TODO
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
		LOG.info("-----------開始 查詢----------");
		User user = loginservice.selectUserById(10);
//		model.addAttribute("user",user);
		return "../jsp/Login.jsp";
	}
	
	
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
	public String find(HttpSession session,@RequestBody Map<String, Object> data){
		LOG.info("-----------開始 查詢----------");
		User user = loginservice.selectUserById(10);
//		model.addAttribute("user",user);
		return "../jsp/Login.jsp";
	}
}
