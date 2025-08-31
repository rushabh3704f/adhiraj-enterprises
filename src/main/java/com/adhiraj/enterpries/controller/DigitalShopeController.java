package com.adhiraj.enterpries.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.adhiraj.enterpries.model.UserData;

@Controller
public class DigitalShopeController {

	@Autowired
	HttpSession session;
	
	@PostMapping(value="/updateProductForPurchase", params= {"command=rePayPurchase"})
	public String rePayPurchase(Model model, @ModelAttribute("productDetailsForPurchase")String productDetailsForPurchase,BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		model.addAttribute("role",data.getRole());
		return "redirect:purchaseOrderList";
	}
		

}
