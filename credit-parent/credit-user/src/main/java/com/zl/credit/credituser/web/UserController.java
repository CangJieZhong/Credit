package com.zl.credit.credituser.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.credit.creditcore.pojo.User;
import com.zl.credit.creditcore.service.UserService;
import com.zl.credit.creditcore.util.JsonResult;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(path="/login.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult login(String username,String password){
		User user = userService.login(username,password);
		JsonResult json = new JsonResult();
		if(user!=null) {
		//获取角色
		int rolo = user.getRole_id();
		//判断角色
		json.setSuccess(true);
		}else {
			json.setSuccess(true);
			json.setMsg("用户名或密码错误!!!");
			
		}
		return json;
	}
}
