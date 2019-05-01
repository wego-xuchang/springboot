package com.gitboy.springboot.mapper;

import java.util.List;

import com.gitboy.springboot.pojo.User;

public interface UserMapper {

	List<User> findAllUser();

	List<User> findUserList();

}
