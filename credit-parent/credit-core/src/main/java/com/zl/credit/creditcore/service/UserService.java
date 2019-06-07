package com.zl.credit.creditcore.service;

import com.zl.credit.creditcore.pojo.User;
/**
 * 用户业务类
 * @author cangjie
 *
 */
public interface UserService {

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	User login(String username, String password) throws Exception;

	/**
	 * 验证用户名
	 * @param username
	 * @param roleIdPersonal
	 * @return
	 * @throws Exception
	 */
	boolean checkUsername(String username, int roleIdPersonal) throws Exception;

	/**
	 * 注册
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	void register(String username, String password) throws Exception;

}
