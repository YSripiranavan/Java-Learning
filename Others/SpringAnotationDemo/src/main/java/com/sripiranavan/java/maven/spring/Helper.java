package com.sripiranavan.java.maven.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class Helper {

	@Before("execution(public void config())")
	public void log() {
		System.out.println("Log Message");
	}
}
