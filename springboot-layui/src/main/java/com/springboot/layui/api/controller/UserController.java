package com.springboot.layui.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.layui.api.pojo.User;
import com.springboot.layui.api.pojo.UserVo;
import com.springboot.layui.api.service.UserService;
import com.springboot.layui.utils.PageUtil;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("findUserByPage")
	public PageUtil<User> findUserByPage(UserVo userVo) {
		//page=1&limit=10
		return userService.findUserByPage(userVo.getPage(),userVo.getLimit());

	}
}
