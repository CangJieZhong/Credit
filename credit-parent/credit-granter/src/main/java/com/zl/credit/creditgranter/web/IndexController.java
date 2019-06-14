package com.zl.credit.creditgranter.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zl.credit.creditcore.pojo.User;

@RestController
public class IndexController {

	@RequestMapping("/gainUser")
	public User gainUserName(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null) {
			return user;
		}
		return null;
	}
}
