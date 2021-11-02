package com.sripiranavan.java.maven.spring.model;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

	@Override
	public void drive() {
		System.out.println("Drive Bike");
	}

}
