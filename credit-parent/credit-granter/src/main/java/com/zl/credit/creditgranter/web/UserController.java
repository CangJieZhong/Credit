package com.zl.credit.creditgranter.web;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.credit.creditcore.pojo.User;
import com.zl.credit.creditcore.service.UserService;
import com.zl.credit.creditcore.util.JsonResult;
/**
 * 
 * @author 龙发文
 * @version  创建时间   2019年6月3日  下午3:06:23
 */
@Controller
public class UserController {
	@Autowired
	private UserService userServiceImpl;
	@RequestMapping(path="/login.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult login(String username,String password) throws Exception{
		JsonResult json = new JsonResult();
		User user = userServiceImpl.login(username, password);
		if(user!=null) {
			json.setSuccess(true);
			json.setMsg("登录成功！");
		}else {
			json.setSuccess(false);
			json.setMsg("账号密码错误！");
		}
		return json;
	}
	@RequestMapping(path="/checkUsername.action",method=RequestMethod.POST)
	@ResponseBody
	public boolean  checkUsername(String username) throws Exception{
		return !userServiceImpl.checkUsername(username,User.role_id_Personal);
	}
	
	
	
	@RequestMapping(path="/register.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult  register(String username,String password){
		JsonResult json = new JsonResult();
		try{
			userServiceImpl.register(username,password);
		}catch(Exception e){
			json.setMsg("注册失败,请稍后重试!");
			json.setSuccess(false);
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/getUser.action")
	public User getUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null) {
			user.setPassword(null);
			user.setCreate_date(null);
			user.setUpdate_date(null);
			return user;
		}
		return null;
	}
}
