package com.zl.credit.creditcore.service;

import java.util.Map;

import com.zl.credit.creditcore.pojo.Userinfo;

public interface UserInfoService {

	Userinfo getUserInfoById() throws Exception;

	void updatePhoneNumber(String phoneNumber) throws Exception;

	boolean queryIdCardInfo(String idcard);

	Map<String, Object> updateIdCard(String realname, String idcard) throws Exception;

}
