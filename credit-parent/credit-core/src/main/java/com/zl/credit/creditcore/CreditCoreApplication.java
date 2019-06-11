package com.zl.credit.creditcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class CreditCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCoreApplication.class, args);
	}

}
