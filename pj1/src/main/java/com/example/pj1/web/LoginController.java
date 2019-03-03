package com.example.pj1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pj1.form.LoginForm;
import com.example.pj1.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Value("${title.login}")
	private String title;

	@RequestMapping(method = RequestMethod.GET)
	public String testController(final LoginForm form,
			final Model model) throws Exception {

		model.addAttribute("title", title);

		return "Login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(final LoginForm form,
			final Model model) throws Exception {

		boolean login = loginService.login(form);
		if(!login) {
			model.addAttribute("loginCheck","fail");
		}


		return "Login";
	}


}
