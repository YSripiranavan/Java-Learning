package com.sripiranavan.java.maven.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {
	@Autowired
	private Tyre tyre;

	@Override
	public void drive() {
		System.out.println("Drive Car");
	}

	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	@Override
	public String toString() {
		return "Car [tyre=" + tyre + "]";
	}

}
