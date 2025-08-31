package com.adhiraj.enterpries.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adhiraj.enterpries.constants.Constants;
import com.adhiraj.enterpries.model.BookingEntryModel;
import com.adhiraj.enterpries.model.UserData;
import com.adhiraj.enterpries.service.DigitalShopeService;
import com.adhiraj.enterpries.serviceImpl.UtilServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookingEntryController {

	@Autowired
	HttpSession session;

	@Autowired
	UtilServiceImpl utils;
	
	@Autowired
	DigitalShopeService digitalShopeService;
	
	
	@RequestMapping("/bookingEntry")
	public String bookingEntry(Model model,@ModelAttribute("allocationDetailsModel")BookingEntryModel bookingEntryModel) {
	    model.addAttribute("allocationDetails",bookingEntryModel);
		return "bookingEntry";
	}
	
	
	@RequestMapping("/fetchBookingDetails")
	public String fetchBookingDetails(Model model,@ModelAttribute("allocationDetailsModel")BookingEntryModel allocationDetailsModel) {
		System.out.println("Search Chasis Num :"+allocationDetailsModel.getSearchChassisNum());
		UserData data = (UserData) session.getAttribute("userData");
		if (data == null) {
			return "redirect:loginPage";
		}
		List<BookingEntryModel>allocationDetails = digitalShopeService.fetchBookingDetails();		
	    model.addAttribute("allocationDetails",allocationDetails);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "bookingEntry";//search bar need to add....last six digit chasis
	}
	
	

}
