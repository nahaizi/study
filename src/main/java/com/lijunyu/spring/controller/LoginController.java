package com.lijunyu.spring.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lijunyu.spring.entity.User;
import com.lijunyu.spring.entity.Userdto;
import com.lijunyu.spring.service.LoginService;

/**
 * 
 * @Description: TODO
 * @version 1.0.2
 * @author lijunyu
 * @date 2018年3月1日上午11:21:59
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
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login.do")
    public String login(HttpServletRequest request, HttpServletResponse response){
//        SysAdmin admin = (SysAdmin) session.getAttribute(Constant.LOGIN_SESSION);  
//              
//            JSONObject json=new JSONObject(data);  
//            User user=new User();  
//          
//            user.setPageNum(0);  
//            user.setInsert_Date(json.getString("year"));  
            //user.setInsert_Date(json.getString("year"));  
        LOG.info("-----------login.do----------");
        String username = (String) request.getAttribute("username");
        LOG.info("username: --------------------" + username + "-------------------");
        String password = (String) request.getAttribute("password");
        LOG.info("password: --------------------" + password+ "-------------------");

		response.setContentType("application/json");// 设置响应内容格式为json
        User user = loginservice.selectUserById(10);
//        model.addAttribute("user",user);
        request.setAttribute("res","success");
        try {
            response.sendRedirect("../jsp/user/UserList.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "user/UserList";
    }
    
    @ResponseBody
    @RequestMapping(value = "/login1.do", method = {RequestMethod.POST })
    public String login(@RequestBody Userdto userparam){
//         JSONArray arrs = JSONArray.fromObject(userparam);
        LOG.info("-----------login1.do----------");
        String username = userparam.getUsername();
        LOG.info("username: --------------------"+username+ "-------------------");
        String password = userparam.getPassword();
        LOG.info("password: --------------------"+password+ "-------------------");
        
        User user = loginservice.selectUserById(10);
//        model.addAttribute("user",user);
        return "jsp/OK.jsp";
    }
    
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping("/find.do")
    public String find(Model model){
        LOG.info("-----------find.do----------");
        User user = loginservice.selectUserById(10);
        model.addAttribute("user",user);
        /**
         * 
         */
        return "user/UserList";
    }
    
    
    /**
     * 
     * @Description: TODO
     * @param modelAndView
     * @return
     * @return ModelAndView
     * @throws
     * @author lijunyu
     * @date 2018年3月1日上午11:24:00
     *===========================================
     * 修改人：lijunyu，    修改时间：2018年3月1日上午11:24:00，    修改版本：
     * 修改备注：TODO
     *===========================================
     */
    @RequestMapping("/test2.do")
    public ModelAndView test2(ModelAndView modelAndView){
        LOG.info("------------浣跨敤ModelAndView----------------");
        String name = "呵呵呵呵";
        LOG.info("----------" + name + "-------------");
        modelAndView.setViewName("jsp/user/UserList.jsp");
        modelAndView.addObject("name", name);
        return  modelAndView;
         
    }
    
    @RequestMapping("/test3")
    public ModelAndView test3(){
        LOG.info("------------test3----------------");
        String name = "lijunyu";
        return new ModelAndView("/login/test2.do", "name", name);
    }
    
    @RequestMapping("/test.do")
    public ModelAndView test(){
//        ModelAndView mav=new ModelAndView("/user/test.do");
//        mav.addObject("time", new Date());
//        mav.getModel().put("name", "caoyc");
        
        return new ModelAndView("/user/test.do", "name", "caoyc");
    }
    
    /**
     * 
     * @Description: TODO
     * @param user
     * @throws IOException
     * @return void
     * @throws
     * @author lijunyu
     * @date 2018年3月1日下午7:05:53
     *===========================================
     * 修改人：lijunyu，    修改时间：2018年3月1日下午7:05:53，    修改版本：
     * 修改备注：TODO
     *===========================================
     */
    public void createHadoopFSFolder(User user) throws IOException {  
        Configuration conf = new Configuration();  
        conf.addResource(new Path("/opt/hadoop-1.2.1/conf/core-site.xml"));  
        conf.addResource(new Path("/opt/hadoop-1.2.1/conf/hdfs-site.xml"));  
        FileSystem fileSystem = FileSystem.get(conf);  
        System.out.println(fileSystem.getUri());  
        Path file = new Path("/user/" + user.getUsername());  
        if (fileSystem.exists(file)) {  
            System.out.println("haddop hdfs user foler  exists.");  
            fileSystem.delete(file, true);  
            System.out.println("haddop hdfs user foler  delete success.");  
        }  
        fileSystem.mkdirs(file);  
        System.out.println("haddop hdfs user foler  creat success.");  
    }  
}
