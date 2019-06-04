package com.zl.credit.creditcore.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.credit.creditcore.dao.UserInfoMapper;
import com.zl.credit.creditcore.pojo.User;
import com.zl.credit.creditcore.pojo.Userinfo;
import com.zl.credit.creditcore.service.UserInfoService;
import com.zl.credit.creditcore.util.UserContext;
@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Override
	public Userinfo getUserInfoById() {
		//从域中获取user数据
		User user = (User) UserContext.getCurrent("user");
		if(user!=null) {
		//通过用户id查取用户信息
		Userinfo userinfo = userInfoMapper.queryByUid(user.getUser_id());
		//判断如果表中没有数据,那么就插入一条数据
		if(userinfo==null) {
			Userinfo userinfo2 = new Userinfo();
			userinfo2.setUser_id(user.getUser_id());
			userinfo2.setCreate_date(new Date());
			userInfoMapper.insertUserInfo(userinfo2);
			//添加之后直接返回该对象
			return userinfo2;
			}
		//说明数据库有该数据,返回该数据
		return userinfo;
		}
		//如果域中没有user数据,直接返回一个空
		return null;
	}

}
