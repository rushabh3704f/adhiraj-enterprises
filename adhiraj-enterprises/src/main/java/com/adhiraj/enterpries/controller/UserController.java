package com.adhiraj.enterpries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

	@RequestMapping("/users")
	public String home(Model model) {
		return "users";
	}
}
