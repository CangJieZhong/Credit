package com.zl.credit.creditcore.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.credit.creditcore.dao.UserInfoMapper;
import com.zl.credit.creditcore.dao.UserMapper;
import com.zl.credit.creditcore.pojo.User;
import com.zl.credit.creditcore.util.MD5;
import com.zl.credit.creditcore.util.UserContext;
/**
 * 
 * @author cangjie
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(String username, String password) throws Exception {
		User user = userMapper.queryByNameAndPwd(username,MD5.encode(password));
		if(user!=null) {
			UserContext.setCurrent("user", user);
		}
		return user;
	}
	@Override
	public boolean checkUsername(String username, int roleIdPersonal) throws Exception {
		int count = userMapper.queryNameInfo(username,roleIdPersonal);
		if(count>0) {
			return true;
		}
		return false;
	}
	@Override
	public void register(String username, String password) throws Exception {
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(MD5.encode(password));
		user.setRole_id(User.role_id_Personal);
		user.setCreate_date(new Date());
		try {
			//往user表中插入一行数据
			userMapper.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
