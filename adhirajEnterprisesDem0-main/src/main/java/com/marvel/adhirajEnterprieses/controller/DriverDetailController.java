package com.marvel.adhirajEnterprieses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DriverDetailController {
	@GetMapping("/driver-details")
	public String driverDetails() {
		return "driver-details"; // maps to driver-details.html
	}
}
