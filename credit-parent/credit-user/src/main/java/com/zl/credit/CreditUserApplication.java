package com.zl.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CreditUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditUserApplication.class, args);
	}
}
//6217002970110230741