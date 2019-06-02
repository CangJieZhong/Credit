package com.zl.credit.creditcore.service;

import com.zl.credit.creditcore.pojo.User;
/**
 * 
 * @author cangjie
 *
 */
public interface UserService {

	User login(String username, String password) throws Exception;

	boolean checkUsername(String username, int roleIdPersonal) throws Exception;

	void register(String username, String password) throws Exception;

}
