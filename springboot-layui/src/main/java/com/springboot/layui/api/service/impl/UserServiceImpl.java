package com.springboot.layui.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.layui.api.mapper.UserMapper;
import com.springboot.layui.api.pojo.User;
import com.springboot.layui.api.service.UserService;
import com.springboot.layui.utils.PageUtil;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public PageUtil<User> findUserByPage(int page, int limit) {
		
		PageUtil<User> pageUtil = new PageUtil<User>();
		
		Long count = userMapper.findCount();
		pageUtil.setCount(count);
		
		List<User> users = userMapper.findUserByPage(page,limit);
		
		pageUtil.setData(users);
		return pageUtil;
	}

}
