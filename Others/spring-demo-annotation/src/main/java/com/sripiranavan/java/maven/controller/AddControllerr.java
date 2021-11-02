package com.sripiranavan.java.maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sripiranavan.java.maven.service.AddService;

@Controller
public class AddControllerr {

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView showResult(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		AddService service = new AddService();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result", service.add(num1, num2));
		return mv;
	}
}
