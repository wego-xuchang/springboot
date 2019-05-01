package com.gitboy.springboot.test02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitboy.springboot.pojo.User;
import com.gitboy.springboot.test02.mapper.Test2Mapper;
import com.gitboy.springboot.test02.service.UserTest2Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserTest2ServiceImpl implements UserTest2Service {

	@Autowired
	private Test2Mapper test2Mapper;

	@Override
	public List<User> findAllUserTest2() {
		return test2Mapper.findAllUserTest2();
	}

	@Override
	public PageInfo<User> findUserListTest2(int page, int size) {
		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		List<User> listUser = test2Mapper.findAllUserTest2();
		// 封装分页之后的数据
		PageInfo<User> pageInfoUser = new PageInfo<User>(listUser);
		return pageInfoUser;
	}

}
