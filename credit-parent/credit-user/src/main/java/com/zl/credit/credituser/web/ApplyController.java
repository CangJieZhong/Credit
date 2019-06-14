package com.zl.credit.credituser.web;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.pojo.ApplyData;
import com.zl.credit.creditcore.service.UserInfoService;
import com.zl.credit.creditcore.util.MaxApplyMoney;

@Controller
public class ApplyController {
	@Autowired
	private UserInfoService userInfoService;
	@RequestMapping("/apply.action")
	public String apply(ApplyData apply) {
		userInfoService.addApply(apply);
		return "redirect:/user/user.html";
	}
	@RequestMapping("/MaxApplyMoney.action")
	@ResponseBody
	public Integer getMaxApplyMoney(String grade) {
		return MaxApplyMoney.getMaxApplyMoney(Integer.parseInt(grade));
	}
	@RequestMapping("/checkHaveApply.action")
	@ResponseBody
	public Apply checkHaveApply() {
		return userInfoService.checkHaveApply();
	}
}
