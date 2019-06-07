package com.zl.credit;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CreditGranterApplication {
	public static void main(String[] args) {
		SpringApplication.run(CreditGranterApplication.class, args);
	}
	
	
	/**
	 * 分页插件pageHelper
	 * @return
	 */
	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum","true");
		properties.setProperty("rowBoundsWithCount","true");
		properties.setProperty("reasonable","true");
		properties.setProperty("dialect","oracle");    //配置oracle数据库的方言
		pageHelper.setProperties(properties);
		return pageHelper;
	}

}
