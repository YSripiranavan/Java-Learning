package com.sripiranavan.java.maven.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sripiranavan.java.maven.spring.model.Samsung;

public class SpringDemo {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		Samsung samsung = context.getBean(Samsung.class);
		samsung.config();
	}

}
