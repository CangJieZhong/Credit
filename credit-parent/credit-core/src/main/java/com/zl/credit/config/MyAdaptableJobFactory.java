package com.zl.credit.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory{

	//AutowireCapableBeanFactory  可以将一个对象添加到springioc容器中，并且完成对象注入
	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;
	/**
	 * 改方法需要将实例化的任务对象手动添加到ioc容器，并完成注入
	 * 
	 */
	
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle)throws Exception{
		Object obj=super.createJobInstance(bundle);
		//将obj对象添加ioc容器中 
		this.autowireCapableBeanFactory.autowireBean(obj);
		return obj;
	}
}
