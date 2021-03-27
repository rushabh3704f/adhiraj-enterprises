package com.shope.dev.webcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shope.dev.model.UserData;

@Controller
public class LoginController {

	@Autowired
	HttpSession session;

	@Autowired
	LoginService loginService;

	@RequestMapping("/")
	public String loginPageRequest(Model model, @ModelAttribute("loginPage") Login login) {
		model.addAttribute("loginPage", login);
		return "login";
	}

	@RequestMapping("/loginPage")
	public String loginPageReq(Model model, @ModelAttribute("loginPage") Login login) {
		model.addAttribute("loginPage", login);
		return "login";
	}

	@PostMapping(value = "/loginPage", params = { "command=loginCreate" })
	public String loginPage(Model model, @ModelAttribute("loginPage") Login login) {

		UserData userData = loginService.isValidUser(login);
		if (userData != null) {
			model.addAttribute("loginPage", login);
			session.setAttribute("userData", userData);
			return "redirect:createNewOrder";
		}
		model.addAttribute("loginPage", login);
		model.addAttribute("error", "UserName or Password Wrong.Please Try Again..");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

}