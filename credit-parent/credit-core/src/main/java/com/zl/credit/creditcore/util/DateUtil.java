package com.zl.credit.creditcore.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 把日期转换为 yyyy-MM-dd 00:00:00
	 * @param date 转换的日期
	 * @return
	 */
	public static Date beginForDate(Date date){
		if(date != null){
			//使用Calendar (日历类)来进行转换
			//1.得到Calendar的对象 调用getInstance()
			Calendar c = Calendar.getInstance();
			//2.把java.util.Date 转换为java.util.Calendar类型  调用Calendar的setTime()
			c.setTime(date);
			//3.把时分秒清零 set()
			c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), 0, 0, 0);
			//4.把Calendar转换为java.util.Date,并返回
			return c.getTime();
		}
		return null;
	}
	
	/**
	 * 把日期转换为 yyyy-MM-dd 23:59:59
	 * @param date
	 * @return
	 */
	public static Date endForDate(Date date){
		if(date != null){
			//使用Calendar (日历类)来进行转换
			//1.得到Calendar的对象 调用getInstance()
			Calendar c = Calendar.getInstance();
			//2.把java.util.Date 转换为java.util.Calendar类型  调用Calendar的setTime()
			c.setTime(date);
			//3.把时分秒清零 set()
			c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), 0, 0, 0);
			//4.天数加1
			c.add(Calendar.DATE, 1);
			//5.秒减1
			c.add(Calendar.SECOND, -1);
			//6.把Calendar转换为java.util.Date,并返回
			return c.getTime();
		}
		return null;
	}
	
	/**
	 * 获取两个时间的相隔的秒
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static  long secondBetwen(Date d1 , Date d2){
		return Math.abs((d1.getTime() - d2.getTime()))/1000;
	}
	/**
	 * 获取两个时间的相隔的天
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static  long dayBetwen(Date d1 , Date d2){
		return Math.abs((d1.getTime() - d2.getTime()))/(1000*3600*24);
	}
}
