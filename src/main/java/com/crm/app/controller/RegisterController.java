package com.crm.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crm.app.entity.Business;
import com.crm.app.entity.Utilisateur;
import com.crm.app.repository.BusinessRepository;


@Controller 
public class RegisterController {
	
	@Autowired
	BusinessRepository businessRepository;
	
	/*@RequestMapping(value = "/redirect", method = RequestMethod.POST)
	public ModelAndView method() {

	    return new ModelAndView("result" );
	}*/
	
	@RequestMapping(value = "/resultat", method = RequestMethod.POST)
	public ModelAndView result() {
	    return new ModelAndView("result" );
	}
	
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public ModelAndView methodget() {
	    return new ModelAndView("redirect:/enquiry" );
	}
	
	@RequestMapping(value = "/enquiry", method = RequestMethod.GET)
	public ModelAndView getform(Model model) {
		
		model.addAttribute("business",new Business());
	    return new ModelAndView("register" );
	}
	
	@RequestMapping(value = "/registration-business", method = RequestMethod.GET)
	public ModelAndView getBusiness(Model model) {
		
		model.addAttribute("liste",businessRepository.findAll());
	    return new ModelAndView("registration/business/index" );
	}

	@RequestMapping(value = "/saveBusiness", method = RequestMethod.POST)
	public ModelAndView newBusiness(Model model,@ModelAttribute Business business, final RedirectAttributes redirectAttributes) {
		
		business.setCreatedAt(new Date());
		business.setStatus("");
		businessRepository.save(business);
		
		 return new ModelAndView("result" );
		
	}
}
