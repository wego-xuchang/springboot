package com.gitboy.shiro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gitboy.shiro.pojo.User;


@Mapper
public interface UserMapper {

	public User login(String username);
	
	public List<User> findAll();
}
