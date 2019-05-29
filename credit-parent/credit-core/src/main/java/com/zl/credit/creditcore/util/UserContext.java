package com.zl.credit.creditcore.util;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 封装获取HttpSession,以及往HttpSession存放数据
 * @author cangjie
 *
 */
public class UserContext {
	private static String USER_IN_SESSION = "current";
	/**
	 * 获取HttpSession的方法
	 */
	private  static HttpSession  getHttpSession(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	}
	
	public static  Object  getCurrent(){
		return (Object) getHttpSession().getAttribute(USER_IN_SESSION);
	}
	public static void setCurrent(Object logininfo){
		getHttpSession().setAttribute(USER_IN_SESSION, logininfo);
	}
}
