package com.adhiraj.enterpries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

	
	@GetMapping("/contact")
	public String contactDetails() {
		return "contact"; // maps to contact.html
	}
}
