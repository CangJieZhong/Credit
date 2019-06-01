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
	private UserService userServiceImpl;
	@RequestMapping(path="/login.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult login(String username,String password) throws Exception{
		User user = userServiceImpl.login(username,password);
		JsonResult json = new JsonResult();
		if(user!=null) {
		//获取角色
		int rolo = user.getRole_id();
		//判断角色
		json.setSuccess(true);
		}else {
			json.setSuccess(false);
			json.setMsg("用户名或密码错误!!!");
		}
		return json;
	}
	@RequestMapping(path="/checkUsername.action",method=RequestMethod.POST)
	@ResponseBody
	public boolean  checkUsername(String username) throws Exception{
		return userServiceImpl.checkUsername(username,User.role_id_Personal);
	}
	
	
	
	@RequestMapping(path="/register.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult  register(String username,String password){
		JsonResult json = new JsonResult();
		try{
			userServiceImpl.register(username,password);
		}catch(Exception e){
			json.setSuccess(false);
		}
		return json;
	}
}
