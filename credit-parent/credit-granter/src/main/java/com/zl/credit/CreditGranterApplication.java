package com.zl.credit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 审计模块
 * @author Administrator
 *
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CreditGranterApplication {
	public static void main(String[] args) {
		SpringApplication.run(CreditGranterApplication.class, args);
	}
}
