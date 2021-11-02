package com.sripiranavan.java.maven.spring.model;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class MediaTek implements MobileProcessor {

	@Override
	public void process() {
		System.out.println("Good Processor");
	}

}
