package com.zl.credit.credituser.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.credit.creditcore.pojo.Userinfo;
import com.zl.credit.creditcore.service.UserInfoService;
import com.zl.credit.creditcore.util.AliyunSendPhoneMsg;
import com.zl.credit.creditcore.util.SendPhoneMessage;

@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	@RequestMapping("/getUserInfo.action")
	@ResponseBody
	public Userinfo getUserInfo() throws Exception {
		return userInfoService.getUserInfoById();
	}
	@RequestMapping("/sendPhoneMessage.action")
	@ResponseBody
	public String sendPhoneMessage(HttpServletRequest request,
			String phoneNumber) throws Exception {
		//判断域中是否存在验证码和手机信息
		if(request.getSession().getAttribute("userPhoneMsg")!=null){
			return "erro";
		}else{
		// 随机生成6位数的验证码
		String checkCode = "";
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			checkCode += random.nextInt(10);
		}
		//发送短信,接受返回值
			/*
			 * String result = SendPhoneMessage.sendPhoneMessage(phoneNumber, checkCode);
			 */
		String result = AliyunSendPhoneMsg.sendPhoneMsg(phoneNumber,
				 checkCode);
		 //把域中之前的清除
		request.getSession().removeAttribute("sendMessage");
		//如果发生成功
		if(result.indexOf("\"Message\":\"OK\"")!=-1){
		//把手机号码及验证码放域里
		Map<String, String> userPhoneMsg = new HashMap<String, String>();
		userPhoneMsg.put("sendMessage", checkCode);
		userPhoneMsg.put("phoneNumber", phoneNumber);
				request.getSession().setAttribute("userPhoneMsg", userPhoneMsg);
		 }else{
			 //发送失败直接返回发送失败
		return "发送失败了,请稍后重试!";
		}
		}
		return null;
	}
	@RequestMapping("/savePhoneNumber.action")
	@ResponseBody
	public Map<String, Object> savePhoneNumber(HttpServletRequest request,String code,String phoneNumber) throws Exception{
		Map<String, Object> map = new HashMap<>();
		Map<String, String> userPhoneMsg = (Map<String, String>) request.getSession().getAttribute("userPhoneMsg");
		if(code.equals(userPhoneMsg.get("sendMessage"))&&phoneNumber.equals(userPhoneMsg.get("phoneNumber"))){
			map.put("success", true);
			userInfoService.updatePhoneNumber(phoneNumber);
		}else{
			map.put("ErroMsg", "验证码错误,请重新输入");
		}
		return map;
	}
	//查询数据库该身份证是否绑定用户了
	@RequestMapping("/checkIdCardInfo.action")
	@ResponseBody
	public boolean checkIdCardInfo(String idcard){
		return userInfoService.queryIdCardInfo(idcard);
	}
	//添加身份证信息
	@RequestMapping("/bindIdcard.action")
	@ResponseBody
	public Map<String, Object> bindIdcard(String realname,String idcard) throws Exception {
		return userInfoService.updateIdCard(realname,idcard);
	}
}
