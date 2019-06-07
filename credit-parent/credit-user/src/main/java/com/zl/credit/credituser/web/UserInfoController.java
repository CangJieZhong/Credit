package com.zl.credit.credituser.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zl.credit.creditcore.pojo.Userinfo;
import com.zl.credit.creditcore.service.UserInfoService;
import com.zl.credit.creditcore.util.AliyunSendPhoneMsg;
import com.zl.credit.creditcore.util.SendPhoneMessage;
import com.zl.credit.creditcore.util.UploadUtil;

@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/getUserInfo.action")
	@ResponseBody
	public Userinfo getUserInfo() throws Exception {
		Userinfo userinfo = userInfoService.getUserInfoById();
		if (userinfo != null) {
			String bank_card = "";
			if (userinfo.getBank_card() != null && userinfo.getBank_card() != "") {
				char[] cha = userinfo.getBank_card().toCharArray();
				for (int i = 0; i < cha.length; i++) {
					if (i == 3 || i==7 || i==11 || i==15) {
						bank_card += cha[i] + " ";
					} else {
						bank_card += cha[i];
					}
				}
				userinfo.setBank_card(bank_card);
			}
		}
		return userinfo;
	}

	@RequestMapping("/sendPhoneMessage.action")
	@ResponseBody
	public String sendPhoneMessage(HttpServletRequest request, String phoneNumber) throws Exception {
		// 判断域中是否存在验证码和手机信息
		if (request.getSession().getAttribute("userPhoneMsg") != null) {
			return "erro";
		} else {
			// 随机生成6位数的验证码
			String checkCode = "";
			Random random = new Random();
			for (int i = 0; i < 6; i++) {
				checkCode += random.nextInt(10);
			}
			// 发送短信,接受返回值
			/*
			 * String result = SendPhoneMessage.sendPhoneMessage(phoneNumber, checkCode);
			 */
			String result = AliyunSendPhoneMsg.sendPhoneMsg(phoneNumber, checkCode);
			// 把域中之前的清除
			request.getSession().removeAttribute("sendMessage");
			// 如果发生成功
			if (result.indexOf("\"Message\":\"OK\"") != -1) {
				// 把手机号码及验证码放域里
				Map<String, String> userPhoneMsg = new HashMap<String, String>();
				userPhoneMsg.put("sendMessage", checkCode);
				userPhoneMsg.put("phoneNumber", phoneNumber);
				request.getSession().setAttribute("userPhoneMsg", userPhoneMsg);
			} else {
				// 发送失败直接返回发送失败
				return "发送失败了,请稍后重试!";
			}
		}
		return null;
	}

	/** 保存电话号码 */
	@RequestMapping("/savePhoneNumber.action")
	@ResponseBody
	public Map<String, Object> savePhoneNumber(HttpServletRequest request, String code, String phoneNumber)
			throws Exception {
		Map<String, Object> map = new HashMap<>();
		Map<String, String> userPhoneMsg = (Map<String, String>) request.getSession().getAttribute("userPhoneMsg");
		if (code.equals(userPhoneMsg.get("sendMessage")) && phoneNumber.equals(userPhoneMsg.get("phoneNumber"))) {
			map.put("success", true);
			userInfoService.updatePhoneNumber(phoneNumber);
		} else {
			map.put("ErroMsg", "验证码错误,请重新输入");
		}
		return map;
	}

	// 查询数据库该身份证是否绑定用户了
	@RequestMapping("/checkIdCardInfo.action")
	@ResponseBody
	public boolean checkIdCardInfo(String idcard) throws Exception {
		return userInfoService.queryIdCardInfo(idcard);
	}

	// 添加身份证信息
	@RequestMapping("/bindIdcard.action")
	@ResponseBody
	public Map<String, Object> bindIdcard(String realname, String idcard) throws Exception {
		return userInfoService.updateIdCard(realname, idcard);
	}

	// 添加当前居住地址
	@RequestMapping("/bindNew_address.action")
	public String bindNew_address(String new_address) {
		try {
			userInfoService.addNew_address(new_address);
		} catch (Exception e) {
			return "redirect:/index.html";
		}
		return "redirect:/user/user.html";
	}

	/** 银行卡预留电话绑定发送验证码 */
	@RequestMapping("/sendBankPhoneMessage.action")
	@ResponseBody
	public String sendBankPhoneMessage(HttpServletRequest request, String phoneNumber) throws Exception {
		// 判断域中是否存在验证码和手机信息
		if (request.getSession().getAttribute("userBankPhoneMsg") != null) {
			return "erro";
		} else {
			// 随机生成6位数的验证码
			String checkCode = "";
			Random random = new Random();
			for (int i = 0; i < 6; i++) {
				checkCode += random.nextInt(10);
			}
			// 发送短信,接受返回值
			/*
			 * String result = SendPhoneMessage.sendPhoneMessage(phoneNumber, checkCode);
			 */
			String result = AliyunSendPhoneMsg.sendPhoneMsg(phoneNumber, checkCode);
			// 把域中之前的清除
			request.getSession().removeAttribute("sendMessage");
			// 如果发生成功
			if (result.indexOf("\"Message\":\"OK\"") != -1) {
				// 把手机号码及验证码放域里
				Map<String, String> userPhoneMsg = new HashMap<String, String>();
				userPhoneMsg.put("sendMessage", checkCode);
				userPhoneMsg.put("phoneNumber", phoneNumber);
				request.getSession().setAttribute("userBankPhoneMsg", userPhoneMsg);
			} else {
				// 发送失败直接返回发送失败
				return "发送失败了,请稍后重试!";
			}
		}
		return null;
	}

	/** 银行卡绑定 */
	@RequestMapping("/saveBackPhone.action")
	@ResponseBody
	public Map<String, Object> saveBackPhone(HttpServletRequest request, String backcard, String code,
			String phoneNumber) throws Exception {
		System.out.println(backcard);
		Map<String, Object> map = new HashMap<>();
		Map<String, String> userPhoneMsg = (Map<String, String>) request.getSession().getAttribute("userBankPhoneMsg");
		if (code.equals(userPhoneMsg.get("sendMessage")) && phoneNumber.equals(userPhoneMsg.get("phoneNumber"))) {
			try {
				userInfoService.updateReser_phone(backcard, phoneNumber);
			} catch (Exception e) {
				map.put("success", false);
				map.put("ErroMsg", e.getMessage());
				return map;
			}
			map.put("success", true);
		} else {
			map.put("success", false);
			map.put("ErroMsg", "验证码或银行卡错误,请重新输入");
		}
		return map;
	}
	/**
	 * 异步上传文件
	 * @param file 文件
	 * @return 
	 */
	@RequestMapping("/realAuth_upload.action")
	@ResponseBody
	public String realAuthUpload(MultipartFile file) {
		String fileName = UploadUtil.upload(file);
		return "/upload/"+fileName;
	}
	@RequestMapping("/addImg.action")
	public String addImg(String image1,String image2) throws Exception {
			userInfoService.addImg(image1,image2);
			return "redirect:/user/user.html";
	}
}
