package com.lijunyu.spring.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response,@RequestBody User userparam){
//		SysAdmin admin = (SysAdmin) session.getAttribute(Constant.LOGIN_SESSION);  
//	          
//	        JSONObject json=new JSONObject(data);  
//	        User user=new User();  
//	      
//	        user.setPageNum(0);  
//	        user.setInsert_Date(json.getString("year"));  
	        //user.setInsert_Date(json.getString("year"));  
		LOG.info("-----------开始查询用户----------");
		String username = (String) request.getAttribute("username");
		LOG.info("username: --------------------"+username+ "-------------------");
		String password = (String) request.getAttribute("password");
		LOG.info("password: --------------------"+password+ "-------------------");
		
		User user = loginservice.selectUserById(10);
//		model.addAttribute("user",user);
		
		try {
			response.sendRedirect("../jsp/user/UserList.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "../jsp/user/UserList.jsp";
	}
	
	@RequestMapping(value = "/login1.do", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody User userparam){
		LOG.info("-----------开始查询用户----------");
		String username = userparam.getUserName();
		LOG.info("username: --------------------"+username+ "-------------------");
		String password = userparam.getUserPassword();
		LOG.info("password: --------------------"+password+ "-------------------");
		
		User user = loginservice.selectUserById(10);
//		model.addAttribute("user",user);
		
		return "success";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/find.do")
	public String find(Model model){
		LOG.info("-----------开始检索----------");
		User user = loginservice.selectUserById(10);
		model.addAttribute("user",user);
		/**
	     * 使用forward跳转,传递基本类型参数到页面
	     *     注意:
	     *         1.使用springmvc 封装好的Model对象(底层就是request作用域)
	     */
		return "../jsp/user/UserList.jsp";
	}
	
	
	/**
     * 使用modelAndView
     *     注意事项
     *         modelAndView对象中的数据只能被ModelAndView对象的视图获取
     */
    @RequestMapping("/test2.do")
    public ModelAndView test2(ModelAndView modelAndView){
    	LOG.info("------------使用ModelAndView----------------");
        String name = "张小五";
        modelAndView.setViewName("../jsp/user/UserList.jsp");
        modelAndView.addObject("name", name);
        return  modelAndView;
         
    }
    
    @RequestMapping("/test3")
    public ModelAndView test3(){
    	LOG.info("------------使用ModelAndView----------------");
        String name = "张小六";
        return new ModelAndView("/login/test2.do", "name", name);
    }
}
