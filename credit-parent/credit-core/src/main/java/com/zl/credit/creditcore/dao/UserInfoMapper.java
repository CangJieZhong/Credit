package com.zl.credit.creditcore.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zl.credit.creditcore.pojo.Userinfo;

/**
 * 用户信息表数据访问
 * @author THINK
 *
 */
@Mapper
public interface UserInfoMapper {
	void insertUserInfo(Userinfo userinfo);

	Userinfo queryByUid(@Param("user_id")Integer user_id);
}
