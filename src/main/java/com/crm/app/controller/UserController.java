package com.crm.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crm.app.entity.Role;
import com.crm.app.entity.Utilisateur;
import com.crm.app.repository.UtilisateurRepository;


@Controller 
public class UserController {

	
	@Autowired
	UtilisateurRepository userRepository;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView listusers(Model model) {

		List<Utilisateur> lsuser = userRepository.findAll();
		
		
		//System.out.print(lspermission.toString());
		
		model.addAttribute("liste", userRepository.findAll());
		
	    return new ModelAndView("user/index" );
	}
}
