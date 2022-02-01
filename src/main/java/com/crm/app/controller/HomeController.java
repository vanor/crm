package com.crm.app.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showPermissions(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();
		
	//	System.out.println("login: " + login);
		
		
		
	    return new ModelAndView("index" );
	}
}
