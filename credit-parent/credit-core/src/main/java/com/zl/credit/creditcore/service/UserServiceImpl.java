package com.zl.credit.creditcore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.credit.creditcore.dao.UserMapper;
import com.zl.credit.creditcore.pojo.User;
import com.zl.credit.creditcore.util.UserContext;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(String username, String password) {
		User user = userMapper.queryByNameAndPwd(username,password);
		UserContext.setCurrent("user", user);
		return user;
	}

}
