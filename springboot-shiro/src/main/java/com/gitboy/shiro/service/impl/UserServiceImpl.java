package com.gitboy.shiro.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gitboy.shiro.mapper.FunctionMapper;
import com.gitboy.shiro.mapper.UserMapper;
import com.gitboy.shiro.pojo.Function;
import com.gitboy.shiro.pojo.User;
import com.gitboy.shiro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserMapper userMapper;
	@Resource
	FunctionMapper functionMapper;
	@Override
	public User findByUsername(String username) {
		return userMapper.login(username);
	}
	@Override
	public List<User> findAll() {
		
		return userMapper.findAll();
	}
	@Override
	public List<Function> findFuncByUserId(Integer userId) {
		return functionMapper.findFunctionByUserId(userId);
	}
}
