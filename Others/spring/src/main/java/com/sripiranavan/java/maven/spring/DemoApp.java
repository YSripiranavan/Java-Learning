package com.sripiranavan.java.maven.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sripiranavan.java.maven.spring.model.Car;

public class DemoApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sripiranavan/java/maven/spring/spring.xml");

//		Vehicle obj = (Vehicle) context.getBean("car");
//		obj.drive();

//		Tyre tyre = (Tyre) context.getBean("tyre");
//		System.out.println(tyre);

		Car car = (Car) context.getBean("car");
		System.out.println(car);
	}

}
