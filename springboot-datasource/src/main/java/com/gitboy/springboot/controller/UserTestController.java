package com.gitboy.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gitboy.springboot.pojo.User;
import com.gitboy.springboot.test01.service.UserTest1Service;
import com.gitboy.springboot.test02.service.UserTest2Service;
import com.github.pagehelper.PageInfo;

@RestController
public class UserTestController {

	@Autowired
	private UserTest1Service userTest1Service;
	
	@Autowired
	private UserTest2Service userTest2Service;
	
	@RequestMapping("userTest1")
	public List<User> userTest1() {
		
		return userTest1Service.findAllUserTest1();
		
	}
	@RequestMapping("userTest2")
	public List<User> userTest2() {
		List<User> list = userTest2Service.findAllUserTest2();
		return list;
		
	}
	@RequestMapping("findUserListTest1")
	public PageInfo<User> findUserListTest1(int page, int size) {
		return userTest1Service.findUserListTest1(page, size);
	}
	@RequestMapping("findUserListTest2")
	public PageInfo<User> findUserListTest2(int page, int size) {
		return userTest2Service.findUserListTest2(page, size);
	}
}
