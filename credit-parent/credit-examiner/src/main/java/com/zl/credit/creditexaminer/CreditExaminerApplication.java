package com.zl.credit.creditexaminer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CreditExaminerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditExaminerApplication.class, args);
	}

}
