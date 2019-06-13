package com.zl.credit.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ConfigMain extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {  

    @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {  
        return builder.sources(ConfigMain.class);  
    }  

    public static void main(String[] args) {  
        SpringApplication.run(ConfigMain.class, args);  
    }  


    @Override  
    public void customize(ConfigurableEmbeddedServletContainer container) {
		/*
		 * //指定项目名称 container.setContextPath("/demo");
		 */
        //指定端口地址
        container.setPort(8092);  
    }  
}
