package com.adhiraj.enterpries.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adhiraj.enterpries.constants.Constants;
import com.adhiraj.enterpries.model.BookingEntryModel;
import com.adhiraj.enterpries.model.UserData;
import com.adhiraj.enterpries.repository.BookingEntryRepository;
import com.adhiraj.enterpries.service.DownloadChallanService;

@Controller
public class ChallanEntryController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	BookingEntryRepository bookingEntryRepository;

	@Autowired
	private DownloadChallanService downloadChallanService;

	@RequestMapping("/challanEntry")
	public String challanEntry(Model model,@ModelAttribute("allocationDetailsModel")BookingEntryModel bookingEntryModel) {
        model.addAttribute("chassisSuffix", bookingEntryModel);
		return "challanEntry";
	}

	
	@RequestMapping("/searchChallanEntry")
	public String searchChallanEntry(Model model,@ModelAttribute("allocationDetailsModel")BookingEntryModel bookingEntryModel) {
		UserData data = (UserData) session.getAttribute("userData");
		if (data == null) {
			return "redirect:loginPage";
		}
	    BookingEntryModel entry = bookingEntryRepository.getDetailsByVehicleChassisNumber(bookingEntryModel.getSearchChassisNum());
	    model.addAttribute("allocationDetails",entry);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
	    return "challanEntry";
	}


	@PostMapping("/downloadChallanEntry")
	public void getDownloadChallan(HttpServletResponse response, Model model) throws IOException {
		downloadChallanService.downloadChallan(response, model);
	}
}
