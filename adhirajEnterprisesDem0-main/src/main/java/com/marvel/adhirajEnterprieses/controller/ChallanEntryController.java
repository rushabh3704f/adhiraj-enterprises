package com.marvel.adhirajEnterprieses.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marvel.adhirajEnterprieses.model.BookingEntry;
import com.marvel.adhirajEnterprieses.repository.ChallanEntryRepository;
import com.marvel.adhirajEnterprieses.service.DownloadChallanService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ChallanEntryController {

	@Autowired
	private ChallanEntryRepository challanEntryRepository;

	@Autowired
	private DownloadChallanService downloadChallanService;

	@GetMapping("/challan-entry")
	public String challanEntry() {
		return "challan-entry"; // maps to challan-entry.html
	}

	@PostMapping("/challan-entry/search")
	public String searchChallanEntry(@RequestParam("chassisSuffix") String chassisSuffix, Model model) {
	    // Find by last 6 digits of chassis number
	    BookingEntry entry = challanEntryRepository.findFirstByVehicleChassisNumberEndingWith(chassisSuffix);

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
