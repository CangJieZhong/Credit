package com.zl.credit.creditcore.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zl.credit.creditcore.pojo.User;

@Mapper
public interface UserMapper {

	User queryByNameAndPwd(@Param("username")String username,@Param("password")String password);
	
}
