package com.zl.credit.creditcore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.credit.creditcore.dao.UserMapper;
import com.zl.credit.creditcore.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(String username, String password) {
		return userMapper.queryByNameAndPwd(username,password);
	}

}
