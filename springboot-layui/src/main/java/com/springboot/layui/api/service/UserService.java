package com.springboot.layui.api.service;

import com.springboot.layui.api.pojo.User;
import com.springboot.layui.utils.PageUtil;

public interface UserService {

	PageUtil<User> findUserByPage(int page, int limit);

}
