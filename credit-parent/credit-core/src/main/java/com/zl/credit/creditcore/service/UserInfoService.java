package com.zl.credit.creditcore.service;

import java.util.Map;

import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.pojo.ApplyData;
import com.zl.credit.creditcore.pojo.Userinfo;

public interface UserInfoService {

	Userinfo getUserInfoById() throws Exception;

	void updatePhoneNumber(String phoneNumber) throws Exception;

	boolean queryIdCardInfo(String idcard) throws Exception;

	Map<String, Object> updateIdCard(String realname, String idcard) throws Exception;

	void addNew_address(String new_address) throws Exception;

	void updateReser_phone(String backCard,String reser_phone) throws Exception;

	void addImg(String image1, String image2)  throws Exception;

	void addApply(ApplyData apply);

	Apply checkHaveApply();

}
