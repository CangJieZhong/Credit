package com.zl.credit.creditcore.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zl.credit.creditcore.pojo.User;

@Mapper
public interface UserMapper {

	User queryByNameAndPwd(String username, String password);
	
}
