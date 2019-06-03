package com.zl.credit.credituser.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.credit.creditcore.pojo.Userinfo;
import com.zl.credit.creditcore.service.UserInfoService;

@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	@RequestMapping("/getUserInfo.action")
	@ResponseBody
	public Userinfo getUserInfo() {
		return userInfoService.getUserInfoById();
	}
}
