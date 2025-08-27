package com.marvel.adhirajEnterprieses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marvel.adhirajEnterprieses.repository.UserRepository;

@Controller
public class LoginController {
	private final UserRepository userRepository;

	public LoginController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, Model model) {
		/*
		 * return userRepository.findByEmailAndPassword(email, password).map(user ->
		 * "redirect:/home").orElseGet(() -> { model.addAttribute("error",
		 * "Invalid email or password"); return "login"; });
		 */
	  return "login";
		
	}

	@GetMapping("/home")
	public String homePage() {
		return "home";
	}

	@GetMapping("/logout")
	public String logout() {
		// later we can clear session, for now just redirect
		return "redirect:/";
	}

}