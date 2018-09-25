package com.pyshy.lgwebapi;

import com.pyshy.lgwebapi.interceptor.config.ManagerInterceptorConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LgWebapiApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LgWebapiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LgWebapiApplication.class, args);
	}

	@Bean
	public ManagerInterceptorConfig managerInterceptorConfig(){
		return new ManagerInterceptorConfig();
	}
}
