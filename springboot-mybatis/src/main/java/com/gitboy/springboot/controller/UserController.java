package com.gitboy.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gitboy.springboot.pojo.User;
import com.gitboy.springboot.service.UserService;
import com.github.pagehelper.PageInfo;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("findUserByName")
	public String findUserByName() {
		return null;

	}

	@RequestMapping("findAllUser")
	public List<User> findAllUser() {

		List<User> list = userService.findAllUser();
		return list;

	}

	@RequestMapping("/findUserList")
	public PageInfo<User> findUserList(int page, int size) {
		return userService.findUserList(page, size);
	}

}
