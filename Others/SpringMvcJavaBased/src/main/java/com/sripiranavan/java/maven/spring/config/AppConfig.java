package com.sripiranavan.java.maven.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({ "com.sripiranavan.java.maven.spring" })
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

}
