package com.sripiranavan.java.maven.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.sripiranavan.java.maven.spring")
public class ApplicationConfig {

//	@Bean
//	public Samsung getPhone() {
//		return new Samsung();
//	}
//
//	@Bean
//	public MobileProcessor getProcessor() {
//		return new Snapdragon();
//	}
}
