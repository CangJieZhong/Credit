package com.zl.credit.creditcore.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zl.credit.creditcore.pojo.User;
/**
 * 
 * @author cangjie
 *
 */
@Mapper
public interface UserMapper {

	User queryByNameAndPwd(@Param("username")String username,@Param("password")String password) throws Exception;

	int queryNameInfo(@Param("username")String username, @Param("role_id")int role_id) throws Exception;

	void insertUser(User user)  throws Exception;
	
	int queryUidByUsername(@Param("username")String username) throws Exception;
}
