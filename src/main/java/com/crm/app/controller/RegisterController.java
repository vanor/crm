package com.crm.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class RegisterController {
	
	@RequestMapping(value = "/redirect", method = RequestMethod.POST)
	public ModelAndView method() {

	    return new ModelAndView("result" );
	}
	
	@RequestMapping(value = "/resultat", method = RequestMethod.POST)
	public ModelAndView result() {
	    return new ModelAndView("result" );
	}
	
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public ModelAndView methodget() {
	    return new ModelAndView("redirect:/enquiry" );
	}

}
