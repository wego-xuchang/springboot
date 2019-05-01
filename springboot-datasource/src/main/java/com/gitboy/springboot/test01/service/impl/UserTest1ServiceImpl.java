package com.gitboy.springboot.test01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitboy.springboot.pojo.User;
import com.gitboy.springboot.test01.mapper.Test1Mapper;
import com.gitboy.springboot.test01.service.UserTest1Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserTest1ServiceImpl implements UserTest1Service {

	@Autowired
	private Test1Mapper test1Mapper;

	@Override
	public List<User> findAllUserTest1() {
		return test1Mapper.findAllUserTest1();
	}

	@Override
	public PageInfo<User> findUserListTest1(int page, int size) {
		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		List<User> listUser = test1Mapper.findAllUserTest1();
		// 封装分页之后的数据
		PageInfo<User> pageInfoUser = new PageInfo<User>(listUser);
		return pageInfoUser;
	}

}
