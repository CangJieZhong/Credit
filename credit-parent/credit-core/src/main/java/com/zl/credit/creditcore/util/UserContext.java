package com.zl.credit.creditcore.util;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 封装获取HttpSession,以及往HttpSession存放数据
 * @author cangjie
 *
 */
public class UserContext {
	/**
	 * 获取HttpSession的方法
	 */
	private  static HttpSession  getHttpSession(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	}
	
	public static  Object  getCurrent(String key){
		return (Object) getHttpSession().getAttribute(key);
	}
	public static void setCurrent(String key,Object logininfo){
		getHttpSession().setAttribute(key, logininfo);
	}
}
