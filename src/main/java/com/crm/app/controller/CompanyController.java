package com.crm.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {

	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	public String getCompanies() {
		//
		
		return "company/index";
	}
	
	@RequestMapping(value = "/new-company", method = RequestMethod.GET)
	public String getNewCompany(Model model) {
		//
		
		return "company/create";
	}
}
