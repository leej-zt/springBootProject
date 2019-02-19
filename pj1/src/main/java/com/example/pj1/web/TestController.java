package com.example.pj1.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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

		login();
		System.out.println("login success");

		return "TestView";
	}

	private void login() {
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("leej", "leej");
	    currentUser.login(token);
	}
}
