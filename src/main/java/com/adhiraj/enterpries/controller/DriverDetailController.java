package com.adhiraj.enterpries.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adhiraj.enterpries.constants.Constants;
import com.adhiraj.enterpries.model.BookingEntryModel;
import com.adhiraj.enterpries.model.DriverDetailEntity;
import com.adhiraj.enterpries.model.UserData;

@Controller
public class DriverDetailController {
	
	@Autowired
	HttpSession session;

	@GetMapping("/driverEntry")
	public String driverDetails(Model model,@ModelAttribute("driverDetailEntity")DriverDetailEntity driverDetailEntity) {
		model.addAttribute("driverDetailEntity", driverDetailEntity);
		return "driverEntry";
	}
	
	
	@RequestMapping("/searchDriverEntry")
	public String searchChallanEntry(Model model,@ModelAttribute("driverDetailEntity")DriverDetailEntity driverDetailEntity) {

		UserData data = (UserData) session.getAttribute("userData");
		if (data == null) {
			return "redirect:loginPage";
		}
	    model.addAttribute("driverDetailEntity",driverDetailEntity);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
	    return "driverEntry";
	}
	
	
}
