package com.nttdata3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class HomeController {
	
	@RequestMapping("")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "usuario/login.jsp";
	}
}
