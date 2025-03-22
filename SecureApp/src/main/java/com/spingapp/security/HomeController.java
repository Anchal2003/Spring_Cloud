package com.spingapp.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
		
	@GetMapping("/")
	public String getMesage(){
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String loginpage(){
		return "login.jsp";
	}
	
	@RequestMapping("/logout-success")
	public String logoutpage(){
		return "logout.jsp";
	}
}
