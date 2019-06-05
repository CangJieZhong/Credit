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
	/**
	 * 添加一条数据
	 * @param userinfo
	 * @throws Exception
	 */
	void insertUserInfo(Userinfo userinfo) throws Exception;
	/**
	 * 通过用户id查用户信息
	 * @param user_id 用户id
	 * @return
	 * @throws Exception
	 */
	Userinfo queryByUid(@Param("user_id")Integer user_id) throws Exception;
	/**
	 * 通过用户id添加电话号码
	 * @param user_id 用户id
	 * @param phoneNumber 电话号码
	 * @param status_code 状态码
	 * @param update_date 修改时间
	 * @throws Exception
	 */
	void addPhoneNumber(@Param("user_id")Integer user_id,@Param("phoneNumber")String phoneNumber,@Param("status_code")Integer status_code,@Param("update_date")Date update_date) throws Exception;
	/**
	 * 查看数据库是否存在该身份证
	 * @param idcard 身份证
	 * @return
	 * @throws Exception
	 */
	int queryByIdCard(@Param("idcard")String idcard) throws Exception;
	/**
	 * 添加身份证信息
	 * @param userinfo 一个用户信息对象
	 * @throws Exception
	 */
	void addIdCard(Userinfo userinfo) throws Exception;
	/**
	 * 添加当前住址
	 * @param user_id 用户id
	 * @param now_address 地址
	 * @param update_date 修改时间
	 * @throws Exception
	 */
	void addNew_address(@Param("user_id")Integer user_id,@Param("now_address")String now_address,@Param("update_date") Date update_date)throws Exception;
	/**
	 * 添加银行卡认证
	 * @param user_id 用户id
	 * @param bank_card 卡号
	 * @param reser_phone 预留电话
	 * @param status_code 状态码
	 * @param date 修改时间
	 */
	void updateBackCard(@Param("user_id")Integer user_id,@Param("bank_card")String bank_card,@Param("reser_phone")String reser_phone,@Param("status_code")Integer status_code,@Param("update_date")Date date) throws Exception;
}
