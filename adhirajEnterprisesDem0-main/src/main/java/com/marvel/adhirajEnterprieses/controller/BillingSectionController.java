package com.marvel.adhirajEnterprieses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BillingSectionController {

	
	@GetMapping("/billing-section")
	public String billingSection() {
		return "billing-section"; // maps to billing-section.html
	}
	
}
