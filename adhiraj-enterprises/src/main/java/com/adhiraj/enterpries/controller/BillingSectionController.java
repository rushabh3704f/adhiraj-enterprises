package com.adhiraj.enterpries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.adhiraj.enterpries.model.BookingEntryModel;

@Controller
public class BillingSectionController {

	@GetMapping("/billingSection")
	public String billingSection(Model model,@ModelAttribute("allocationDetailsModel")BookingEntryModel bookingEntryModel) {
	    model.addAttribute("allocationDetails",bookingEntryModel);
		return "billingSection";
	}

}
