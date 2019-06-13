package com.zl.credit.creditcore.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
 
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
 
/**
 * 修改Spring Scheculed默认线程池
 *
 * @author yihonglei
 * @date 2019/1/7 15:47
 */
@Configuration
public class ScheduledConfig implements SchedulingConfigurer {
 
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(new ScheduledThreadPoolExecutor(10,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "my-schedule-pool");
                    }
                }));
}}