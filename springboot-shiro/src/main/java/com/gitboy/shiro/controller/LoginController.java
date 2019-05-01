package com.gitboy.shiro.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gitboy.shiro.pojo.User;
import com.gitboy.shiro.service.UserService;


@Controller
public class LoginController {

	@Resource
	UserService userService;
	
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/login.do")
	public String login(String username, String password, Model model) {
		// 判断用户名密码是否为空
		if (username != null && !"".equals(username) && password != null && !"".equals(password)) {
			// 进行登录验证
			Subject subject = SecurityUtils.getSubject();
			// 创建验证用的令牌对象
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
				subject.login(token);
				boolean flag = subject.isAuthenticated();
				if(flag){
					System.out.println("登录成功！");
					//获取当前用对象，放入到session中
					User user = (User)subject.getPrincipal();
					subject.getSession().setAttribute("user",user);
					return "redirect:userList.do";
				}else{
					model.addAttribute("msg","登录认证失败！");
					return "login";
				}
			
			} catch (Exception e) {
				model.addAttribute("msg","登录认证失败！");
				//e.printStackTrace();
				return "login";
			}
		}
		return "success";
	}
	@RequestMapping("/userList.do")
	public String userList(Model model){
		//查询所有的用户信息并且显示到页面上
		List<User> list = userService.findAll();
		model.addAttribute("userList", list);
		return "userList";
	}
	@RequestMapping("/unFunc.do")
	public String noFunc(){
		return "unFunc";
	}
}
