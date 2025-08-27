package com.adhiraj.enterpries.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adhiraj.enterpries.model.BookingEntryModel;
import com.adhiraj.enterpries.repository.BookingEntryRepository;
import com.adhiraj.enterpries.service.DownloadChallanService;

@Controller
public class ChallanEntryController {
	
	@Autowired
	BookingEntryRepository bookingEntryRepository;

	@Autowired
	private DownloadChallanService downloadChallanService;

	@GetMapping("/challan-entry")
	public String challanEntry() {
		return "challan-entry"; // maps to challan-entry.html
	}

	@PostMapping("/challan-entry/search")
	public String searchChallanEntry(@RequestParam("chassisSuffix") String chassisSuffix, Model model) {
	    // Find by last 6 digits of chassis number
	    BookingEntryModel entry = bookingEntryRepository.getDetailsByVehicleChassisNumber(chassisSuffix);
	    if (entry != null) {
	        System.out.println("Challan Entry details :: " + entry.toString());
	        model.addAttribute("entry", entry);
	        model.addAttribute("chassisSuffix", chassisSuffix);
	    } else {
	        System.out.println("No entry found for chassis suffix :: " + chassisSuffix);
	        model.addAttribute("chassisSuffix", chassisSuffix);
	        model.addAttribute("errorMessage", "⚠️ No value found for chassis number ending with " + chassisSuffix);
	    }
	    return "challan-entry"; // Thymeleaf template
	}


	@PostMapping("/challan-entry/download")
	public void getDownloadChallan(HttpServletResponse response, Model model) throws IOException {
		downloadChallanService.downloadChallan(response, model);
	}
}
