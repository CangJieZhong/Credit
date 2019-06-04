package com.zl.credit.creditcore.service;

import com.zl.credit.creditcore.pojo.Userinfo;

public interface UserInfoService {

	Userinfo getUserInfoById() throws Exception;

	void updatePhoneNumber(String phoneNumber) throws Exception;

}
