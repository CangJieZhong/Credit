package com.zl.credit.creditcore.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.credit.creditcore.dao.UserInfoMapper;
import com.zl.credit.creditcore.pojo.User;
import com.zl.credit.creditcore.pojo.Userinfo;
import com.zl.credit.creditcore.util.AliyunQueryBackCard;
import com.zl.credit.creditcore.util.BitStateUtil;
import com.zl.credit.creditcore.util.IdCardUtil;
import com.zl.credit.creditcore.util.UserContext;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public Userinfo getUserInfoById() throws Exception {
		// 从域中获取user数据
		User user = (User) UserContext.getCurrent("user");
		if (user != null) {
			// 通过用户id查取用户信息
			Userinfo userinfo = userInfoMapper.queryByUid(user.getUser_id());
			// 判断如果表中没有数据,那么就插入一条数据
			if (userinfo == null) {
				Userinfo userinfo2 = new Userinfo();
				userinfo2.setUser_id(user.getUser_id());
				userinfo2.setCreate_date(new Date());
				userInfoMapper.insertUserInfo(userinfo2);
				// 添加之后直接返回该对象
				return userinfo2;
			}
			// 说明数据库有该数据,返回该数据
			return userinfo;
		}
		// 如果域中没有user数据,直接返回一个空
		return null;
	}

	@Override
	public void updatePhoneNumber(String phoneNumber) throws Exception {
		// 从域中获取user数据
		User user = (User) UserContext.getCurrent("user");
		if (user != null) {
			// 获取个人信息
			Userinfo userinfo = userInfoMapper.queryByUid(user.getUser_id());
			// 修改状态码
			Integer status_code = userinfo.getStatus_code();
			// 判断数据库是否有该状态码
			if (BitStateUtil.hasState(status_code, BitStateUtil.OP_PHONE_NUMBER)) {
				// 如果有就先移除
				BitStateUtil.removeState(status_code, BitStateUtil.OP_PHONE_NUMBER);
			}
			// 通过用户id添加电话号码,修改认证状态码
			userInfoMapper.addPhoneNumber(user.getUser_id(), phoneNumber,
					BitStateUtil.addState(status_code, BitStateUtil.OP_PHONE_NUMBER), new Date());
		}
	}

	@Override
	public boolean queryIdCardInfo(String idcard) throws Exception {
		int count = userInfoMapper.queryByIdCard(idcard);
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Map<String, Object> updateIdCard(String realname, String idcard) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// 从域中获取user数据
		User user = (User) UserContext.getCurrent("user");
		if (user != null) {
			// 获取个人信息
			Userinfo userinfo1 = userInfoMapper.queryByUid(user.getUser_id());
			//创建一个对象,用来存放接口查询出来的数据及要去数据库更改的数据
			Userinfo userinfo = new Userinfo();
			//获取返回的json字符串
			String result = IdCardUtil.checkIdCard(idcard, realname);
			//判断查询成功并且查询的数据时正确的
			if ((result.indexOf("\"reason\":\"成功\"") != -1) && (result.indexOf("\"isok\":true") != -1)) {
				String[] arr = result.split("\"IdCardInfor\":");
				String[] arr1 = arr[1].split(",");
				String message = "";
				for (String string : arr1) {
					String[] arr2 = string.split("\"");
					message += arr2[3] + ",";
				}
				String[] mess = message.split(",");
				//返回值为山西省太原市清徐县(0)   男(1)   1985-4-10(2)
				if ("男".equals(mess[1])) {
					userinfo.setSex_id(0);
				} else {
					userinfo.setSex_id(1);
				}
				if(BitStateUtil.hasState(userinfo1.getStatus_code(), BitStateUtil.OP_ID_CARD)) {
					userinfo1.setStatus_code(BitStateUtil.removeState(userinfo1.getStatus_code(),BitStateUtil.OP_ID_CARD));
				}
				userinfo.setStatus_code(BitStateUtil.addState(userinfo1.getStatus_code(), BitStateUtil.OP_ID_CARD));
				userinfo.setUser_id(user.getUser_id());
				userinfo.setRealname(realname);
				userinfo.setIdcard(idcard);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				userinfo.setBirthday(sdf.parse(mess[2]));
				userinfo.setUpdate_date(new Date());
				userinfo.setAddress(mess[0]);
				try {
					userInfoMapper.addIdCard(userinfo);
					map.put("success", true);
					return map;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					map.put("success", false);
				}
			}
			map.put("success", false);
		}
		return map;
	}

	@Override
	public void addNew_address(String new_address) throws Exception{
		// 从域中获取user数据
		User user = (User) UserContext.getCurrent("user");
		if (user != null) {
		userInfoMapper.addNew_address(user.getUser_id(),new_address,new Date());
		}else {
			throw new RuntimeException("你没有登录!");
		}
	}

	@Override
	public void updateReser_phone(String backCard,String reser_phone) throws Exception {
				// 从域中获取user数据
				User user = (User) UserContext.getCurrent("user");
				if (user != null) {
					// 获取个人信息
					Userinfo userinfo = userInfoMapper.queryByUid(user.getUser_id());
					String body = AliyunQueryBackCard.queryBackCard(userinfo.getRealname(), backCard, userinfo.getIdcard());
					System.out.println(body);
					if(body.indexOf("\"认证通过\"")!=-1) {
						if(BitStateUtil.hasState(userinfo.getStatus_code(), BitStateUtil.OP_BACK_CARD)) {
							userinfo.setStatus_code(BitStateUtil.removeState(userinfo.getStatus_code(), BitStateUtil.OP_BACK_CARD));
						}
						//新的状态码
						Integer status_code = BitStateUtil.addState(userinfo.getStatus_code(), BitStateUtil.OP_BACK_CARD);
						try {
							userInfoMapper.updateBackCard(user.getUser_id(),backCard,reser_phone,status_code,new Date());
						} catch (Exception e) {
							throw new RuntimeException("添加失败,请重试!");
						}
					}else {
						throw new RuntimeException("银行卡客户资料不匹配");
					}
				}else {
					throw new RuntimeException("你没有登录!");
				}
	}
}
