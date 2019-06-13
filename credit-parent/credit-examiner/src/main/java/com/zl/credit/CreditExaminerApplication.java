package com.zl.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * 发放模块
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableScheduling
public class CreditExaminerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditExaminerApplication.class, args);
	}

}
