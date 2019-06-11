package com.zl.credit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.zl.credit.creditcore.job.AutoRepay;



/**
 * Quartz配置类
 * @author Administrator
 *
 */
@Configuration
public class QuartzConfig {

	/**
	 * 1创建job对象
	 * 任务
	 * @return
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		//关联我们自己的Job类
		factory.setJobClass(AutoRepay.class);
		return factory;
	}
	
	/**
	 * 2创建Trigger对象
	 * 
	 * 触发器
	 */
//	@Bean
//	public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
//		SimpleTriggerFactoryBean factory=new SimpleTriggerFactoryBean();
//		//关联jobDetailFactoryBean对象
//		factory.setJobDetail(jobDetailFactoryBean.getObject());
//		//该参数表示一个执行的毫秒数
//		factory.setRepeatInterval(2000);
//		//重复次数
//		//factory.setRepeatCount(2);
//		return factory;
//	}
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
		CronTriggerFactoryBean factory=new CronTriggerFactoryBean();
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		//设置触发时间
		factory.setCronExpression("0 30 23 L * ?");
		return factory;
	}
	
	/**
	 * 3创建Scheduler对象
	 * 任务调度
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,
			MyAdaptableJobFactory myAdaptableJobFactory) {
		SchedulerFactoryBean factory= new SchedulerFactoryBean();
		//关联Trigger
		factory.setTriggers(cronTriggerFactoryBean.getObject());
		factory.setJobFactory(myAdaptableJobFactory);
		return factory;
	}
}
