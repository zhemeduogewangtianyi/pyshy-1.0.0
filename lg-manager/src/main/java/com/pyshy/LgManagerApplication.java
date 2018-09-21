package com.pyshy;

import com.pyshy.lgmanager.interceptor.config.ManagerInterceptorConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
public class LgManagerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LgManagerApplication.class, args);
	}

	/**
	 * 这个是为了让自定义的页面模板位置能够正确找到才加的
	 * @param builder
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LgManagerApplication.class);
	}

	@Bean
	public ManagerInterceptorConfig managerInterceptorConfig(){
		return new ManagerInterceptorConfig();
	}

}
