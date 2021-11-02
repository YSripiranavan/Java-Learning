package com.sripiranavan.java.maven.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView showResult(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", num1 + num2);
		mv.setViewName("display.jsp");

		return mv;
	}
}
