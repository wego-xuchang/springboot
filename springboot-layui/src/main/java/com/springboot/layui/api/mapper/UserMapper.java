package com.springboot.layui.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springboot.layui.api.pojo.User;

public interface UserMapper {

	Long findCount();

	List<User> findUserByPage(@Param("page")int page,@Param("limit") int limit);

}
