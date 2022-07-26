package com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {//methodo get por causa do post que criamos em login.html
	
	@GetMapping()
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginError")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login";
	  }

}
