package com.example.pj1.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TestController {

	@Value("${test.abc}")
	private String test;

	@RequestMapping(method = RequestMethod.GET)
	public String testController(Model model) {
		System.out.println(test);
		model.addAttribute("test", test);
		return "TestView";
	}
}
