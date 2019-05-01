package com.gitboy.springboot.service;

import java.util.List;

import com.gitboy.springboot.pojo.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

	List<User> findAllUser();

	PageInfo<User> findUserList(int page, int size);

}
