package com.gitboy.springboot.test01.service;

import java.util.List;

import com.gitboy.springboot.pojo.User;
import com.github.pagehelper.PageInfo;

public interface UserTest1Service {

	List<User> findAllUserTest1();

	PageInfo<User> findUserListTest1(int page, int size);
}
