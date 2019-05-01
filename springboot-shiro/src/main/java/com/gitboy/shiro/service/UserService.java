package com.gitboy.shiro.service;

import java.util.List;

import com.gitboy.shiro.pojo.Function;
import com.gitboy.shiro.pojo.User;

public interface UserService {
	public User findByUsername(String username);

	public List<User> findAll();

	public List<Function> findFuncByUserId(Integer userId);
}
