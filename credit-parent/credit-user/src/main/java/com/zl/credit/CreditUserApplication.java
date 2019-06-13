package com.zl.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
/**
 * 用户模块启动类
 * @author Administrator
 *
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CreditUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditUserApplication.class, args);
	}
}
//6217002970110230741