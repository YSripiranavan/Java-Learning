package com.sripiranavan.java.maven.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sripiranavan.java.maven.spring.service.AddNumbers;

@Controller
public class AddController {

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView displayPage(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		AddNumbers addNumbers = new AddNumbers();
		int result = addNumbers.add(num1, num2);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result", result);
		return mv;
	}
}
