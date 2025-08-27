package com.adhiraj.enterpries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingEntryController {

	@GetMapping("/booking-entry")
	public String bookingEntry() {
		return "booking-entry"; // maps to booking-entry.html
	}
}