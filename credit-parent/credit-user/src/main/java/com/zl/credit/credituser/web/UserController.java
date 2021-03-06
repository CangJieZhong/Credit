package com.zl.credit.credituser.web;

import javax.servlet.http.Cookie;
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
 * @author cangjie
 *
 */
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
		json.setMsg(rolo+"");
		}else {
			json.setSuccess(false);
			json.setMsg("用户名或密码错误!!!");
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
	@RequestMapping("/clearUser.action")
	public void clearUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		Cookie[] cookies = request.getCookies();
		if(user!=null) {
			request.getSession().setAttribute("user", null);
		}
	}
}
