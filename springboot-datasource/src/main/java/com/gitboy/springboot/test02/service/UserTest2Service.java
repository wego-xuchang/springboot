package com.gitboy.springboot.test02.service;

import java.util.List;

import com.gitboy.springboot.pojo.User;
import com.github.pagehelper.PageInfo;

public interface UserTest2Service {

	List<User> findAllUserTest2();

	PageInfo<User> findUserListTest2(int page, int size);
}
