package com.zl.credit.creditcore.dao;

import java.util.Date;

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
	void insertUserInfo(Userinfo userinfo) throws Exception;

	Userinfo queryByUid(@Param("user_id")Integer user_id) throws Exception;

	void addPhoneNumber(@Param("user_id")Integer user_id,@Param("phoneNumber")String phoneNumber,@Param("status_code")Integer status_code,@Param("update_date")Date update_date) throws Exception;

	int queryByIdCard(@Param("idcard")String idcard) throws Exception;

	void addIdCard(Userinfo userinfo) throws Exception;

	void addNew_address(@Param("user_id")Integer user_id,@Param("now_address")String now_address,@Param("update_date") Date update_date)throws Exception;
}
